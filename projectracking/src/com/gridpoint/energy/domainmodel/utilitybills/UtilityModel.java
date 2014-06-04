package com.gridpoint.energy.domainmodel.utilitybills;

import java.util.Date;

public class UtilityModel {

	private String targetSiteId;
	private String account;
	private Double amountPaid;
	private Date billDate;
	private Date dueDate;
	private Double invoice;
	private Double invoiceTotalDue;
	private Double lateFees;
	private Double transactionFee;
	private Double serviceCost;
	private Integer serviceDays;
	private Date serviceFromDate;
	private Date serviceToDate;
	private String estimatedReading;
	private Double loadFactor;
	private String meterLocation;
	private String meterNumber;
	private Double meterReadingPrevious;
	private Double meterReadingCurrent;
	private String rateClass;
	private Double billedKW;
	private Double billedKVA;
	private Double kW;
	private Double kVA;
	private Double kWCost;
	private Double kVACost;
	private String uomActual;
	private Double usageComputed;
	private Double usageCost;
	private String uomComputed;
	private Double uomCost;
	private Double uomQtyActual;	
	private String vendor;
	private String service;
	private String deliveryAddress;
	private String state;
	private String city;
	private String zip;//Zip in csv is string for ex: in csv T2A 0
	private String county;
	private Integer rowNumber;
	public String getTargetSiteId() {
		return targetSiteId;
	}
	public void setTargetSiteId(String targetSiteId) {
		this.targetSiteId = targetSiteId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Double getInvoice() {
		return invoice;
	}
	public void setInvoice(Double invoice) {
		this.invoice = invoice;
	}
	public Double getInvoiceTotalDue() {
		return invoiceTotalDue;
	}
	public void setInvoiceTotalDue(Double invoiceTotalDue) {
		this.invoiceTotalDue = invoiceTotalDue;
	}
	public Double getLateFees() {
		return lateFees;
	}
	public void setLateFees(Double lateFees) {
		this.lateFees = lateFees;
	}
	public Double getTransactionFee() {
		return transactionFee;
	}
	public void setTransactionFee(Double transactionFee) {
		this.transactionFee = transactionFee;
	}
	public Double getServiceCost() {
		return serviceCost;
	}
	public void setServiceCost(Double serviceCost) {
		this.serviceCost = serviceCost;
	}
	public Integer getServiceDays() {
		return serviceDays;
	}
	public void setServiceDays(Integer serviceDays) {
		this.serviceDays = serviceDays;
	}
	public Date getServiceFromDate() {
		return serviceFromDate;
	}
	public void setServiceFromDate(Date serviceFromDate) {
		this.serviceFromDate = serviceFromDate;
	}
	public Date getServiceToDate() {
		return serviceToDate;
	}
	public void setServiceToDate(Date serviceToDate) {
		this.serviceToDate = serviceToDate;
	}
	public String getEstimatedReading() {
		return estimatedReading;
	}
	public void setEstimatedReading(String estimatedReading) {
		this.estimatedReading = estimatedReading;
	}
	public Double getLoadFactor() {
		return loadFactor;
	}
	public void setLoadFactor(Double loadFactor) {
		this.loadFactor = loadFactor;
	}
	public String getMeterLocation() {
		return meterLocation;
	}
	public void setMeterLocation(String meterLocation) {
		this.meterLocation = meterLocation;
	}
	public String getMeterNumber() {
		return meterNumber;
	}
	public void setMeterNumber(String meterNumber) {
		this.meterNumber = meterNumber;
	}
	public Double getMeterReadingPrevious() {
		return meterReadingPrevious;
	}
	public void setMeterReadingPrevious(Double meterReadingPrevious) {
		this.meterReadingPrevious = meterReadingPrevious;
	}
	public Double getMeterReadingCurrent() {
		return meterReadingCurrent;
	}
	public void setMeterReadingCurrent(Double meterReadingCurrent) {
		this.meterReadingCurrent = meterReadingCurrent;
	}
	public String getRateClass() {
		return rateClass;
	}
	public void setRateClass(String rateClass) {
		this.rateClass = rateClass;
	}
	public Double getBilledKW() {
		return billedKW;
	}
	public void setBilledKW(Double billedKW) {
		this.billedKW = billedKW;
	}
	public Double getBilledKVA() {
		return billedKVA;
	}
	public void setBilledKVA(Double billedKVA) {
		this.billedKVA = billedKVA;
	}
	public Double getKW() {
		return kW;
	}
	public void setKW(Double kW) {
		this.kW = kW;
	}
	public Double getKVA() {
		return kVA;
	}
	public void setKVA(Double kVA) {
		this.kVA = kVA;
	}
	public Double getKWCost() {
		return kWCost;
	}
	public void setKWCost(Double kWCost) {
		this.kWCost = kWCost;
	}
	public Double getKVACost() {
		return kVACost;
	}
	public void setKVACost(Double kVACost) {
		this.kVACost = kVACost;
	}
	public String getUomActual() {
		return uomActual;
	}
	public void setUomActual(String uomActual) {
		this.uomActual = uomActual;
	}
	public Double getUsageComputed() {
		return usageComputed;
	}
	public void setUsageComputed(Double usageComputed) {
		this.usageComputed = usageComputed;
	}
	public Double getUsageCost() {
		return usageCost;
	}
	public void setUsageCost(Double usageCost) {
		this.usageCost = usageCost;
	}
	public String getUomComputed() {
		return uomComputed;
	}
	public void setUomComputed(String uomComputed) {
		this.uomComputed = uomComputed;
	}
	public Double getUomCost() {
		return uomCost;
	}
	public void setUomCost(Double uomCost) {
		this.uomCost = uomCost;
	}
	public Double getUomQtyActual() {
		return uomQtyActual;
	}
	public void setUomQtyActual(Double uomQtyActual) {
		this.uomQtyActual = uomQtyActual;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public Integer getRowNumber() {
		return rowNumber;
	}
	public void setRowNumber(Integer rowNumber) {
		this.rowNumber = rowNumber;
	}
	
	//private String balanceForward;-->removed column from new csv file
	
}
