package com.gridpoint.energy.domainmodel;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class TimeSpan implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This represent midnight GMT Sunday Jan 4th, 1970. The first unix week. (Inclusive)
     */
    public static final int START_OF_WEEK = 259200000;

    /**
     * This represent The last millisecond of GMT Saturday Jan 10th, 1970. (Inclusive)
     */
    public static final int END_OF_WEEK = 863999999;

    private Date startDate;
    private Date endDate;

    public TimeSpan() {
    }

    public TimeSpan(Date startDate, Date endDate) {
        setStartDate(startDate);
        setEndDate(endDate);
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        if (startDate instanceof Timestamp) {
            this.startDate = new Date(startDate.getTime());
        } else {
            this.startDate = startDate;
        }
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        if (endDate instanceof Timestamp) {
            this.endDate = new Date(endDate.getTime());
        } else {
            this.endDate = endDate;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( endDate == null ) ? 0 : endDate.hashCode() );
        result = prime * result + ( ( startDate == null ) ? 0 : startDate.hashCode() );
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        TimeSpan other = (TimeSpan) obj;
        if (endDate == null) {
            if (other.endDate != null) return false;
        } else if (!endDate.equals(other.endDate)) return false;
        if (startDate == null) {
            if (other.startDate != null) return false;
        } else if (!startDate.equals(other.startDate)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "TimeSpan [endDate=" + endDate + ", startDate=" + startDate + "]";
    }

}
