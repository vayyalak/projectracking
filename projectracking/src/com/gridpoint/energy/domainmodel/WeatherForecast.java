package com.gridpoint.energy.domainmodel;

import java.io.Serializable;
import java.util.Date;

public class WeatherForecast implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date date;
    private String conditions;
    private double tempC;
    private double highC;
    private double lowC;
    private double windKmph;
    private double humidityPercent;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public double getTempC() {
        return tempC;
    }

    public void setTempC(double tempC) {
        this.tempC = tempC;
    }

    public double getHighC() {
        return highC;
    }

    public void setHighC(double highC) {
        this.highC = highC;
    }

    public double getLowC() {
        return lowC;
    }

    public void setLowC(double lowC) {
        this.lowC = lowC;
    }

    public double getWindKmph() {
        return windKmph;
    }

    public void setWindKmph(double wind) {
        this.windKmph = wind;
    }

    public double getHumidityPercent() {
        return humidityPercent;
    }

    public void setHumidityPercent(double humidity) {
        this.humidityPercent = humidity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( conditions == null ) ? 0 : conditions.hashCode() );
        result = prime * result + ( ( date == null ) ? 0 : date.hashCode() );
        long temp;
        temp = Double.doubleToLongBits(highC);
        result = prime * result + (int) ( temp ^ ( temp >>> 32 ) );
        temp = Double.doubleToLongBits(humidityPercent);
        result = prime * result + (int) ( temp ^ ( temp >>> 32 ) );
        temp = Double.doubleToLongBits(lowC);
        result = prime * result + (int) ( temp ^ ( temp >>> 32 ) );
        temp = Double.doubleToLongBits(tempC);
        result = prime * result + (int) ( temp ^ ( temp >>> 32 ) );
        temp = Double.doubleToLongBits(windKmph);
        result = prime * result + (int) ( temp ^ ( temp >>> 32 ) );
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        WeatherForecast other = (WeatherForecast) obj;
        if (conditions == null) {
            if (other.conditions != null) return false;
        } else if (!conditions.equals(other.conditions)) return false;
        if (date == null) {
            if (other.date != null) return false;
        } else if (!date.equals(other.date)) return false;
        if (Double.doubleToLongBits(highC) != Double.doubleToLongBits(other.highC)) return false;
        if (Double.doubleToLongBits(humidityPercent) != Double.doubleToLongBits(other.humidityPercent)) return false;
        if (Double.doubleToLongBits(lowC) != Double.doubleToLongBits(other.lowC)) return false;
        if (Double.doubleToLongBits(tempC) != Double.doubleToLongBits(other.tempC)) return false;
        if (Double.doubleToLongBits(windKmph) != Double.doubleToLongBits(other.windKmph)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "WeatherForecast [conditions=" + conditions + ", date=" + date + ", highC=" + highC + ", humidityPercent=" + humidityPercent
                + ", lowC=" + lowC + ", tempC=" + tempC + ", windKmph=" + windKmph + "]";
    }

}
