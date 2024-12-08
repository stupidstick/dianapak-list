package ru.dianapak;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class JavaFxApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(
                FXMLLoader.load(
                        Objects.requireNonNull(
                                ru.dianapak.Application.class.getClassLoader().getResource("menu.fxml")
                        )
                )
        );
        stage.setTitle("main menu");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}