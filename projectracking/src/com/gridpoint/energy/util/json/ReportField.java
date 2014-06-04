package com.gridpoint.energy.util.json;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReportField {
    int position() default Integer.MAX_VALUE;
    int width() default -1;
    String name() default "";
    String title() default "";
    Justification justification() default Justification.CENTER;
    FieldFormat format() default FieldFormat.BASE;
    
    public enum FieldFormat {DATE, BASE,TIME}
    
    public enum Justification {LEFT, CENTER, RIGHT, JUSTIFY}
   
}
