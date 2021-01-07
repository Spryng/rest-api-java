package com.spryng.Models;

import com.google.gson.annotations.SerializedName;

public class Message extends BaseObject {
    @SerializedName("id")
    public String id;

    @SerializedName("encoding")
    public String encoding;

    @SerializedName("originator")
    public String originator;

    @SerializedName("route")
    public String route;

    @SerializedName("recipients")
    public String[] recipients;

    @SerializedName("body")
    public String body;

    @SerializedName("reference")
    public String reference;

    @SerializedName("credits")
    public float credits;

    @SerializedName("scheduled_at")
    public String scheduledAt;

    @SerializedName("canceled_at")
    public String canceledAt;

    @SerializedName("created_at")
    public String createdAt;

    @SerializedName("updated_at")
    public String updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public float getCredits() {
        return credits;
    }

    public void setCredits(float credits) {
        this.credits = credits;
    }

    public String getScheduledAt() {
        return scheduledAt;
    }

    public void setScheduledAt(String scheduledAt) {
        this.scheduledAt = scheduledAt;
    }

    public String getCanceledAt() {
        return canceledAt;
    }

    public void setCanceledAt(String canceledAt) {
        this.canceledAt = canceledAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
