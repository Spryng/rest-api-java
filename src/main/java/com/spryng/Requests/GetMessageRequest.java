package com.spryng.Requests;

import com.spryng.Models.Message;
import com.spryng.Utils.RequestMethod;

public class GetMessageRequest extends AbstractRequest {

    public final String URL_METHOD = "messages";

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    protected String messageId;

    public GetMessageRequest(String messageId) {
        setMessageId(messageId);
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
    public Class<Message> getClazz() {
        return Message.class;
    }

    @Override
    public String getEndpoint() {
        return this.getUrlResourceIdentifier() + URL_PATH_SEPARATOR + getMessageId();
    }

    @Override
    public String getURLMethod() {
        return getMessageId();
    }

    public String getMessageId() {
        return messageId;
    }
}
