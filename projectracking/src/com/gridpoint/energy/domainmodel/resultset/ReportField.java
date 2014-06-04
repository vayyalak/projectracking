package com.gridpoint.energy.domainmodel.resultset;

public class ReportField {

    private String name;
    private String value;
    private ColumnType type;

    public ReportField(String name, String value, ColumnType type) {
        this.name = name;
        this.value = value;
        this.type = type;
    }

    public ReportField(String name, Object value, ColumnType type) {
        this.name = name;
        this.value = (null == value) ? null : String.valueOf(value);
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public ColumnType getType() {
        return type;
    }

}
