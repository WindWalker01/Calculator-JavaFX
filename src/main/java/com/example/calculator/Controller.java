package com.example.calculator;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML private Label valueText;
    @FXML private Label formulaText;
    double computedVale = 0.0;
    private String operator = "";
    private double x = 0;
    private double y = 0;
    private boolean isX = true;
    private boolean isEqualed;



    @FXML
    private void OnNumberClicked(ActionEvent event){
        String num = ((Button)event.getSource()).getId();

        if(valueText.getText().length() < 16) { // Limits the possible input of the first or second number by 16.

            // Responsible for concatenating the values inputted by the user.
            if (Double.parseDouble(valueText.getText()) == 0) {
                valueText.setText(String.valueOf(num)); // if the value start with zero replaced it by the next non-zero inputted value
            } else {
                valueText.setText(valueText.getText() + num); // if the value does not start with zero just concat the next inputted value to the right.
            }

            // Responsible for determining if the first number is already inputted
            if(isX){
                x = Double.parseDouble(valueText.getText());
            }else{
                y = Double.parseDouble(valueText.getText());
            }

        }

    }

    @FXML
    private void OnOperatorClicked(ActionEvent event){

        switch (((Button) event.getSource()).getId()) {
            case "add":
                isX = false;
                IsRecursive();
                operator = "+";
                valueText.setText("0");
                OnDisplayFormula();
                break;
            case "subtract":
                isX = false;
                IsRecursive();
                operator = "-";
                valueText.setText("0");
                OnDisplayFormula();
                break;
            case "multiply":
                isX = false;
                IsRecursive();
                operator = "*";
                valueText.setText("0");
                OnDisplayFormula();
                break;
            case "divide":
                isX = false;
                operator = "/";
                valueText.setText("0");
                OnDisplayFormula();
               break;
            case "percent":
                computedVale = Double.parseDouble(valueText.getText()) / 100d;
                isX = false;
                formulaText.setText("percentage(" + x + ")");
                x = computedVale;
                valueText.setText(computedVale + "");
                break;
            case "negate":
                computedVale = Double.parseDouble(valueText.getText()) * -1;
                isX = false;
                formulaText.setText("negate(" + x + ")");
                System.out.println(computedVale);
                x = computedVale;
                valueText.setText(computedVale + "");
                break;
            case "equals":
                OnSolve();
                OnDisplay();
                break;
        }
    }

    @FXML
    public void OnClearClick(ActionEvent event){

        switch (((Button) event.getSource()).getId()){
            case "AC":
                isX = true;
                x = 0;
                y = 0;
                formulaText.setText("0");
                valueText.setText("0");
                break;
            case "C":
                if(isEqualed){
                    isX = true;
                    x = 0;
                    y = 0;
                    formulaText.setText("0");
                    valueText.setText("0");
                } else{
                    if (isX){
                        x = 0;
                    }else{
                        y = 0;
                    }
                    valueText.setText("0");
                }
                break;
        }
        isEqualed = false;
    }


    /*
        Responsible for solving arithmetic calculations
     */
    private void OnSolve(){

        switch (operator){
            case "+" -> computedVale = x + y;
            case "-" -> computedVale = x - y;
            case "*" -> computedVale = x * y;
            case "/" -> computedVale = x / y;
        }

        isEqualed = true;
    }


    /*
        Responsible for displaying the formula ONLY when the operators are clicked by the user.
        not necessarily the whole solution.
     */
    private void OnDisplayFormula() {
        formulaText.setText(x + operator);
    }

    /*
        Responsible for displaying the whole solution/formula that the user inputted.
        this will not show the history when the user uses the calculator recursively.
     */
    private void OnDisplay(){

        valueText.setText(computedVale + "");
        formulaText.setText(formulaText.getText() + y + " =");
    }

    /*
        Responsible for determining if the user already performs an arithmetic process.
     */
    private void IsRecursive(){
        //If the second number is already inputted then the computedValue at the last arithmetic process will be
        // the first number and the user will only be required to input the second number.
        if(y != 0){
            isX = false;
            OnSolve();
            x = computedVale;
        }

    }

}
