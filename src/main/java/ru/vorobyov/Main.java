package ru.vorobyov;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.vorobyov.FX.pageCreator.FXPageCreator;

/**
 * @author Arkirka
 */
//for creating project used jdk1.8.0_231
public class Main extends Application {
    //set scene path
    private String FX_URL = "/fxml\\welcomePage.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception{
        //run app
        new FXPageCreator().createPage(FX_URL, 601, 433);
    }

    public static void main(String[] args) {
        launch(args);
    }

}