package ru.dianapak.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ListIntegerController extends ListController<Integer> {

    @FXML
    private TextField valueField;

    @Override
    protected Integer getValue() {
        String value = valueField.getText();
        Integer intValue;
        try {
            intValue = Integer.valueOf(value);
        } catch (NumberFormatException e) {
            showErrorDialog("Не дабл");
            intValue = null;
        }
        return intValue;
    }

    @Override
    protected String getValueName() {
        return "integer";
    }
}
