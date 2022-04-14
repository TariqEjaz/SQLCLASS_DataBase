package com.day1.Review;

import java.sql.*;

public class Looping {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@50.16.40.33:1521:XE";
        String username = "hr";
        String password = "hr";


        Connection conn = DriverManager.getConnection(url,username,password) ;
        Statement  stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY) ;
        ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES");

        while ( rs.next() ) {
            rs.getRow();
            System.out.println( rs.getRow()+" "+rs.getString(  "EMPLOYEE_ID") + " " + rs.getString("SALARY"));

            rs.last();
            System.out.println("rs.getRow() = " + rs.getRow());



        }
    }


}
