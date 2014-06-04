package com.gridpoint.energy.domainmodel;

import java.io.Serializable;
import java.util.Date;

public class WeatherData implements Serializable {

    private static final long serialVersionUID = 1L;

    private String stationId;
    private Date intervalDate;
    private Double temperatureDegF;
    private Double dewPointDegF;
    private Double insolation;
    private Double windSpeedMph;
    private Double windDirectionDeg;
    private Double precipitationInchesHour;
    private Double precipitationPercent;

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public Date getIntervalDate() {
        return intervalDate;
    }

    public void setIntervalDate(Date intervalDate) {
        this.intervalDate = intervalDate;
    }

    public Double getTemperatureDegF() {
        return temperatureDegF;
    }

    public void setTemperatureDegF(Double temperatureDegF) {
        this.temperatureDegF = temperatureDegF;
    }

    public Double getDewPointDegF() {
        return dewPointDegF;
    }

    public void setDewPointDegF(Double dewPointDegF) {
        this.dewPointDegF = dewPointDegF;
    }

    public Double getInsolation() {
        return insolation;
    }

    public void setInsolation(Double insolation) {
        this.insolation = insolation;
    }

    public Double getWindSpeedMph() {
        return windSpeedMph;
    }

    public void setWindSpeedMph(Double windSpeedMph) {
        this.windSpeedMph = windSpeedMph;
    }

    public Double getWindDirectionDeg() {
        return windDirectionDeg;
    }

    public void setWindDirectionDeg(Double windDirectionDeg) {
        this.windDirectionDeg = windDirectionDeg;
    }

    public Double getPrecipitationInchesHour() {
        return precipitationInchesHour;
    }

    public void setPrecipitationInchesHour(Double precipitationInchesHour) {
        this.precipitationInchesHour = precipitationInchesHour;
    }

    public Double getPrecipitationPercent() {
        return precipitationPercent;
    }

    public void setPrecipitationPercent(Double precipitationPercent) {
        this.precipitationPercent = precipitationPercent;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( dewPointDegF == null ) ? 0 : dewPointDegF.hashCode() );
        result = prime * result + ( ( insolation == null ) ? 0 : insolation.hashCode() );
        result = prime * result + ( ( intervalDate == null ) ? 0 : intervalDate.hashCode() );
        result = prime * result + ( ( precipitationInchesHour == null ) ? 0 : precipitationInchesHour.hashCode() );
        result = prime * result + ( ( precipitationPercent == null ) ? 0 : precipitationPercent.hashCode() );
        result = prime * result + ( ( stationId == null ) ? 0 : stationId.hashCode() );
        result = prime * result + ( ( temperatureDegF == null ) ? 0 : temperatureDegF.hashCode() );
        result = prime * result + ( ( windDirectionDeg == null ) ? 0 : windDirectionDeg.hashCode() );
        result = prime * result + ( ( windSpeedMph == null ) ? 0 : windSpeedMph.hashCode() );
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        WeatherData other = (WeatherData) obj;
        if (dewPointDegF == null) {
            if (other.dewPointDegF != null) return false;
        } else if (!dewPointDegF.equals(other.dewPointDegF)) return false;
        if (insolation == null) {
            if (other.insolation != null) return false;
        } else if (!insolation.equals(other.insolation)) return false;
        if (intervalDate == null) {
            if (other.intervalDate != null) return false;
        } else if (!intervalDate.equals(other.intervalDate)) return false;
        if (precipitationInchesHour == null) {
            if (other.precipitationInchesHour != null) return false;
        } else if (!precipitationInchesHour.equals(other.precipitationInchesHour)) return false;
        if (precipitationPercent == null) {
            if (other.precipitationPercent != null) return false;
        } else if (!precipitationPercent.equals(other.precipitationPercent)) return false;
        if (stationId == null) {
            if (other.stationId != null) return false;
        } else if (!stationId.equals(other.stationId)) return false;
        if (temperatureDegF == null) {
            if (other.temperatureDegF != null) return false;
        } else if (!temperatureDegF.equals(other.temperatureDegF)) return false;
        if (windDirectionDeg == null) {
            if (other.windDirectionDeg != null) return false;
        } else if (!windDirectionDeg.equals(other.windDirectionDeg)) return false;
        if (windSpeedMph == null) {
            if (other.windSpeedMph != null) return false;
        } else if (!windSpeedMph.equals(other.windSpeedMph)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "WeatherData [dewPointDegF=" + dewPointDegF + ", insolation=" + insolation + ", intervalDate=" + intervalDate
                + ", precipitationInchesHour=" + precipitationInchesHour + ", precipitationPercent=" + precipitationPercent
                + ", stationId=" + stationId + ", temperatureDegF=" + temperatureDegF + ", windDirectionDeg=" + windDirectionDeg
                + ", windSpeedMph=" + windSpeedMph + "]";
    }
}
