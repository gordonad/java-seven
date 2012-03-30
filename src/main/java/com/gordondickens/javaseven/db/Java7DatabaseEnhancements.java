package com.gordondickens.javaseven.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Java7DatabaseEnhancements {
    private static final Logger logger = LoggerFactory.getLogger(Java7DatabaseEnhancements.class);

    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/contact", "userName", "password");

            logger.debug("Schema: {}", con.getSchema());
            DatabaseMetaData metaData = con.getMetaData();

            logger.debug("Auto Generated Keys: {}", metaData.generatedKeyAlwaysReturned());

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        // Retrieving pseudo-columns
//        try {
//            Connection con = DriverManager.getConnection(
//                    "jdbc:derby://localhost:1527/contact", "userName", "password");
//            DatabaseMetaData metaData = con.getMetaData();
//            ResultSet resultSet = metaData.getPseudoColumns("", "schemaName", "tableName", "");
//
//
//            while (rs.next()) {
//                logger.debug(
// 					resultSet.getString("TABLE_SCHEM ")+" - "+
// 					resultSet.getString("COLUMN_NAME "));
//            }
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }

        // Controlling the type value of the OUT parameter
//        try {
//            Connection conn = DriverManager.getConnection(
//                    "...", "username", "password");
//            String query = "{CALL GETDATE(?,?)}";
//            CallableStatement callableStatement = (CallableStatement) conn.prepareCall(query);
//
//            callableStatement.setInt(1,recordIdentifier);
//            callableStatement.registerOutParameter(1, Types.DATE);
//            callableStatement.executeQuery();
//
//            date = callableStatement.getObject(2,Date.class));
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }


        // Other database enhancements
//        try {
//            Driver driver = DriverManager.getDriver("jdbc:derby://localhost:1527");
//            logger.debug("Parent Logger" + driver.getParentLogger());
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }

    }

}
