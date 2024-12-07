package ru.dianapak.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ListDoubleController extends ListController<Double> {

    @FXML
    private TextField valueField;

    @Override
    protected Double getValue() {
        String value = valueField.getText();
        Double doubleValue;
        try {
            doubleValue = Double.valueOf(value);
        } catch (NumberFormatException e) {
            showErrorDialog("Не дабл");
            doubleValue = null;
        }
        return doubleValue;
    }

    @Override
    protected String getValueName() {
        return "double";
    }
}
