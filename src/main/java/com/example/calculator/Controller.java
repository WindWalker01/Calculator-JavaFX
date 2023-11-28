package com.example.calculator;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controller {



    private Stage windowStage;

    @FXML private Label formulaText;
    @FXML private Label historyText;


    private String currentValue = "0";
    private double x;
    private double y;

    public void Initialize(Stage stage){
        windowStage = stage;
    }

    @FXML
    private void OnTestClick(MouseEvent event){
        String num = ((Button)event.getSource()).getId();

        if(formulaText.getText().length() < 16) {

            if (Double.parseDouble(formulaText.getText()) == 0) {
                formulaText.setText(String.valueOf(num));
            } else {
                formulaText.setText(formulaText.getText() + num);
            }
        }
    }

    @FXML
    private void OnNumberClicked(MouseEvent event){
        String num = ((Button)event.getSource()).getId();

        if(formulaText.getText().length() < 16) {

            if (Double.parseDouble(formulaText.getText()) == 0) {
                formulaText.setText(String.valueOf(num));
            } else {
                formulaText.setText(formulaText.getText() + num);
            }
        }
    }

    @FXML
    private void OnOperatorClicked(){

    }


}
