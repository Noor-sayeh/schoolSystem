package com.example.school_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {

    @FXML
    private AnchorPane anchor;

    @FXML
    private AnchorPane b;

    @FXML
    private BorderPane back;

    @FXML
    private ImageView lock;

    @FXML
    private Button looo;

    @FXML
    private BorderPane p;

    @FXML
    private PasswordField pass;

    @FXML
    private ImageView schoo;

    @FXML
    private TextField username;
    private Stage priStage;
    Parent root = null;

    @FXML
    void buttonkog(ActionEvent event) throws IOException {
        if ((username.getText().toString().equals("Admin") && pass.getText().toString().equals("12345"))) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("managermenu.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } else if ((username.getText().toString().equals("ALIA ALI") && pass.getText().toString().equals("1122"))) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("teachermenu.fxml"));
            Parent root = fxmlLoader.load();
            // Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } else if (username.getText().isEmpty() && pass.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Message Here...");
            alert.setHeaderText("Please enter a username and password");
            alert.setContentText("try again");
            alert.showAndWait();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Message Here...");
            alert.setHeaderText("Wrong username or password");
            alert.setContentText("try again");
            alert.showAndWait();
        }
    }


    @FXML
    void pass(ActionEvent event) {

    }

    @FXML
    void username(ActionEvent event) {

    }

}
