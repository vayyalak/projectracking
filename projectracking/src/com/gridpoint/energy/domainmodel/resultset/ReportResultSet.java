package com.gridpoint.energy.domainmodel.resultset;

import java.util.LinkedList;
import java.util.List;

import com.gridpoint.energy.domainmodel.ReportInstance;

public class ReportResultSet {

    ReportInstance reportInstance;
    
    List<ReportSection> sections;

    public ReportResultSet() {
        this(null);
    }

    public ReportResultSet(ReportInstance reportInstance) {
        this.reportInstance = reportInstance;
        sections = new LinkedList<ReportSection>();
    }
    
    public void setReportInstance(ReportInstance reportInstance) {
        this.reportInstance = reportInstance;
    }
    
    public ReportInstance getReportInstance() {
        return reportInstance;
    }
    
    public void addSection(ReportSection sheet) {
        sections.add(sheet);
    }
    
    public List<ReportSection> getSections() {
        return sections;
    }
    
    public ReportSection findByName(String name) {
        for(ReportSection section: sections) {
            if(name.equals(section.getSheetName())) {
                return section;
            }
        }
        return null;
    }
}
