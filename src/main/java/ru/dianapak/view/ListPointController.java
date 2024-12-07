package ru.dianapak.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import ru.dianapak.core.point.Point;


public class ListPointController extends ListController<Point> {

    @FXML
    private TextField xField;

    @FXML
    private TextField yField;

    @Override
    protected Point getValue() {
        Point point;
        try {
            point = new Point(
                    Integer.parseInt(xField.getText()),
                    Integer.parseInt(yField.getText())
            );
        } catch (NumberFormatException e) {
            showErrorDialog("Неправильно введено");
            point = null;
        }
        return point;
    }

    @Override
    protected String getValueName() {
        return "point";
    }
}
