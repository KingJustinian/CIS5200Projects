package tipcalculator;

// TipCalculatorController.java
// Controller that handles calculateButton and tipPercentageSlider events
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class TipCalculatorController { 
   // formatters for currency and percentages
   private static final NumberFormat currency = 
      NumberFormat.getCurrencyInstance();
   private static final NumberFormat percent = 
      NumberFormat.getPercentInstance();
   
   private BigDecimal tipPercentage = new BigDecimal(0.15); // 15% default
   
   // GUI controls defined in FXML and used by the controller's code
   @FXML 
   private TextField amountTextField; 

   @FXML
   private Label tipPercentageLabel; 

   @FXML
   private Slider tipPercentageSlider;

   @FXML
   private TextField tipTextField;

   @FXML
   private TextField totalTextField;

   // called by FXMLLoader to initialize the controller
   public void initialize() {
      // 0-4 rounds down, 5-9 rounds up 
      currency.setRoundingMode(RoundingMode.HALF_UP);
      
      // Listener to update tip/total after tip slider changes
      tipPercentageSlider.valueProperty().addListener((observable, oldValue, 
            newValue) -> {
                updateAmounts();
        });
      
      // Listener to update tip/total after amount text field changes
      amountTextField.textProperty().addListener((observable, oldValue, 
            newValue) -> {               
                updateAmounts();
        });
      
      // Bind the tip percent label to the value of the tip slider
      tipPercentageLabel.textProperty().bind(Bindings.createStringBinding(
        () -> formatPercentString(tipPercentageSlider.valueProperty()), tipPercentageSlider.valueProperty()
      ));
   }
   
   private String formatPercentString(DoubleProperty valueProperty) {
       tipPercentage = BigDecimal.valueOf(valueProperty.intValue() / 100.0);
       return percent.format(tipPercentage);
   }
   
   private void updateAmounts() {
        try {
           BigDecimal amount = new BigDecimal(amountTextField.getText());
           BigDecimal tip = amount.multiply(tipPercentage);
           BigDecimal total = amount.add(tip);

           tipTextField.setText(currency.format(tip));
           totalTextField.setText(currency.format(total));
        }
        catch (NumberFormatException ex) {
           amountTextField.setText("Enter amount");
           amountTextField.selectAll();
           amountTextField.requestFocus();
        }
   }
}