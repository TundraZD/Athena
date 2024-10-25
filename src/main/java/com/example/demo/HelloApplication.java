package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 249, 341); // Изменил размер сцены для лучшего отображения

        stage.setScene(scene);
        stage.setResizable(false); // Добавлено для запрета изменения размера окна
        stage.setMinWidth(249);
        stage.setMinHeight(341);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
