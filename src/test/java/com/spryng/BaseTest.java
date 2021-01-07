package com.spryng;

import junit.framework.TestCase;

public class BaseTest extends TestCase {

    public Spryng client;

    public final String API_KEY = "";

    public BaseTest() {
        this.client = new Spryng(API_KEY);
    }
}
