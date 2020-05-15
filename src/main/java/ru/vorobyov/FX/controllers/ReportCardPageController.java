package ru.vorobyov.FX.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.WebView;
import ru.vorobyov.database.bl.DatabaseUtil;
import ru.vorobyov.database.entity.ReportCardData;
import ru.vorobyov.database.service.DepartmentService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReportCardPageController {

    @FXML
    private TableColumn<ReportCardData, Integer> columnWorkerId;

    @FXML
    private ToggleButton tButtonApril;

    @FXML
    private TableColumn<ReportCardData, Integer> columnNameLasrName;

    @FXML
    private ToggleButton tButtonMarch;

    @FXML
    private Label infoLabel;

    @FXML
    private ToggleButton tButtonJuly;


    @FXML
    private ToggleButton tButtonDecember;

    @FXML
    private TableColumn<ReportCardData, String> columnPosition;

    @FXML
    private ToggleButton tButtonSeptember;


    @FXML
    private ToggleButton tbuttonDepartmentFirst;

    @FXML
    private ToggleButton tButtonMay;

    @FXML
    private ToggleButton tbuttonDepartmentThird;

    @FXML
    private Button buttonUpdate;

    @FXML
    private ToggleButton tButtonJanuary;

    @FXML
    private ToggleButton tbuttonDepartmentSecond;

    @FXML
    private ToggleButton tButtonJune;

    @FXML
    private ToggleButton tButtonOctober;

    @FXML
    private ToggleButton tButtonNovember;

    @FXML
    private ToggleButton tButtonFebruary;

    @FXML
    private TableView<ReportCardData> tableCardReport;

    @FXML
    private ToggleButton tButtonAugust;

    @FXML
    private WebView tableDate = new WebView();

    private ObservableList<ReportCardData> workersData = FXCollections.observableArrayList();

    @FXML
    void update(ActionEvent event) {
        try {
            tbuttonDepartmentFirst.setText(new DepartmentService().getAll().get(0).getDepartment());
            tbuttonDepartmentSecond.setText(new DepartmentService().getAll().get(1).getDepartment());
            tbuttonDepartmentThird.setText(new DepartmentService().getAll().get(2).getDepartment());
            infoLabel.setText("Выбирите департамент и месяц, а затем нажмите обновить");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            initData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        columnNameLasrName.setCellValueFactory(new PropertyValueFactory<ReportCardData, Integer>("nameLastName"));
        columnPosition.setCellValueFactory(new PropertyValueFactory<ReportCardData, String>("position"));
        columnWorkerId.setCellValueFactory(new PropertyValueFactory<ReportCardData, Integer>("workerId"));

        tableCardReport.setItems(workersData);

        tableDate.getEngine().load("http://docs.oracle.com/javafx/");
    }

    private void initData() throws IOException, SQLException {
        Statement stmt = null;
        Connection connection = DatabaseUtil.getConnection();
        stmt = connection.createStatement();
        String sql = "SELECT concat(NAME, LAST_NAME), POSITION, WORKER_ID FROM WORKER";
        StringBuilder sb = new StringBuilder(sql);

        if(tbuttonDepartmentFirst.isSelected()) {
            sb.append(" WHERE DEPARTMENT = " + "'" + tbuttonDepartmentFirst.getText() + "'" + ";");
        } else if(tbuttonDepartmentSecond.isSelected()) {
            sb.append(" WHERE DEPARTMENT = " + "'" + tbuttonDepartmentSecond.getText() + "'" + ";");
        } else if(tbuttonDepartmentThird.isSelected()) {
            sb.append(" WHERE DEPARTMENT = " + "'" + tbuttonDepartmentThird.getText() + "'" + ";");
        }

        sql = new String(sb);
        System.out.println(sql);
        ResultSet rst = stmt.executeQuery(sql);

        while (rst.next()){
            workersData.add(new ReportCardData(rst.getString(1), rst.getString(2), rst.getInt(3)));
            System.out.println(rst.getString(1));
        }
    }

    @FXML
    void buttonDepartmentFirstPressed(ActionEvent event) {
        if(tbuttonDepartmentFirst.isSelected()){
            tbuttonDepartmentSecond.setDisable(true);
            tbuttonDepartmentThird.setDisable(true);
        } else {
            tbuttonDepartmentSecond.setDisable(false);
            tbuttonDepartmentThird.setDisable(false);
        }
    }

    @FXML
    void buttonDepartmentSecondPressed(ActionEvent event) {
        if(tbuttonDepartmentSecond.isSelected()){
            tbuttonDepartmentFirst.setDisable(true);
            tbuttonDepartmentThird.setDisable(true);
        } else {
            tbuttonDepartmentFirst.setDisable(false);
            tbuttonDepartmentThird.setDisable(false);
        }
    }

    @FXML
    void buttonDepartmentThirdPressed(ActionEvent event) {
        if(tbuttonDepartmentThird.isSelected()){
            tbuttonDepartmentFirst.setDisable(true);
            tbuttonDepartmentSecond.setDisable(true);
        } else {
            tbuttonDepartmentFirst.setDisable(false);
            tbuttonDepartmentSecond.setDisable(false);
        }
    }

    @FXML
    void tButtonJanuaryPressed(ActionEvent event) {
        if(tButtonJanuary.isSelected()) {
            tButtonFebruary.setDisable(true);
            tButtonMarch.setDisable(true);
            tButtonApril.setDisable(true);
            tButtonMay.setDisable(true);
            tButtonJune.setDisable(true);
            tButtonJuly.setDisable(true);
            tButtonAugust.setDisable(true);
            tButtonSeptember.setDisable(true);
            tButtonOctober.setDisable(true);
            tButtonNovember.setDisable(true);
            tButtonDecember.setDisable(true);
        } else {
            tButtonFebruary.setDisable(false);
            tButtonMarch.setDisable(false);
            tButtonApril.setDisable(false);
            tButtonMay.setDisable(false);
            tButtonJune.setDisable(false);
            tButtonJuly.setDisable(false);
            tButtonAugust.setDisable(false);
            tButtonSeptember.setDisable(false);
            tButtonOctober.setDisable(false);
            tButtonNovember.setDisable(false);
            tButtonDecember.setDisable(false);
        }
    }

    @FXML
    void tButtonFebruaryPressed(ActionEvent event) {
        if(tButtonFebruary.isSelected()) {
            tButtonJanuary.setDisable(true);
            tButtonMarch.setDisable(true);
            tButtonApril.setDisable(true);
            tButtonMay.setDisable(true);
            tButtonJune.setDisable(true);
            tButtonJuly.setDisable(true);
            tButtonAugust.setDisable(true);
            tButtonSeptember.setDisable(true);
            tButtonOctober.setDisable(true);
            tButtonNovember.setDisable(true);
            tButtonDecember.setDisable(true);
        } else {
            tButtonJanuary.setDisable(false);
            tButtonMarch.setDisable(false);
            tButtonApril.setDisable(false);
            tButtonMay.setDisable(false);
            tButtonJune.setDisable(false);
            tButtonJuly.setDisable(false);
            tButtonAugust.setDisable(false);
            tButtonSeptember.setDisable(false);
            tButtonOctober.setDisable(false);
            tButtonNovember.setDisable(false);
            tButtonDecember.setDisable(false);
        }
    }

    @FXML
    void tButtonMarchPressed(ActionEvent event) {
        if(tButtonMarch.isSelected()) {
            tButtonJanuary.setDisable(true);
            tButtonFebruary.setDisable(true);
            tButtonApril.setDisable(true);
            tButtonMay.setDisable(true);
            tButtonJune.setDisable(true);
            tButtonJuly.setDisable(true);
            tButtonAugust.setDisable(true);
            tButtonSeptember.setDisable(true);
            tButtonOctober.setDisable(true);
            tButtonNovember.setDisable(true);
            tButtonDecember.setDisable(true);
        } else {
            tButtonJanuary.setDisable(false);
            tButtonFebruary.setDisable(false);
            tButtonApril.setDisable(false);
            tButtonMay.setDisable(false);
            tButtonJune.setDisable(false);
            tButtonJuly.setDisable(false);
            tButtonAugust.setDisable(false);
            tButtonSeptember.setDisable(false);
            tButtonOctober.setDisable(false);
            tButtonNovember.setDisable(false);
            tButtonDecember.setDisable(false);
        }
    }

    @FXML
    void tButtonAprilPressed(ActionEvent event) {
        if(tButtonApril.isSelected()) {
            tButtonJanuary.setDisable(true);
            tButtonFebruary.setDisable(true);
            tButtonMarch.setDisable(true);
            tButtonMay.setDisable(true);
            tButtonJune.setDisable(true);
            tButtonJuly.setDisable(true);
            tButtonAugust.setDisable(true);
            tButtonSeptember.setDisable(true);
            tButtonOctober.setDisable(true);
            tButtonNovember.setDisable(true);
            tButtonDecember.setDisable(true);
        } else {
            tButtonJanuary.setDisable(false);
            tButtonFebruary.setDisable(false);
            tButtonMarch.setDisable(false);
            tButtonMay.setDisable(false);
            tButtonJune.setDisable(false);
            tButtonJuly.setDisable(false);
            tButtonAugust.setDisable(false);
            tButtonSeptember.setDisable(false);
            tButtonOctober.setDisable(false);
            tButtonNovember.setDisable(false);
            tButtonDecember.setDisable(false);
        }
    }

    @FXML
    void tButtonMayPressed(ActionEvent event) {
        if(tButtonMay.isSelected()) {
            tButtonJanuary.setDisable(true);
            tButtonFebruary.setDisable(true);
            tButtonMarch.setDisable(true);
            tButtonApril.setDisable(true);
            tButtonJune.setDisable(true);
            tButtonJuly.setDisable(true);
            tButtonAugust.setDisable(true);
            tButtonSeptember.setDisable(true);
            tButtonOctober.setDisable(true);
            tButtonNovember.setDisable(true);
            tButtonDecember.setDisable(true);
        } else {
            tButtonJanuary.setDisable(false);
            tButtonFebruary.setDisable(false);
            tButtonMarch.setDisable(false);
            tButtonApril.setDisable(false);
            tButtonJune.setDisable(false);
            tButtonJuly.setDisable(false);
            tButtonAugust.setDisable(false);
            tButtonSeptember.setDisable(false);
            tButtonOctober.setDisable(false);
            tButtonNovember.setDisable(false);
            tButtonDecember.setDisable(false);
        }
    }

    @FXML
    void tButtonJunePressed(ActionEvent event) {
        if(tButtonJune.isSelected()) {
            tButtonJanuary.setDisable(true);
            tButtonFebruary.setDisable(true);
            tButtonMarch.setDisable(true);
            tButtonApril.setDisable(true);
            tButtonMay.setDisable(true);
            tButtonJuly.setDisable(true);
            tButtonAugust.setDisable(true);
            tButtonSeptember.setDisable(true);
            tButtonOctober.setDisable(true);
            tButtonNovember.setDisable(true);
            tButtonDecember.setDisable(true);
        } else {
            tButtonJanuary.setDisable(false);
            tButtonFebruary.setDisable(false);
            tButtonMarch.setDisable(false);
            tButtonApril.setDisable(false);
            tButtonMay.setDisable(false);
            tButtonJuly.setDisable(false);
            tButtonAugust.setDisable(false);
            tButtonSeptember.setDisable(false);
            tButtonOctober.setDisable(false);
            tButtonNovember.setDisable(false);
            tButtonDecember.setDisable(false);
        }
    }

    @FXML
    void tButtonJulyPressed(ActionEvent event) {
        if(tButtonJuly.isSelected()) {
            tButtonJanuary.setDisable(true);
            tButtonFebruary.setDisable(true);
            tButtonMarch.setDisable(true);
            tButtonApril.setDisable(true);
            tButtonMay.setDisable(true);
            tButtonJune.setDisable(true);
            tButtonAugust.setDisable(true);
            tButtonSeptember.setDisable(true);
            tButtonOctober.setDisable(true);
            tButtonNovember.setDisable(true);
            tButtonDecember.setDisable(true);
        } else {
            tButtonJanuary.setDisable(false);
            tButtonFebruary.setDisable(false);
            tButtonMarch.setDisable(false);
            tButtonApril.setDisable(false);
            tButtonMay.setDisable(false);
            tButtonJune.setDisable(false);
            tButtonAugust.setDisable(false);
            tButtonSeptember.setDisable(false);
            tButtonOctober.setDisable(false);
            tButtonNovember.setDisable(false);
            tButtonDecember.setDisable(false);
        }
    }

    @FXML
    void tButtonAugustPressed(ActionEvent event) {
        if(tButtonAugust.isSelected()) {
            tButtonJanuary.setDisable(true);
            tButtonFebruary.setDisable(true);
            tButtonMarch.setDisable(true);
            tButtonApril.setDisable(true);
            tButtonMay.setDisable(true);
            tButtonJune.setDisable(true);
            tButtonJuly.setDisable(true);
            tButtonSeptember.setDisable(true);
            tButtonOctober.setDisable(true);
            tButtonNovember.setDisable(true);
            tButtonDecember.setDisable(true);
        } else {
            tButtonJanuary.setDisable(false);
            tButtonFebruary.setDisable(false);
            tButtonMarch.setDisable(false);
            tButtonApril.setDisable(false);
            tButtonMay.setDisable(false);
            tButtonJune.setDisable(false);
            tButtonJuly.setDisable(false);
            tButtonSeptember.setDisable(false);
            tButtonOctober.setDisable(false);
            tButtonNovember.setDisable(false);
            tButtonDecember.setDisable(false);
        }
    }

    @FXML
    void tButtonSeptemberPressed(ActionEvent event) {
        if(tButtonSeptember.isSelected()) {
            tButtonJanuary.setDisable(true);
            tButtonFebruary.setDisable(true);
            tButtonMarch.setDisable(true);
            tButtonApril.setDisable(true);
            tButtonMay.setDisable(true);
            tButtonJune.setDisable(true);
            tButtonJuly.setDisable(true);
            tButtonAugust.setDisable(true);
            tButtonOctober.setDisable(true);
            tButtonNovember.setDisable(true);
            tButtonDecember.setDisable(true);
        } else {
            tButtonJanuary.setDisable(false);
            tButtonFebruary.setDisable(false);
            tButtonMarch.setDisable(false);
            tButtonApril.setDisable(false);
            tButtonMay.setDisable(false);
            tButtonJune.setDisable(false);
            tButtonJuly.setDisable(false);
            tButtonAugust.setDisable(false);
            tButtonOctober.setDisable(false);
            tButtonNovember.setDisable(false);
            tButtonDecember.setDisable(false);
        }
    }

    @FXML
    void tButtonOctoberPressed(ActionEvent event) {
        if(tButtonOctober.isSelected()) {
            tButtonJanuary.setDisable(true);
            tButtonFebruary.setDisable(true);
            tButtonMarch.setDisable(true);
            tButtonApril.setDisable(true);
            tButtonMay.setDisable(true);
            tButtonJune.setDisable(true);
            tButtonJuly.setDisable(true);
            tButtonAugust.setDisable(true);
            tButtonSeptember.setDisable(true);
            tButtonNovember.setDisable(true);
            tButtonDecember.setDisable(true);
        } else {
            tButtonJanuary.setDisable(false);
            tButtonFebruary.setDisable(false);
            tButtonMarch.setDisable(false);
            tButtonApril.setDisable(false);
            tButtonMay.setDisable(false);
            tButtonJune.setDisable(false);
            tButtonJuly.setDisable(false);
            tButtonAugust.setDisable(false);
            tButtonSeptember.setDisable(false);
            tButtonNovember.setDisable(false);
            tButtonDecember.setDisable(false);
        }
    }

    @FXML
    void tButtonNovemberPressed(ActionEvent event) {
        if(tButtonNovember.isSelected()) {
            tButtonJanuary.setDisable(true);
            tButtonFebruary.setDisable(true);
            tButtonMarch.setDisable(true);
            tButtonApril.setDisable(true);
            tButtonMay.setDisable(true);
            tButtonJune.setDisable(true);
            tButtonJuly.setDisable(true);
            tButtonAugust.setDisable(true);
            tButtonOctober.setDisable(true);
            tButtonSeptember.setDisable(true);
            tButtonDecember.setDisable(true);
        } else {
            tButtonJanuary.setDisable(false);
            tButtonFebruary.setDisable(false);
            tButtonMarch.setDisable(false);
            tButtonApril.setDisable(false);
            tButtonMay.setDisable(false);
            tButtonJune.setDisable(false);
            tButtonJuly.setDisable(false);
            tButtonAugust.setDisable(false);
            tButtonOctober.setDisable(false);
            tButtonSeptember.setDisable(false);
            tButtonDecember.setDisable(false);
        }
    }

    @FXML
    void tButtonDecemberPressed(ActionEvent event) {
        if(tButtonDecember.isSelected()) {
            tButtonJanuary.setDisable(true);
            tButtonFebruary.setDisable(true);
            tButtonMarch.setDisable(true);
            tButtonApril.setDisable(true);
            tButtonMay.setDisable(true);
            tButtonJune.setDisable(true);
            tButtonJuly.setDisable(true);
            tButtonAugust.setDisable(true);
            tButtonOctober.setDisable(true);
            tButtonNovember.setDisable(true);
            tButtonSeptember.setDisable(true);
        } else {
            tButtonJanuary.setDisable(false);
            tButtonFebruary.setDisable(false);
            tButtonMarch.setDisable(false);
            tButtonApril.setDisable(false);
            tButtonMay.setDisable(false);
            tButtonJune.setDisable(false);
            tButtonJuly.setDisable(false);
            tButtonAugust.setDisable(false);
            tButtonOctober.setDisable(false);
            tButtonNovember.setDisable(false);
            tButtonSeptember.setDisable(false);
        }
    }

}
