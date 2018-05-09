package org.transaction.statistics.utils;

/**
 * @version : 1.x.x.
 * @author: madasamy
 */
public class DateUtils
{
    private static long ONE_SECOND_IN_MILLS = 1000;

    //Second date should be less than first date.
    public static long getDateDifferenceInSeconds(long firstDateInMillis, long secondDateInMillis)
    {
        long dateDifferenceInMillis = firstDateInMillis - secondDateInMillis;
        return dateDifferenceInMillis / ONE_SECOND_IN_MILLS;
    }
}
