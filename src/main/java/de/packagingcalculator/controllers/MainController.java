package de.packagingcalculator.controllers;

import de.packagingcalculator.components.DistanceTextField;
import de.packagingcalculator.components.WeightTextField;
import de.packagingcalculator.model.Calculator;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    //FXML Bindings
    @FXML
    ChoiceBox<String> shipperChoiceBox; // TODO: Replace with shipper class
    @FXML
    DistanceTextField widthTextField;
    @FXML
    DistanceTextField heightTextField;
    @FXML
    DistanceTextField depthTextField;
    @FXML
    WeightTextField weightTextField;
    @FXML
    Label superPackageLabel;
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
    StringProperty superPackage = new SimpleStringProperty();


    //Controller initialization

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        widthTextField.textProperty().bindBidirectional(width);
        heightTextField.textProperty().bindBidirectional(height);
        depthTextField.textProperty().bindBidirectional(depth);
        weightTextField.textProperty().bindBidirectional(weight);
        resultLabel.textProperty().bind(result);
        superPackageLabel.textProperty().bind(superPackage);

        // TODO: Further initialization here
    }

    //FXML Events

    @FXML
    private void onCalculate(ActionEvent event) {
        Calculator cal = new Calculator();
        result.set(cal.calcShippingCosts(width.get(), height.get(), depth.get(), weight.get()) + " Euro");
        //result.set("Halllo");
    }

    @FXML
    private void onAdd(ActionEvent event) {

    }

    @FXML
    private void onRemove(ActionEvent event) {

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

    public String getSuperPackage() {
        return superPackage.get();
    }

    public void setSuperPackage(String superPackage) {
        this.superPackage.set(superPackage);
    }

    public StringProperty superPackageProperty() {
        return superPackage;
    }
}
