package de.packagingcalculator.controllers;

import de.packagingcalculator.model.Calculator;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    //FXML Bindings
    @FXML
    ChoiceBox<String> shipperChoiceBox; // TODO: Replace with shipper class
    @FXML
    TextField widthTextField;
    @FXML
    TextField heightTextField;
    @FXML
    TextField depthTextField;
    @FXML
    TextField weightTextField;
    @FXML
    Label informationLabel;
    @FXML
    Label resultLabel;

    //Properties
    // TODO: Change to automatic Double converter
    StringProperty width = new SimpleStringProperty();
    StringProperty height = new SimpleStringProperty();
    StringProperty depth = new SimpleStringProperty();
    StringProperty weight = new SimpleStringProperty();
    StringProperty result = new SimpleStringProperty();


    //Controller initialization

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        widthTextField.textProperty().bindBidirectional(width);
        heightTextField.textProperty().bindBidirectional(height);
        depthTextField.textProperty().bindBidirectional(depth);
        weightTextField.textProperty().bindBidirectional(weight);
        resultLabel.textProperty().bind(result);

        // TODO: Further initialization here
    }

    //FXML Events

    @FXML
    private void onCalculate(ActionEvent event) {
        Calculator cal = new Calculator();
        result.set(cal.calcShippingCosts(width.get(), height.get(), depth.get(), weight.get()) + " Euro");
        //result.set("Halllo");
    }

    //Getters And Setters

    public String getWidth() {
        return width.get();
    }

    public void setWidth(String width) {
        this.width.set(width);
    }

    public StringProperty widthProperty() {
        return width;
    }

    public String getHeight() {
        return height.get();
    }

    public void setHeight(String height) {
        this.height.set(height);
    }

    public StringProperty heightProperty() {
        return height;
    }

    public String getDepth() {
        return depth.get();
    }

    public void setDepth(String depth) {
        this.depth.set(depth);
    }

    public StringProperty depthProperty() {
        return depth;
    }

    public String getWeight() {
        return weight.get();
    }

    public void setWeight(String weight) {
        this.weight.set(weight);
    }

    public StringProperty weightProperty() {
        return weight;
    }

    public String getResult() {
        return result.get();
    }

    public void setResult(String result) {
        this.result.set(result);
    }

    public StringProperty resultProperty() {
        return result;
    }
}
