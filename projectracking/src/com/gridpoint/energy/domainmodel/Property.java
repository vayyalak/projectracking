package com.gridpoint.energy.domainmodel;

import java.io.Serializable;

/**
 * Property If Validation is null then do no validation, else it's a regex used to validate.
 */
public class Property implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String value;
    private String validationPattern;
    private boolean readOnly;

    public Property() {

    }

    public Property(final String name, final String value) {
        this.name = name;
        this.value = value;
    }

    public Property(final String name, final String value, final boolean readOnly) {
        this.name = name;
        this.value = value;
        this.readOnly = readOnly;
    }

    public Property(final String name, final String value, final String validationPattern) {
        this.name = name;
        this.value = value;
        this.validationPattern = validationPattern;
    }

    public Property(final String name, final String value, final String validationPattern, final boolean readOnly) {
        this.name = name;
        this.value = value;
        this.validationPattern = validationPattern;
        this.readOnly = readOnly;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValidationPattern() {
        return validationPattern;
    }

    public void setValidationPattern(String validationPattern) {
        this.validationPattern = validationPattern;
    }
    
    public boolean hasValidationPattern() {
        return this.validationPattern != null;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( name == null ) ? 0 : name.hashCode() );
        result = prime * result + ( readOnly ? 1231 : 1237 );
        result = prime * result + ( ( validationPattern == null ) ? 0 : validationPattern.hashCode() );
        result = prime * result + ( ( value == null ) ? 0 : value.hashCode() );
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Property other = (Property) obj;
        if (name == null) {
            if (other.name != null) return false;
        } else if (!name.equals(other.name)) return false;
        if (readOnly != other.readOnly) return false;
        if (validationPattern == null) {
            if (other.validationPattern != null) return false;
        } else if (!validationPattern.equals(other.validationPattern)) return false;
        if (value == null) {
            if (other.value != null) return false;
        } else if (!value.equals(other.value)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Property [name=" + name + ", readOnly=" + readOnly + ", validationPattern=" + validationPattern + ", value=" + value + "]";
    }

}
