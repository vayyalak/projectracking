package com.gridpoint.energy.domainmodel;

public class ValueWithUnit {
    private final double value;
    private final String unit;

    public ValueWithUnit(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    public ValueWithUnit add(ValueWithUnit addee) {
        return new ValueWithUnit(this.value + addee.value, this.unit);
    }

    public ValueWithUnit add(double addee) {
        return new ValueWithUnit(this.value + addee, this.unit);
    }
}
