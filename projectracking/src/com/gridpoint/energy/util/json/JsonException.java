package com.gridpoint.energy.util.json;

import static com.gridpoint.energy.util.Charsets.UTF_8;

public class JsonException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public JsonException() {
        super();
    }

    public static JsonException whileDeserializingPartial(byte[] bytes, Throwable cause) {
        String json = new String(bytes, UTF_8);
        return new JsonException("Error deserializing JSON String (partial): "+json, cause);
    }

    public static JsonException whileDeserializing(byte[] bytes, Throwable cause) {
        String json = new String(bytes, UTF_8);
        return whileDeserializing(json, cause);
    }

    public static JsonException whileDeserializing(String json, Throwable cause) {
        return new JsonException("Error deserializing JSON String: " + json, cause);
    }

    public JsonException(String message, Throwable cause) {
        super(message, cause);
    }

    public JsonException(String message) {
        super(message);
    }

    public JsonException(Throwable cause) {
        super(cause);
    }

}
