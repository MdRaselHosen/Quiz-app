package com.quizapp.quizapp.controller;

import com.quizapp.quizapp.ConnectionSingleton;
import com.quizapp.quizapp.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    @FXML
    public TextField emailField;

    @FXML
    public PasswordField passwordField;
    Connection connect;
    PreparedStatement prepare;
    ResultSet result;

    @FXML
    public void enterButton(ActionEvent event) {
        String validEmail = "rasel";
        String validPassword = "123";
        /*
        String validEmail = emailField.getText();
        String validPassword = passwordField.getText();
        String checkData = "SELECT EMAIL,PASSWORD FROM STUDENT WHERE EMAIL='"+ validEmail+"',and password '"+validPassword+"');";
        connect = ConnectionSingleton.getConnection();
        try{
            prepare = connect.prepareStatement(checkData);
            result = prepare.executeQuery();
            if (result.next()){
                HelloApplication.sceneChange("examPage");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Unable to connect");
        }*/


        String email = emailField.getText();
        String password = passwordField.getText();

        if (email.equals(validEmail) && (password.equals(validPassword))) {

            HelloApplication.sceneChange("examPage");
        } else {
            System.out.println("Failed to login");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Email or password is incorrect");
            alert.setTitle("Error");
            alert.show();

        }
    }

    @FXML
    public void goToRegistration(MouseEvent event) {
        HelloApplication.sceneChange("registration");

    }

    @FXML
    public void goToQuestionSet(MouseEvent event) {
        HelloApplication.sceneChange("loginForTeacher");

    }

}
