package ru.vorobyov.FX.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.vorobyov.FX.pageCreator.FXPageCreator;
import ru.vorobyov.database.bl.DatabaseUtil;
import ru.vorobyov.database.entity.WorkersData;

import java.io.IOException;
import java.sql.*;

public class DatabaseEditPageController {

    @FXML
    private TableColumn<WorkersData, Date> columnBirthday;

    @FXML
    private TableColumn<WorkersData, String> columnLastName;

    @FXML
    private Button buttonEdit;

    @FXML
    private TableColumn<WorkersData, Boolean> columnRemoteWork;

    @FXML
    private TableColumn<WorkersData, String> columnAddress;

    @FXML
    private Button buttonDelete;

    @FXML
    private TableColumn<WorkersData, String> columnPosition;

    @FXML
    private TableView<WorkersData> tableWorkers;

    @FXML
    private TableColumn<WorkersData, Integer> columnAge;

    @FXML
    private Button buttonUpdate;

    @FXML
    private TableColumn<WorkersData, String> columnName;

    @FXML
    private Button buttonAdd;

    private ObservableList<WorkersData> workersData = FXCollections.observableArrayList();

    @FXML
    void toAddPage(ActionEvent event) throws IOException {
        new FXPageCreator().createPage("/fxml\\addEntityPage.fxml", 671, 390);
    }

    @FXML
    void toEditPage(ActionEvent event) throws IOException {
        new FXPageCreator().createPage("/fxml\\editEntityPage.fxml", 671, 314);
    }

    @FXML
    void toDeletePage(ActionEvent event) throws IOException {
        new FXPageCreator().createPage("/fxml\\deleteEntityPage.fxml", 671, 314);
    }

    @FXML
    void updateTable(ActionEvent event) throws IOException, SQLException {
        workersData.clear();
        initData();

        //add workers info to table
        columnName.setCellValueFactory(new PropertyValueFactory<WorkersData, String>("name"));
        columnLastName.setCellValueFactory(new PropertyValueFactory<WorkersData, String>("lastName"));
        columnBirthday.setCellValueFactory(new PropertyValueFactory<WorkersData, Date>("birthday"));
        columnAge.setCellValueFactory(new PropertyValueFactory<WorkersData, Integer>("age"));
        columnPosition.setCellValueFactory(new PropertyValueFactory<WorkersData, String>("position"));
        columnRemoteWork.setCellValueFactory(new PropertyValueFactory<WorkersData, Boolean>("remoteWork"));
        columnAddress.setCellValueFactory(new PropertyValueFactory<WorkersData, String>("address"));

        tableWorkers.setItems(workersData);
    }

    private void initData() throws IOException, SQLException {
        //init configs
        Statement stmt = null;
        Connection connection = null;
        connection = DatabaseUtil.getConnection();
        stmt = connection.createStatement();

        String sql = "SELECT NAME, LAST_NAME, BIRTHDAY, AGE, POSITION, REMOTE_WORK, ADDRESS FROM WORKER";

        //execute query for table
        ResultSet rst = stmt.executeQuery(sql);

        while (rst.next()){
            workersData.add(new WorkersData(rst.getString(1), rst.getString(2), rst.getDate(3), rst.getInt(4), rst.getString(5), rst.getBoolean(6), rst.getString(7) ));
            System.out.println(rst.getString(1));
        }

    }

}
