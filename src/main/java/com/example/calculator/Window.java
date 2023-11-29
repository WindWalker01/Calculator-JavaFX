package com.example.calculator;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.StageStyle;

public class Window extends Application{

    @Override
    public void start(Stage stage) throws Exception {

        //Initialize the Scene
        FXMLLoader fxmlLoader = new FXMLLoader(Window.class.getResource("calculator-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Image icon = new Image("icon.png");
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.setTitle("Scuffed Calculator");
        stage.setScene(scene);

        stage.show();
    }
    public void run() {
        launch();
    }
}
