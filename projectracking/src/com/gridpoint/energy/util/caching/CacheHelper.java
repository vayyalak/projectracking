package com.gridpoint.energy.util.caching;

public class CacheHelper {
    /**
     * Create a key for our cache.
     */
    public static String key(Object ... values) {
        StringBuffer buffer = null;

        for (Object value : values) {
            if (buffer == null) {
                buffer = new StringBuffer(String.valueOf(value));
            } else {
                buffer.append(":");
                buffer.append(value);
            }
        }

        return buffer.toString();
    }

    public static String parseKey(String key, int index) {
        return key.split(":")[index];
    }

    public static long parseLongFromKey(String key, int index) {
        return Long.parseLong(parseKey(key, index));
    }
}