package com.gridpoint.energy.domainmodel.resultset;

public enum ColumnType {
    STRING, DATE, NUMBER;

    public String stringValue() {
        switch (this) {
            case DATE:
                return "Date";
            case NUMBER:
                return "Number";
            default:
                return "String";
        }
    }
}
