package de.packagingcalculator.components;

import de.packagingcalculator.util.WeightUnit;
import javafx.collections.FXCollections;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class WeightTextField extends UnitTextField<WeightUnit> {

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        super.initialize(location, resourceBundle);
        comboBox.setItems(FXCollections.observableList(Arrays.asList(WeightUnit.values())));
        comboBox.getSelectionModel().select(WeightUnit.G);
    }
}
