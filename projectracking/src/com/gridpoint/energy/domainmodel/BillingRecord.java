package com.gridpoint.energy.domainmodel;

import java.sql.Timestamp;

/**
 * record representation for adm realized savings report.
 */
public class BillingRecord implements Cloneable, java.io.Serializable, Comparable<BillingRecord> {

    private static final long serialVersionUID = -8675344641942663468L;

    /** id of the premises the report is for. */
    private long premisesId;

    private boolean isDataComplete;

    private boolean hasGoodModel;

    /** adm site id the report is for. */
    private String siteId;

    /** Start date of the report. */
    private long start;

    /** End date of the report. */
    private long end;

    /** Number of heating degree days. */
    private int hdd;

    /** Number of cooling degree days. */
    private int cdd;

    /** Unit type (kwh or ccf) */
    private String units;

    /** usage amount in <i>units</i> */
    private double usage;

    /** usage if not for our help. */
    private double predictedUsage;

    /** $ amount of bill. */
    private double amount;

    /** cost without our help. */
    private double predictedAmount;

    /** percentage reduction, negative if we failed. */
    private double reduction;

    /** Number of bills in the range. */
    private int count;

    /** Should this bill be excluded. */
    private boolean exclude;

    private double a;
    private double b;
    private double c;
    private double r2;

    private Timestamp commissionDate;

    /** Premises sqFootage, null if we don't have the data. */
    private Double sqFootage;

    public long getPremisesId() {
        return this.premisesId;
    }

    public void setPremisesId(long premisesId) {
        this.premisesId = premisesId;
    }

    public boolean isDataComplete() {
        return isDataComplete;
    }

    public void setDataComplete(boolean dataComplete) {
        isDataComplete = dataComplete;
    }

    public boolean hasGoodModel() {
        return hasGoodModel;
    }

    public void setGoodModel(boolean hasGoodModel) {
        this.hasGoodModel = hasGoodModel;
    }

    public String getSiteId() {
        return this.siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public long getStart() {
        return this.start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return this.end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public int getHdd() {
        return this.hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public int getCdd() {
        return this.cdd;
    }

    public void setCdd(int cdd) {
        this.cdd = cdd;
    }

    public String getUnits() {
        return this.units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public double getUsage() {
        return this.usage;
    }

    public void setUsage(double usage) {
        this.usage = usage;
    }

    public double getPredictedUsage() {
        return this.predictedUsage;
    }

    public void setPredictedUsage(double predictedUsage) {
        this.predictedUsage = predictedUsage;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPredictedAmount() {
        return this.predictedAmount;
    }

    public void setPredictedAmount(double predictedAmount) {
        this.predictedAmount = predictedAmount;
    }

    public double getReduction() {
        return this.reduction;
    }

    public void setReduction(double reduction) {
        this.reduction = reduction;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean getExclude() {
        return this.exclude;
    }

    public void setExclude(boolean exclude) {
        this.exclude = exclude;
    }

    public double getA() {
        return this.a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return this.b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return this.c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getR2() {
        return this.r2;
    }

    public void setR2(double r2) {
        this.r2 = r2;
    }

    public Timestamp getCommissionDate() {
        return this.commissionDate;
    }

    public void setCommissionDate(Timestamp commissionDate) {
        this.commissionDate = commissionDate;
    }

    @Override
    public String toString() {
        return "[" + premisesId + ", " + siteId + ", " + start + ", " + end + ", " + hdd + ", " + cdd + ", " + units + ", " + usage + ", " + predictedUsage + ", " + amount + ", "
                + predictedAmount + ", " + reduction + ", " + count + ", " + exclude + ", " + a + ", " + b + ", " + c + ", " + r2 + ", " + commissionDate + "]";
    }

    public Double getSqFootage() {
        return sqFootage;
    }

    public void setSqFootage(Double sqFootage) {
        this.sqFootage = sqFootage;
    }

    @Override
    public int compareTo(BillingRecord o) {
       return o == null ? -1 : (start < o.start ? -1 : 1); 
    }

    @Override
    public BillingRecord clone() {
        try {
            return (BillingRecord) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone should always be supported by BillingRecord's super class.");
        }
    }
}
