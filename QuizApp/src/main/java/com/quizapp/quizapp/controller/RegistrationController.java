package com.quizapp.quizapp.controller;

import com.quizapp.quizapp.HelloApplication;
import com.quizapp.quizapp.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RegistrationController {

    @FXML
    public TextField emailField;

    @FXML
    public TextField nameField;

    @FXML
    public PasswordField passwordField;

    @FXML
    public void goToLogin(MouseEvent event) {
        HelloApplication.sceneChange("login");



    }

    @FXML
    public void registrationButton(ActionEvent event) {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        Student student = new Student(name, email,password);
        System.out.println(student.getName()+" "+student.getEmail()+" " +student.getPassword());
        insertIntoDatabase(student);
/*
        Student student = new Student(name, email, password);
        StudentImplementation implementation = new StudentImplementation();
        implementation.register(student);
        boolean isRegistered =  implementation.register(student);

        Alert alert;
        if (isRegistered){
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succesfully done");
            alert.setHeaderText("Information");
        }else{
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Failed to load database");
            alert.setHeaderText("Error");
        }
        alert.show();*/


        //System.out.println(name+" "+email+" "+password);
        nameField.setText("");
        emailField.setText("");
        passwordField.setText("");
    }

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

    }
    /*
     Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/product_management","root","12345678");
            String query = "INSERT INTO PRODUCT VALUES(" + product.getId() + ", '"+product.getName()+"' ,"+product.getQuantity()+","+product.getPrice()+");";
            Statement statement = connection.createStatement();
            statement.execute(query);
     */
    /*
    private List<Student> getList(Statement ConnectionSingleton){
        List<Student> studentList = new ArrayList<>();

        try{

            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();

        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("Try again latter");
        }

        return studentList;
    }*/
}
