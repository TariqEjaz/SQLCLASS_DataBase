package com.day1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@50.16.40.33:1521:XE" ;
        String username= "hr";
        String password= "hr";
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("connected");

        } catch (SQLException e) {
            System.out.println("Connection has failed " + e.getMessage() );

        }


    }
}
