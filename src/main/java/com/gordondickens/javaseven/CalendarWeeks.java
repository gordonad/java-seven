package com.gordondickens.javaseven;

import com.gordondickens.javaseven.concurrency.ForkJoin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.SimpleTimeZone;

public class CalendarWeeks {
    private static final Logger logger = LoggerFactory.getLogger(ForkJoin.class);

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        if (calendar.isWeekDateSupported()) {
            logger.debug("Number of weeks in this year: " + calendar.getWeeksInWeekYear());
            logger.debug("Current week number: " + calendar.get(Calendar.WEEK_OF_YEAR));
        }

        calendar.setWeekDate(2012, 16, 3);
        logger.debug(DateFormat.getDateTimeInstance(
                DateFormat.LONG, DateFormat.LONG).format(calendar.getTime()));

        calendar.setWeekDate(2022, 1, 1);
        logger.debug(DateFormat.getDateTimeInstance(
                DateFormat.LONG, DateFormat.LONG).format(calendar.getTime()));

        SimpleTimeZone simpleTimeZone = new SimpleTimeZone(
                -21600000,
                "CST",
                Calendar.MARCH, 1, -Calendar.SUNDAY,
                7200000,
                Calendar.NOVEMBER, -1, Calendar.SUNDAY,
                7200000,
                3600000);
        logger.debug(simpleTimeZone.getDisplayName() + " - " +
                simpleTimeZone.observesDaylightTime());

    }
}
