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
public class TransactionStatisticsTest
{
    private TransactionStatistics transactionStatistics1;
    private TransactionStatistics transactionStatistics2;

    @Before
    public void setUp() throws Exception
    {
        transactionStatistics1 = new TransactionStatistics(1000, 100, 200, 100);
        transactionStatistics2 = new TransactionStatistics(transactionStatistics1.getSum(),transactionStatistics1.getAvg(),
                transactionStatistics1.getMax(), transactionStatistics1.getMin());
    }

    @Test
    public void testToString() throws Exception
    {
        System.out.println("--toString--");
        String result = transactionStatistics2.toString();
        assertTrue(result.contains("1000"));
        assertFalse(result.contains("300.0"));
    }

    @Test
    public void testEquals() throws Exception
    {
        System.out.println("--equals--");
        assertTrue(transactionStatistics1.equals(transactionStatistics2));
    }

    @Test
    public void testNotEquls()
    {
        transactionStatistics2.setSum(300);
        assertFalse(transactionStatistics1.equals(transactionStatistics2));
    }

    @Test
    public void testHashCode() throws Exception
    {
        Set<TransactionStatistics> transactionStatisticsSet = new HashSet<>();
        transactionStatisticsSet.add(transactionStatistics1);
        transactionStatisticsSet.add(transactionStatistics2);
        transactionStatisticsSet.add(new TransactionStatistics());
        assertEquals(2, transactionStatisticsSet.size());
    }
}