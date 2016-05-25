package edu.bsu.cs222;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UI extends Application {
    public static void main(String[] args){
        launch(args);
    }

    private Button translateButton = new Button("Translate");
    private TextField inputField = new TextField();
    private TextField outputField = new TextField();
    private ComboBox<String> translatorSelector = new ComboBox<>();

    @Override
    public void start(Stage primaryStage) {
        outputField.setEditable(false);
        configure(primaryStage);
        configureComboBox();
        configureTranslateButton();
    }

    private void configure(Stage stage){
        stage.setTitle("Transloator");
        stage.setScene(new Scene(createRoot()));
        stage.sizeToScene();
        stage.show();
    }

    private Pane createRoot() {
        VBox root = new VBox();
        root.getChildren().addAll( //
                new Label("Input:"), //
                inputField, //
                translatorSelector, //
                translateButton, //
                new Label("Output:"),//
                outputField);
        return root;
    }

    private void configureComboBox() {
        translatorSelector.getItems().addAll("Identity");
    }

    private void configureTranslateButton() {
        translateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                translateInputFieldToOutputFiled();
            }
        });
    }

    private void translateInputFieldToOutputFiled() {
        Translator translator = new IdentityTranslator();
        if (translatorSelector.getValue().equals("Identity")){
            translator = new IdentityTranslator();
        }

        String translation = translator.translate(inputField.getText());
        outputField.setText(translation);
    }


}
