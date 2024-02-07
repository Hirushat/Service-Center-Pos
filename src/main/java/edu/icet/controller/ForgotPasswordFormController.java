package edu.icet.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.icet.bo.custom.UserBo;
import edu.icet.bo.custom.impl.UserBoImpl;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class ForgotPasswordFormController { ;
    public JFXButton btnSendOTP;
    public JFXTextField txtMailAddress;
    public Button btnBack;

    private UserBo userBo = new UserBoImpl();

    public void sendOTPButtonOnAction(ActionEvent actionEvent) {

    }

    public void backButtonOnAction(ActionEvent actionEvent) {
    }
}
