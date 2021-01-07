package com.spryng;

import com.spryng.Exceptions.RequestException;
import com.spryng.Models.Message;
import com.spryng.Models.MessageList;
import com.spryng.Utils.Filter;
import com.spryng.Utils.FilterOperator;
import org.junit.Test;

import java.util.ArrayList;

public class MessageTest extends BaseTest {
    @Test
    public void testCreateMessage() throws RequestException {
        Message msg = new Message();
        msg.body = "Test message";
        msg.recipients = new String[]{""};
        msg.reference = "abc123";
        msg.originator = "Spryng";
        msg.route = "business";

        Message sendMsg = this.client.message.create(msg);

        assertNotNull(sendMsg.id);
    }

    @Test
    public void testListMessages() throws RequestException {
        MessageList res = this.client.message.list(new ArrayList<>());
        assertNotNull(res.data);
    }

    @Test
    public void testListMessageWithFilter() throws RequestException {
        ArrayList filters = new ArrayList<Filter>();
        filters.add(new Filter("originator", FilterOperator.EQUALS, "Test"));
        MessageList res = this.client.message.list(filters);

        assertNotNull(res.data);
        for (Message msg : res.data) {
            assertEquals("Test", msg.originator);
        }
    }

    @Test
    public void testGetMessageById() throws RequestException {
        String testMessageID = "";

        Message msg = this.client.message.get(testMessageID);

        assertNotNull(msg);
        assertEquals(testMessageID, msg.id);
    }
}
