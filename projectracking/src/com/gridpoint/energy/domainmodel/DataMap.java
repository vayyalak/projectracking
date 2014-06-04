package com.gridpoint.energy.domainmodel;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnore;


/**
 * Used as a asset data type to value holder. (data types are things like coolTemp, heatTemp, heartbeat etc...) 
 * 
 */
public class DataMap implements Serializable{

	/**
     * 
     */
    private static final long serialVersionUID = 8044964272315821455L;

    private final Map<DataDictionaryType, Object> data = new HashMap<DataDictionaryType, Object>();

    public Map<DataDictionaryType, Object> getData() {
		return data;
	}
    
    public void setData(Map<DataDictionaryType, Object> newData) {
		data.putAll(newData);
	}

	/**
     * Add data
     * 
     * @param type the data type to add
     * @param value the value associated with that type
     */
    public void addData(DataDictionaryType type, Object value){
    	data.put(type, value);
    }
    
    /**
     * Gets the value associated with the type input
     * 
     * @param type
     * @return
     */
    public Object getValue(DataDictionaryType type){
    	return data.get(type);
    }
    
    /**
     * 
     * @param type 
     * @return true if the dataMap contains this type, false otherwise
     */
    public boolean contains(DataDictionaryType type){
    	return data.containsKey(type);
    }
    
    /**
     * Gets all data types stored in this bucket 
     * 
     * @return
     */
    @JsonIgnore
    public Set<DataDictionaryType> getDataTypes(){
    	return data.keySet();
    }

    /**
     *  Adds all the data types from the passed in DataMap to this DataMap
     * @param dataMap
     */

    public void addDataMap(DataMap dataMap){
        data.putAll(dataMap.data);
    }
}
