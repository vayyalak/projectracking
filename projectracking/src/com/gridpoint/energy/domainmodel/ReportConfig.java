package com.gridpoint.energy.domainmodel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.gridpoint.energy.domainmodel.ReportValidator.Operator;

/**
 * A description of an available report
 * 
 * @author mrochon
 */
public class ReportConfig {

    private Long id;
    private String name;

    private String type;
    private String path;

    private List<ReportSetting> params = new ArrayList<ReportSetting>();
    private Set<ReportValidator> validators = new HashSet<ReportValidator>();
    private Set<String> exportTypes = new HashSet<String>();

    private boolean applyToEv;
    private boolean applyToSolar;
    private boolean applyToSubmetering;
    
    public final static String ADVANCED_REPORTING_CAPABLE = "MSRT_CAPABLE";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void addParams(ReportSetting param) {
        this.params.add(param);
    }

    public void addParams(ReportSetting left, ReportSetting right, Operator operator) {
        this.params.add(left);
        this.params.add(right);
        this.addValidator(new ReportValidator(left, right, operator));
    }

    public void addValidator(ReportValidator validator) {
        validators.add(validator);
    }

    public List<ReportSetting> getParams() {
        return params;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setParams(List<ReportSetting> params) {
        this.params = params;
    }

    public void setValidators(Set<ReportValidator> validators) {
        this.validators = validators;
    }

    public Set<ReportValidator> getValidators() {
        return validators;
    }
    
    public void setExportTypes(Set<String> exportTypes) {
        this.exportTypes = exportTypes;
    }
    
    public Set<String> getExportTypes() {
        return exportTypes;
    }

    public boolean isApplyToEv() {
        return applyToEv;
    }

    public void setApplyToEv(boolean applyToEv) {
        this.applyToEv = applyToEv;
    }

    public boolean isApplyToSolar() {
        return applyToSolar;
    }

    public void setApplyToSolar(boolean applyToSolar) {
        this.applyToSolar = applyToSolar;
    }

    public boolean isApplyToSubmetering() {
        return applyToSubmetering;
    }

    public void setApplyToSubmetering(boolean applyToSubmetering) {
        this.applyToSubmetering = applyToSubmetering;
    }

    public class Validator {

    }
}
