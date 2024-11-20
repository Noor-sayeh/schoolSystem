package com.example.school_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Teachermenu {

    @FXML
    private Label Tmenu;

    @FXML
    private ImageView b;

    @FXML
    private AnchorPane bb;

    @FXML
    private ImageView g;

    @FXML
    private Button grade;

    @FXML
    private ImageView lo;

    @FXML
    private Button logout;

    @FXML
    private ImageView m;

    @FXML
    private ImageView st;

    @FXML
    private Button studentB;

    @FXML
    void grade(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("grade1.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();


    }

    @FXML
    void logout(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("log.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();

    }

    @FXML
    void student(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("student.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();


    }

}
