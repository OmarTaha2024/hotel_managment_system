package com.example.login2;

import java.sql.ResultSet;
import java.sql.Statement;
public class Manager {
    private String m_name,m_email,m_pass;



    public String getUsername() {
        return m_email;
    }

    public void setUsername(String m_email) {
        this.m_email = m_email;
    }

    public String getPassword() {
        return m_pass;
    }

    public void setPassword(String password) {
        m_pass = password;
    }

   static public boolean verify_Manager_login (String username , String password) {
        String verifyLogin = "SELECT count(1) FROM Manger WHERE m_email = '" + username + "' AND m_pass = '" + password + "'";
        try {

            int counter = 0;
            Statement statement = DbConnect.connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while (queryResult.next()) {

                if (queryResult.getInt(1) == 1) {
                    System.out.println(username + " just logged \n");
                    Main x = new Main();
                    x.changeScene("forAdmins.fxml", 847, 493);
                  // m.changeScene("gui.fxml", 589, 493);

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
