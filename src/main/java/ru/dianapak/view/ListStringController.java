package ru.dianapak.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ListStringController extends ListController<String> {

    @FXML
    private TextField valueField;

    @Override
    protected String getValue() {
        String value = valueField.getText();
        if (value.isEmpty()) {
            showErrorDialog("Значение не введено");
            return null;
        }
        return value;
    }

    @Override
    protected String getValueName() {
        return "string";
    }
}
