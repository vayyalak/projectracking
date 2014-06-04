package com.gridpoint.energy.domainmodel;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonValue;

public class DataDictionaryType implements Serializable {
	private static final long serialVersionUID = 7468459179048887492L;
	
	
	protected long                id;
    protected String              name;
    protected String              description;
    protected String              unit;
    protected String              graphUnit;
    protected Class<?>            type;

    private DataDictionaryType(){
        // please don't construct this, use the DataDictionary in DataModel to get the db driven set of DataDictionaryTypes
    }

    private DataDictionaryType(Long id, String name, String description, String unit, String graphUnit, Class<?> type){
        this.id = id;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.graphUnit = graphUnit;
        this.type = type;
    }
    
    public static final DataDictionaryType emptyType() {
        return new DataDictionaryType();
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUnit() {
        return unit;
    }

    
    public String getGraphUnit() {
        return graphUnit;
    }

    public Class<?> getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataDictionaryType that = (DataDictionaryType) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (unit != that.unit) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
    

}
