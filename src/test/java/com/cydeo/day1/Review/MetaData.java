package com.cydeo.day1.Review;

import java.sql.*;

public class MetaData {

    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@50.16.40.33:1521:XE";
        String username = "hr";
        String password = "hr";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES");

            ResultSetMetaData rsmd = rs.getMetaData();

            int index = rsmd.getColumnCount();
            String firs = rsmd.getColumnName(1);
            System.out.println("index  "+index + " firs = " + firs);
            for (int colindex = 1; colindex <index ; colindex++) {
                String colName = rsmd.getColumnName(colindex);
                System.out.println("colName = " + colName);
            }




            System.out.println("connected");


        } catch (SQLException e) {

            System.out.println("Connection has failed " + e.getMessage());
            e.printStackTrace();

        }




    }
}
