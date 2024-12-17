package com.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FXcobacoba extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("aplikasi hebatt");

        BorderPane pane = new BorderPane();
        Label label1 = new Label("haihaitayo");
        Label label2 = new Label("yak halo lagi");
        Button button1 = new Button("tekan akuu");

        VBox vbox1 = new VBox();
        vbox1.getChildren().add(label2);
        vbox1.getChildren().add(button1);
        vbox1.setAlignment(Pos.BOTTOM_RIGHT);

        pane.setCenter(label1);
        pane.setBottom(vbox1);

        Scene scene1 = new Scene(pane,200,100);

        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
