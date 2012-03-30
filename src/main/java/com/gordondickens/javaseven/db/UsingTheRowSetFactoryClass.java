package com.gordondickens.javaseven.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

public class UsingTheRowSetFactoryClass {
    private static final Logger logger = LoggerFactory.getLogger(UsingTheRowSetFactoryClass.class);


    public static void main(String[] args) {
        String databaseUrl = "jdbc:derby://localhost:1527/contact";
        String username = "richard";
        String password = "password";

        RowSetFactory rowSetFactory = null;
        try {
            rowSetFactory = RowSetProvider.newFactory("com.sun.rowset.RowSetFactoryImpl", null);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return;
        }

        try (
                JdbcRowSet rowSet = rowSetFactory.createJdbcRowSet();) {

            rowSet.setUrl(databaseUrl);
            rowSet.setUsername(username);
            rowSet.setPassword(password);
            rowSet.setCommand("SELECT * FROM COLLEAGUES");
            rowSet.execute();

            while (rowSet.next()) {
                logger.debug(rowSet.getInt("ID") + " - "
                        + rowSet.getString("FIRSTNAME"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
