package org.transaction.statistics.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @version : 1.x.x.
 * @author: madasamy
 */
public class DateUtilsTest
{

    @Test
    public void testGetDateDifferenceInSeconds() throws Exception
    {
        System.out.println("--getDateDifferenceInSeconds---");
        long firstDateInMillis = 1525482900000l; //2018-May-05 09:15:00
        long secondDateInMillis = 1525482840000l;//2018-May-05 09:14:00
        assertEquals(60, DateUtils.getDateDifferenceInSeconds(firstDateInMillis, secondDateInMillis));
    }

}