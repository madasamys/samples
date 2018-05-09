package org.transaction.statistics.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author: madasamy
 * @version : 1.x.x.
 */
public class Transaction
{
    private double amount;
    private long timestamp;

    public Transaction()
    {
        //Do nothing indefault constructor
    }

    public Transaction(double amount, long timestamp)
    {
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public long getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(long timestamp)
    {
        this.timestamp = timestamp;
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object object)
    {
        return EqualsBuilder.reflectionEquals(this, object);
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder().append(getAmount()).append(getTimestamp()).build();
    }
}
