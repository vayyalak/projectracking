package com.gridpoint.energy.util.json;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.gridpoint.energy.util.MeasurementOf;
import com.gridpoint.energy.util.MeasurementSystem;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConvertibleUnit{

    public MeasurementOf measure();
    public MeasurementSystem system();

}
