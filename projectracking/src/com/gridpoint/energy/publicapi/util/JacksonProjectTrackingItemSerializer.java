package com.gridpoint.energy.publicapi.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import com.gridpoint.energy.domainmodel.ProjectTrackingItem;

public class JacksonProjectTrackingItemSerializer extends JsonSerializer<ProjectTrackingItem> {
	
	@Override
    public Class<ProjectTrackingItem> handledType(){
        return ProjectTrackingItem.class;
    }

	@Override
	public void serialize(ProjectTrackingItem projectTracking,
			JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		jgen.writeStartObject();

		if (null != projectTracking.getProjectId()) {
			jgen.writeNumberField(JSON.PROJECT_TRACKING.PROJECT_ID,
					projectTracking.getProjectId());
		}

		if (null != projectTracking.getPremisesId()) {
			jgen.writeNumberField(JSON.PROJECT_TRACKING.PREMISES_ID,
					projectTracking.getPremisesId());
		}

		if (null != projectTracking.getProjectTypeId()) {
			jgen.writeNumberField(JSON.PROJECT_TRACKING.PROJECT_TYPE_ID,
					projectTracking.getProjectTypeId());
		}

		if (null != projectTracking.getProjectType()) {
			jgen.writeStringField(JSON.PROJECT_TRACKING.PROJECT_TYPE,
					projectTracking.getProjectType());
		}

		if (null != projectTracking.getProjectName()) {
			jgen.writeStringField(JSON.PROJECT_TRACKING.PROJECT_NAME,
					projectTracking.getProjectName());
		}

		if (null != projectTracking.getProjectStatus()) {
			jgen.writeStringField(JSON.PROJECT_TRACKING.STATUS,
					projectTracking.getProjectStatus());
		}

		if (null != projectTracking.getDeprecated()) {
			jgen.writeBooleanField(JSON.PROJECT_TRACKING.DEPRECATED,
					projectTracking.getDeprecated());
		}

		if (projectTracking.getStartDate() != null) {
			jgen.writeObjectField(JSON.PROJECT_TRACKING.START_DATE,
					projectTracking.getStartDate());
		}

		if (projectTracking.getEndDate() != null) {
			jgen.writeObjectField(JSON.PROJECT_TRACKING.END_DATE,
					projectTracking.getEndDate());
		}
		if (projectTracking.getChannels() != null && !projectTracking.getChannels().isEmpty()) {
				jgen.writeObjectField(JSON.PROJECT_TRACKING.CHANNELS,projectTracking.getChannels());
		}
		if (projectTracking.getSiteName() != null && !projectTracking.getSiteName().isEmpty()) {
			jgen.writeObjectField(JSON.PROJECT_TRACKING.SITE_NAME,
					projectTracking.getSiteName());
		}
		if (projectTracking.getErrorsAndWarnings() != null) {
			jgen.writeObjectField(JSON.PROJECT_TRACKING.PROJECT_ERROR_WARNING,
					projectTracking.getErrorsAndWarnings());
		}
		jgen.writeEndObject();
	}
									   
}
