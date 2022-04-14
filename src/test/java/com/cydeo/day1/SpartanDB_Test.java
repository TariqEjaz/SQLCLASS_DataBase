package com.cydeo.day1;



import java.sql.*;

public class SpartanDB_Test {

    public static void main(String[] args) throws SQLException {

        int  count = 0;
        String url = "jdbc:oracle:thin:@50.16.40.33:1521:XE";
        String username = "SP" ;
        String password = "SP" ;

        Connection conn = DriverManager.getConnection(url,username,password) ;
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs   = stmt.executeQuery("SELECT * FROM spartans") ;

        while (rs.next() ) {
            System.out.println("First Row is  = " + rs.getString("NAME"));
            System.out.println("First Row is  = " + rs.getString("GENDER"));
            System.out.println(count++);
        }
    }



}
