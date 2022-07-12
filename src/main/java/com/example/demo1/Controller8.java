package com.example.demo1;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller8 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button edit;

    @FXML
    private TextField id;

    @FXML
    private TextField quotes;

    @FXML
    void initialize() {
        edit.setOnAction(event -> {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection connection = DriverManager.getConnection("jdbc:mysql://std-mysql.ist.mospolytech.ru:3306/std_1970_quotes",
                        "std_1970_quotes", "quotes123");

                Statement statement = connection.createStatement();
                String query = "UPDATE quotes_teachers SET quotes = " + "'" + quotes.getText() + "'" + " WHERE id = " + id.getText();

                statement.executeUpdate(query);

                connection.close();
            }
            catch(Exception e) {
                System.out.println(e);
            }

        });
    }

}
