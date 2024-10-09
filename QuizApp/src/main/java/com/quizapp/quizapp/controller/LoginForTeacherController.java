
package com.quizapp.quizapp.controller;

import com.quizapp.quizapp.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginForTeacherController {

    @FXML
    public TextField teacherLogin;

    @FXML
    public PasswordField teacherPassword;




    @FXML
    public void enter(ActionEvent event) {
        String validEmail = "rasel";
        String validPassword = "123";

        String email = teacherLogin.getText();
        String password = teacherPassword.getText();

        if(email.equals(validEmail) && (password.equals(validPassword))){
            HelloApplication.sceneChange("setQuestion");

        }



    }


    public void goToLogin(MouseEvent mouseEvent) {
        HelloApplication.sceneChange("login");
    }
}
