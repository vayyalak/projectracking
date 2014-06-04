package com.gridpoint.energy.domainmodel;

import com.gridpoint.energy.util.collection.JavaBeanToMapAdapter;
import com.gridpoint.energy.util.collection.PropertyCatalogue;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * A domain layer representation of the store/site hours for a single premises as well as schedules for any associated
 * devices.
 *
 * This is the analog to EndpointScheduleEntity, in the entity layer.
 *
 * @author dhorlick
 */
public class PremisesSchedules
{
    private Set<SiteHours> siteHoursSet = new LinkedHashSet<SiteHours> ();
    private Set<DeviceSchedule> deviceSchedules = new LinkedHashSet<DeviceSchedule> ();
    private CustomSchedules customSchedules;

    public Set<SiteHours> getSiteHoursSet()
    {
        return siteHoursSet;
    }

    public void setSiteHoursSet(final Set<SiteHours> designatedSiteHoursSet)
    {
        siteHoursSet = designatedSiteHoursSet;
    }

    public CustomSchedules getCustomSchedules()
    {
        return customSchedules;
    }

    public void setCustomSchedules(final CustomSchedules customSchedules)
    {
        this.customSchedules = customSchedules;
    }

    public Set<DeviceSchedule> getDeviceSchedules()
    {
        return deviceSchedules;
    }

    public void setDeviceSchedules(Set<DeviceSchedule> deviceSchedules)
    {
        this.deviceSchedules = deviceSchedules;
    }

    public JSONObject toJson()
    {
        return new JSONObject(toPropertyCatalog());
    }

    public PropertyCatalogue toPropertyCatalog()
    {
        final PropertyCatalogue propertyCatalogue = new JavaBeanToMapAdapter(this);
        return propertyCatalogue;
    }

    public SiteHours[] mainSiteHoursSortedByWeekday()
    {
        return siteHoursSortedByWeekday("Main");
    }

    public SiteHours[] alternateSiteHoursSortedByWeekday()
    {
        return siteHoursSortedByWeekday("Alternate");
    }

    /**
     * @return an Array of 7 elements. Any missing weekdays will be represented with null elements.
     */
    public SiteHours[] siteHoursSortedByWeekday(final String type)
    {
        return PremisesSchedules.sortSiteHoursByWeekday(type, siteHoursSet);
    }

    private static SiteHours[] sortSiteHoursByWeekday(final String type, final Iterable<SiteHours> siteHourses)
    {
        final SiteHours [] sorted = new SiteHours[7];

        for (final SiteHours siteHours : siteHourses)
        {
            if (type.equals(siteHours.getType()))
            {
                if (siteHours.getNumericDayOfWeek()==null)
                    throw new IllegalStateException("Constituent site hours has no numeric day of week: "+siteHours);
                if (siteHours.getNumericDayOfWeek()<0 || siteHours.getNumericDayOfWeek()>6)
                    throw new IllegalStateException("Constituent site hours has invalid numeric day of week property; must be an integer from zero to 6: "+siteHours);

                sorted[siteHours.getNumericDayOfWeek()] = siteHours;
            }
        }

        return sorted;
    }

    public Set<String> siteHoursTypes()
    {
        final Set<String> result = new TreeSet<String> ();
        if (siteHoursSet!=null)
            result.addAll(PremisesSchedules.siteHoursTypes(siteHoursSet));
        if (customSchedules!=null)
            result.addAll(customSchedules.siteHoursTypes());

        return result;
    }

    private static Set<String> siteHoursTypes(final Iterable<SiteHours> siteHourses)
    {
        final SortedSet<String> siteHoursTypes = new TreeSet<String> ();

        for (final SiteHours siteHours : siteHourses)
        {
            if (siteHours.getType()!=null)
                siteHoursTypes.add(siteHours.getType());
        }

        return siteHoursTypes;
    }

    public void overlaySiteAndCustomHoursFrom(final PremisesSchedules moreRecent)
    {
        if (moreRecent==null)
            return;

        overlaySiteHoursFrom(moreRecent.getSiteHoursSet());
        overlayCustomSchedulesFrom(moreRecent.getCustomSchedules());
    }

    public void overlaySiteHoursFrom(final Collection<SiteHours> moreRecentSiteHours)
    {
        if (moreRecentSiteHours==null)
            return;

        if (siteHoursSet==null)
        {
            if (moreRecentSiteHours!=null)
            {
                siteHoursSet = new HashSet<SiteHours>();
                siteHoursSet.addAll(moreRecentSiteHours);
            }
        }
        else
        {
            final Set<String> siteHoursTypes = siteHoursTypes();
            siteHoursTypes.addAll(PremisesSchedules.siteHoursTypes(moreRecentSiteHours));

            final Set<SiteHours> munged = new LinkedHashSet<SiteHours> ();

            for (final String siteHoursType : siteHoursTypes)
            {
                final SiteHours[] sortedSiteHours = siteHoursSortedByWeekday(siteHoursType);
                final SiteHours[] sortedSiteHoursMoreRecent
                        = PremisesSchedules.sortSiteHoursByWeekday(siteHoursType, moreRecentSiteHours);

                for (int i=0; i<7; i++)
                {
                    if (sortedSiteHoursMoreRecent[i]!=null)
                        munged.add(sortedSiteHoursMoreRecent[i]);
                    else if (sortedSiteHours[i]!=null)
                        munged.add(sortedSiteHours[i]);
                }
            }

            siteHoursSet = munged;
        }
    }

