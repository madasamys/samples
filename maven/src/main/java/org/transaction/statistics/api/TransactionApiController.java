package org.transaction.statistics.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.transaction.statistics.domain.Transaction;
import org.transaction.statistics.domain.TransactionStatistics;
import org.transaction.statistics.service.ITransactionService;

/**
 * @version : 1.x.x.
 * @author: madasamy
 */
@RestController
public class TransactionApiController
{
    @Autowired
    private ITransactionService transactionService;

    @RequestMapping(value = "/transactions", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody Transaction transaction)
    {
        if (transactionService.isValid(transaction)) {
            transactionService.create(transaction);
            return new ResponseEntity<Object>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public TransactionStatistics getStatistics()
    {
        return transactionService.findStatistics();
    }

}
