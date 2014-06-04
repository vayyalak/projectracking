package com.gridpoint.energy.domainmodel;


/**
 * The description of a report parameter
 * 
 * @author mrochon
 */
public class ReportSetting {

    private String name;

    private ReportParameterType type;

    private String regex;

    private boolean required;
    
    public ReportSetting() {
    }

    public ReportSetting(String name, ReportParameterType type, String regex) {
        this(name, type, regex, true);
    }

    public ReportSetting(String name, ReportParameterType type, String regex, boolean required) {
        this.name = name;
        this.type = type;
        this.regex = regex;
        this.required = required;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

    public void setType(ReportParameterType type) {
        this.type = type;
    }

    public ReportParameterType getType() {
        return type;
    }

    /**
     * @return the required
     */
    public boolean isRequired() {
        return required;
    }

    /**
     * @param required
     *            the required to set
     */
    public void setRequired(boolean required) {
        this.required = required;
    }

}
