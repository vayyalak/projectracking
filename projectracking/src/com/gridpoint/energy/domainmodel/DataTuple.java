package com.gridpoint.energy.domainmodel;

import java.io.Serializable;

/**
 *
 */
public class DataTuple implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Double value;
    private final Double min;
    private final Double max;

    public DataTuple (Double value, Double min, Double max) {
        this.value = value;
        this.min = min;
        this.max = max;
    }

    public Double getValue () {
        return value;
    }

    public Double getMin () {
        return min;
    }

    public Double getMax () {
        return max;
    }

    @Override
    public String toString(){
        return min+":"+value+":"+max;
    }
}
