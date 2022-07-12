package com.example.demo1;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class Controller6 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button add;

    @FXML
    private TextField date;

    @FXML
    private TextField quotes;

    @FXML
    private TextField subject;

    @FXML
    private TextField teacher;

    @FXML
    private TextField user_id;

    @FXML
    void initialize() {
        add.setOnAction(event -> {
            if(!date.getText().equals("") && !quotes.getText().equals("") && !subject.getText().equals("") && !teacher.getText().equals("") && !user_id.getText().equals(""))
                CreateNewQuotes();
            else
                System.out.println("Заполните все поля");
        });
    }

    private void CreateNewQuotes() {
        DatabaseHandler DbH = new DatabaseHandler();
        String quotess = quotes.getText();
        String subjectt = subject.getText();
        String teacherr = teacher.getText();
        String datee = date.getText();
        String user_idd = user_id.getText();

        Quotes quotes = new Quotes(quotess,subjectt, teacherr, datee, user_idd);

        DbH.signUpQuotes(quotes);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://std-mysql.ist.mospolytech.ru:3306/std_1970_quotes",
                    "std_1970_quotes", "quotes123");

            Statement statement = connection.createStatement();
            String queryy = "UPDATE users SET count_quotes = count_quotes + 1  WHERE " + "login" + "=" + "'" + Controller.getS() + "'" + " AND " + "password" + "=" + "'" + Controller.getP() + "'";

            statement.executeUpdate(queryy);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
