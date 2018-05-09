package org.transaction.statistics.service;

import org.transaction.statistics.domain.Transaction;
import org.transaction.statistics.domain.TransactionStatistics;

import java.util.List;

/**
 * @author: madasamy
 * @version : 1.x.x.
 */
public interface ITransactionService
{
    void create(Transaction transaction);

    List<Transaction> findAll();

    TransactionStatistics findStatistics();

    boolean isValid(Transaction transaction);

    void delete(Transaction transaction);

    void deleteAll();

}
