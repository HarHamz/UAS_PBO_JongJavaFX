package com.uaspbo.uas_pbo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("Jong JavaFX");
        stage.getIcons().add(new Image(Objects.requireNonNull(main.class.getResourceAsStream("USU.png"))));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}