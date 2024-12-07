package ru.dianapak.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import ru.dianapak.core.list.SingleLinkedList;
import ru.dianapak.core.list.SingleLinkedListImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;

public abstract class ListController<T extends Comparable<T>> implements Initializable {

    protected SingleLinkedList<T> list = new SingleLinkedListImpl<>();
    protected ObservableList<T> observableList = FXCollections.observableArrayList();

    @FXML
    protected ListView<T> listView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.setItems(observableList);
    }

    protected abstract T getValue();

    protected abstract String getValueName();

    protected void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void insert() {
        T element = getValue();
        if (element == null) {
            return;
        }
        list.insert(getValue());
        updateListView();
    }

    @FXML
    private void insertByPos() {
        int pos = listView.getSelectionModel().getSelectedIndex();
        if (pos == -1) {
            showErrorDialog("Позиция в списке не выбрана");
            return;
        }
        T element = getValue();
        if (element == null) {
            return;
        }
        list.insert(element, pos);
        updateListView();
    }

    @FXML
    private void remove() {
        int pos = listView.getSelectionModel().getSelectedIndex();
        if (pos == -1) {
            showErrorDialog("Элемент списка не выбран");
            return;
        }
        list.remove(pos);
        updateListView();
    }

    @FXML
    private void sort() {
        list.sort();
        updateListView();
    }

    @FXML
    private void serialize() throws IOException {
        File file = new File("/aboba");
        System.out.println(file.createNewFile());;
        try (
                var fos = new FileOutputStream(getValueName() + "-list.aboba");
                var out = new ObjectOutputStream(fos)
        ) {
            out.writeObject(list);
        }
    }

    @FXML
    @SuppressWarnings("unchecked")
    private void deserialize() throws IOException, ClassNotFoundException {
        try (
                var fis = new FileInputStream( getValueName() + "-list");
                var ois = new ObjectInputStream(fis)
        ) {
            list = (SingleLinkedList<T>) ois.readObject();
            updateListView();
        } catch (FileNotFoundException e) {
            showErrorDialog("Файл не найден");
        }
    }

    private void updateListView() {
        observableList.setAll(list.toList());
    }
}
