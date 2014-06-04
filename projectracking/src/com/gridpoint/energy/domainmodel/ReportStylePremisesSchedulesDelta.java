package com.gridpoint.energy.domainmodel;

import com.gridpoint.energy.util.collection.Delta;
import com.gridpoint.energy.util.collection.JavaBeanToMapAdapter;
import com.gridpoint.energy.util.collection.SimpleDiffer;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Conveys how two premises schedules differ, in a format suitable for use on the Site Schedules Report.
 *
 * @author dhorlick
 */
public class ReportStylePremisesSchedulesDelta
{
    public enum Section {HVAC_SETTINGS, STORE_HOURS, LIGHTING_SCHEDULES}

    private Section section;
    private String fieldNameChanged;
    private String oldValue;
    private String newValue;
    private Integer rowIndex;
    private Integer periodIndex;

    public Section getSection()
    {
        return section;
    }

    public void setSection(final Section section)
    {
        this.section = section;
    }

    public String getFieldNameChanged()
    {
        return fieldNameChanged;
    }

    public void setFieldNameChanged(final String fieldNameChanged)
    {
        this.fieldNameChanged = fieldNameChanged;
    }

    public String getOldValue()
    {
        return oldValue;
    }

    public void setOldValue(final String oldValue)
    {
        this.oldValue = oldValue;
    }

    public String getNewValue()
    {
        return newValue;
    }

    public void setNewValue(final String newValue)
    {
        this.newValue = newValue;
    }

    /**
     * @return a row index, counting up from zero. For store hours, this may correspond to weekday (or the conjunction
     * of weekday and alternateness.) For device schedules, will typically indicate which device is being described.
     */
    public Integer getRowIndex()
    {
        return rowIndex;
    }

    public void setRowIndex(final Integer rowIndex)
    {
        this.rowIndex = rowIndex;
    }

    public Integer getPeriodIndex()
    {
        return periodIndex;
    }

    public void setPeriodIndex(final Integer periodIndex)
    {
        this.periodIndex = periodIndex;
    }

    public static List<ReportStylePremisesSchedulesDelta> diff(final PremisesSchedules one, final PremisesSchedules two)
    {
        final List<ReportStylePremisesSchedulesDelta> reportStylePremisesSchedulesDeltas
                = new ArrayList<ReportStylePremisesSchedulesDelta> ();

        if (one==two) {
            return reportStylePremisesSchedulesDeltas;
        }
        final SimpleDiffer differ = new SimpleDiffer();

        if (one.getSiteHoursSet().size()!=two.getSiteHoursSet().size())
        {
            throw new IllegalArgumentException("PremisesSchedules' site hours cover different numbers of weekdays: "
                    +one.getSiteHoursSet().size()+" !+ "+two.getSiteHoursSet().size());
        }

        final Iterator<SiteHours> siteHoursIter1 = one.getSiteHoursSet().iterator();
        final Iterator<SiteHours> siteHoursIter2 = two.getSiteHoursSet().iterator();

        int rowIndex = 0;

        while (siteHoursIter1.hasNext() && siteHoursIter2.hasNext())
        {
            final SiteHours siteHours1 = siteHoursIter1.next();
            final SiteHours siteHours2 = siteHoursIter2.next();

            final List<Delta> deltas
                    = differ.diff(new JavaBeanToMapAdapter(siteHours1), new JavaBeanToMapAdapter(siteHours2));

            for (final Delta delta : deltas)
            {
                final ReportStylePremisesSchedulesDelta rspsDelta = new ReportStylePremisesSchedulesDelta();
                rspsDelta.setSection(Section.STORE_HOURS);
                rspsDelta.setOldValue(stringify(delta.getBefore()));
                rspsDelta.setNewValue(stringify(delta.getAfter()));
                rspsDelta.setFieldNameChanged(admifyFieldName(delta.getPropertyName()));
                rspsDelta.setRowIndex(rowIndex);
                reportStylePremisesSchedulesDeltas.add(rspsDelta);
            }

            rowIndex++;
        }

        if (one.getDeviceSchedules().size()!=two.getDeviceSchedules().size())
        {
            throw new IllegalArgumentException("PremisesSchedules' device schedules cover different numbers of devices: "
                    +one.getDeviceSchedules().size()+" !+ "+two.getDeviceSchedules().size());
        }

        rowIndex = 0;
        int periodIndex = 0;

        final Iterator<DeviceSchedule> deviceSchedIter1 = one.getDeviceSchedules().iterator();
        final Iterator<DeviceSchedule> deviceSchedIter2 = two.getDeviceSchedules().iterator();

        while (deviceSchedIter1.hasNext() && deviceSchedIter2.hasNext())
        {
            final DeviceSchedule deviceSched1 = deviceSchedIter1.next();
            final DeviceSchedule deviceSched2 = deviceSchedIter2.next();

            if (!deviceSched1.getClass().equals(deviceSched2.getClass()))
            {
                throw new IllegalArgumentException("Device class mismatch: "+deviceSched1.getClass().getSimpleName()
                        +"!="+deviceSched2.getClass().getSimpleName());
            }

            final Iterator<DeviceScheduleEntry> entryIter1 = deviceSched1.getEntries().iterator();
            final Iterator<DeviceScheduleEntry> entryIter2 = deviceSched2.getEntries().iterator();

            while (entryIter1.hasNext() && entryIter2.hasNext())
            {
                final DeviceScheduleEntry entry1 = entryIter1.next();
                final DeviceScheduleEntry entry2 = entryIter2.next();

                final List<Delta> deltas = differ.diff(new JavaBeanToMapAdapter(entry1), new JavaBeanToMapAdapter(entry2));

                for (final Delta delta : deltas)
                {
                    final ReportStylePremisesSchedulesDelta rspsDelta = new ReportStylePremisesSchedulesDelta();
                    rspsDelta.setRowIndex(rowIndex);
                    rspsDelta.setPeriodIndex(periodIndex);

                    if (entry1.getState() instanceof HvacScheduleState)
                    {
                        rspsDelta.setSection(Section.HVAC_SETTINGS);
                    }
                    else if (entry1.getState() instanceof LightingScheduleState)
                    {
                        rspsDelta.setSection(Section.LIGHTING_SCHEDULES);
                    }

                    rspsDelta.setFieldNameChanged(admifyFieldName(delta.getPropertyName()));
                    rspsDelta.setOldValue(stringify(delta.getBefore()));
                    rspsDelta.setNewValue(stringify(delta.getAfter()));

                    reportStylePremisesSchedulesDeltas.add(rspsDelta);

                    periodIndex++;
                }
            }

            rowIndex++;
        }

        return reportStylePremisesSchedulesDeltas;
    }

    private static String admifyFieldName(final String fieldName)
    {
        if (fieldName==null)
            return null;

        if ("siteOpen".equals(fieldName))
            return "OpenTime";
        else if ("siteClose".equals(fieldName))
            return "CloseTime";

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i=0; i<fieldName.length(); i++)
        {
            final char ch = fieldName.charAt(i);
            if (!Character.isWhitespace(ch))
            {
                if (i==0)
                {
                    stringBuilder.append(Character.toUpperCase(ch));
                }
                else
                {
                    stringBuilder.append(ch);
                }
            }
        }

        final String capitalized = stringBuilder.toString();
        return capitalized.toString();
    }

    private static String stringify(final Object object)
    {
        if (object == null)
            return null;
        return String.valueOf(object);
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
