package com.spryng;

import com.spryng.Exceptions.RequestException;
import com.spryng.Models.Message;
import com.spryng.Models.MessageList;
import com.spryng.Requests.CreateMessageRequest;
import com.spryng.Requests.GetMessageRequest;
import com.spryng.Requests.ListMessagesRequest;
import com.spryng.Utils.Filter;

import java.util.List;

public class MessageController extends Controller {

    public MessageController(Spryng client) {
        super(client);
    }

    public Message create(Message message) throws RequestException
    {
        this.http.setRequest(new CreateMessageRequest());
        this.http.setPostEntity(message);
        this.http.send();

        return (Message) this.http.getDeserializedResponse().getData();
    }

    public MessageList list(List<Filter> filters) throws RequestException {
        this.http.setRequest(new ListMessagesRequest());
        for (Filter filter : filters) {
            this.http.addFilter(filter);
        }

        this.http.send();
        return (MessageList) this.http.getDeserializedResponse().getData();
    }

    public Message get(String messageId) throws RequestException {
        this.http.setRequest(new GetMessageRequest(messageId));
        this.http.send();

        return (Message) this.http.getDeserializedResponse().getData();
    }
}
