package com.example.calculator;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controller {



    private Stage windowStage;

    @FXML private Label formulaText;
    @FXML private Label historyText;
    @FXML private Pane titleBar;


    private double x;
    private double y;

    public void Initialize(Stage stage){
        InitDraggableTitleBar(stage);
        windowStage = stage;

    }

    @FXML
    private void OnTestClick(MouseEvent event){
        System.out.println("Hello World");
    }
    @FXML
    private void onMinimizedClick(MouseEvent event){
        windowStage.setIconified(true);
    }

    @FXML
    private void onCloseClick(MouseEvent event){
        windowStage.close();
    }

    @FXML
    private void OnNumberClicked(MouseEvent event){

    }

    @FXML
    private void OnOperatorClicked(){

    }

    //I definetly copied this code I have no idea about lambda expressions lmao.
    // Special thanks to TheeQbit in GitHub for this. I learned so much.
    private void InitDraggableTitleBar(Stage stage){

        // Gets the current position of the window or the scene in this case.
        titleBar.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });

        //And then off set it to the current mouse location and current screen location to make it move.
        titleBar.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        });
    }

}
