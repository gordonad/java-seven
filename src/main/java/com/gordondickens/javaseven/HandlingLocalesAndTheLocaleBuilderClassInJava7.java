package com.gordondickens.javaseven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Locale.Builder;

public class HandlingLocalesAndTheLocaleBuilderClassInJava7 {
    private static final Logger logger = LoggerFactory.getLogger(HandlingLocalesAndTheLocaleBuilderClassInJava7.class);

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setWeekDate(2012, 16, 3);

        Builder builder = new Builder();
        builder.setLanguage("hy");
        builder.setScript("Latn");
        builder.setRegion("IT");
        builder.setVariant("arevela");

        Locale locale = builder.build();
        Locale.setDefault(locale);

        logger.debug(DateFormat.getDateTimeInstance(
                DateFormat.LONG, DateFormat.LONG).format(calendar.getTime()));
        logger.debug("" + locale.getDisplayLanguage());


        builder.setLanguage("zh");
        builder.setScript("Hans");
        builder.setRegion("CN");

        locale = builder.build();
        Locale.setDefault(locale);

        logger.debug(DateFormat.getDateTimeInstance(
                DateFormat.LONG, DateFormat.LONG).format(calendar.getTime()));
        logger.debug("" + locale.getDisplayLanguage());

        // Using the Locale.Category enumeration to display 
        // information using two different locales
//        Locale locale = Locale.getDefault();
//        Calendar calendar = Calendar.getInstance();
//        calendar.setWeekDate(2012, 16, 3);
//        
//        logger.debug(DateFormat.getDateTimeInstance(
//            DateFormat.LONG, DateFormat.LONG).format(calendar.getTime()));
//        logger.debug("" + locale.getDisplayLanguage());
//        
//        Locale.setDefault(Locale.Category.FORMAT, Locale.JAPANESE);
//        Locale.setDefault(Locale.Category.DISPLAY, Locale.GERMAN);
// 
//        logger.debug(DateFormat.getDateTimeInstance(
//            DateFormat.LONG, DateFormat.LONG).format(calendar.getTime()));   
//        logger.debug("" + locale.getDisplayLanguage());

    }
}
