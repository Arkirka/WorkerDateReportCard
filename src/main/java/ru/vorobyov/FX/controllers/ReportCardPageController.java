package ru.vorobyov.FX.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.ToggleButton;

public class ReportCardPageController {

    @FXML
    private TableColumn<?, ?> columnWorkerId;

    @FXML
    private ToggleButton tButtonApril;

    @FXML
    private TableColumn<?, ?> columnNameLasrName;

    @FXML
    private TableColumn<?, ?> columnDay25;

    @FXML
    private TableColumn<?, ?> columnDay24;

    @FXML
    private TableColumn<?, ?> columnDay27;

    @FXML
    private TableColumn<?, ?> columnDay26;

    @FXML
    private TableColumn<?, ?> columnDay29;

    @FXML
    private TableColumn<?, ?> columnDay28;

    @FXML
    private ToggleButton tButtonMarch;

    @FXML
    private TableColumn<?, ?> columnDay21;

    @FXML
    private TableColumn<?, ?> columnDay20;

    @FXML
    private TableColumn<?, ?> columnDay23;

    @FXML
    private TableColumn<?, ?> columResult;

    @FXML
    private TableColumn<?, ?> columnDay22;

    @FXML
    private TableColumn<?, ?> columnDay14;

    @FXML
    private TableColumn<?, ?> columnDay13;

    @FXML
    private TableColumn<?, ?> columnDay16;

    @FXML
    private Label infoLabel;

    @FXML
    private TableColumn<?, ?> columnDay15;

    @FXML
    private ToggleButton tButtonJuly;

    @FXML
    private TableColumn<?, ?> columnDay18;

    @FXML
    private TableColumn<?, ?> columnDay17;

    @FXML
    private TableColumn<?, ?> columnDay19;

    @FXML
    private ToggleButton tButtonDecember;

    @FXML
    private TableColumn<?, ?> columnPosition;

    @FXML
    private ToggleButton tButtonSeptember;

    @FXML
    private TableColumn<?, ?> columnDay10;

    @FXML
    private TableColumn<?, ?> columnDay12;

    @FXML
    private TableColumn<?, ?> columnDay11;

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
    private TableColumn<?, ?> columnDay7;

    @FXML
    private TableColumn<?, ?> columnDay6;

    @FXML
    private TableColumn<?, ?> columnDay9;

    @FXML
    private TableColumn<?, ?> columnDay8;

    @FXML
    private ToggleButton tButtonNovember;

    @FXML
    private TableColumn<?, ?> columnDay1;

    @FXML
    private ToggleButton tButtonFebruary;

    @FXML
    private TableColumn<?, ?> columnDay3;

    @FXML
    private TableColumn<?, ?> columnDay2;

    @FXML
    private TableColumn<?, ?> columnDay5;

    @FXML
    private TableColumn<?, ?> columnDay4;

    @FXML
    private TableColumn<?, ?> columnDay30;

    @FXML
    private TableColumn<?, ?> columnDay31;

    @FXML
    private ToggleButton tButtonAugust;

    @FXML
    void update(ActionEvent event) {

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
