package com.gridpoint.energy.domainmodel.resultset;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringEscapeUtils;

public class ReportSection {

    private String sheetName;

    private List<ReportColumn> columns = new LinkedList<ReportColumn>();

    private List<List<ReportField>> rows = new LinkedList<List<ReportField>>();

    public int numColumns(){
        return columns.size();
    }

    public int numRows(){
        return rows.size();
    }

    public List<ReportColumn> getColumns() {
        Collections.sort(columns, new Comparator<ReportColumn>() {
            @Override
            public int compare(ReportColumn arg0, ReportColumn arg1) {
                return Integer.valueOf(arg0.getOrdinal()).compareTo(arg1.getOrdinal());
            }
        });
        return columns;
    }

    public String getSheetName() {
        return sheetName;
    }

    public List<List<ReportField>> getRows() {
        return rows;
    }

    public void addRow(List<ReportField> row) {
        rows.add(row);
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public void setColumns(List<ReportColumn> columns) {
        this.columns = columns;
    }
}
