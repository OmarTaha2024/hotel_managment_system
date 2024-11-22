package com.example.login2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Class.*;


/**
 * @author hocin
 */
public class DbConnect {



    private static String HOST = "192.168.56.1";

   private static int PORT = 1433;
   private static String DB_NAME = "hotel_management_system";
    private static String USERNAME = "admin2";
    /**
     *
     */
    private static final String url;

    static {
        url = "jdbc:sqlserver://192.168.56.1:1433;database=hotel_management_system;encrypt=true;trustservercertificate=true";
    } ;
    private static String PASSWORD = "1234567";
    private static Connection connection=null;

    public static Connection connectDB;

    public static void database_connect(){
        connectDB=DbConnect.getConnect();
    }

    public static Connection getConnect() {
       String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }


}