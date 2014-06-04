package com.gridpoint.energy.domainmodel;

public class BillingUsageAndAmount {
    private final double usage;
    private final double amount;

    public BillingUsageAndAmount (double usage, double amount) {
        this.usage = usage;
        this.amount = amount;
    }

    public double getUsage() {
        return usage;
    }

    public double getAmount() {
        return amount;
    }
}
