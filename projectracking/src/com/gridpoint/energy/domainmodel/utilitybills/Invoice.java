package com.gridpoint.energy.domainmodel.utilitybills;

import java.util.Date;

public class Invoice {

	private Long id;
	private String vendor;
	private String meterNumber;
	private String accountNumber;
	private String invoiceNumber;
	private Date startDate;
	private Date endDate;
	private Double usage;
	private String uom;
	private Double multiplier;
	private Double totalBillAmount;
	private Double previousBalance;
	private Double currentCharge;
	private Double paymentAmount;
	private Integer daysInPeriod;
	private String billSource;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getMeterNumber() {
		return meterNumber;
	}
	public void setMeterNumber(String meterNumber) {
		this.meterNumber = meterNumber;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Double getUsage() {
		return usage;
	}
	public void setUsage(Double usage) {
		this.usage = usage;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public Double getMultiplier() {
		return multiplier;
	}
	public void setMultiplier(Double multiplier) {
		this.multiplier = multiplier;
	}
	public Double getTotalBillAmount() {
		return totalBillAmount;
	}
	public void setTotalBillAmount(Double totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
	}
	public Double getPreviousBalance() {
		return previousBalance;
	}
	public void setPreviousBalance(Double previousBalance) {
		this.previousBalance = previousBalance;
	}
	public Double getCurrentCharge() {
		return currentCharge;
	}
	public void setCurrentCharge(Double currentCharge) {
		this.currentCharge = currentCharge;
	}
	public Double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public Integer getDaysInPeriod() {
		return daysInPeriod;
	}
	public void setDaysInPeriod(Integer daysInPeriod) {
		this.daysInPeriod = daysInPeriod;
	}
	public String getBillSource() {
		return billSource;
	}
	public void setBillSource(String billSource) {
		this.billSource = billSource;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((invoiceNumber == null) ? 0 : invoiceNumber.hashCode());
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
		Invoice other = (Invoice) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (invoiceNumber == null) {
			if (other.invoiceNumber != null)
				return false;
		} else if (!invoiceNumber.equals(other.invoiceNumber))
			return false;
		if (meterNumber == null) {
			if (other.meterNumber != null)
				return false;
		} else if (!meterNumber.equals(other.meterNumber))
			return false;
		return true;
	}
}
