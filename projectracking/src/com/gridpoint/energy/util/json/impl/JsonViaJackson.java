package com.gridpoint.energy.util.json.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import com.gridpoint.energy.util.DebuggingInputStream;
import com.gridpoint.energy.util.TypeReference;
import com.gridpoint.energy.util.json.JsonDeserializer;
import com.gridpoint.energy.util.json.JsonException;
import com.gridpoint.energy.util.json.JsonSerializer;

public class JsonViaJackson implements JsonDeserializer, JsonSerializer {
    private static final Logger log = Logger.getLogger(JsonViaJackson.class);
    private ObjectMapper mapper;

    public JsonViaJackson() {
        mapper = new ObjectMapper();
    }

    @Override
    public String serialize(Object obj) throws JsonException {
        String result;
        try {
            result = mapper.writeValueAsString(obj);
        } catch (Exception ex) {
            throw wrapException(ex);
        }
        return result;
    }

    @Override
    public <T> T deserialize(String json, TypeReference<T> typeReference) {
        if (StringUtils.isEmpty(StringUtils.trimToEmpty(json))) {
            return null;
        }

        try {
            T result = mapper.<T> readValue(json, asThirdPartyTypeReference(typeReference));
            return result;
        } catch (Exception ex) {
            throw JsonException.whileDeserializing(json, ex);
        }
    }

    @Override
    public <T> T deserialize(InputStream jsonStream, Class<T> clazz) {
        ByteArrayOutputStream debugOut = new ByteArrayOutputStream();
        DebuggingInputStream debuggingInputStream = new DebuggingInputStream(jsonStream, debugOut);

        try {
            T result = mapper.readValue(debuggingInputStream, clazz);
            return result;
        } catch (Exception ex) {
            try {
                debuggingInputStream.readRemainder();
            } catch (IOException ioex) {
                log.error("Exception reading the remainder of debug output stream.  Throwing a JsonException with what we could capture.");
                throw JsonException.whileDeserializingPartial(debugOut.toByteArray(), ex);
            }
            throw JsonException.whileDeserializing(debugOut.toByteArray(), ex);
        }
    }

    private <T> org.codehaus.jackson.type.TypeReference<T> asThirdPartyTypeReference(final TypeReference<T> typeReference) {
        org.codehaus.jackson.type.TypeReference<T> tr = new org.codehaus.jackson.type.TypeReference<T>() {
            @Override
            public Type getType() {
                return typeReference.getType();
            }
        };
        return tr;
    }

    private JsonException wrapException(Exception ex) {
        return new JsonException(ex);
    }

}
