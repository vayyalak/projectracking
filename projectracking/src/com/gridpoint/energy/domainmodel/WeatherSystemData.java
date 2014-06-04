package com.gridpoint.energy.domainmodel;

import java.io.Serializable;
import java.util.List;

public class WeatherSystemData implements Serializable {

    private static final long serialVersionUID = 1L;

    private String zipCode;

    private boolean isObserved;
    private List<WeatherData> weatherDataList;

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public List<WeatherData> getWeatherDataList() {
        return weatherDataList;
    }

    public void setWeatherDataList(List<WeatherData> weatherDataList) {
        this.weatherDataList = weatherDataList;
    }

    public void setObserved(boolean isObserved) {
        this.isObserved = isObserved;
    }

    public boolean isObserved() {
        return isObserved;
    }

}
