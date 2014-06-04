package com.gridpoint.energy.domainmodel;

import com.gridpoint.energy.domainmodel.datetime.DateTZ;
import com.gridpoint.energy.domainmodel.TimeSeriesEntry;

public class TimeSeriesData {
	public final long channelId; 
	public final String channelName;
	public final String channelType;
	public final long premisesId;
	
	public final Double value;
	public final Double min;
	public final Double max;
	
	public ChannelTotalType totalType;
	public String channelCategory;
	public String measureType;
	public String unitOfMeasure;
    
	public final DateTZ dateTZ;
	
	public TimeSeriesData(long channelId, String channelName, String channelType, long premisesId, Double value, Double min, Double max, DateTZ dateTZ) {
		this.channelId = channelId;
		this.channelName = channelName;
		this.channelType = channelType;
		this.premisesId = premisesId;
		this.value = value;
		this.min = min;
		this.max = max;
		this.dateTZ = dateTZ;
	}
	
	
	
	public TimeSeriesData(long channelId, String channelName, String channelType, long premisesId, Double value, Double min, Double max, ChannelTotalType totalType,
            String channelCategory, String measureType, String unitOfMeasure, DateTZ dateTZ) {
        super();
        this.channelId = channelId;
        this.channelName = channelName;
        this.channelType = channelType;
        this.premisesId = premisesId;
        this.value = value;
        this.min = min;
        this.max = max;
        this.totalType = totalType;
        this.channelCategory = channelCategory;
        this.measureType = measureType;
        this.unitOfMeasure = unitOfMeasure;
        this.dateTZ = dateTZ;
    }



    @Override
	public int hashCode() {
		return (int)(channelId ^ premisesId ^ dateTZ.hashCode());
	}
	
	@Override
	public boolean equals(Object obj) {
		return hashCode() == obj.hashCode();
	}
	
	@Override
	public String toString() {
		return "premises id: " + premisesId + ", channel: (id: " + channelId + ", name: " + channelName + ", type: " + channelType +
			"), value: " + value + " (" + min + "/" + max + "), date:  " + dateTZ;
	}
	
	public static TimeSeriesData generateFromTimeSeriesEntry(long channelId, String channelName, String channelType, long premisesId, TimeSeriesEntry entry, ChannelTotalType totalType,
            String channelCategory, String measureType, String unitOfMeasure, DateTZ dateTZ) {
		
		Double value;
		if (entry.value().isDefined())
			value = (Double)entry.value().get();
		else
			value = null;
		Double min = entry.min().isDefined()?(Double)entry.min().get():value;
		Double max = entry.max().isDefined()?(Double)entry.max().get():value;
		return new TimeSeriesData(channelId, channelName, channelType, premisesId, 
                    value, min, max, totalType, channelCategory,
                    measureType, unitOfMeasure, dateTZ);
	}
}
