package edu.icet.bo.custom.impl;

import edu.icet.bo.custom.CustomerBo;
import edu.icet.dao.util.custom.CustomerDao;
import edu.icet.dao.util.custom.UserDao;
import edu.icet.dao.util.custom.impl.CustomerDaoImpl;
import edu.icet.dao.util.custom.impl.UserDaoImpl;
import edu.icet.dto.CustomerDto;
import edu.icet.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBoImpl implements CustomerBo {
    private CustomerDao customerDao = new CustomerDaoImpl();
    @Override
    public boolean saveCustomer(CustomerDto dto) throws SQLException {
        return customerDao.save(new Customer(
                dto.getId(),
                dto.getName(),
                dto.getContactNumber(),
                dto.getEmail()
        ));
    }

    @Override
    public boolean updateCustomer(CustomerDto dto) throws SQLException {
        return customerDao.update(new Customer(
                dto.getId(),
                dto.getName(),
                dto.getContactNumber(),
                dto.getEmail()
        ));
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException {
        return customerDao.delete(id);
    }

    @Override
    public List<CustomerDto> allCustomers() throws SQLException {
        List<Customer> entityList = customerDao.getAll();
        List<CustomerDto> list = new ArrayList<>();
        for (Customer customer: entityList) {
            list.add(new CustomerDto(
                    customer.getId(),
                    customer.getName(),
                    customer.getContactNumber(),
                    customer.getEmail()
            ));
        }
        return list;
    }

    @Override
    public String generateId() throws SQLException, ClassNotFoundException {
        try {
            List<Customer> entityList = customerDao.getAll();
            if (entityList.size() == 0){
                return "D001";
            }else{
                Customer customer = entityList.get(entityList.size()-1) ;
                String id = customer.getId();
                int num = Integer.parseInt(id.split("[D]")[1]);
                num++;
                return String.format("D%03d",num);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
