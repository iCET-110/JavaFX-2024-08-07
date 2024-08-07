package controller;

import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.Customer;

import java.util.List;

public class AddCustomerFormController {

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtSalary;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        double salary = Double.parseDouble(txtSalary.getText());

        Customer customer = new Customer(id, name, address, salary);

        List<Customer> customerList = DBConnection.getInstance().getConnection();
        customerList.add(customer);

        clearTxt();

    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        clearTxt();
    }

    private void clearTxt(){
        txtId.setText(null);
        txtName.setText(null);
        txtAddress.setText(null);
        txtSalary.setText(null);
    }
}
