package com.cydeo.day1.Review;

import java.sql.*;

public class rsANDrsmd {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@50.16.40.33:1521:XE";
        String username = "hr";
        String password = "hr";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES");
            ResultSetMetaData rsmd = rs.getMetaData();


            while ( rs.next() ) {
                for (int i = 1; i < rsmd.getColumnCount(); i++) {
                    System.out.print(rs.getString(rsmd.getColumnName(i)) + " ");
                }
                System.out.println("");
            }
            System.out.println("connected");


        } catch (SQLException e) {

            System.out.println("Connection has failed " + e.getMessage());
            e.printStackTrace();

        }




    }
}