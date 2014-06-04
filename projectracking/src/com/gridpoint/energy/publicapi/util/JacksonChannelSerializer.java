package com.gridpoint.energy.publicapi.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import com.gridpoint.energy.domainmodel.Channel;
import com.gridpoint.energy.util.ConversionUtil;
import com.gridpoint.energy.util.MeasurementSystem;

/**
 * Instead of serializing a data map with data dictionary type keys we want to send something more usable to the front end (whatever front end
 * that is). Serialize the Channel object into something more manageable to be used on some UI (flex/flash/html/javascript/swing etc...)
 *
 * @see JacksonFactory
 */
public class JacksonChannelSerializer extends JsonSerializer<Channel>  {
    private final ConversionUtil.Converter converter;

    @Override
    public Class<Channel> handledType(){
        return Channel.class;
    }

    public JacksonChannelSerializer(MeasurementSystem measurementSystem) {
        this.converter = ConversionUtil.getConverter(measurementSystem);
    }

    @Override
    public void serialize(Channel channel, JsonGenerator generator, SerializerProvider serializer) throws IOException, JsonProcessingException {
        generator.writeStartObject();
        generator.writeNumberField(JSON.CHANNEL.CHANNEL_ID, channel.getChannelId());
        generator.writeStringField(JSON.CHANNEL.CHANNEL_NAME, channel.getChannelName());
        generator.writeStringField(JSON.CHANNEL.DISPLAY_NAME, channel.getDisplayName());
        generator.writeStringField(JSON.CHANNEL.REFERENCE_ID, channel.getReferenceId());
        generator.writeNumberField(JSON.CHANNEL.SCALE, channel.getScale());
        generator.writeStringField(JSON.CHANNEL.DICTIONARY_UNIT, channel.getDataDictionaryType() == null ? null : converter.convertGraphUnit(channel.getDataDictionaryType().getGraphUnit()));
        generator.writeStringField(JSON.CHANNEL.DICTIONARY_NAME, channel.getDataDictionaryType() == null ? null : channel.getDataDictionaryType().getName());
        generator.writeStringField(JSON.CHANNEL.CALC_TYPE, (null == channel.getCalcType()) ? null : channel.getCalcType().toDbString());
        generator.writeBooleanField(JSON.CHANNEL.DISABLED, channel.isDisabled());
        generator.writeBooleanField(JSON.CHANNEL.INVISIBLE, channel.isInvisible());
        generator.writeStringField(JSON.CHANNEL.GRANULARITY, channel.getGranularity().name());
        generator.writeStringField(JSON.CHANNEL.TOTAL_TYPE, channel.getTotalType().name());
        generator.writeStringField(JSON.CHANNEL.CATEGORY, channel.getCategory());
        generator.writeStringField(JSON.CHANNEL.SUBCATEGORY, channel.getSubcategory());
        generator.writeStringField(JSON.CHANNEL.MEASURETYPE, channel.getMeasureType());
        generator.writeStringField(JSON.CHANNEL.UNIT_OF_MEASURE, channel.getUnitOfMeasure());
        generator.writeStringField(JSON.CHANNEL.UNIT_IDENTIFIER, channel.getUnitIdentifier());
        generator.writeBooleanField(JSON.CHANNEL.LEGACY, channel.isLegacy());
        generator.writeBooleanField(JSON.CHANNEL.DISPLAYED_BY_DEFAULT, channel.isDisplayedByDefault());
        
        generator.writeEndObject();
    }
}
