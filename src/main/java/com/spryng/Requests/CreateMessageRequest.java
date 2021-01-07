
package com.spryng.Requests;

import com.spryng.Models.Message;
import com.spryng.Utils.RequestMethod;

public class CreateMessageRequest extends AbstractRequest
{

    public final String URL_METHOD = "messages";

    public CreateMessageRequest()
    {
        this.isCollection = false;
    }

    @Override
    public RequestMethod getRequestMethod()
    {
        return RequestMethod.POST;
    }

    @Override
    public String getUrlResourceIdentifier() {
        return URL_METHOD;
    }

    @Override
    public Class<?> getClazz()
    {
        return Message.class;
    }

    @Override
    public String getURLMethod()
    {
        return null;
    }
}