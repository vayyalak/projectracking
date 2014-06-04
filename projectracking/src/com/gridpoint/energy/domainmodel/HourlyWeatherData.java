package com.gridpoint.energy.domainmodel;

import java.util.Date;

/**
 * Data from the gpup_persistent.alarm_log table.
 */

public class HourlyWeatherData {

    private Long premisesId;

    private String weatherStation;

    private String timezone;

    private Date forecastTime;

    private Integer temperature;

    private Integer humidity;

    private Double precipitation;

    private Integer cloudCover;

    public Long getPremisesId() {
        return premisesId;
    }

    public void setPremisesId(Long premisesId) {
        this.premisesId = premisesId;
    }

    public String getWeatherStation() {
        return weatherStation;
    }

    public String getTimezone() {
        return timezone;
    }

    public Date getForecastTime() {
        return forecastTime;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public Double getPrecipitation() {
        return precipitation;
    }

    public Integer getCloudCover() {
        return cloudCover;
    }

    public void setWeatherStation(String weatherStation) {
        this.weatherStation = weatherStation;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void setForecastTime(Date forecastTime) {
        this.forecastTime = forecastTime;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public void setPrecipitation(Double precipitation) {
        this.precipitation = precipitation;
    }

    public void setCloudCover(Integer cloudCover) {
        this.cloudCover = cloudCover;
    }
}
