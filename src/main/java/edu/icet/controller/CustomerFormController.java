package edu.icet.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import edu.icet.bo.custom.CustomerBo;
import edu.icet.bo.custom.impl.CustomerBoImpl;
import edu.icet.dto.CustomerDto;
import edu.icet.dto.tm.CustomerTm;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Predicate;

public class CustomerFormController {
    public Button btnSave;
    public Button btnUpdate;
    public JFXTextField txtSearch;
    public Button btnBack;
    public JFXTreeTableView<CustomerTm> tblCustomer;
    public TreeTableColumn colCustomerId;
    public TreeTableColumn colCustomerName;
    public TreeTableColumn colContactNumber;
    public TreeTableColumn colEmailAddress;
    public TreeTableColumn colOption;
    public JFXTextField txtEmail;
    public JFXTextField txtContact;
    public JFXTextField txtName;
    public JFXTextField txtId;

    CustomerBo customerBo = new CustomerBoImpl();
    public void initialize() throws SQLException {
        try {
            txtId.setText(customerBo.generateId());
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        colCustomerId.setCellValueFactory(new TreeItemPropertyValueFactory<>("custId"));
        colCustomerName.setCellValueFactory(new TreeItemPropertyValueFactory<>("custName"));
        colContactNumber.setCellValueFactory(new TreeItemPropertyValueFactory<>("contactNumber"));
        colEmailAddress.setCellValueFactory(new TreeItemPropertyValueFactory<>("eMailAddress"));
        colOption.setCellValueFactory(new TreeItemPropertyValueFactory<>("btn"));
        loadCustomerTable();

        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) ->
                setData(newValue)
        );

        txtSearch.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String newValue) {
                tblCustomer.setPredicate(new Predicate<TreeItem<CustomerTm>>() {
                    @Override
                    public boolean test(TreeItem<CustomerTm> treeItem) {
                        return treeItem.getValue().getCustId().contains(newValue) || treeItem.getValue().getCustName().contains(newValue);
                    }
                });
            }
        });

    }

    private void setData(TreeItem<CustomerTm> newValue) {
        if (newValue != null) {
            txtId.setEditable(false);
            txtId.setText(newValue.getValue().getCustId());
            txtName.setText(newValue.getValue().getCustName());
            txtContact.setText(newValue.getValue().getContactNumber());
            txtEmail.setText(String.valueOf(newValue.getValue().getEMailAddress()));
        }
    }


    private void loadCustomerTable() {
        ObservableList<CustomerTm> tmList = FXCollections.observableArrayList();
        try {
            List<CustomerDto> dtoList = customerBo.allCustomers();

            for(CustomerDto dto: dtoList){
                JFXButton btn = new JFXButton("Delete");
                CustomerTm item = new CustomerTm(
                        dto.getId(),
                        dto.getName(),
                        dto.getContactNumber(),
                        dto.getEmail(),
                        btn
                );

                btn.setOnAction(actionEvent -> {
                    deleteCustomer(item.getCustId());
                    loadCustomerTable();
                });

                tmList.add(item);
            }

            TreeItem<CustomerTm> treeItem = new RecursiveTreeItem<>(tmList, RecursiveTreeObject::getChildren);
            tblCustomer.setRoot(treeItem);
            tblCustomer.setShowRoot(false);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCustomer(String id){
        try {
            if (customerBo.deleteCustomer(id)){
                new Alert(Alert.AlertType.INFORMATION,"Customer Deleted");
                loadCustomerTable();
            }else{
                new Alert(Alert.AlertType.ERROR,"Something Went Wrong");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void backButtonOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)tblCustomer.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DashBoardForm.fxml"))));
        stage.setTitle("DashBoard");
    }

    public void updateButtonOnAction(ActionEvent actionEvent){
        try {
            boolean isUpdated = customerBo.updateCustomer(new CustomerDto(
                    txtId.getText(),
                    txtName.getText(),
                    txtContact.getText(),
                    txtEmail.getText()
            ));
            if(isUpdated){
                new Alert(Alert.AlertType.INFORMATION,"Customer Updated").show();
                loadCustomerTable();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveButtonOnAction(ActionEvent actionEvent) {
        if(txtId.getText() == null || txtName.getText() == null || txtContact.getText() == null || txtEmail.getText() == null){
            new Alert(Alert.AlertType.ERROR,"Customer Saved fail").show();
        }else{
            try {
                boolean isSaved = customerBo.saveCustomer(new CustomerDto(
                        txtId.getText(),
                        txtName.getText(),
                        txtContact.getText(),
                        txtEmail.getText()
                ));
                if(isSaved){
                    new Alert(Alert.AlertType.INFORMATION,"Customer Saved").show();
                    loadCustomerTable();
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
