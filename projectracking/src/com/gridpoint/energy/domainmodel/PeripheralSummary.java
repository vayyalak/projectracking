package com.gridpoint.energy.domainmodel;

import org.apache.commons.lang.StringUtils;

public class PeripheralSummary {
    private String name;

    public String getName() {
        return name;
    }

    public PeripheralSummary(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object arg0) {
        if (arg0 instanceof PeripheralSummary) {
            PeripheralSummary that = (PeripheralSummary) arg0;
            return StringUtils.equals(that.name, name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (null == name) ? 0 : name.hashCode();
    }

    @Override
    public String toString() {
        return "name:" + name;
    }
}
