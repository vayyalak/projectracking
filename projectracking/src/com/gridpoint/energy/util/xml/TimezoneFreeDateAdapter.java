package com.gridpoint.energy.util.xml;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * When importing xml with jaxb, by default a schemaless xml file will evaluate dates with the format
 * "yyyy-MM-dd'T'HH:mm:ss". We need to support time zones under certain circumstances. When you need 
 * to support a date with a timezone annotate the date field with 
 * @XmlJavaTypeAdapter(TimezoneFreeDateAdapter.class) and it will use this object to marshall
 * and unmarshall dates to/from XML.
 * 
 * This object is designed to help with importing meter data. When importing data 
 * we want to blindly change the timezone to UTC without modifying the timestamp 
 * in any other way.
 * 
 * This may seem counter intuitive but in the context of keeping the services layer timezone agnostic
 * it makes sense.
 * 
 * For example: If I have a meter read for [Feb 10th, 2010 5:00 AM -0500] (EST) then we do not want to
 * store it as [Feb 10th, 2010 10:00 AM +0000] (UTC) because the UI will request UTC times which do not
 * take into account the premises time zone. This is actually the desired behaviour because we do not 
 * want to handle complex timezone calculations inside the services layer.
 * 
 * A simple use case would be the following:
 * 
 * My tenant uploads my 5 minute, electric meter data for Feb 10th 2010 EST.
 * 
 * If we do not ignore the timezone that is specified, the data will be saved as 
 * [Feb 10th 2010 05:00:00 UTC - Feb 11th 2010 04:59:59 UTC].
 * 
 * When the UI requests the meter data it asks for [Feb 10 2010 UTC] and the data 
 * that is returned is from that range, not the range we just inserted for [Feb 10 2010 EST].
 * 
 * The correct way to achieve this in a timezone-agnostic way on the server is to ignore that timezone
 * that was passed in the XML. In our use case where we insert data for [Feb 10th 2010 EST], we should
 * explicitly treat this as a pre-adjusted UTC time and only change the timezone specifier.
 * 
 * This way when the UI requests the meter reads for Feb 10 2010 UTC, the system is actually returning 
 * them in the premises timezone for the graph to display
 * 
 * This way only this batchfile processor has to understand about the timezones of the data
 * it is inserting and the server and UI can just assume it is all UTC.
 * 
 * The only drawback of this approach is that for auditing we would need to adjust the meter reads by
 * premises timezone in the database to know what "real" time it was generated at.
 * 
 * @author mrochon
 *
 */

public class TimezoneFreeDateAdapter extends XmlAdapter<String, Date> {

    @Override
    public String marshal(Date v) throws Exception {
        //store the date as utc
        final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        
        return formatter.format(v);
    }

    @Override
    public Date unmarshal(String v) throws Exception {
        DateFormat formatter = null;
        final Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        
        try {
            //unmarshall the date as unadjusted utc
            //ignore the time zone and treat the rest as already utc
            formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            formatter.setCalendar(cal);
            formatter.parse(v);
    
            Date d = cal.getTime();
            return d;
        }catch(Exception e){
          //unmarshall the date as unadjusted utc
            //ignore the time zone and treat the rest as already utc
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            formatter.setCalendar(cal);
            formatter.parse(v);
    
            Date d = cal.getTime();
            return d;
        }
      
    }

}
