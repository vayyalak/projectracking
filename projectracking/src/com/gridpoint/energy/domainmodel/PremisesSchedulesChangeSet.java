package com.gridpoint.energy.domainmodel;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author dhorlick
 */
public class PremisesSchedulesChangeSet
{
    private Date modification;
    private List<ReportStylePremisesSchedulesDelta> deltas = new ArrayList<ReportStylePremisesSchedulesDelta> ();
    private String comment;
    private String editedBy;

    public Date getModification()
    {
        return modification;
    }

    public void setModification(Date modification)
    {
        this.modification = modification;
    }

    public List<ReportStylePremisesSchedulesDelta> getDeltas()
    {
        return deltas;
    }

    public void setDeltas(List<ReportStylePremisesSchedulesDelta> deltas)
    {
        this.deltas = deltas;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public String getEditedBy()
    {
        return editedBy;
    }

    public void setEditedBy(String editedBy)
    {
        this.editedBy = editedBy;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
