package com.example.demo1;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller9 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button change;

    @FXML
    private TextField login;

    @FXML
    private TextField password;

    @FXML
    void initialize() {
        change.setOnAction(event -> {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection connection = DriverManager.getConnection("jdbc:mysql://std-mysql.ist.mospolytech.ru:3306/std_1970_quotes",
                        "std_1970_quotes", "quotes123");

                Statement statement = connection.createStatement();
                String query = "UPDATE users SET login = " + "'" + login.getText() + "'" + ", password = " + "'" + password.getText() + "'" + " WHERE login = " + "'" + Controller.getS() + "'" + " AND password = " + "'" + Controller.getP() + "'";

                statement.executeUpdate(query);

                connection.close();
            }
            catch(Exception e) {
                System.out.println(e);
            }
        });
    }

}
