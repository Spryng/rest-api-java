package com.spryng;

public class Spryng implements Constants {
    private String apiKey;

    public MessageController message;



    public BalanceController balance;

    public Spryng(String apiKey) {
        setApiKey(apiKey);
        setMessage(new MessageController(this));
        setBalance(new BalanceController(this));
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public static String getEndpoint()
    {
        return Spryng.API_ENDOINT;
    }

    public BalanceController getBalance() {
        return balance;
    }

    public void setBalance(BalanceController balance) {
        this.balance = balance;
    }

    public MessageController getMessage() {
        return message;
    }

    public void setMessage(MessageController message) {
        this.message = message;
    }
}
