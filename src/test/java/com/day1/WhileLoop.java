package com.day1;

import java.sql.*;

public class WhileLoop {

    public static void main(String[] args) {


        String url = "jdbc:oracle:thin:@50.16.40.33:1521:XE";
        String username = "hr";
        String password = "hr";

        try {
            Connection con = DriverManager.getConnection(url,username,password);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT *from REGIONS") ;
            // ResultSet rss = stmt.executeQuery("SELECT *from HR.EMPLOYEES") ;

            while (rs.next()==true) {
                System.out.println("Region NAME on first row is " + rs.getString("REGION_NAME"));
                System.out.println("Region ID on FORTH row is " + rs.getString("REGION_ID"));
                rs.next();
            }
        } catch (SQLException e) {
            System.out.println("Error has occurred " + e.getMessage() );

        }





    }
}



