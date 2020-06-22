package ru.vorobyov.FX.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import ru.vorobyov.database.entity.JobInfo;
import ru.vorobyov.database.entity.Worker;
import ru.vorobyov.database.service.JobInfoService;
import ru.vorobyov.database.service.WorkerService;

import java.io.IOException;
import java.sql.Date;

public class AddEntityPageController {

    @FXML
    private TextField textId;

    @FXML
    private TextField textAddress;

    @FXML
    private TextField textName;

    @FXML
    private TextField textDepartment;

    @FXML
    private TextField textDay;

    @FXML
    private TextField textYear;

    @FXML
    private Button buttonEntity;

    @FXML
    private TextField textPosition;

    @FXML
    private TextField textMonth;

    @FXML
    private TextField textLastName;

    @FXML
    private RadioButton rButtonRemoteWork;

    @FXML
    private TextField textAge;

    @FXML
    void addEntity(ActionEvent event) throws IOException {
        JobInfo jobInfo = new JobInfo();
        jobInfo.setPosition(textPosition.getText());
        new JobInfoService().add(jobInfo);

        Worker worker = new Worker();
        worker.setWorkerId(Integer.parseInt(textId.getText()));
        worker.setPreview(null);
        worker.setName(textName.getText());
        worker.setLastName(textLastName.getText());
        worker.setBirthday(new Date(Integer.parseInt(textYear.getText()) - 1900, Integer.parseInt(textMonth.getText()) - 1, Integer.parseInt(textDay.getText())));
        worker.setAge(Integer.parseInt(textAge.getText()));
        worker.setAddress(textAddress.getText());
        worker.setRemoteWork(rButtonRemoteWork.isSelected());
        worker.setDepartment(textDepartment.getText());
        worker.setPosition(textPosition.getText());
        new WorkerService().add(worker);
    }

}
