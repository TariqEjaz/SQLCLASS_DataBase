package com.cydeo.day2;

import java.sql.*;

public class GettingColumInformation {

    public static void main(String[] args) throws SQLException {


        String url = "jdbc:oracle:thin:@50.16.40.33:1521:XE";
        String username = "hr" ;
        String password = "hr" ;

        Connection conn = DriverManager.getConnection(url,username,password) ;
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs   = stmt.executeQuery("SELECT * FROM EMPLOYEES") ;

        // We want to extract column information from above ResultSet object
        // First we need to ResultSetMetaData object by calling below method
        ResultSetMetaData rsmd = rs.getMetaData();
        // This ResultSetMetaData has 2 methods we care about
        //  getColumnCount method to get the count of column
        //  getColumnName or getColumnLabel using 1 based index
        System.out.println("rsmd.getColumnCount() = " + rsmd.getColumnCount() );

        System.out.println("rsmd.getColumnName(2) = " + rsmd.getColumnName(2));

        // Now we know how to count how many columns we have
        // and how to get the column name at specific position (starting with 1)
        // Print out all column names -->> for loop
        int totalColumnCount = rsmd.getColumnCount() ;

        for (int columnIndex = 1; columnIndex <= totalColumnCount ; columnIndex++) {
//            System.out.println("rsmd.getColumnName( "+columnIndex+" ) = "
//                    + rsmd.getColumnName(columnIndex) );
            System.out.println(rsmd.getColumnName(columnIndex));
        }

    }

}