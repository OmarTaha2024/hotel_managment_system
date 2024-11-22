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

public class Checkout_Form extends Login_Form {
    public static String roomnumber;
    @FXML
    private TextField roomID_textfield;
    @FXML
    private Button checkoutbutton;
    @FXML
    private Label roomtype_label;
    @FXML
    private Label roomtype_price;
    @FXML
    private Label food_label;
    @FXML
    private Label food_price;
    @FXML
    private Label days_number;
    @FXML
    private Label total;
    private String rs;
    private String roomtype;
    private int days;
    private int bf = 0, l = 0, d = 0, food, foodprice;
    private int vipprice = 1500, normalprice = 1000, economyprice = 750, price;

    public void checkoutbutton_click(ActionEvent event) throws Exception {
        roomnumber = roomID_textfield.getText();
        DbConnect connectNOW = new DbConnect();
        Connection connectDB = connectNOW.getConnect();
        try {
            PreparedStatement st1, st2, st3, st4;
            st1 = connectDB.prepareStatement("SELECT roomType,num_of_Days FROM `rooms` WHERE `roomID`=" + roomnumber);
            st2 = connectDB.prepareStatement("SELECT breakfast,lunch,dinner FROM `food` WHERE `roomID`=" + roomnumber);
            ResultSet rs1 = st1.executeQuery();
            ResultSet rs2 = st2.executeQuery();
            while (rs1.next() == true) {
                roomtype = rs1.getString("roomType");
                days = rs1.getInt("num_of_Days");
            }
            if ("VIP".equals(roomtype)) {
                price = vipprice;
            } else if ("Normal".equals(roomtype)) {
                price = normalprice;
            } else if ("Economy".equals(roomtype)) {
                price = economyprice;
            }
            System.out.println("roomtype " + roomtype);
            System.out.println("number of days " + days);
            System.out.println("price" + price);
            roomtype_label.setText(roomtype);
            roomtype_price.setText("" + price + "L.E/day");
            days_number.setText("" + days + " days");
            st3 = connectDB.prepareStatement("UPDATE rooms SET isBooked = ?, num_of_Days = ?, owner = ? WHERE roomID=" + roomnumber);
            st3.setString(1, "false");
            st3.setInt(2, 0);
            st3.setString(3, "false");
            st3.executeUpdate();
            //end of dealing with rooms table
            while (rs2.next() == true) {
                bf = rs2.getInt("breakfast");
                l = rs2.getInt("lunch");
                d = rs2.getInt("dinner");
            }
            food = bf + l + d;
            food_label.setText("" + food + " meals");
            foodprice = bf * 100 + l * 300 + d * 200;
            food_price.setText("" + foodprice + "L.E/day");
            total.setText("" + (foodprice + price) * days + " L.E");
            st4 = connectDB.prepareStatement("UPDATE food SET breakfast = ?, lunch = ?, dinner = ? WHERE roomID=" + roomnumber);
            st4.setInt(1, 0);
            st4.setInt(2, 0);
            st4.setInt(3, 0);
            st4.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Message");
        alert.setHeaderText("The process");
        alert.setContentText("Done.");
        alert.showAndWait();
    }

    public void back() throws IOException {
        Main m = new Main();
        m.changeScene("gui.fxml", 589, 493);
    }

}
