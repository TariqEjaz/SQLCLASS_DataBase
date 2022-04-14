package com.cydeo.day1;

import java.sql.*;

public class NavigatingQueryResult {

    public static void main(String[] args) {


        String url = "jdbc:oracle:thin:@50.16.40.33:1521:XE";
        String username = "hr";
        String password = "hr";

        try {
            Connection conn = DriverManager.getConnection(url,username,password);

            Statement stmt = conn.createStatement();

          ResultSet rs = stmt.executeQuery("SELECT *from REGIONS") ;
           // ResultSet rss = stmt.executeQuery("SELECT *from HR.EMPLOYEES") ;

            rs.next() ;
          //  System.out.println("Region ID on first row is " + rs.getString(1));
         //   System.out.println("Region ID on first row is " + rs.getString("REGION_ID"));
          //  System.out.println("Region NAME on first row is " + rs.getString(2));
            System.out.println("Region NAME on first row is " + rs.getString("REGION_NAME"));
            System.out.println("Region ID on FORTH row is " + rs.getString("REGION_ID"));

            rs.next() ;
            System.out.println("Region NAME on SECOND row is " + rs.getString("REGION_NAMe"));
            System.out.println("Region ID on FORTH row is " + rs.getString("REGION_ID"));

            rs.next() ;
            System.out.println("Region NAME on THIRD row is " + rs.getString("REGION_NAME"));
            System.out.println("Region ID on FORTH row is " + rs.getString("REGION_ID"));


            System.out.println("Do we have more dara " + rs.next());
            System.out.println("Region NAME on FORTH row is " + rs.getString("REGION_NAME"));
            System.out.println("Region ID on FORTH row is " + rs.getString("REGION_ID"));

            System.out.println("Do we have more data " + rs.next());
            System.out.println("Region NAME on FORTH row is " + rs.getString("REGION_NAME"));


            System.out.println("Do we have more dara " + rs.next());
            rs.previous() ;


        } catch (SQLException e) {
            System.out.println("Error has occurred " + e.getMessage() );

        }





    }
}