    public void overlayCustomSchedulesFrom(final CustomSchedules moreRecentCustomSchedules)
    {
        if (moreRecentCustomSchedules==null)
            return;

        if (customSchedules==null)
            customSchedules = moreRecentCustomSchedules;
        else
            customSchedules.overlayFrom(moreRecentCustomSchedules);
    }

    public void overlayDeviceSchedules(final Set<DeviceSchedule> designatedDeviceSchedules)
    {
        if (deviceSchedules==null)
            deviceSchedules = new LinkedHashSet<DeviceSchedule> ();

        for (final DeviceSchedule designatedDeviceSchedule : designatedDeviceSchedules)
        {
            final DeviceSchedule corresponding = findDeviceScheduleByDeviceAddress(designatedDeviceSchedule.getDeviceAddress());
            if (corresponding!=null)
            {
                deviceSchedules.remove(corresponding);
            }

            deviceSchedules.add(designatedDeviceSchedule);
        }
    }

    public DeviceSchedule findDeviceScheduleByDeviceAddress(final String requestedDeviceAddress)
    {
        for (final DeviceSchedule deviceSchedule : deviceSchedules)
        {
            if (deviceSchedule.getDeviceAddress()==requestedDeviceAddress
                    || deviceSchedule.getDeviceAddress().equals(requestedDeviceAddress))
            {
                return deviceSchedule;
            }
        }

        return null;
    }

    public static Map<String, List<DeviceSchedule>> parseDeviceScheduleSetJson(final JSONObject json) throws JSONException
    {
        if (json.has("result") && json.length()==1)
            return parseDeviceScheduleSetJson(json.getJSONObject("result"));

        final Map<String, List<DeviceSchedule>> deviceSchedulesPerPremises
            = new LinkedHashMap<String, List<DeviceSchedule>>();

        final Iterator<String> keyIter = json.keys();
        while (keyIter.hasNext())
        {
            final String key = keyIter.next();
            final JSONArray deviceJsonArray = json.getJSONArray(key);
            final List<DeviceSchedule> deviceSchedules = new ArrayList<DeviceSchedule>();

            for (int i=0; i<deviceJsonArray.length(); i++)
            {
                final JSONObject deviceJson = deviceJsonArray.getJSONObject(i);

                if (deviceJson.has("unitNo"))
                {
                    // It's an HVAC
                    deviceSchedules.add(new DeviceSchedule(deviceJson.getString("unitNo")));
                    // TODO map entries
                }
                else if (deviceJson.has("lightingLevel"))
                {
                    // It's a Light
                    deviceSchedules.add(new DeviceSchedule(deviceJson.getString("lightingLevel")));
                    // TODO map entries
                }
            }
            deviceSchedulesPerPremises.put(key, deviceSchedules);
        }

        return deviceSchedulesPerPremises;
    }

    public static Set<SiteHours> parseSiteHours(final JSONArray json) throws JSONException
    {
        final Set<SiteHours> siteHoursSet = new LinkedHashSet<SiteHours> ();

        for (int i=0; i<json.length(); i++)
        {
            final JSONObject jsonObject = json.getJSONObject(i);
            final SiteHours siteHours = new SiteHours();

            if (jsonObject.has("siteOpen"))
                siteHours.setSiteOpen(jsonObject.getString("siteOpen"));
            if (jsonObject.has("siteClose"))
                siteHours.setSiteClose(jsonObject.getString("siteClose"));
            if (jsonObject.has("numericDayOfWeek"))
                siteHours.setNumericDayOfWeek(jsonObject.getInt("numericDayOfWeek"));
            if (jsonObject.has("numericDayOfWeek"))
                siteHours.setDayOfWeek(jsonObject.getString("dayOfWeek"));
            if (jsonObject.has("premisesId"))
                siteHours.setPremisesId(jsonObject.getLong("premisesId"));
            if (jsonObject.has("premisesName"))
                siteHours.setPremisesName(jsonObject.getString("premisesName"));
            if (jsonObject.has("type"))
                siteHours.setType(jsonObject.getString("type"));

            siteHoursSet.add(siteHours);
        }

        return siteHoursSet;
    }

