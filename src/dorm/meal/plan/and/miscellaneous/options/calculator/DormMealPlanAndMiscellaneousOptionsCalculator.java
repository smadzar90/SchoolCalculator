/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package dorm.meal.plan.and.miscellaneous.options.calculator;


import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.mail.MessagingException;


/**
 *
 * @author stipanmadzar
 */
public class DormMealPlanAndMiscellaneousOptionsCalculator extends Application {
    
    String hallAllen = "Allen Hall: $1,800";
    String hallPike = "Pike Hall: $2,200";
    String hallFarthing = "Farthing Hall: $2,800";
    String hallSuits = "University Suites: $3,000";
    double result = 0.00;
    String text;
       
    
    @Override
    public void start(Stage primaryStage) {
        
        GridPane grid = new GridPane();
        Label label1 = new Label("1. Select a Dorm (e.g. Allen Hall)");
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setPromptText("Click to select a dorm");
        comboBox.getItems().addAll(hallAllen, hallPike, hallFarthing, hallSuits);
        VBox vbox1 = new VBox(6, label1, comboBox);
        grid.setHgap(20);
        grid.setVgap(10);
        grid.add(vbox1, 0, 0);
        
        Label label2 = new Label("2. Select a Meal Plan");
        RadioButton radio1 = new RadioButton("7 meals weekly: $600");
        RadioButton radio2 = new RadioButton("14 meals weekly: $1,100");
        RadioButton radio3 = new RadioButton("Unlimited meals: $1,800");
        ToggleGroup radioGroup = new ToggleGroup();
        radio1.setToggleGroup(radioGroup);
        radio2.setToggleGroup(radioGroup);
        radio3.setToggleGroup(radioGroup);
        VBox vbox2 = new VBox(5, label2, radio1, radio2, radio3);
        grid.add(vbox2, 1, 0);
        
        Label label3 = new Label("3. Select some option(s)");
        CheckBox check1 = new CheckBox("Use laundry room: $80");
        CheckBox check2 = new CheckBox("Use paid-parking areas: $90");
        CheckBox check3 = new CheckBox("Use SE school buses: $100");
        VBox vbox3 = new VBox(5, label3, check1, check2, check3);
        grid.add(vbox3, 0, 1);
        
        Label label4 = new Label("4. Payment Type:");
        RadioButton r1 = new RadioButton("by Cash");
        RadioButton r2 = new RadioButton("by Check");
        RadioButton r3 = new RadioButton("by Credit Card");
        ToggleGroup rGroup = new ToggleGroup();
        r1.setToggleGroup(rGroup);
        r2.setToggleGroup(rGroup);
        r3.setToggleGroup(rGroup);
        VBox vbox4 = new VBox(5, label4, r1, r2, r3);
        grid.add(vbox4, 1, 1);
        grid.setMargin(vbox4, new Insets(20, 0, 0, 0));
     
        CheckBox check4 = new CheckBox("Email my order");
        TextField textField = new TextField();
        textField.setPromptText("Your Email address here");
        
        Label total = new Label("Total Cost: ");
        VBox vbox5 = new VBox(5, check4, textField, total);
        vbox3.setMargin(total, new Insets(5, 0, 0, 0));
        grid.add(vbox5, 0, 2);
        
        Button btn3 = new Button("Place Order");
        Button btn1 = new Button("Compute Cost");
        Button btn2 = new Button("Clear All");
        HBox hbox = new HBox(15, btn1, btn2);
        VBox bb = new VBox(10, hbox, btn3);
        grid.setMargin(bb, new Insets(50, 0, 0, 15));
        grid.add(bb, 1, 2);
        
        btn1.setOnAction(e -> {
            
            text = "You have selected the following items or options:\n";
            String selected = comboBox.getValue();
            
            if(selected != null) {
                
            if(selected.equals(hallAllen)) {
                result += 1800;
                text += hallAllen + "\n";
            }
            else if(selected.equals(hallPike)) {
                result += 2200;
                text += hallPike + "\n";
            }
            else if(selected.equals(hallFarthing)) {
                result += 2800;
                text += hallFarthing + "\n";
            }
            else if(selected.equals(hallSuits)) {
                result += 3000;
                text += hallSuits + "\n";
            }}
            
            if(radio1.isSelected()) {
                result += 600;
                text += radio1.getText() + "\n";
            }
            else if(radio2.isSelected()) {
                result += 1100;
                text += radio2.getText() + "\n";
            }
            else if(radio3.isSelected()) {
                result += 1800;
                text += radio3.getText() + "\n";
            }
            if(check1.isSelected()) {
                result += 80;
                text += check1.getText() + "\n";
            }
            if(check2.isSelected()) {
                result += 90;
                text += check2.getText() + "\n";
            }
            if(check3.isSelected()) {
                result += 100;
                text += check3.getText() + "\n";
            }
            
            text += "\nTotal Cost: $" + String.format("%,.2f", result) + "\n";

            if(r1.isSelected()) {
                total.setText("Total Cost:  $" + String.format("%,.2f", result) +
                              "\nPay " + r1.getText());
                text += "Pay " + r1.getText() + "\n";    
            }
            else if(r2.isSelected()) {
                total.setText("Total Cost:  $" + String.format("%,.2f", result) +
                              "\nPay " + r2.getText());
                text += "Pay " + r2.getText() + "\n";
            }
            else if(r3.isSelected()) {
                total.setText("Total Cost:  $" + String.format("%,.2f", result) +
                              "\nPay " + r3.getText());
                text += "Pay " + r3.getText() + "\n";
            }
            else {
                total.setText("Total Cost:  $" + String.format("%,.2f", result));
            }
            text += "Thank you for your Business!\n";
            result = 0;   
        });
        
        btn2.setOnAction(e -> {
          
            comboBox.getSelectionModel().clearSelection();
            
            comboBox.setButtonCell(new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty) ;
            if (empty || item == null) {
                setText("Click to select a dorm");
            } 
            else {
                setText(item);
                }
            }});
            
            radio1.setSelected(false);
            radio2.setSelected(false);
            radio3.setSelected(false);
            check1.setSelected(false);
            check2.setSelected(false);
            check3.setSelected(false);
            r1.setSelected(false);
            r2.setSelected(false);
            r3.setSelected(false);
            check4.setSelected(false);
            textField.clear();
            total.setText("Total Cost: ");
        });

        btn3.setOnAction(e -> {
              
            if(check4.isSelected()) {

                try {
                    JavaEmailSender.sendEmail(textField.getText(), text, total);
                } catch (MessagingException ex) {
                    Logger.getLogger(DormMealPlanAndMiscellaneousOptionsCalculator.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        grid.setPadding(new Insets(25, 10, 30, 20));
        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dorm, Meals, Others Calculator/Semester");
        scene.getStylesheets().add("SchoolCalculator.css");
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
