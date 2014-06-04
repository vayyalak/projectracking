package com.gridpoint.energy.util;

import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.MapSerializer; 
import com.gridpoint.energy.domainmodel.datetime.DateTZ;
import com.gridpoint.energy.util.date.LocalDateTime.LocalDateTime;


public class JacksonMapSerializer extends MapSerializer{

    public JacksonMapSerializer(){
        this.handledType();
    }

    @Override
    @SuppressWarnings("deprecation")
    public void serialize(@SuppressWarnings("rawtypes") Map map, JsonGenerator jgen, SerializerProvider provider)throws IOException, JsonProcessingException{
        jgen.writeStartObject();
        for(Object key : map.keySet()){
            if(key instanceof DateTZ){
                DateTZ date = (DateTZ)key;
				LocalDateTime ldt = date.asLdt();
                jgen.writeObjectField(ldt.toString(), map.get(key));
            }else{
                jgen.writeObjectField(key.toString(), map.get(key));
            }
        }
        jgen.writeEndObject();
    }
}
