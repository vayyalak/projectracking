package com.gridpoint.energy.domainmodel;

import java.io.Serializable;

public class SessionRollup implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id; //Arbitrary id for display purposes
    private long totalConnectionTime = 0;
    private long sessionCount = 0;
    private double totalEnergyIn = 0;

    public SessionRollup () {
    }

    public long getTotalConnectionTime() {
        return totalConnectionTime;
    }

    public void setTotalConnectionTime(long totalConnectionTime) {
        this.totalConnectionTime = totalConnectionTime;
    }

    public void addToTotalConnectionTime(long totalConnectionTime) {
        this.totalConnectionTime += totalConnectionTime;
    }

    public long getSessionCount() {
        return sessionCount;
    }

    public void setSessionCount(long sessionCount) {
        this.sessionCount = sessionCount;

    }

    public void addToSessionCount(long sessionCount) {
        this.sessionCount += sessionCount;
    }

    public double getTotalEnergyIn() {
        return totalEnergyIn;
    }

    public void setTotalEnergyIn(double totalEnergyIn) {
        this.totalEnergyIn = totalEnergyIn;
    }

    public void addToTotalEnergyIn(double totalEnergyIn) {
        this.totalEnergyIn += totalEnergyIn;
    }
    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SessionRollup that = (SessionRollup) o;

        if (sessionCount != that.sessionCount) return false;
        if (totalConnectionTime != that.totalConnectionTime) return false;
        if (Double.compare(that.totalEnergyIn, totalEnergyIn) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (totalConnectionTime ^ (totalConnectionTime >>> 32));
        result = 31 * result + (int) (sessionCount ^ (sessionCount >>> 32));
        temp = totalEnergyIn != +0.0d ? Double.doubleToLongBits(totalEnergyIn) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
