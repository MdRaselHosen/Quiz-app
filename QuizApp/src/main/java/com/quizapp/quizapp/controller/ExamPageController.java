package com.quizapp.quizapp.controller;

import com.quizapp.quizapp.HelloApplication;
import com.quizapp.quizapp.Question;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.w3c.dom.ls.LSOutput;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class ExamPageController implements Initializable {
    @FXML
    public TextArea questionField;

    @FXML
    public Button opt1Clicked;

    @FXML
    public Button opt2Clicked;

    @FXML
    public Button opt3Clicked;

    @FXML
    public Button opt4Clicked;

    @FXML
    public Button nextBtn;
    @FXML
    public Label commentField;

    @FXML
    public Button resultBtn;
    public static int correct = 0;

    public static int wrong = 0;


    private int questionStage = 0;
    String ans = "";



    @FXML
    public void nextScene(ActionEvent event) {
        questionStage++;
        if (questionStage ==10){
            commentField.setText("Well done. You complete your test");
            questionField.setVisible(false);
            opt1Clicked.setVisible(false);
            opt2Clicked.setVisible(false);
            opt3Clicked.setVisible(false);
            opt4Clicked.setVisible(false);
            nextBtn.setVisible(false);
            resultBtn.setVisible(true);
        }

        System.out.println("Successfully changed scene");
        List<Question> qList = this.read();
//        if (questionStage <= 2) {
//            Question question = qList.get(questionStage);
//            questionField.setText(question.getQuestion());
//            opt1Clicked.setText(question.getOption1());
//            opt2Clicked.setText(question.getOption2());
//            opt3Clicked.setText(question.getOption3());
//            opt4Clicked.setText(question.getOption4());
//        } else {
//            nextBtn.setVisible(false);
//            resultBtn.setVisible(true);
//        }
        System.out.println("Correct answer is "+ans);
        System.out.println("Total Correct answered "+correct);
        System.out.println("Total wrong answered "+wrong);
        System.out.println("question stage is "+questionStage);
        Question question = qList.get(questionStage);
        questionField.setText(question.getQuestion());
        opt1Clicked.setText(question.getOption1());
        opt2Clicked.setText(question.getOption2());
        opt3Clicked.setText(question.getOption3());
        opt4Clicked.setText(question.getOption4());
        ans = question.getCorrectAnswer();





    }

    public List<Question> read() {
        List<Question> questionList = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/question", "root", "12345678");
            Statement statement = connection.createStatement();
            String query = "select * from question_set;";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                int intId = Integer.parseInt(id);
                String Question = resultSet.getString("question");
                String option1 = resultSet.getString("option1");
                String option2 = resultSet.getString("option2");
                String option3 = resultSet.getString("option3");
                String option4 = resultSet.getString("option4");
                String correctAnswer = resultSet.getString("answer");
                Question question = new Question(id, Question, option1, option2, option3, option4, correctAnswer);
                //ans = question.getCorrectAnswer();
                questionList.add(question);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("enable to connect");
        }



        return questionList;


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        resultBtn.setVisible(false);
        List<Question> q = this.read();
        for (Question question : q) {
            questionField.setText(question.getQuestion());
            opt1Clicked.setText(question.getOption1());
            opt2Clicked.setText(question.getOption2());
            opt3Clicked.setText(question.getOption3());
            opt4Clicked.setText(question.getOption4());
            ans= question.getCorrectAnswer();

            break;
        }

    }
    @FXML
    public void goToResult(ActionEvent event) {
        HelloApplication.sceneChange("result");

    }

    @FXML
    public void option1Clicked(MouseEvent event) {


        String result = opt1Clicked.getText();
        System.out.println("option 1 result is " +result);


        if (Objects.equals(result, ans)){
            correct++;

        }else{
            wrong++;
        }

    }

    @FXML
    public void option2Clicked(MouseEvent event) {
        String result = opt2Clicked.getText();
        System.out.println("option 2 result is "+result);
        if (Objects.equals(result, ans)){
            correct++;

        }else{
            wrong++;
        }


    }

    @FXML
    public void option3Clicked(MouseEvent event) {
        String result = opt3Clicked.getText();
        System.out.println("option 3 result is "+result);
        if (Objects.equals(result, ans)){
            correct++;

        }else{
            wrong++;
        }
    }

    @FXML
    public void option4Clicked(MouseEvent event) {
        String result = opt4Clicked.getText();
        System.out.println("option 4 result is "+result);
        if (Objects.equals(result, ans)){
            correct++;

        }else{
            wrong++;
        }

    }


}

