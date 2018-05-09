package org.transaction.statistics.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @version : 1.x.x.
 * @author: madasamy
 */
public class TransactionTest
{
    private Transaction transaction1;
    private Transaction transaction2;

    @Before
    public void setUp() throws Exception
    {
        transaction1 = new Transaction(200.0, 2339009l);
        transaction2 = new Transaction(transaction1.getAmount(), transaction1.getTimestamp());

    }

    @Test
    public void testToString() throws Exception
    {
        System.out.println("--toString--");
        String result = transaction1.toString();
        assertTrue(result.contains("200.0"));
        assertFalse(result.contains("300.0"));
    }

    @Test
    public void testEquals() throws Exception
    {
        System.out.println("--equals--");
        assertTrue(transaction1.equals(transaction2));
    }

    @Test
    public void testNotEquls()
    {
        transaction1.setAmount(300);
        assertFalse(transaction1.equals(transaction2));
    }

    @Test
    public void testHashCode() throws Exception
    {
        Set<Transaction> transactions = new HashSet<>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(new Transaction());
        assertEquals(2, transactions.size());
    }
}