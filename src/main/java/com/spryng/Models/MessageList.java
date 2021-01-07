package com.spryng.Models;

import com.google.gson.annotations.SerializedName;

public class MessageList extends BaseObject {
    @SerializedName("total")
    public int total;

    @SerializedName("per_page")
    public int perPage;

    @SerializedName("current_page")
    public int currentPage;

    @SerializedName("last_page")
    public int lastPage;

    @SerializedName("next_page_url")
    public String nextPageURL;

    @SerializedName("prev_page_url")
    public String prevPageURL;

    @SerializedName("from")
    public int from;

    @SerializedName("to")
    public int to;

    @SerializedName("data")
    public Message[] data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public String getNextPageURL() {
        return nextPageURL;
    }

    public void setNextPageURL(String nextPageURL) {
        this.nextPageURL = nextPageURL;
    }

    public String getPrevPageURL() {
        return prevPageURL;
    }

    public void setPrevPageURL(String prevPageURL) {
        this.prevPageURL = prevPageURL;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public Message[] getData() {
        return data;
    }

    public void setData(Message[] data) {
        this.data = data;
    }
}
