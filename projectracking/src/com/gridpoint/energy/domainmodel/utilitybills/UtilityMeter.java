package com.gridpoint.energy.domainmodel.utilitybills;

import java.io.Serializable;
import java.util.List;

import com.gridpoint.energy.util.date.LocalDateTime;

public class UtilityMeter implements Serializable{

	private Long meterId;
	private Long accountNumber;
	private String meterNumber;
	private String[] channels;
	private String deliveryAddress;	
	private String state;
	private String city;
	private String zip;
	private String country;
	private String serviceType;
	private String tariffName;
	private String tariffId;
	private LocalDateTime startDate;
	private String masterTariffId;
	private long tariffCode;
	private boolean status;
	private String message;
	private Long endUserId;
	private List<ChannelUsages> channelUsages;
	
	/**
	 * @return the accountNumber
	 */
	public Long getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * @return the meterNumber
	 */
	public String getMeterNumber() {
		return meterNumber;
	}
	/**
	 * @param meterNumber the meterNumber to set
	 */
	public void setMeterNumber(String meterNumber) {
		this.meterNumber = meterNumber;
	}
	/**
	 * @return the channels
	 */
	public String[] getChannels() {
		return channels;
	}
	/**
	 * @param channels the channels to set
	 */
	public void setChannels(String[] channels) {
		this.channels = channels;
	}
	/**
	 * @return the deliveryAddress
	 */
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	/**
	 * @param deliveryAddress the deliveryAddress to set
	 */
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the serviceType
	 */
	public String getServiceType() {
		return serviceType;
	}
	/**
	 * @param serviceType the serviceType to set
	 */
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	/**
	 * @return the meterId
	 */
	public Long getMeterId() {
		return meterId;
	}
	/**
	 * @param meterId the meterId to set
	 */
	public void setMeterId(Long meterId) {
		this.meterId = meterId;
	}
	/**
	 * @return the tariffName
	 */
	public String getTariffName() {
		return tariffName;
	}
	/**
	 * @param tariffName the tariffName to set
	 */
	public void setTariffName(String tariffName) {
		this.tariffName = tariffName;
	}
	/**
	 * @return the tariffId
	 */
	public String getTariffId() {
		return tariffId;
	}
	/**
	 * @param tariffId the tariffId to set
	 */
	public void setTariffId(String tariffId) {
		this.tariffId = tariffId;
	}
	/**
	 * @return the startDate
	 */
	public LocalDateTime getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the masterTariffId
	 */
	public String getMasterTariffId() {
		return masterTariffId;
	}
	/**
	 * @param masterTariffId the masterTariffId to set
	 */
	public void setMasterTariffId(String masterTariffId) {
		this.masterTariffId = masterTariffId;
	}
	/**
	 * @return the tariffCode
	 */
	public long getTariffCode() {
		return tariffCode;
	}
	/**
	 * @param tariffCode the tariffCode to set
	 */
	public void setTariffCode(long tariffCode) {
		this.tariffCode = tariffCode;
	}
	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the endUserId
	 */
	public Long getEndUserId() {
		return endUserId;
	}
	/**
	 * @param endUserId the endUserId to set
	 */
	public void setEndUserId(Long endUserId) {
		this.endUserId = endUserId;
	}
	/**
	 * @return the channelUsages
	 */
	public List<ChannelUsages> getChannelUsages() {
		return channelUsages;
	}
	/**
	 * @param channelUsages the channelUsages to set
	 */
	public void setChannelUsages(List<ChannelUsages> channelUsages) {
		this.channelUsages = channelUsages;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((meterId == null) ? 0 : meterId.hashCode());
		result = prime * result
				+ ((meterNumber == null) ? 0 : meterNumber.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UtilityMeter other = (UtilityMeter) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (meterId == null) {
			if (other.meterId != null)
				return false;
		} else if (!meterId.equals(other.meterId))
			return false;
		if (meterNumber == null) {
			if (other.meterNumber != null)
				return false;
		} else if (!meterNumber.equals(other.meterNumber))
			return false;
		return true;
	}
}
