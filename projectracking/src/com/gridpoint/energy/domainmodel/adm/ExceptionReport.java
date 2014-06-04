package com.gridpoint.energy.domainmodel.adm;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = Inclusion.NON_NULL)
public class ExceptionReport {

    private List<ExceptionReportTables> tables;

    public void setTables(List<ExceptionReportTables> tables) {
        this.tables = tables;
    }

    public List<ExceptionReportTables> getTables() {
        return tables;
    }
}
