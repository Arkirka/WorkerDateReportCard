package ru.vorobyov.FX.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import ru.vorobyov.database.bl.DatabaseUtil;

import java.io.IOException;
import java.sql.Connection;

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
            Parent root = FXMLLoader.load(getClass().getResource("/fxml\\reportCardPage.fxml"));
            reportCardPage = new Stage();
            reportCardPage.setScene(new Scene(root, 1366, 576));
            reportCardPage.show();
        } catch (IOException er) {
            er.printStackTrace();
        }
    }

    @FXML
    void toEdit(ActionEvent event) {

    }

}