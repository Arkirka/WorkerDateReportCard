package ru.vorobyov.FX.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ru.vorobyov.FX.pageCreator.FXPageCreator;
import ru.vorobyov.database.entity.Roles;
import ru.vorobyov.database.service.RolesService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class LoginPageController {

    @FXML
    private Label infoLabel;

    @FXML
    private Button buttonToEdit;

    @FXML
    private TextField textPassword;

    @FXML
    private TextField textLogin;

    @FXML
    private Button buttonPasswords;

    @FXML
    void toEdit(ActionEvent event) {
        try {
            List<Roles> rolesList;
            rolesList = new RolesService().getAll();

            if(textLogin.getText().equals( rolesList.get(0).getLogin() )) {
                if(textPassword.getText().equals( rolesList.get(0).getPassword() )){
                    new FXPageCreator().createPage("/fxml\\databaseEditPage.fxml", 1366, 599);
                } else {
                    infoLabel.setText("Пароль неверен");
                }
            } else if(textLogin.getText().equals( rolesList.get(1).getLogin() )) {
                if(textPassword.getText().equals( rolesList.get(1).getPassword() )){
                    new FXPageCreator().createPage("/fxml\\timekeeperPage.fxml", 889, 511);
                } else {
                    infoLabel.setText("Пароль неверен");
                }
            } else {
                infoLabel.setText("Логин неверен");
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void toPasswords(ActionEvent event) {
        try {
            new FXPageCreator().createPage("/fxml\\passwordsInfoPage.fxml", 800, 599);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
