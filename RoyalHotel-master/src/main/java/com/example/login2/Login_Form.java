package com.example.login2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

import javafx.scene.control.Alert;

public class Login_Form {
    public static String username;
    public static String password;
    @FXML
    private Button but1;

    @FXML
    private Button cancel;

    @FXML
    private PasswordField passwordfield;

    @FXML
    public TextField usernamefield;

    @FXML
    private Label wrong;
    private static Stage stg;





    @FXML
    void click(ActionEvent event) throws IOException, SQLException {
        username = usernamefield.getText();
        password = passwordfield.getText();
        DbConnect.database_connect();
       User user = new User();
       Manager manager =new Manager();
       boolean flag =user.verify_user_login(username,password);
        boolean flag1 = Manager.verify_Manager_login(username,password);
       if (flag ==false && flag1==false)
            wrong.setText("Wrong username or password");
    }

    @FXML
    void close(ActionEvent event) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }
    public void changeScene(String fxml, int x, int y) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.setScene(new Scene(pane, x, y));
        stg.getScene().setRoot(pane);
    }
    public static void pop_error(String status){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(status);
        alert.showAndWait();
    }
}



