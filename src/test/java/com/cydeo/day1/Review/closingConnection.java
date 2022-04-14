package com.cydeo.day1.Review;

import java.sql.*;

public class closingConnection {

    public static void main(String[] args) {


        String url = "jdbc:oracle:thin:@50.16.40.33:1521:XE";
        String username = "hr";
        String password = "hr";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM EMPLOYEES");
            System.out.println("All is good ");
        } catch (SQLException e) {
            System.out.print("Error Occurred");
            System.out.println(e.getMessage());
        } finally {

            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();

            } catch (SQLException e) {
                System.out.print("Error Occurred while closing ");
                System.out.println(e.getMessage());
            }

        }


    }
}
