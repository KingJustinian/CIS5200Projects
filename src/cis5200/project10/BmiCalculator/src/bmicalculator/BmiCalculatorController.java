package bmicalculator;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

public class BmiCalculatorController {

    @FXML
    private Label underweightLabel;

    @FXML
    private Button calculateButton;

    @FXML
    private ToggleGroup unitToggleGroup;

    @FXML
    private Label heightLabel;

    @FXML
    private RadioButton englishRadioButton;

    @FXML
    private TextField weightTextField;

    @FXML
    private Label obeseLabel;

    @FXML
    private Label unitLabel;

    @FXML
    private Label bmiLabel;

    @FXML
    private Label weightLabel;

    @FXML
    private Label normalLabel;

    @FXML
    private TextField heightTextField;

    @FXML
    private Label bmiValuesLabel;

    @FXML
    private RadioButton metricRadioButton;

    @FXML
    private TextField bmiTextField;

    @FXML
    private Label overweightLabel;
    
    private List<Label> bmiRangeLabels = new ArrayList<>();
    
    // called by FXMLLoader to initialize the controller
    public void initialize() {
        bmiRangeLabels.add(underweightLabel);
        bmiRangeLabels.add(normalLabel);
        bmiRangeLabels.add(overweightLabel);
        bmiRangeLabels.add(obeseLabel);
        
        unitToggleGroup.selectedToggleProperty().addListener(
            (ObservableValue<? extends Toggle> ob, Toggle o, Toggle n) -> {
                RadioButton selectedRb = (RadioButton) unitToggleGroup.getSelectedToggle();
                
                if (selectedRb != null) {
                    heightTextField.clear();
                    weightTextField.clear();
                    bmiTextField.clear();
                    
                    if (selectedRb.getId().startsWith("english")) {
                        heightTextField.setPromptText("Inches");
                        weightTextField.setPromptText("Pounds");
                    } else if (selectedRb.getId().startsWith("metric")) {
                        heightTextField.setPromptText("Meters");
                        weightTextField.setPromptText("Kilograms");
                    }
                }
            });
    }

    @FXML
    public void calculateButtonPressed(ActionEvent event) {
        String heightTextValue = heightTextField.getText();
        String weightTextValue = weightTextField.getText();
        bmiTextField.clear();
        bmiRangeLabels.forEach( (bmiRangeLabel) -> 
                bmiRangeLabel.setTextFill(Color.BLACK));
        
        if (heightTextValue == null || heightTextValue.isEmpty()) {
            bmiTextField.setStyle("-fx-text-inner-color: red;");
            bmiTextField.setText("Missing height value");
        } else if (weightTextValue == null || weightTextValue.isEmpty()) {
            bmiTextField.setStyle("-fx-text-inner-color: red;");
            bmiTextField.setText("Missing weight value");
        } else {
            bmiTextField.setStyle("-fx-text-inner-color: black;");
            
            try {
                double bmi = calculateBmi();
                bmiTextField.setText(String.valueOf(bmi));
                setBmiValuesColor(bmi);
            } catch (NumberFormatException nfe) {
                bmiTextField.setStyle("-fx-text-inner-color: red;");
                bmiTextField.setText("Please enter valid numbers.");
            }
        }
    }
    
    private double calculateBmi() throws NumberFormatException {       
        String weightString = weightTextField.getText().trim();
        String heightString = heightTextField.getText().trim();
        
        double weight = Double.valueOf(weightString);
        double height = Double.valueOf(heightString);
        
        double bmi = weight / (height * height);
        
        if (englishRadioButton.isSelected()) {
            bmi = bmi * 703;
        }
        
        return bmi;
    }
    
    private void setBmiValuesColor(double bmi) {
        if (bmi < 18.50) {
            underweightLabel.setTextFill(Color.RED);
        } else if (bmi >= 18.50 && bmi < 25.0) {
            normalLabel.setTextFill(Color.RED);
        } else if (bmi >= 25.0 && bmi < 30.0) {
            overweightLabel.setTextFill(Color.RED);
        } else if (bmi >= 30.0) {
            obeseLabel.setTextFill(Color.RED);
        }
    }
}