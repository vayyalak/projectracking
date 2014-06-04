package com.gridpoint.energy.domainmodel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Premises implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String description;
	private String referenceId;
	private String timezone;
	private String zipcode;
	private String address1;
	private String address2;
	private String province;
	private String city;
	private String country;
	private String phone1;
	private String phone2;
	private Date controlDate;
	private Date commissionDate;
	private Double sqfootage;
	private Double latitude;
	private Double longitude;
	private Double systemSize;
	private boolean hidden;

	// this is a bad naming convention, it should be "is*". This confuses
	// reflection, such as in JavaBeanToMapAdapter,
	// which looks for a getReadMethod() and in this case found null. Do not
	// continue to use "has*", or, if you have
	// to, be sure to create set* get* and has* methods (KPS)
	private boolean hasSubmetering;
	private boolean hasControl;
	private boolean hasEv;
	private boolean hasPv;

	private String legacySiteId;

	private String geocodeStatus;
	private Date geocodeDate;
	private List<String> paths;
	private Long admLegacyId;

	private Tenant tenant;

	public Premises() {
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public Date getControlDate() {
		return controlDate;
	}

	public void setControlDate(Date controlDate) {
		this.controlDate = controlDate;
	}

	public Date getCommissionDate() {
		return commissionDate;
	}

	public void setCommissionDate(Date commissionDate) {
		this.commissionDate = commissionDate;
	}

	public Double getSqfootage() {
		return sqfootage;
	}

	public void setSqfootage(Double sqfootage) {
		this.sqfootage = sqfootage;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	
	public Double getSystemSize() {
		return systemSize;
	}

	public void setSystemSize(Double systemSize) {
		this.systemSize = systemSize;
	}

	// this is a bad naming convention, it should be "is*". This confuses
	// reflection, such as in JavaBeanToMapAdapter,
	// which looks for a getReadMethod() and in this case found null. Adding
	// "get" to the name fixes this but is still
	// not ideal (KPS)
	public boolean getHasSubmetering() {
		return hasSubmetering();
	}

	public boolean hasSubmetering() {
		return hasSubmetering;
	}

	public void setHasSubmetering(boolean hasSubmetering) {
		this.hasSubmetering = hasSubmetering;
	}

	// this is a bad naming convention, it should be "is*". This confuses
	// reflection, such as in JavaBeanToMapAdapter,
	// which looks for a getReadMethod() and in this case found null. Adding
	// "get" to the name fixes this but is still
	// not ideal (KPS)
	public boolean getHasControl() {
		return hasControl();
	}

	public boolean hasControl() {
		return hasControl;
	}

	public void setHasControl(boolean hasControl) {
		this.hasControl = hasControl;
	}

	// this is a bad naming convention, it should be "is*". This confuses
	// reflection, such as in JavaBeanToMapAdapter,
	// which looks for a getReadMethod() and in this case found null. Adding
	// "get" to the name fixes this but is still
	// not ideal (KPS)
	public boolean getHasEv() {
		return hasEv();
	}

	public boolean hasEv() {
		return hasEv;
	}

	public void setHasEv(boolean hasEv) {
		this.hasEv = hasEv;
	}

	// this is a bad naming convention, it should be "is*". This confuses
	// reflection, such as in JavaBeanToMapAdapter,
	// which looks for a getReadMethod() and in this case found null. Adding
	// "get" to the name fixes this but is still
	// not ideal (KPS)
	public boolean getHasPv() {
		return hasPv();
	}

	public boolean hasPv() {
		return hasPv;
	}

	public void setHasPv(boolean hasPv) {
		this.hasPv = hasPv;
	}

	public String getLegacySiteId() {
		return legacySiteId;
	}

	public void setLegacySiteId(String legacySiteId) {
		this.legacySiteId = legacySiteId;
	}

	public int countCapabilities() {

		int capabilities = 0;

		if (hasSubmetering)
			capabilities++;
		if (hasEv)
			capabilities++;
		if (hasPv)
			capabilities++;
		if (hasControl)
			capabilities++;

		return capabilities;
	}

	public String getGeocodeStatus() {
		return geocodeStatus;
	}

	public void setGeocodeStatus(String geocodeStatus) {
		this.geocodeStatus = geocodeStatus;
	}

	public Date getGeocodeDate() {
		return geocodeDate;
	}

	public void setGeocodeDate(Date geocodeDate) {
		this.geocodeDate = geocodeDate;
	}

	public List<String> getPaths() {
		return paths;
	}

	public void setPaths(List<String> paths) {
		this.paths = paths;
	}

    @Deprecated
	public Long getAdmLegacyId() {
		return admLegacyId;
	}

    @Deprecated
	public void setAdmLegacyId(Long admLegacyId) {
		this.admLegacyId = admLegacyId;
	}

    @Override
    public String toString() {
        return "Premises{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
