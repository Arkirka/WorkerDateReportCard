package ru.vorobyov.FX.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import ru.vorobyov.database.bl.DatabaseUtil;
import ru.vorobyov.database.entity.*;
import ru.vorobyov.database.service.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class WelcomePageController {

    @FXML
    private Button buttonToReportCard;

    @FXML
    private Button buttonToEdit;

    static private Stage reportCardPage = null;

    @FXML
    void toReportCard(ActionEvent event) {
        try {
            Connection connection = DatabaseUtil.getConnection();
            try {
                createTables();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            Parent root = FXMLLoader.load(getClass().getResource("/fxml\\reportCardPage.fxml"));
            reportCardPage = new Stage();
            reportCardPage.setScene(new Scene(root, 1366, 599));
            reportCardPage.setResizable(false);
            reportCardPage.show();
        } catch (IOException er) {
            er.printStackTrace();
        }
    }

    @FXML
    void toEdit(ActionEvent event) {

    }

    public void createTables() throws IOException, SQLException {

        if(!new AccountingService().getAll().isEmpty()) new AccountingService().truncateTable();
        if(!new EncodingService().getAll().isEmpty()) new EncodingService().truncateTable();
        if(!new WorkerService().getAll().isEmpty()) new WorkerService().truncateTable();
        if(!new DepartmentService().getAll().isEmpty()) new DepartmentService().truncateTable();
        if(!new JobInfoService().getAll().isEmpty()) new JobInfoService().truncateTable();

        DepartmentService departmentService = new DepartmentService();
        departmentService.createTable();



        JobInfoService jobInfoService = new JobInfoService();
        jobInfoService.createTable();


        WorkerService workerService = new WorkerService();
        workerService.createTable();


        EncodingService encodingService = new EncodingService();
        encodingService.createTable();


        AccountingService accountingService = new AccountingService();
        accountingService.createTable();


        Department department = new Department();
        department.setDepartment("������������� ������������� �������");
        new DepartmentService().add(department);
        department.setDepartment("���������� ��������� �����������");
        new DepartmentService().add(department);
        department.setDepartment("PR ������� � �������");
        new DepartmentService().add(department);

        JobInfo jobInfo = new JobInfo();
        jobInfo.setPosition("�����");
        new JobInfoService().add(jobInfo);
        jobInfo.setPosition("IT-��������");
        new JobInfoService().add(jobInfo);

        Worker worker = new Worker();
        worker.setWorkerId(342);
        worker.setPreview(null);
        worker.setName("ϸ��");
        worker.setLastName("������");
        worker.setBirthday(new Date(1990, 3, 24));
        worker.setAge(30);
        worker.setAddress("�. ������");
        worker.setRemoteWork(false);
        worker.setDepartment("������������� ������������� �������");
        worker.setPosition("IT-��������");
        new WorkerService().add(worker);

        worker.setWorkerId(9382);
        worker.setPreview(null);
        worker.setName("�������");
        worker.setLastName("���������");
        worker.setBirthday(new Date(1983, 5, 23));
        worker.setAge(37);
        worker.setAddress("�. ���");
        worker.setRemoteWork(false);
        worker.setDepartment("������������� ������������� �������");
        worker.setPosition("�����");
        new WorkerService().add(worker);

        Encoding encoding = new Encoding();
        encoding.setEncoding("�");
        new EncodingService().add(encoding);
        encoding.setEncoding("�");
        new EncodingService().add(encoding);
        encoding.setEncoding("�");
        new EncodingService().add(encoding);
        encoding.setEncoding("��");
        new EncodingService().add(encoding);
        encoding.setEncoding("�");
        new EncodingService().add(encoding);
        encoding.setEncoding("�");
        new EncodingService().add(encoding);
        encoding.setEncoding("��");
        new EncodingService().add(encoding);
        encoding.setEncoding("��");
        new EncodingService().add(encoding);
        encoding.setEncoding("��");
        new EncodingService().add(encoding);
        encoding.setEncoding("�");
        new EncodingService().add(encoding);
        encoding.setEncoding("��");
        new EncodingService().add(encoding);

        Accounting accounting = new Accounting();
        accounting.setWorkerId(9382);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,0, 1));
        new AccountingService().add(accounting);
        accounting.setWorkerId(9382);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,0, 2));
        new AccountingService().add(accounting);
        accounting.setWorkerId(9382);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,0, 3));
        new AccountingService().add(accounting);
        accounting.setWorkerId(9382);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,0, 4));
        new AccountingService().add(accounting);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,0, 5));
        new AccountingService().add(accounting);
        accounting.setWorkerId(9382);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,0, 6));
        new AccountingService().add(accounting);
        accounting.setWorkerId(9382);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,0, 7));
        new AccountingService().add(accounting);
        accounting.setWorkerId(9382);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,0, 8));
        new AccountingService().add(accounting);
        accounting.setWorkerId(9382);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,0, 9));
        new AccountingService().add(accounting);
        accounting.setWorkerId(9382);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,0, 10));
        new AccountingService().add(accounting);
        accounting.setWorkerId(9382);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,0, 11));
        new AccountingService().add(accounting);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,0, 12));
        new AccountingService().add(accounting);

        accounting.setWorkerId(342);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,0, 1));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,0, 2));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,0, 3));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,0, 4));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,0, 5));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,0, 6));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,0, 7));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,0, 8));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,0, 9));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,0, 10));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,0, 11));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,0, 12));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,0, 13));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,0, 14));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,0, 15));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,0, 16));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,0, 17));
        new AccountingService().add(accounting);
        //february
        accounting.setWorkerId(342);
        accounting.setEncoding("��");
        accounting.setDay(new Date(120,1, 1));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("��");
        accounting.setDay(new Date(120,1, 2));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("��");
        accounting.setDay(new Date(120,1, 3));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("��");
        accounting.setDay(new Date(120,1, 4));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("��");
        accounting.setDay(new Date(120,1, 5));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("��");
        accounting.setDay(new Date(120,1, 6));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("��");
        accounting.setDay(new Date(120,1, 7));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("��");
        accounting.setDay(new Date(120,1, 8));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("��");
        accounting.setDay(new Date(120,1, 9));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("��");
        accounting.setDay(new Date(120,1, 10));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("��");
        accounting.setDay(new Date(120,1, 11));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("��");
        accounting.setDay(new Date(120,1, 12));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("��");
        accounting.setDay(new Date(120,1, 13));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("��");
        accounting.setDay(new Date(120,1, 14));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("��");
        accounting.setDay(new Date(120,1, 15));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("��");
        accounting.setDay(new Date(120,1, 16));
        new AccountingService().add(accounting);
        accounting.setWorkerId(342);
        accounting.setEncoding("��");
        accounting.setDay(new Date(120,1, 17));
        new AccountingService().add(accounting);

        accounting.setWorkerId(9382);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,1, 1));
        new AccountingService().add(accounting);
        accounting.setWorkerId(9382);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,1, 2));
        new AccountingService().add(accounting);
        accounting.setWorkerId(9382);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,1, 3));
        new AccountingService().add(accounting);
        accounting.setWorkerId(9382);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,1, 4));
        new AccountingService().add(accounting);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,1, 5));
        new AccountingService().add(accounting);
        accounting.setWorkerId(9382);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,1, 6));
        new AccountingService().add(accounting);
        accounting.setWorkerId(9382);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,1, 7));
        new AccountingService().add(accounting);
        accounting.setWorkerId(9382);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,1, 8));
        new AccountingService().add(accounting);
        accounting.setWorkerId(9382);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,1, 9));
        new AccountingService().add(accounting);
        accounting.setWorkerId(9382);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,1, 10));
        new AccountingService().add(accounting);
        accounting.setWorkerId(9382);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,1, 11));
        new AccountingService().add(accounting);
        accounting.setEncoding("�");
        accounting.setDay(new Date(120,1, 12));
        new AccountingService().add(accounting);
    }

}