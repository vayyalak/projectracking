package com.gridpoint.energy.domainmodel.reporting;

public class AlarmCounts {

    public AlarmCounts(String group, Type type, Long activeCount, Long closedCount) {
        this.group = group;
        this.type = type;
        this.activeCount = activeCount;
        this.closedCount = closedCount;
    }
    
    public enum Type {
        Alarm, Exception;
    }

    private String group;

    private Type type;

    private Long activeCount;

    private Long closedCount;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Long getActiveCount() {
        return activeCount;
    }

    public void setActiveCount(Long activeCount) {
        this.activeCount = activeCount;
    }

    public Long getClosedCount() {
        return closedCount;
    }

    public void setClosedCount(Long closedCount) {
        this.closedCount = closedCount;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getType() {
        return type.name();
    }

    public boolean isException(){
        return Type.Exception == this.type;
    }
}
