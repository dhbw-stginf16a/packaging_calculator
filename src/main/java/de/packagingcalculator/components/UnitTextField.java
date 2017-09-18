package de.packagingcalculator.components;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UnitTextField<T extends Enum<T>> extends HBox implements Initializable {

    public String promptText;
    @FXML
    ComboBox<T> comboBox;
    @FXML
    private TextField textField;

    public UnitTextField() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("unitTextField.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String css = this.getClass().getResource("unitTextField.css").toExternalForm();
        this.getStylesheets().add(css);
        this.textField.setOnKeyPressed(event -> {
            int i;
            switch (event.getCode()) {
                case UP:
                    i = this.comboBox.getSelectionModel().getSelectedIndex();
                    i = (i > 1) ? i - 1 : 0;
                    this.comboBox.getSelectionModel().select(i);
                    break;
                case DOWN:
                    i = this.comboBox.getSelectionModel().getSelectedIndex();
                    i = (i < this.comboBox.getItems().size() - 1) ? i + 1 : this.comboBox.getItems().size() - 1;
                    this.comboBox.getSelectionModel().select(i);
                    break;
            }
        });
    }

    public StringProperty textProperty() {
        return textField.textProperty();
    }

    public String getText() {
        return textField.getText();
    }

    public void setText(String text) {
        textField.setText(text);
    }

    public ReadOnlyObjectProperty<T> selectedUnitProperty() {
        return comboBox.getSelectionModel().selectedItemProperty();
    }

    public T getSelectedUnit() {
        return comboBox.getSelectionModel().getSelectedItem();
    }

    public String getPromptText() {
        return this.promptText;
    }

    public void setPromptText(String prompt) {
        this.promptText = prompt;
        this.textField.setPromptText(promptText);
    }
}
