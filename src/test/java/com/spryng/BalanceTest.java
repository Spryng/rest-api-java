package com.spryng;

import com.spryng.Exceptions.RequestException;
import com.spryng.Models.Balance;
import org.junit.Test;

public class BalanceTest extends BaseTest {
    @Test
    public void testGetBalance() throws RequestException {
        Balance balance = this.client.balance.getBalance();

        assertNotNull(balance.amount);
    }
}
