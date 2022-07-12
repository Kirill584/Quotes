package com.example.demo1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller3 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField post;

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    @FXML
    private Button registration;

    @FXML
    void initialize() {
        registration.setOnAction(event -> {
            if(!login.getText().equals("") && !password.getText().equals("") && !post.getText().equals(""))
                CreateNewUser();
            else
                System.out.println("Заполните все поля");
        });
    }

    private void CreateNewUser() {
        DatabaseHandler DbH = new DatabaseHandler();
        String loginn = login.getText();
        String passsword = password.getText();
        String postt = post.getText();
        String countt = "0";

        User user = new User(loginn, passsword, postt, countt);

        DbH.signUpUser(user);
    }

}