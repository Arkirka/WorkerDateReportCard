package ru.vorobyov.FX.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DatabaseEditPageController {

    @FXML
    private TableColumn<?, ?> columnBirthday;

    @FXML
    private TableColumn<?, ?> columnLastName;

    @FXML
    private Button buttonEdit;

    @FXML
    private TableColumn<?, ?> columnRemoteWork;

    @FXML
    private TableColumn<?, ?> columnAddress;

    @FXML
    private TableColumn<?, ?> columnPreview;

    @FXML
    private Button buttonDelete;

    @FXML
    private TableColumn<?, ?> columnPosition;

    @FXML
    private TableView<?> tableWorkers;

    @FXML
    private TableColumn<?, ?> columnAge;

    @FXML
    private Button buttonUpdate;

    @FXML
    private TableColumn<?, ?> columnName;

    @FXML
    private Button buttonAdd;

    @FXML
    void toAddPage(ActionEvent event) {

    }

    @FXML
    void toEditPage(ActionEvent event) {

    }

    @FXML
    void toDeletePage(ActionEvent event) {

    }

    @FXML
    void updateTable(ActionEvent event) {

    }

}
