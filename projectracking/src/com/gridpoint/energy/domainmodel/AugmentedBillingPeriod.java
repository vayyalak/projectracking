package com.gridpoint.energy.domainmodel;

public class AugmentedBillingPeriod {
    private final boolean canMainLoadBeUsed;
    private final BillingPeriod billingPeriod;

    public AugmentedBillingPeriod(boolean canMainLoadBeUsed, BillingPeriod billingPeriod) {
        this.canMainLoadBeUsed = canMainLoadBeUsed;
        this.billingPeriod = billingPeriod;
    }

    public boolean canMainLoadBeUsed() {
        return canMainLoadBeUsed;
    }

    public BillingPeriod getBillingPeriod() {
        return billingPeriod;
    }
}
