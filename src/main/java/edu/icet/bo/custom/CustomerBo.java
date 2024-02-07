package edu.icet.bo.custom;

import edu.icet.bo.SuperBo;
import edu.icet.dto.CustomerDto;
import edu.icet.dto.UserDto;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBo extends SuperBo {
    boolean saveCustomer(CustomerDto dto) throws SQLException;
    boolean updateCustomer(CustomerDto dto) throws SQLException;
    boolean deleteCustomer(String id) throws SQLException;
    List<CustomerDto> allCustomers() throws SQLException;
    String generateId() throws SQLException, ClassNotFoundException;

}
