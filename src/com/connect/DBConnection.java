package com.connect;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static final String JDBC_Driver="com.mysql.cj.jdbc.Driver";
    public static final String JDBC_URL="jdbc:mysql://localhost:3307/orderdb";
    public static final String USERNAME="root";
    public static final String PASSWORD="root";

    static Connection conn=null;

    public static Connection getConnect() {

        try{
            Class.forName(JDBC_Driver);
            System.out.println("Driver loaded.............");

            conn= DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
        }catch (Exception e)
        {
            System.out.println(e);
        }
        return conn;
    }

    public static void main(String[] args) {

getConnect();
    }
}


