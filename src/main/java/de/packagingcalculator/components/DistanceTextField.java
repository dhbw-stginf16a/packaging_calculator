package de.packagingcalculator.components;

import de.packagingcalculator.util.DistanceUnit;
import javafx.collections.FXCollections;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class DistanceTextField extends UnitTextField<DistanceUnit> {

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        super.initialize(location, resourceBundle);
        comboBox.setItems(FXCollections.observableList(Arrays.asList(DistanceUnit.values())));
        comboBox.getSelectionModel().select(DistanceUnit.MM);
    }
}
