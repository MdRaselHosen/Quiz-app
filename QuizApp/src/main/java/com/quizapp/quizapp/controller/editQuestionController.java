package com.quizapp.quizapp.controller;

import com.quizapp.quizapp.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class editQuestionController {
    @FXML
    public void goToSetQuestion(MouseEvent event) {
        HelloApplication.sceneChange("setQuestion");

    }

}
