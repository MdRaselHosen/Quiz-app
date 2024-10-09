package com.quizapp.quizapp.controller;


import com.quizapp.quizapp.HelloApplication;
import com.quizapp.quizapp.Question;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class QuestionController {

    @FXML
    public TextField correctAnswerField;

    @FXML
    public TextField opt1Field;

    @FXML
    public TextField opt2Field;

    @FXML
    public TextField opt3Field;

    @FXML
    public TextField opt4Field;

    @FXML
    public TextArea questionField;

    @FXML
    public TextField questionIDField;

    @FXML
    public void saveQuestion(ActionEvent event) throws SQLException {
        String id = questionIDField.getText();
        String questionSet = questionField.getText();
        String option1 = opt1Field.getText();
        String option2 = opt2Field.getText();
        String option3 = opt3Field.getText();
        String option4 = opt4Field.getText();
        String correctAnswer = correctAnswerField.getText();
        Question question = new Question(id,questionSet,option1,option2,option3,option4,correctAnswer);
        InsertIntoDatabase(question);
        System.out.println(question.getQuestion()+question.getCorrectAnswer());
        /*

        Question question1 = new Question(id, question,opt1,opt2,opt3,opt4,correctAnswer);
        QuestionImplementation implementation = new QuestionImplementation();
        implementation.save(question1);
        boolean isQuestion =  implementation.save(question1);

        Alert alert;
        if (isQuestion){
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succesfully done");
            alert.setHeaderText("Information");
        }else{
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Failed to load database");
            alert.setHeaderText("Error");
        }
        alert.show();*/

        System.out.println(id+questionSet+" "+option1+" "+option2+" "+option3+" "+option4+" "+correctAnswer);


        questionIDField.setText(" ");
        questionField.setText(" ");
        opt1Field.setText("");
        opt2Field.setText("");
        opt3Field.setText("");
        opt4Field.setText("");
        correctAnswerField.setText("");




    }
    @FXML
     public void goToLogin(MouseEvent event) {
        HelloApplication.sceneChange("login");

    }

    public void InsertIntoDatabase(Question question){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/question","root","12345678");
            String query = "INSERT INTO question_set VALUES('"+question.getId()+"', '"+question.getQuestion()+"' , '"+question.getOption1()+"', '"+question.getOption2()+"' , '"+question.getOption3()+"' , '"+question.getOption4()+"', '"+question.getCorrectAnswer()+"');";
            Statement statement = connection.createStatement();
            statement.execute(query);


        } catch(SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failed to load database");
        }
    }

    /*
    public void insertIntoDatabase(Student student){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/question","root","12345678");

            String query = "INSERT INTO student VALUES('"+student.getName()+"','"+student.getEmail()+"','"+student.getPassword()+"');";
            Statement statement = connection.createStatement();
            statement.execute(query);

        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("Failed to load database");
        }

     */
    @FXML
    public void goToEdit(MouseEvent event) {
        HelloApplication.sceneChange("editQuestion");

    }
}
