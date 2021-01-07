package com.spryng;

import com.spryng.Exceptions.RequestException;
import com.spryng.Models.Balance;
import com.spryng.Requests.GetBalanceRequest;

public class BalanceController extends Controller {
    public BalanceController(Spryng client) {
        super(client);
    }

    public Balance getBalance() throws RequestException {
        this.http.setRequest(new GetBalanceRequest());
        this.http.send();

        return (Balance) this.http.getDeserializedResponse().getData();
    }
}
