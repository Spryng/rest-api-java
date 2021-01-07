package com.spryng;

import com.spryng.Spryng;
import com.spryng.Utils.RequestHandler;

public class Controller {
    protected Spryng client;
    protected RequestHandler http;

    public Controller(Spryng client) {
        this.client = client;
        this.http = new RequestHandler();
        this.http.addHeader("Authorization", "Bearer " + client.getApiKey());
    }
}
