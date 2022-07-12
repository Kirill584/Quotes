package com.example.demo1;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Controller5 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button add;

    @FXML
    private Button delete;

    @FXML
    private Button edit;

    @FXML
    private Button change;

    @FXML
    private Label user;

    @FXML
    void initialize() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://std-mysql.ist.mospolytech.ru:3306/std_1970_quotes",
                    "std_1970_quotes", "quotes123");

            Statement statement = connection.createStatement();
            String query = "SELECT * FROM quotes_teachers, users";
            ResultSet result = statement.executeQuery(query);
            StringBuilder msg = new StringBuilder();

            int counter = 0;

            while(result.next()){
                if (result.getString(Const.QUOTES_USER_ID).equals(result.getString(Const.USERS_ID)) && result.getString(Const.USERS_LOGIN).equals(Controller.getS()) && result.getString(Const.USERS_PASSWORD).equals(Controller.getP())){
                    String s = result.getString(Const.QUOTES_ID)+ " " + result.getString(Const.QUOTES_QUOTES) + " " + result.getString(Const.QUOTES_TEACHER) + " " + result.getString(Const.QUOTES_SUBJECT) + " " + result.getString(Const.QUOTES_DATE) + " " + result.getString(Const.QUOTES_USER_ID);
                    msg.append(s);
                    msg.append(",\n");
                    counter++;
                }
            }

            user.setText(msg.toString());

            String queryy = "UPDATE users SET count_quotes = "  + counter  + " WHERE " + "login" + "=" + "'" + Controller.getS() + "'" + " AND " + "password" + "=" + "'" + Controller.getP() + "'";

            statement.executeUpdate(queryy);

            connection.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        add.setOnAction(event -> {
            openNewWindow("/com/example/demo/addquotes.fxml");
        });

        delete.setOnAction(event -> {
            openNewWindow("/com/example/demo/deletequotes.fxml");
        } );

        edit.setOnAction(event -> {
            openNewWindow("/com/example/demo/editquotes.fxml");
        });

        change.setOnAction(event -> {
            openNewWindow("/com/example/demo/changedata.fxml");
        });
    }

    public void openNewWindow(String window){

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

}
