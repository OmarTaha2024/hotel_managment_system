package com.example.login2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.scene.control.Alert;


public class Dashboard extends Login_Form implements Initializable {
    @FXML
    private Button checkin;

    @FXML
    private Button checkout;

    @FXML
    private Button rooms;
    @FXML
    public Label welcome;

    Main x =new Main ();

    @FXML
    void checkin_click(ActionEvent event) throws IOException {

        x.changeScene("check in.fxml", 833, 607);

    }

    public void orderfood_click(ActionEvent event) throws IOException {

        x.changeScene("food.fxml", 600, 400);
    }


    public void admin_click(ActionEvent actionEvent) throws IOException {
        DbConnect.database_connect();
        try {
            int counter = 0;
            PreparedStatement st;
            st = DbConnect.connectDB.prepareStatement("SELECT privilege FROM users WHERE username =? AND password =?");
            st.setString(1, username);
            st.setString(2, password);
            ResultSet queryResult = st.executeQuery();
            while (queryResult.next() == true) {
                String Privilrge = queryResult.getString("privilege");
                if (Privilrge.equals("admin")) {
                    x.changeScene("forAdmins.fxml", 847, 493);
                } else{ welcome.setText("You are not admin");
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setHeaderText("Not permited");
                    alert.setContentText("you are not admin");
                    alert.showAndWait();
                }
            }
        } catch (Exception e) {
        }

    }

    public void checkout_click(ActionEvent event) throws IOException {

        x.changeScene("checkout.fxml", 670, 409);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        welcome.setText("Welcome " + username);
    }
}