    public static Set<PremisesSchedules> sewTogether(final Iterable<SiteHours> siteHoursSet,
                                                     final Map<String, List<DeviceSchedule>> requestedDeviceScheduleMap)
            // TODO add a parameter for CustomSchedules
    {
        final Map<String, List<DeviceSchedule>> deviceScheduleMap = new LinkedHashMap<String, List<DeviceSchedule>>();
        deviceScheduleMap.putAll(requestedDeviceScheduleMap);

        final Map<String, PremisesSchedules> premisesSchedulesMap = new LinkedHashMap<String, PremisesSchedules> ();

        for (final SiteHours siteHours : siteHoursSet)
        {
            final PremisesSchedules premisesSchedules;

            if (premisesSchedulesMap.containsKey(siteHours.getPremisesName()))
                premisesSchedules = premisesSchedulesMap.get(siteHours.getPremisesName());
            else
            {
                premisesSchedules = new PremisesSchedules();
                premisesSchedulesMap.put(siteHours.getPremisesName(), premisesSchedules);
            }

            premisesSchedules.getSiteHoursSet().add(siteHours);

            final List<DeviceSchedule> correspondingDeviceSchedules
                    = deviceScheduleMap.remove(siteHours.getPremisesName());
            if (correspondingDeviceSchedules!=null)
            {
                for (final DeviceSchedule deviceSchedule : correspondingDeviceSchedules)
                {
                    premisesSchedules.getDeviceSchedules().add(deviceSchedule);
                }
            }
        }

        if (deviceScheduleMap.size()>0)
        {
            throw new IllegalArgumentException("Some device schedules couldn't be matched up to premises schedules: "
                    +deviceScheduleMap);
        }

        final Set<PremisesSchedules> premisesSchedulesSet = new LinkedHashSet<PremisesSchedules> ();
        premisesSchedulesSet.addAll(premisesSchedulesMap.values());
        return premisesSchedulesSet;
    }

    public List<ReportStylePremisesSchedulesDelta> reportStyleDiff(final PremisesSchedules premisesSchedules)
    {
        return ReportStylePremisesSchedulesDelta.diff(this, premisesSchedules);
    }

    /**
     * @return a GPEC Schedule element, suitable for inclusion in schedule.xml, or a consolidated Configuration
     * document.
     */
    public Element toGpecConfiguationSchedule(final Document doc)
    {
        final Element scheduleElement = doc.createElement("Schedule");

        for (final String storeHoursType : siteHoursTypes())
        {
            final Element storeHourElement = doc.createElement("StoreHour");
            storeHourElement.setAttribute("name", storeHoursType);
            scheduleElement.appendChild(storeHourElement);
            final Element defaultHoursElement = doc.createElement("DefaultHours");
            storeHourElement.appendChild(defaultHoursElement);

            final SiteHours[] siteHourses = siteHoursSortedByWeekday(storeHoursType);

            for (int weekdayIndex=0; weekdayIndex<siteHourses.length; weekdayIndex++)
            {
                final SiteHours siteHours = siteHourses[weekdayIndex];

                if (siteHours!=null && !siteHours.closedAllDay())
                {
                    final Element dayElement = doc.createElement(DayOfWeek.newInstance(weekdayIndex).stringDayOfWeek());
                    dayElement.setAttribute("open", siteHours.getSiteOpen());
                    dayElement.setAttribute("close", siteHours.getSiteClose());
                    defaultHoursElement.appendChild(dayElement);
                }
                else
                {
                    final Element dayElement = doc.createElement(DayOfWeek.newInstance(weekdayIndex).stringDayOfWeek());
                    dayElement.setAttribute("open", "0:00");
                    dayElement.setAttribute("close", "0:00");
                    defaultHoursElement.appendChild(dayElement);
                }
            }

            if (customSchedules!=null && customSchedules.getCustomHoursSetByType().containsKey(storeHoursType))
            {
                final Element customSchedulesElement = doc.createElement("CustomHours");
                storeHourElement.appendChild(customSchedulesElement);

                for (final CustomHours customHours : customSchedules.getCustomHoursSetByType().get(storeHoursType))
                {
                    customSchedulesElement.appendChild(customHours.toGpecConfigElement(doc));
                }
            }
        }

        if (deviceSchedules!=null)
        {
            for (final DeviceSchedule deviceSchedule : deviceSchedules)
            {
                scheduleElement.appendChild(deviceSchedule.toGpecConfigElement(doc));
            }
        }

        return scheduleElement;
    }

    /**
     * @return a PremisesSchedules with 7 closed Main and 7 closed Alternate store schedule days.
     */
    public static PremisesSchedules buildTemplate(final long premisesId, final String premisesName)
    {
        final PremisesSchedules premisesSchedules = new PremisesSchedules();

        for (final String storeHoursType : new String[] {"Main", "Alternate"})
        {
            for (int weekdayIndex = 0; weekdayIndex<7; weekdayIndex++)
            {
                premisesSchedules.getSiteHoursSet().add(SiteHours.closed(premisesId, premisesName, weekdayIndex,
                        storeHoursType));
            }
        }

        return premisesSchedules;
    }

    public void addDeviceSchedule(final DeviceSchedule designatedDeviceSchedule)
    {
        final DeviceSchedule found = findDeviceScheduleByDeviceAddress(designatedDeviceSchedule.getDeviceAddress());

        if (found==null)
        {
            deviceSchedules.add(designatedDeviceSchedule);
        }
        else
        {
            throw new IllegalArgumentException("There is already a device schedule with for the device address: "+found);
        }
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
