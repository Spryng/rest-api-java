package com.spryng.Exceptions;

public class RequestException extends SpryngException
{
    public static final int INVALID_RESPONSE = 100;
    public static final int MALFORMED_URL = 101;
    public static final int INVALID_HTTP_METHOD = 102;
    public static final int UNSUPPORTED_ENCODING = 103;

    public RequestException(String message, int code)
    {
        super(message, code);
    }
}