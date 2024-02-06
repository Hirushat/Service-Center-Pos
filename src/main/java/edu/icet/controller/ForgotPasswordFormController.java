package edu.icet.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.icet.bo.UserBo;
import edu.icet.bo.custom.UserBoImpl;
import javafx.event.ActionEvent;

public class ForgotPasswordFormController { ;
    public JFXButton btnSendOTP;
    public JFXTextField txtMailAddress;

    private UserBo userBo = new UserBoImpl();

    public void sendOTPButtonOnAction(ActionEvent actionEvent) {

    }
}
