package com.gridpoint.energy.util.tag;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.gridpoint.energy.util.DateFormats;


public class TagUtils {
	
	private static final ThreadLocal<DateFormat> dateFormatsIn = new ThreadLocal<DateFormat>();
    private static final ThreadLocal<DateFormat> dateFormatsOut = new ThreadLocal<DateFormat>();
    
    public static final String DATE_FORMAT_IN = "yyyy-MM-dd HH:mm:ss.S";
    public static final String DATE_FORMAT_OUT = DateFormats.DATE_FORMAT_TZ;
	
	public static class TagHolder {
    	public String name;
    	public String value;
    }
	
	public static final TagHolder getTagHolder(String name, String value, String timeZone) {
		TagHolder holder = new TagHolder();
    	
    	holder.name = name;
    	holder.value = value;
    	
    	//try to parse this as a 'commission date' string. Commission date has a very specific format that is used in the Realized Savings report
    	//Since the report does some db work on the dates directly we are going to do the transformation into some
    	//format that flex can understand here
    	
    	//2010-02-23 00:00:00.0
    	DateFormat format = dateFormatsIn.get();
    	if (format == null) {
    		format = new SimpleDateFormat(DATE_FORMAT_IN);
    		dateFormatsIn.set(format);
    	}
    	
    	TimeZone siteLocal = TimeZone.getTimeZone(timeZone);
    	
    	try {
    		//try to parse using our date format
    		format.setTimeZone(siteLocal);
    		Date commissiondate = format.parse(holder.value);
    		
    		
    		DateFormat formatOut = dateFormatsOut.get();
    		if (formatOut == null) {
    			formatOut = new SimpleDateFormat(DATE_FORMAT_OUT);
    			dateFormatsOut.set(formatOut);
    		}
    		
    		formatOut.setTimeZone(siteLocal);
    		
    		holder.value = formatOut.format(commissiondate);
		} catch (ParseException ignored) {
			//must not be a date
		}
    	
    	return holder;
	}

}
