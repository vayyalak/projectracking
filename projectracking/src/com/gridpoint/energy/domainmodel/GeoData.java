package com.gridpoint.energy.domainmodel;

import java.io.Serializable;

public class GeoData implements Serializable {

    private static final long serialVersionUID = 1L;

    private String city;
    private String state;
    private String zipCode;
    private String areaCode;
    private String county;
    private String country;
    private double latitude;
    private double longitude;
    private String javaTimeZoneId;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getJavaTimeZoneId() {
        return javaTimeZoneId;
    }

    public void setJavaTimeZoneId(String javaTimeZoneId) {
        this.javaTimeZoneId = javaTimeZoneId;
    }

    @Override
    public String toString() {
        return "GeoData [areaCode=" + areaCode + ", city=" + city + ", country=" + country + ", county=" + county + ", javaTimeZoneId="
                + javaTimeZoneId + ", latitude=" + latitude + ", longitude=" + longitude + ", state=" + state + ", zipCode=" + zipCode
                + "]";
    }

}
