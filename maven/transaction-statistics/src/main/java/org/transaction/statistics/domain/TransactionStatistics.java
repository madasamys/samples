package org.transaction.statistics.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @version : 1.x.x.
 * @author: madasamy
 */
public class TransactionStatistics
{
    private double sum;
    private double avg;
    private double max;
    private double min;
    private long count;

    public TransactionStatistics()
    {

    }

    public TransactionStatistics(double sum, double avg, double max, double min)
    {
        this.sum = sum;
        this.avg = avg;
        this.max = max;
        this.min = min;
    }

    public double getSum()
    {
        return sum;
    }

    public void setSum(double sum)
    {
        this.sum = sum;
    }

    public double getAvg()
    {
        return avg;
    }

    public void setAvg(double avg)
    {
        this.avg = avg;
    }

    public double getMax()
    {
        return max;
    }

    public void setMax(double max)
    {
        this.max = max;
    }

    public double getMin()
    {
        return min;
    }

    public void setMin(double min)
    {
        this.min = min;
    }

    public long getCount()
    {
        return count;
    }

    public void setCount(long count)
    {
        this.count = count;
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

        return new HashCodeBuilder().append(getSum())
                .append(getAvg())
                .append(getMax())
                .append(getMin())
                .append(getCount()).build();
    }
}
