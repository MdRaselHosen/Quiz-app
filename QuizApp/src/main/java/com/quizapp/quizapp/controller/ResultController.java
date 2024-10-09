package com.quizapp.quizapp.controller;

import com.quizapp.quizapp.HelloApplication;
import com.quizapp.quizapp.controller.ExamPageController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.input.MouseEvent;

public class ResultController {

    @FXML
    public ProgressIndicator correct_progress;

    @FXML
    public Label correcttext;

    @FXML
    public Label marks;

    @FXML
    public Label markstext;

    @FXML
    private Label remark;

    @FXML
    public ProgressIndicator wrong_progress;

    @FXML
    public Label wrongtext;
    int correct = 0;
    int wrong = 0;

    @FXML
    private void initialize() {
        correct = ExamPageController.correct;
        wrong = ExamPageController.wrong;

        correcttext.setText("Correct Answers : " + correct);
        wrongtext.setText("Incorrect Answers : " + String.valueOf(ExamPageController.wrong));

        marks.setText(correct + "/10");
        float correctf = (float) correct / 10;
        correct_progress.setProgress(correctf);

        float wrongf = (float) wrong / 10;
        wrong_progress.setProgress(wrongf);


        markstext.setText(correct + " Marks Scored");

        if (correct < 2) {
            remark.setText("Oh no..! You have failed the quiz. It seems that you need to improve your general knowledge. Practice daily! Check your results here.");
        } else if (correct >= 2 && correct < 5) {
            remark.setText("Oops..! You have scored less marks. It seems like you need to improve your general knowledge. Check your results here.");
        } else if (correct >= 5 && correct <= 7) {
            remark.setText("Good. A bit more improvement might help you to get better results. Practice is the key to success. Check your results here.");
        } else if (correct == 8 || correct == 9) {
            remark.setText("Congratulations! Its your hardwork and determination which helped you to score good marks. Check you results here.");
        } else if (correct == 10) {
            remark.setText("Congratulations! You have passed the quiz with full marks because of your hardwork and dedication towards studies. Keep it up! Check your results here.");
        }


    }
    @FXML
    public void goToLogin(MouseEvent event) {
        HelloApplication.sceneChange("login");

    }

}