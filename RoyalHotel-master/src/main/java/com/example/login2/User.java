package com.example.login2;

import java.sql.ResultSet;
import java.sql.Statement;
public class User {
    private String username,password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean verify_user_login (String username , String password) {
        String verifyLogin = "SELECT count(1) FROM RECEPTIONIST WHERE R_email = '" + username + "' AND R_pass = '" + password + "'";

        try {

            int counter = 0;
            Statement statement = DbConnect.connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while (queryResult.next()) {

                if (queryResult.getInt(1) == 1) {
                    System.out.println(username + " just logged \n");
                    Main m = new Main();
                    m.changeScene("gui.fxml", 589, 493);

                } /*else {
                    //wrong.setText("Wrong username or password");
                        Login_Form.pop_error("Wrong username or password");
                    return false;
                }*/
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
