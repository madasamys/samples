package org.transaction.statistics.service;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Component;
import org.transaction.statistics.domain.Transaction;
import org.transaction.statistics.domain.TransactionStatistics;
import org.transaction.statistics.utils.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * @version : 1.x.x.
 * @author: madasamy
 */

@Component
public class TransactionService implements ITransactionService
{
    private List<Transaction> transactions = new ArrayList<>();
    private static long VALID_TRANSACTION_TIME_DIFFERENCE_IN_SECOND = 60;

    @Override
    public void create(Transaction transaction)
    {
        transactions.add(transaction);
    }

    @Override
    public List<Transaction> findAll()
    {
        return transactions;
    }

    @Override
    public TransactionStatistics findStatistics()
    {
        List<Transaction> filteredTransactions = transactions.stream().filter(this::isValid).collect(Collectors.toList());
        TransactionStatistics transactionStatistics = new TransactionStatistics();
        try {
            transactionStatistics.setSum(filteredTransactions.stream().mapToDouble(Transaction::getAmount).sum());
            transactionStatistics.setAvg(filteredTransactions.stream().collect(Collectors.averagingDouble(Transaction::getAmount)));
            transactionStatistics.setMax(filteredTransactions.stream().mapToDouble(Transaction::getAmount).max().getAsDouble());
            transactionStatistics.setMin(filteredTransactions.stream().mapToDouble(Transaction::getAmount).min().getAsDouble());
            transactionStatistics.setCount(filteredTransactions.size());
        }catch (Exception ex){

        }
        return transactionStatistics;
    }

    @Override
    public boolean isValid(Transaction transaction)
    {
        long dateDifferenceInSeconds = DateUtils.getDateDifferenceInSeconds(getCurrentDateInMillis(),
                transaction.getTimestamp());
        return dateDifferenceInSeconds <= VALID_TRANSACTION_TIME_DIFFERENCE_IN_SECOND && dateDifferenceInSeconds >= 0;
    }

    //Method should be package protected for unit test
    long getCurrentDateInMillis()
    {
        return new Date().getTime();
    }

    @Override
    public void delete(Transaction transaction)
    {
        transactions.remove(transaction);
    }

    @Override
    public void deleteAll()
    {
        transactions.clear();
    }
}
