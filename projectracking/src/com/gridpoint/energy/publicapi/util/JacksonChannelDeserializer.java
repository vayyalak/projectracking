package com.gridpoint.energy.publicapi.util;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import com.gridpoint.energy.domainmodel.Channel;
import com.gridpoint.energy.domainmodel.ChannelTotalType;
import com.gridpoint.energy.domainmodel.DataDictionaryType;
import com.gridpoint.energy.domainmodel.IntervalSize;

public class JacksonChannelDeserializer extends JsonDeserializer<Channel>  {
    @Override
    public Channel deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        Channel channel = new Channel();

        while (jp.nextToken() != JsonToken.END_OBJECT) {
            String fieldname = jp.getCurrentName();
            jp.nextToken(); // move to value, or START_OBJECT/START_ARRAY

            if (jp.getCurrentToken() == JsonToken.VALUE_NULL) {
                continue;
            }

            if (JSON.CHANNEL.CHANNEL_ID.equals(fieldname)) {
                channel.setChannelId(jp.getLongValue());
            } else if (JSON.CHANNEL.CHANNEL_NAME.equals(fieldname)) {
                channel.setChannelName(jp.getText());
            } else if (JSON.CHANNEL.DISPLAY_NAME.equals(fieldname)) {
                channel.setDisplayName(jp.getText());
            } else if (JSON.CHANNEL.REFERENCE_ID.equals(fieldname)) {
                channel.setReferenceId(jp.getText());
            } else if (JSON.CHANNEL.SCALE.equals(fieldname)) {
                channel.setScale(jp.getValueAsDouble());
            } else if (JSON.CHANNEL.GRANULARITY.equals(fieldname)) {
            	channel.setGranularity(IntervalSize.fromByte(IntervalSize.FIVE_MINUTE.getByteId()));
            } else if (JSON.CHANNEL.CATEGORY.equals(fieldname)) {
            	channel.setCategory(jp.getText());
            } else if (JSON.CHANNEL.SUBCATEGORY.equals(fieldname)) {
            	channel.setSubcategory(jp.getText());
            } else if (JSON.CHANNEL.TOTAL_TYPE.equals(fieldname)) {            	
            	channel.setTotalType(ChannelTotalType.fromString(jp.getText()));
            } else if (JSON.CHANNEL.DISABLED.equals(fieldname)) {
            	channel.setDisabled(jp.getBooleanValue());
            } else if (JSON.CHANNEL.UNIT_IDENTIFIER.equals(fieldname)) {
            	channel.setUnitIdentifier(jp.getText());
            } else if (JSON.CHANNEL.LEGACY.equals(fieldname)) {
                channel.setLegacy(jp.getBooleanValue());
            }
        }

        //
        // BUGBUG: The channel datatype is only partially serialized as
        // dictionaryName and dictionaryUnit. Unfortunately, these are not
        // easily deserialized into an appropriate DataDictionaryType object
        // that can be attached to the Channel object.
        //

        channel.setDataDictionaryType(DataDictionaryType.emptyType());
        return channel;
    }
}
