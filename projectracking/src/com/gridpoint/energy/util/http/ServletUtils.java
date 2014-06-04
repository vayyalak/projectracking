package com.gridpoint.energy.util.http;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;

public class ServletUtils {

    /**
     * HttpServletRequest body as a String, or empty String if there was no body or there was any error to read from it.
     * 
     * @param request
     * @return
     */
    public static String getRequestBody(HttpServletRequest request) {
        try {
            return new ObjectMapper().writeValueAsString(request.getParameterMap());
        } catch (Exception e) {
            return "";
        }
    }
}
