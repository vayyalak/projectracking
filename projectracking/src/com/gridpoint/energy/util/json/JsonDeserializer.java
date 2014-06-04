package com.gridpoint.energy.util.json;

import java.io.InputStream;

import com.gridpoint.energy.util.TypeReference;

public interface JsonDeserializer {

    <T> T deserialize(String json, TypeReference<T> typeReference) throws JsonException;

    <T> T deserialize(InputStream jsonStream, Class<T> clazz) throws JsonException;
}
