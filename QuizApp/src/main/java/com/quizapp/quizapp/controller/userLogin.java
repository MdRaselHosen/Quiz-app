package com.quizapp.quizapp.controller;

import com.quizapp.quizapp.ConnectionSingleton;

import java.sql.Connection;

public class userLogin {
    public static Connection connectUser(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = ConnectionSingleton.getConnection();
            return connection;



        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Unable to get login information");
        }

        return null;

    }
}
