package org.transaction.statistics.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.transaction.statistics.domain.Transaction;
import org.transaction.statistics.domain.TransactionStatistics;

import static org.junit.Assert.*;

/**
 * @version : 1.x.x.
 * @author: madasamy
 */
public class TransactionServiceTest
{
    private ITransactionService transactionService = new TransactionService();

    @Before
    public void setUp() throws Exception
    {

    }

    @After
    public void tearDown() throws Exception
    {
        transactionService.deleteAll();
    }

    @Test
    public void testCreate() throws Exception
    {
        System.out.println("---create--");
        Transaction transaction = new Transaction(2000, 230989798887l);
        transactionService.create(transaction);
        assertEquals(1, transactionService.findAll().size());
    }

    @Test
    public void testFindStatistics() throws Exception
    {
        System.out.println("--findStatistics--");
        final long currentDateTimeInMillis = 1525482900000l; //2018-May-05 09:15:00
        TransactionService transactionService = new TransactionService()
        {
            @Override
            long getCurrentDateInMillis()
            {
                return currentDateTimeInMillis;
            }
        };
        long transactionDateTimeInMillis = 1525482840000l;//2018-May-05 09:14:00
        for (int i = 0; i < 10; i++) {
            transactionService.create(new Transaction(100, transactionDateTimeInMillis));
        }
        //Create transaction 2018-May-05 09:39:00
        transactionService.create(new Transaction(1000, 1525484340000l));

        TransactionStatistics result = transactionService.findStatistics();
        TransactionStatistics expected = new TransactionStatistics(1000,100, 100, 100);
        expected.setCount(10);
        assertEquals(expected, result);

    }

    @Test
    public void testIsValidTransaction()
    {
        System.out.println("--isValidTransaction--");
        final long currentDateTimeInMillis = 1525482900000l; //2018-May-05 09:15:00
        long transactionDateTimeInMillis = 1525482840000l;//1525484340000l;;//2018-May-05 09:14:00
        Transaction transaction = new Transaction(100, transactionDateTimeInMillis);
        TransactionService transactionService = new TransactionService()
        {
            @Override
            long getCurrentDateInMillis()
            {
                return currentDateTimeInMillis;
            }
        };
        assertTrue(transactionService.isValid(transaction));
    }

    @Test
    public void testIsNotValidTransactionWithFutureDateTime()
    {
        System.out.println("--isNotValidTransactionWithFutureDateTime--");
        final long currentDateTimeInMillis = 1525482900000l; //2018-May-05 09:15:00
        long transactionDateTimeInMillis = 1525484340000l;;//2018-May-05 09:39:00
        Transaction transaction = new Transaction(100, transactionDateTimeInMillis);
        TransactionService transactionService = new TransactionService()
        {
            @Override
            long getCurrentDateInMillis()
            {
                return currentDateTimeInMillis;
            }
        };
        assertFalse(transactionService.isValid(transaction));
    }

    @Test
    public void testIsNotValidTransaction()
    {
        System.out.println("--isNotValidTransaction--");
        final long currentDateTimeInMillis = 1525484340000l; //2018-May-05 09:15:00
        long transactionDateTimeInMillis = 1525482840000l;//2018-May-05 09:14:00
        Transaction transaction = new Transaction(100, transactionDateTimeInMillis);
        TransactionService transactionService = new TransactionService()
        {
            @Override
            long getCurrentDateInMillis()
            {
                return currentDateTimeInMillis;
            }
        };
        assertFalse(transactionService.isValid(transaction));
    }


    @Test
    public void testDelete() throws Exception
    {
        System.out.println("---create--");
        Transaction transaction = new Transaction(2000, 230989798887l);
        transactionService.create(transaction);
        transactionService.create(new Transaction(3000, 576576765l));
        assertEquals(2, transactionService.findAll().size());
        transactionService.delete(transaction);
        assertEquals(1, transactionService.findAll().size());
    }

    @Test
    public void testDeleteAll() throws Exception
    {
        Transaction transaction = new Transaction(2000, 230989798887l);
        transactionService.create(transaction);
        transactionService.create(new Transaction(3000, 576576765l));
        transactionService.deleteAll();
        assertEquals(0, transactionService.findAll().size());
    }
}