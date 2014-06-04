package com.gridpoint.energy.domainmodel;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collection;

public class System implements Serializable {

    private static final long serialVersionUID = 1L;
    private long systemId;
    private String name;

    private Collection<Channel> channels = new ArrayList<Channel>();

    public long getSystemId() {
        return this.systemId;
    }

    public void setSystemId(long systemId) {
        this.systemId = systemId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Channel> getChannels() {
        return this.channels;
    }

    public void setChannels(Collection<Channel> channels) {
        this.channels = channels;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof System) ? equals((System)o) : false;
    }

    public boolean equals(System system) {
        return systemId == system.getSystemId();
    }

    @Override
    public int hashCode() {
        return (int)systemId;
    }
}
