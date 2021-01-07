package com.spryng;

import org.apache.http.HttpHeaders;

public interface Constants {
    /**
     * Version of the library
     */
    String VERSION = "1.0";
    /**
     * Version of the API to be appended to request URL
     */
    String API_VERSION = "v1";

    /**
     * The main endpoint for the API
     */
    String API_ENDOINT = "rest.spryngsms.com";
    /**
     * UTF_8 encoding
     */
    String UTF_8 = "utf-8";
    /**
     * The HTTP scheme.
     */
    String HTTP_SCHEME = "https";
    /**
     * Format of dates
     */
    String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssX";
    /**
     * URL Separator
     */
    String URL_PATH_SEPARATOR = "/";
    /**
     * User Agent for HTTP requests
     */
    String USER_AGENT = "SpryngJavaSDK/" + VERSION;
    /**
     * JSON content type header value
     */
    String JSON_CONTENT_TYPE = "application/json";
    /**
     * API Key header key
     */
    String HDR_APIKEY = "X-APIKEY";
    /**
     * Content type header key.
     */
    String HDR_CONTENT_TYPE = HttpHeaders.CONTENT_TYPE;
    /**
     * User agent header key.
     */
    String HDR_USER_AGENT = HttpHeaders.USER_AGENT;
}
