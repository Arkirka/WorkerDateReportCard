package ru.vorobyov.FX.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ru.vorobyov.database.entity.Accounting;
import ru.vorobyov.database.entity.Worker;
import ru.vorobyov.database.service.AccountingService;
import ru.vorobyov.database.service.WorkerService;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class TimekeeperPageController {

    @FXML
    private TextField textId;

    @FXML
    private Label labelInfo;

    @FXML
    private TextField textDay;

    @FXML
    private TextField textEncoding;

    @FXML
    private TextField textMonth;

    @FXML
    private Button buttonUpdate;

    @FXML
    void updateEntity(ActionEvent event) {
        try {
            List<Accounting> accountingList = new AccountingService().getAll();

            Accounting accounting = new Accounting();

            accounting.setWorkerId(Integer.parseInt(textId.getText()));
            accounting.setEncoding(textEncoding.getText());
            accounting.setDay(new Date(120,Integer.parseInt(textMonth.getText()) - 1 , Integer.parseInt(textDay.getText())));

            new AccountingService().add(accounting);

            labelInfo.setText("Успешно");
        } catch (SQLException throwables) {
            labelInfo.setText("Ошибка");
            throwables.printStackTrace();
        } catch (IOException e) {
            labelInfo.setText("Ошибка");
            e.printStackTrace();
        }
    }

}
