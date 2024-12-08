package ru.dianapak.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.dianapak.Application;

import java.io.IOException;
import java.util.Objects;

public class MenuController {

    @FXML
    private void openListStringMenu() throws IOException {
        createStage("list-string.fxml", "string menu").show();
    }

    @FXML
    private void openListIntegerMenu() throws IOException {
        createStage("list-integer.fxml", "integer menu").show();
    }

    @FXML
    private void openListDoubleMenu() throws IOException {
        createStage("list-double.fxml", "double menu").show();
    }

    @FXML
    private void openListPointMenu() throws IOException {
        createStage("list-point.fxml", "point.fxml").show();
    }

    private Stage createStage(String viewName, String title) throws IOException {
        Scene scene = new Scene(
                FXMLLoader.load(
                        Objects.requireNonNull(
                                Application.class.getClassLoader().getResource(viewName)
                        )
                )
        );
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(scene);
        return stage;
    }
}
