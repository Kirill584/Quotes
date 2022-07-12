package com.example.demo1;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login;

    @FXML
    private TextField post;

    @FXML
    private PasswordField password;

    @FXML
    private Button registration;

    @FXML
    private Button vhod;

    @FXML
    private Button quest;

    public static String loginText;
    public static String passwordText;

    @FXML
    void initialize() {
        vhod.setOnAction(event -> {
            loginText = login.getText().trim();
            passwordText = password.getText().trim();
            String postText = post.getText().trim();

            if(!loginText.equals("") && !passwordText.equals(""))
                loginUser(loginText, passwordText, postText);
            else
                System.out.println("Заполните все поля");
        });

        registration.setOnAction(event -> {
            openNewWindow("/com/example/demo/registration.fxml");
        });

        quest.setOnAction(event -> {
            openNewWindow("/com/example/demo/quest.fxml");
        });
    }

    private void loginUser(String loginText, String passwordText, String postText) {
        DatabaseHandler DbHr = new DatabaseHandler();
        User user = new User();
        user.setLogin(loginText);
        user.setPassword(passwordText);
        user.setPost(postText);
        ResultSet result = DbHr.getUser(user);

        int counter = 0;

        try {
            while (result.next()){
                counter++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (counter>=1 && user.getPost().equals("Пользователь")){
            System.out.println("Вход выполнен");
            openNewWindow("/com/example/demo/user.fxml");
        }
        else if (counter>=1 && user.getPost().equals("Суперпользователь")){
            System.out.println("Вход выполнен");
            openNewWindow("/com/example/demo/superuser.fxml");
        }
        else if (counter>=1 && user.getPost().equals("Верификатор")){
            System.out.println("Вход выполнен");
            openNewWindow("/com/example/demo/verificator.fxml");
        }
    }

    public void openNewWindow(String window){
        registration.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    public static String getS(){
        return loginText;
    }

    public static String getP(){
        return passwordText;
    }

}
