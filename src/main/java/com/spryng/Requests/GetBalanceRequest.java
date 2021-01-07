package com.spryng.Requests;

import com.spryng.Models.Balance;
import com.spryng.Utils.RequestMethod;

public class GetBalanceRequest extends AbstractRequest {

    public final String URL_METHOD = "balance";

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.GET;
    }

    @Override
    public String getUrlResourceIdentifier() {
        return URL_METHOD;
    }

    @Override
    public Class<Balance> getClazz() {
        return Balance.class;
    }

    @Override
    public String getURLMethod() {
        return null;
    }
}
