package com.gridpoint.energy.domainmodel.resultset;

public class ReportColumn {

    private String name;
    private int ordinal;
    private String displayName;

    public ReportColumn(String name, String displayName, int ordinal) {
        this.name = name;
        this.displayName = displayName;
        this.ordinal = ordinal;
    }

    public String getName() {
        return name;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public String getDisplayName() {
        return displayName;
    }
}
