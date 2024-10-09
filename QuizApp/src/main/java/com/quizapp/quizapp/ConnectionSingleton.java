package com.quizapp.quizapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {

    private static final String DB_HOST = "localhost";
    private static final String DB_NAME = "question";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "12345678";
    private static final String DB_URL = "jdbc:mysql://"+ DB_HOST+"/"+DB_NAME;

    private static Connection connection;

    private ConnectionSingleton(){
        try{
            Connection Connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connected");

        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("Failed to connect to Database");
        }
    }
    public static Connection getConnection(){
        return connection;
    }


}
