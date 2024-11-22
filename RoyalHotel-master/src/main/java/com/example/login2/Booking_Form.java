package com.example.login2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.scene.control.Alert;


public class Booking_Form extends Login_Form {
    @FXML
    private TextField roomIDFld;

    @FXML
    private Button Back;

    @FXML
    private TextField IDFld;

    @FXML
    private MenuItem VIP;

    @FXML
    private TextField addressFld;

    @FXML
    private TextField cityFld;

    @FXML
    private Button confirm;

    @FXML
    private MenuItem economy;

    @FXML
    private TextField emailFld;

    @FXML
    private TextField holderFld;

    @FXML
    private MenuButton menu;

    @FXML
    private TextField nameFld;

    @FXML
    private TextField nationalityFld;

    @FXML
    private MenuItem normal;

    @FXML
    private TextField numofDaysFld;

    @FXML
    private TextField phoneFld;
    String room_Type;
    int roomnumber;


    @FXML
    void Back_click(ActionEvent event) throws IOException {
        Main x = new Main();
        x.changeScene("gui.fxml", 589, 493);
        ;

    }

    @FXML
    void VIP_choose(ActionEvent event) {
        room_Type = "VIP";
        System.out.println(room_Type);
    }

    @FXML
    void economy_choose(ActionEvent event) {
        room_Type = "Economy";
        System.out.println(room_Type);
    }

    @FXML
    void normal_choose(ActionEvent event) {
        room_Type = "Normal";
        System.out.println(room_Type);
    }

    @FXML
    void confirm_click(ActionEvent event) throws IOException {
        Customers x=new Customers();

        x.setName(nameFld.getText());
        x.setNationality(nationalityFld.getText());
        x.setID(IDFld.getText());
        x.setAddress(addressFld.getText());
        x.setCity(cityFld.getText());
        x.setPhone( phoneFld.getText());
        x.setEmail(emailFld.getText());
        String Days = numofDaysFld.getText();
        int numofDays = Integer.parseInt(Days);
        DbConnect connectNOW = new DbConnect();
        Connection connectDB = connectNOW.getConnect();
        try {
            int counter = 0;
            PreparedStatement st;
            st = connectDB.prepareStatement("SELECT roomID FROM rooms WHERE ro_type =? AND ro_is_occupied =?");
            st.setString(1, room_Type);
            st.setString(2, "false");
            ResultSet queryResult = st.executeQuery();
            while (queryResult.next() == true) {
                if (counter == 1) break;
                roomnumber = queryResult.getInt("roomID");
                System.out.println(roomnumber);
                roomIDFld.setText(String.valueOf(roomnumber));
                counter++;
            }
        } catch (Exception e) {
        }
        try {
            DbConnect connectNOW2 = new DbConnect();
            Connection con2 = connectNOW2.getConnect();
            PreparedStatement st1;
            st1 = con2.prepareStatement("INSERT INTO `customers`(`name`, `room_ID`, `nationality`, `nationalID`, `address`, `phone`, `city`, `email`) VALUES (?,?,?,?,?,?,?,?)");
            st1.setString(1, x.getName());
            st1.setInt(2, roomnumber);
            st1.setString(3, x.getNationality());
            st1.setString(4, x.getID());
            st1.setString(5, x.getAddress());
            st1.setString(6, x.getPhone());
            st1.setString(7, x.getCity());
            st1.setString(8, x.getEmail());

            int status = st1.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

        }

        try {
            DbConnect connectNOW3 = new DbConnect();
            Connection con3 = connectNOW3.getConnect();
            PreparedStatement st2;
            st2 = con3.prepareStatement("UPDATE rooms SET roomType = ?, isBooked = ?, num_of_Days = ?, owner = ? WHERE roomID=?");
            st2.setString(1, room_Type);
            st2.setString(2, "true");
            st2.setInt(3, numofDays);
            st2.setString(4, x.getName());
            st2.setInt(5, roomnumber);
            int status = st2.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();

        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Message");
        alert.setHeaderText("The process");
        alert.setContentText("Done.");
        alert.showAndWait();
    }
}



