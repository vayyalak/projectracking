package com.gridpoint.energy.publicapi.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Set;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.type.TypeReference;

import com.gridpoint.energy.domainmodel.ProjectTrackingItem;



public class JacksonProjectTrackingItemDeserializer extends JsonDeserializer<ProjectTrackingItem> {

	@Override
	public ProjectTrackingItem deserialize(JsonParser jp,DeserializationContext ctxt) throws IOException,JsonProcessingException {
		ProjectTrackingItem proTrackingItem = new ProjectTrackingItem();
		 
		while (jp.nextToken() != JsonToken.END_OBJECT) {
            String fieldname = jp.getCurrentName();
            jp.nextToken(); // move to value, or START_OBJECT/START_ARRAY

            if (jp.getCurrentToken() == JsonToken.VALUE_NULL) {
                continue;
            }

            if ("projectId".equals(fieldname)) {
            	proTrackingItem.setProjectId(jp.getLongValue());
            } else if ("premisesId".equals(fieldname)) {
            	proTrackingItem.setPremisesId(jp.getLongValue());
            } else if ("projectName".equals(fieldname)) {
            	proTrackingItem.setProjectName(jp.getText());
            } else if ("projectTypeId".equals(fieldname)) {
            	proTrackingItem.setProjectTypeId(jp.getLongValue());
            } else if ("projectType".equals(fieldname)) {
            	proTrackingItem.setProjectType(jp.getText());
            } else if ("channels".equals(fieldname)) {
            	proTrackingItem.setChannels(jp.<Set<String>>readValueAs(new TypeReference<Set<String>>(){}));
            } else if ("siteName".equals(fieldname)) {
            	proTrackingItem.setSiteName(jp.getText());
            }
		
	}
		return proTrackingItem;
   }
	
}
