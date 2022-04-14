package com.cydeo.day2;

import com.cydeo.utility.DB_Util;

public class DB_Util_practice {

    public static void main(String[] args) {


        String url = "jdbc:oracle:thin:@50.16.40.33:1521:XE";
        String username = "hr" ;
        String password = "hr" ;

        // This will create connection and save the connection to static variable of utility
        DB_Util.createConnection(url, username, password);
        // This will execute query and save the query result to static variable of utility
        DB_Util.runQuery("SELECT * FROM COUNTRIES") ;

        // This will print out every cell in the result
        DB_Util.displayAllData();

        // get 2nd column from 2nd row
        System.out.println("DB_Util.getCellValue(2,2) = "
                + DB_Util.getCellValue(2, 2));

        // get the Country_Name from 2nd row
        System.out.println("DB_Util.getCellValue(2, \"COUNTRY_NAME\") = "
                + DB_Util.getCellValue(2, "COUNTRY_NAME"));

        // get row count
        System.out.println("DB_Util.getRowCount() = " + DB_Util.getRowCount());

        // get column count
        System.out.println("DB_Util.getColumnCount() = " + DB_Util.getColumnCount());

        // This will clean up ResultSet, Statement, Connection object resources just like you did with File
        DB_Util.destroy();

    }

}