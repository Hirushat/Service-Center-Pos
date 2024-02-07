package edu.icet.controller;

import com.jfoenix.controls.JFXButton;
import edu.icet.dto.UserDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardFormController {

    public JFXButton btnCreateAccount;
    public JFXButton btnReports;
    public JFXButton btnCustomers;
    public JFXButton btnInventoryMgt;
    public JFXButton btnOderMgt;
    public BorderPane pane;
    public Label lblLogin;
    public static UserDto login;

    public void initialize(){
        String email = login.getEMail();
        if (email.length() > 10) {
            // Remove the last 10 characters
            email = email.substring(0, email.length() - 10);
        }
        lblLogin.setText("Logged in : "+email);

        if (login.getUserType().equals("Default")){
            btnCreateAccount.setDisable(true);
        }
    }
    public void reportBtnOnAction(ActionEvent actionEvent) throws IOException {
//        Stage stage = (Stage)pane.getScene().getWindow();
//        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/RegisterForm.fxml"))));
//        stage.setTitle("Create User Account");
//        stage.show();
    }

    public void orderMgtButtonOnAction(ActionEvent actionEvent) throws IOException {
//        Stage stage = (Stage)pane.getScene().getWindow();
//        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/RegisterForm.fxml"))));
//        stage.setTitle("Create User Account");
//        stage.show();
    }

    public void inventoryMgtButtonOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)pane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/RegisterForm.fxml"))));
        stage.setTitle("Create User Account");
        stage.show();
    }

    public void customerBtnOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)pane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/CustomerForm.fxml"))));
        stage.setTitle("Customer Management");
        stage.show();
    }

    public void createButtonOnAction(ActionEvent actionEvent) throws IOException{
            Stage stage = (Stage) pane.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/RegisterForm.fxml"))));
            stage.setTitle("Create User Account");
            stage.show();


    }

}
