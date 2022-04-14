package com.cydeo.day1;

import java.sql.*;

public class LoopingBackward {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@50.16.40.33:1521:XE";
        String username = "hr" ;
        String password = "hr" ;

        Connection conn = DriverManager.getConnection(url,username,password) ;
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs   = stmt.executeQuery("SELECT * FROM EMPLOYEES") ;

        // use afterLast() method to go to after last location
        // use previous() method to move backward
        // and check whether we have valid previous row or not
        // stop if there is no more valid row
        rs.afterLast();

        while( rs.previous() ) {
            System.out.println(rs.getString("EMPLOYEE_ID") + " "
                    + rs.getString("FIRST_NAME"));

        }



    }

}


