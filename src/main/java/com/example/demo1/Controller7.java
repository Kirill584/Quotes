package com.example.demo1;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller7 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button delete;

    @FXML
    private TextField id;

    @FXML
    void initialize() {
        delete.setOnAction(event -> {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection connection = DriverManager.getConnection("jdbc:mysql://std-mysql.ist.mospolytech.ru:3306/std_1970_quotes",
                        "std_1970_quotes", "quotes123");

                Statement statement = connection.createStatement();
                String query = "DELETE FROM quotes_teachers WHERE id = " + id.getText();

                statement.executeUpdate(query);

                String queryy = "UPDATE users SET count_quotes = count_quotes - 1  WHERE " + "login" + "=" + "'" + Controller.getS() + "'" + " AND " + "password" + "=" + "'" + Controller.getP() + "'";

                statement.executeUpdate(queryy);

                connection.close();
            }
            catch(Exception e){
                System.out.println(e);
            }
        });
    }

}
