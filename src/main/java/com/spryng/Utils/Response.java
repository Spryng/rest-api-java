package com.spryng.Utils;

import com.spryng.Requests.AbstractRequest;

/**
 * Represents Spryng API Response.
 */
public class Response
{
    private AbstractRequest request;

    private Object data;

    private boolean requestWasSuccessful;

    /**
     * Instantiates a new Response.
     */
    public Response()
    {

    }

    /**
     * Instantiates a new Response.
     *
     * @param request               the request
     * @param requestWasSuccessful the request was successfull
     */
    public Response(AbstractRequest request, boolean requestWasSuccessful)
    {
        this(request, null, requestWasSuccessful);
    }

    /**
     * Instantiates a new Response.
     *
     * @param request               the request
     * @param data                  the data
     * @param requestWasSuccessful the request was successfull
     */
    public Response(AbstractRequest request, Object data, boolean requestWasSuccessful)
    {
        this.request = request;
        this.data = data;
        this.requestWasSuccessful = requestWasSuccessful;
    }

    /**
     * Gets request.
     *
     * @return the request
     */
    public AbstractRequest getRequest()
    {
        return request;
    }

    /**
     * Sets request.
     *
     * @param request the request
     */
    public void setRequest(AbstractRequest request)
    {
        this.request = request;
    }

    /**
     * Gets data.
     *
     * @return the data
     */
    public Object getData()
    {
        return data;
    }

    /**
     * Sets data.
     *
     * @param data the data
     */
    public void setData(Object data)
    {
        this.data = data;
    }

    /**
     * Is request was successfull boolean.
     *
     * @return the boolean
     */
    public boolean isRequestWasSuccessful()
    {
        return requestWasSuccessful;
    }

    /**
     * Sets request was successfull.
     *
     * @param requestWasSuccessful the request was successfull
     */
    public void setRequestWasSuccessful(boolean requestWasSuccessful)
    {
        this.requestWasSuccessful = requestWasSuccessful;
    }
}