package com.example.login2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Adminstrators extends Login_Form {
    @FXML
    private Button Back;

    @FXML
    private Button Insert;

    @FXML
    private Button delete;

    @FXML
    private TextField password1;

    @FXML
    private TextField privilege1;

    @FXML
    private TextField username1;

    @FXML
    private Label welcome;

    public static String username_;
    public static String password_;
    public static String privilege_;
    int id;
    @FXML
    void delete_click(ActionEvent event) {
        try {
            User y=new User();
            y.setUsername(username1.getText());
            y.setPassword(password1.getText());
            DbConnect connectNOW = new DbConnect();
            Connection connectDB = connectNOW.getConnect();
            try {

                PreparedStatement st;
                st = connectDB.prepareStatement("SELECT Manger_id FROM Manager WHERE m_email =? AND m_pass =?");
                st.setString(1, y.getUsername());
                st.setString(2, y.getPassword());
                ResultSet queryResult = st.executeQuery();
                while (queryResult.next() == true) {

                    id = queryResult.getInt("Manger_id");
                    System.out.println(id);
                }
            } catch (Exception e) {
            }


            DbConnect connectNOW3 = new DbConnect();
            Connection con3 = connectNOW3.getConnect();
            PreparedStatement st3;
            st3 = con3.prepareStatement("DELETE FROM RECEPTIONIST WHERE `R_email`.`ID` = ?");
            st3.setInt(1, id);

            int status = st3.executeUpdate();
            Main x = new Main();
            x.changeScene("gui.fxml", 589, 493);

        } catch (Exception e) {
            e.printStackTrace();

        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Message");
        alert.setHeaderText("The process");
        alert.setContentText("Done.");
        alert.showAndWait();
    }

    @FXML
    void Back_click(ActionEvent event) throws IOException {
        Main x = new Main();
        x.changeScene("gui.fxml", 589, 493);
        ;

    }
    public static boolean validatePassword(String password) {
        if (password == null) {
            return false;
        }
        int length = password.length();
        if (length < 8 || length > 20) {
            return false;
        }
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        for (int i = 0; i < length; i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (ch == '!' || ch == '@' || ch == '#' || ch == '$' || ch == '%' || ch == '^' || ch == '&' || ch == '*') {
                hasSpecialChar = true;
            } else {
                return false;
            }
        }
        return hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
    }

    @FXML
    void insert_click(ActionEvent event) {
        try {
            User y = new User();
            y.setUsername(username1.getText());
            y.setPassword(password1.getText());
            if (validatePassword(y.getPassword())) {
                DbConnect connectNOW3 = new DbConnect();
                Connection con3 = connectNOW3.getConnect();
                PreparedStatement st3;
                st3 = con3.prepareStatement("INSERT INTO RECEPTIONIST ('R_email','R_pass','m_id','hotel_id') VALUES (?,?,2,1)");
                st3.setString(1, y.getUsername());
                st3.setString(2, y.getPassword());
                int status = st3.executeUpdate();
                Main x = new Main();
                x.changeScene("gui.fxml", 589, 493);
            }
            else Login_Form.pop_error("invalid password");
            } catch(Exception e){
                e.printStackTrace();

            }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Message");
            alert.setHeaderText("The process");
            alert.setContentText("Done.");
            alert.showAndWait();
        }
    }




