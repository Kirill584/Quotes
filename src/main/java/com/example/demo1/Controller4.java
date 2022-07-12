package com.example.demo1;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Controller4 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label qute;

    @FXML
    void initialize() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://std-mysql.ist.mospolytech.ru:3306/std_1970_quotes",
                    "std_1970_quotes", "quotes123");

            Statement statement = connection.createStatement();
            String query = "SELECT * FROM quotes_teachers";
            ResultSet result = statement.executeQuery(query);
            StringBuilder msg = new StringBuilder();

            while(result.next()){
                String s = result.getString(Const.QUOTES_ID)+ " " + result.getString(Const.QUOTES_QUOTES) + " " + result.getString(Const.QUOTES_TEACHER) + " " + result.getString(Const.QUOTES_SUBJECT) + " " + result.getString(Const.QUOTES_DATE) + " " + result.getString(Const.QUOTES_USER_ID);
                msg.append(s);
                msg.append(",\n");
            }

            qute.setText(msg.toString());

            connection.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
