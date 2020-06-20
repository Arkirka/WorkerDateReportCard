package ru.vorobyov.FX.pageCreator;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FXPageCreator {
    private static String FX_URL = "/fxml\\welcomePage.fxml";
    private static Stage stage = null;

    public void createPage(String url, int width, int height) throws IOException {
        setFxUrl(url);
        Parent root = FXMLLoader.load(getClass().getResource(getFxUrl()));
        setStage(new Stage());
        stage.setTitle("Report card");
        stage.setScene(new Scene(root, width, height));
        stage.show();
    }

    public static String getFxUrl() {
        return FX_URL;
    }

    public static void setFxUrl(String fxUrl) {
        FX_URL = fxUrl;
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        FXPageCreator.stage = stage;
    }
}
