package com.gridpoint.energy.util.json;


public interface JsonSerializer {

    String serialize(Object obj) throws JsonException;
}
