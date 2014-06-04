package com.gridpoint.energy.domainmodel;

/**
 * Pojo to represent a channel type, which is the name of a channel
 * and the unit from it's associated data dictionary type.
 */
public class ChannelType {
    /** Name of the channel. */
    private final String name;

    /** Units as specified by the data dictionary. */
    private final String unit;

    public ChannelType(String name, String unit) {
        this.name = name;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChannelType that = (ChannelType) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ChannelType{" +
                "name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
