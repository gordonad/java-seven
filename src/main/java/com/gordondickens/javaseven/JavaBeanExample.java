package com.gordondickens.javaseven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.Expression;

public class JavaBeanExample {
    private static final Logger logger = LoggerFactory.getLogger(JavaBeanExample.class);

    public static void main(String args[]) {
        Person person = new Person();
        String arguments[] = {"Peter"};
        Expression expression = new Expression(null, person, "setName", arguments);

        try {
            logger.debug("Name: " + person.getName());
            expression.execute();
            logger.debug("Name: " + person.getName());

            expression = new Expression(null, person, "getName", null);
            logger.debug("Name: " + person.getName());
            expression.execute();
            logger.debug("getValue: " + expression.getValue());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

