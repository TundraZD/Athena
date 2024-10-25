package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import javafx.animation.FadeTransition;
import javafx.util.Duration;

public class HelloController {
    @FXML
    private AnchorPane myAnchorPane;
    @FXML
    private VBox themesBox;
    private Button themesButton; // Убрана аннотация @FXML, кнопка создается программно
    private VBox themeButtons; // VBox для кнопок тем

    @FXML
    public void initialize() {
        // Создание кнопки "Темы"
        themesButton = new Button();
        themesButton.setText("Темы");
        themesButton.setOnAction(event -> toggleThemeButtons());
        themesButton.setLayoutX(190); // Установка позиции по X
        themesButton.setLayoutY(5);   // Установка позиции по Y
        themesButton.setPrefWidth(57); // Ширина кнопки
        themesButton.setPrefHeight(19); // Высота кнопки
        // Начальный фон для кнопки
        setButtonBackground(themesButton, "D:/ProjectAthena/picture/blueAthena/buttom.png");

        // Создание VBox для кнопок тем
        themeButtons = new VBox();
        themeButtons.setLayoutX(205); // Расположение под кнопкой "Темы"
        themeButtons.setLayoutY(30);  // Отступ вниз от кнопки "Темы"
        themeButtons.setSpacing(5);  // Отступы между кнопками

        // Создание кнопок тем
        Button blueButton = createThemeButton("Blue", "D:/ProjectAthena/picture/blueAthena/buttom1.png", "D:/ProjectAthena/picture/blueAthena", "#011023");
        Button purpleButton = createThemeButton("Purple", "D:/ProjectAthena/picture/purpurleAthena/buttom2.png", "D:/ProjectAthena/picture/purpurleAthena", "#0D0421");
        Button yellowButton = createThemeButton("Yellow", "D:/ProjectAthena/picture/yelowAthena/buttom3.png", "D:/ProjectAthena/picture/yelowAthena", "#350400");

        // Добавление кнопок тем в VBox
        themeButtons.getChildren().addAll(blueButton, purpleButton, yellowButton);

        // Добавление кнопки "Темы" и VBox для кнопок тем на AnchorPane
        myAnchorPane.getChildren().addAll(themesButton, themeButtons);
        // Принести кнопку на передний план
        themesButton.toFront();
        // Изначально скрыть кнопки тем
        themeButtons.setVisible(false);
        // Установите начальную тему
        setTheme("D:/ProjectAthena/picture/blueAthena", "Blue");
    }

    private Button createThemeButton(String text, String buttonBackgroundPath, String themePath, String textColor) {
        Button button = new Button(text);
        button.setPrefWidth(38); // Установка ширины кнопок тем
        button.setPrefHeight(19); // Установка высоты кнопок тем
        button.setStyle("-fx-text-fill: " + textColor + "; -fx-alignment: CENTER; -fx-padding: 0;"); // Установка цвета текста и центрирование
        setButtonBackground(button, buttonBackgroundPath);
        // Установка действия при нажатии на кнопку
        button.setOnAction(event -> {
            setTheme(themePath, text);
        });
        return button;
    }

    private void setButtonBackground(Button button, String backgroundPath) {
        BackgroundImage buttonBackground = new BackgroundImage(
                new Image("file:" + backgroundPath),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false)
        );
        button.setBackground(new Background(buttonBackground));
    }

    private void toggleThemeButtons() {
        themeButtons.setVisible(!themeButtons.isVisible());
        themesButton.toFront(); // Принести кнопку на передний план после смены видимости тем
    }

    private void setTheme(String themePath, String themeName) {
        // Add background image
        BackgroundImage backgroundImage = new BackgroundImage(
                new Image("file:" + themePath + "/Rectangle 2.png"),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        myAnchorPane.setBackground(new Background(backgroundImage));

        // Clear previous images and add new ones
        myAnchorPane.getChildren().clear();
        ImageView imageView1 = new ImageView(new Image("file:" + themePath + "/Ellipse 4.png"));
        imageView1.setFitWidth(180);
        imageView1.setFitHeight(177);
        imageView1.setLayoutX(34);
        imageView1.setLayoutY(64);
        ImageView imageView2 = new ImageView(new Image("file:" + themePath + "/Ellipse 5.png"));
        imageView2.setFitWidth(213);
        imageView2.setFitHeight(211);
        imageView2.setLayoutX(17);
        imageView2.setLayoutY(47);
        ImageView imageView3 = new ImageView(new Image("file:" + themePath + "/Ellipse 6.png"));
        imageView3.setFitWidth(224);
        imageView3.setFitHeight(229);
        imageView3.setLayoutX(12);
        imageView3.setLayoutY(64);
        myAnchorPane.getChildren().addAll(imageView3, imageView2, imageView1);
        myAnchorPane.getChildren().add(themesButton);
        myAnchorPane.getChildren().add(themeButtons);
        themesButton.toFront();
        themeButtons.toFront();

        // Create fade-in transitions for the imageViews
        FadeTransition fadeIn1 = new FadeTransition(Duration.millis(1500), imageView1);
        fadeIn1.setFromValue(0.0);
        fadeIn1.setToValue(1.0);

        FadeTransition fadeIn2 = new FadeTransition(Duration.millis(0), imageView2);
        fadeIn2.setFromValue(0.0);
        fadeIn2.setToValue(1.0);

        FadeTransition fadeIn3 = new FadeTransition(Duration.millis(3000), imageView3);
        fadeIn3.setFromValue(0.0);
        fadeIn3.setToValue(1.0);

        // Play the fade-in transitions sequentially
        fadeIn1.setOnFinished(event -> fadeIn2.play());
        fadeIn1.play();
        fadeIn3.play();
        fadeIn1.play();

        // Change the texture of the "Темы" button
        switch (themeName) {
            case "Blue":
                setButtonBackground(themesButton, "D:/ProjectAthena/picture/blueAthena/buttom.png");
                break;
            case "Purple":
                setButtonBackground(themesButton, "D:/ProjectAthena/picture/purpurleAthena/buttom.png");
                break;
            case "Yellow":
                setButtonBackground(themesButton, "D:/ProjectAthena/picture/yelowAthena/buttom.png");
                break;
        }
    }
}