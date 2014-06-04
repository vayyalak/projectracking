package com.gridpoint.energy.domainmodel;

import java.util.Collection;

public class EnduserLabel{

    public EnduserLabel(long id, long enduserId, String name, String color, Collection<Long> premisesIds){
        this.id = id;
        this.enduserId = enduserId;
        this.name = name;
        this.color = color;
        this.premisesIds = premisesIds;
    }

    private long id;

    private long enduserId;

    private String name;

    private String color;

    private Collection<Long> premisesIds;

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public long getEnduserId(){
        return enduserId;
    }

    public void setEnduserId(long enduserId){
        this.enduserId = enduserId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public Collection<Long> getPremisesIds(){
        return premisesIds;
    }

    public void setPremisesIds(Collection<Long> premisesIds){
        this.premisesIds = premisesIds;
    }
}
