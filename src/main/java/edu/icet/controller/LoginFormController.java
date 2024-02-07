package edu.icet.controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.icet.bo.custom.UserBo;
import edu.icet.bo.custom.impl.UserBoImpl;
import edu.icet.dto.UserDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class LoginFormController {

    public JFXButton btnForgotPassword;
    public JFXTextField txtPassword;
    public JFXTextField txtEmailAddress;
    public Button btnLogin;
    public BorderPane pane;
    private UserBo userBo = new UserBoImpl();


    public void forgotPasswordButtonOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)pane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/ForgotPasswordForm.fxml"))));
        stage.setTitle("Create User Account");
        stage.show();
    }

    public void loginButtonOnAction(ActionEvent actionEvent) throws IOException {
        //add login failed
        try {
            List<UserDto> userDtos = userBo.allUsers();
            for (UserDto dto : userDtos) {
                if ((dto.getEMail().equals(txtEmailAddress.getText())) && dto.getPassWord().equals(txtPassword.getText())) {
                    DashBoardFormController.login = dto;
                    Stage stage = (Stage)pane.getScene().getWindow();
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DashBoardForm.fxml"))));
                    stage.setTitle("DashBoard");
                    stage.show();
                }else{
                    new Alert(Alert.AlertType.ERROR, "Login Failed!").show();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

    
