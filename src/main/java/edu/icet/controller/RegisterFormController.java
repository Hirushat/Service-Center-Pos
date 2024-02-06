package edu.icet.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import edu.icet.bo.UserBo;
import edu.icet.bo.custom.UserBoImpl;
import edu.icet.dto.UserDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.sql.SQLException;
import java.util.Objects;

public class RegisterFormController {
    public JFXComboBox cmbSelectType;
    public JFXTextField txtMailAddress;
    public JFXTextField txtNewPassword;
    public JFXTextField txtRepeatPassword;
    public JFXButton btnRegister;

    private UserBo userBo = new UserBoImpl();

    public void initialize() {
        ObservableList<String> stringList = FXCollections.observableArrayList("Default", "Admin");
        cmbSelectType.getItems().addAll(stringList);
        cmbSelectType.setValue("Default");
    }

    public void registerButtonOnAction(ActionEvent actionEvent) {
        //should add a way to avoid from used emails and 8 characters or more, which includes numbers, letters, and symbols for password
        if (txtMailAddress.getText() == null || txtNewPassword.getText() == null || txtRepeatPassword.getText() == null) {
            new Alert(Alert.AlertType.ERROR, "Please fill All Information!").show();
        } else if (!(txtNewPassword.getText().equals(txtRepeatPassword.getText()))) {
            new Alert(Alert.AlertType.ERROR, "Password not matching!").show();
        } else {
            try {
                userBo.saveUser(new UserDto(
                        txtMailAddress.getText(),
                        txtNewPassword.getText(),
                        cmbSelectType.getValue().toString()
                ));
            } catch (SQLException e){
                throw new RuntimeException(e);
            }

            new Alert(Alert.AlertType.INFORMATION, "User Account Created!").show();
        }
    }
}
