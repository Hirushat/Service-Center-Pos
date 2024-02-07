package edu.icet.dao.util.custom;

import edu.icet.dao.util.CrudDao;
import edu.icet.dto.CustomerDto;
import edu.icet.entity.Customer;

import java.sql.SQLException;

public interface CustomerDao extends CrudDao<Customer>{
    CustomerDto lastOrder() throws SQLException;
}
