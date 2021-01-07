package com.spryng.Models;

import com.google.gson.annotations.SerializedName;

public class Balance extends BaseObject {
    @SerializedName("amount")
    public String amount;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
