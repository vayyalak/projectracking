package com.gridpoint.energy.domainmodel;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: davids
 * Date: Oct 14, 2010
 * Time: 3:20:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class EnergyHogSummary implements Serializable {

    private static final long serialVersionUID = -1L;         // need unique ID
        
    private String name;
    private Long   good;
    private Long   normal;
    private Long   bad;

    public String getName()   { return name; }   public void setName  ( String value ) { name   = value ; }
    public Long   getGood()   { return good; }   public void setGood  ( Long   value ) { good   = value ; }
    public Long   getNormal() { return normal; } public void setNormal( Long   value ) { normal = value ; }
    public Long   getBad()    { return bad; }    public void setBad   ( Long   value ) { bad    = value ; }

}
