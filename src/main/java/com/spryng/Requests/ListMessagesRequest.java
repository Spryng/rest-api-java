package com.spryng.Requests;

import com.spryng.Models.Message;
import com.spryng.Models.MessageList;
import com.spryng.Utils.RequestMethod;

public class ListMessagesRequest extends AbstractRequest {

    public final String URL_METHOD = "messages";

    public ListMessagesRequest() {
        this.isCollection = true;
    }

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.GET;
    }

    @Override
    public String getUrlResourceIdentifier() {
        return URL_METHOD;
    }

    @Override
    public Class<MessageList> getClazz() {
        return MessageList.class;
    }

    @Override
    public String getURLMethod() {
        return null;
    }
}
