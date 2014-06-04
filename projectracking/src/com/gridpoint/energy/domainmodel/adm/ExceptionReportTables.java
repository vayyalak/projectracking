package com.gridpoint.energy.domainmodel.adm;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExceptionReportTables {

    List<ExceptionReportColumn> columns;

    private String siteId;

    private String reportName;

    private String queryName;

    private Integer reportId;

    private Integer queryId;

    private String runDate;
    
    private Integer reportCount;

    private List<Map<String, Object>> reportData;

    public List<ExceptionReportColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<ExceptionReportColumn> columns) {
        this.columns = columns;
    }
    
    public void setReportCount(Integer reportCount) {
    	this.reportCount = reportCount;
    }
    
    public Integer getReportCount() {
    	return reportCount;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getReportName() {
        return reportName;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public Integer getQueryId() {
        return queryId;
    }

    public void setQueryId(Integer queryId) {
        this.queryId = queryId;
    }

    public String getRunDate() {
        return runDate;
    }

    public void setRunDate(String runDate) {
        this.runDate = runDate;
    }

    public List<Map<String, Object>> getReportData() {
        return reportData;
    }

    public void setReportData(List<Map<String, Object>> reportData) {
        this.reportData = reportData;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( queryId == null ) ? 0 : queryId.hashCode() );
        result = prime * result + ( ( queryName == null ) ? 0 : queryName.hashCode() );
        result = prime * result + ( ( reportId == null ) ? 0 : reportId.hashCode() );
        result = prime * result + ( ( reportName == null ) ? 0 : reportName.hashCode() );
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ExceptionReportTables other = (ExceptionReportTables) obj;
        if (queryId == null) {
            if (other.queryId != null) return false;
        } else if (!queryId.equals(other.queryId)) return false;
        if (queryName == null) {
            if (other.queryName != null) return false;
        } else if (!queryName.equals(other.queryName)) return false;
        if (reportId == null) {
            if (other.reportId != null) return false;
        } else if (!reportId.equals(other.reportId)) return false;
        if (reportName == null) {
            if (other.reportName != null) return false;
        } else if (!reportName.equals(other.reportName)) return false;
        return true;
    }
}
