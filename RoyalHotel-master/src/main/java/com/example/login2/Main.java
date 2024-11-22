package com.example.login2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    private static Stage stg;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stg = primaryStage;
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Royal Hotel");
        primaryStage.setScene(new Scene(root, 550, 400));
        primaryStage.show();
    }

    public void changeScene(String fxml, int x, int y) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.setScene(new Scene(pane, x, y));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch(args);
    }

}