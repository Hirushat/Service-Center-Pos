package edu.icet.bo.custom;

import edu.icet.bo.UserBo;
import edu.icet.dao.util.custom.UserDao;
import edu.icet.dao.util.custom.impl.UserDaoImpl;
import edu.icet.dto.UserDto;
import edu.icet.entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserBoImpl implements UserBo {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public boolean saveUser(UserDto dto) throws SQLException {
       return userDao.save(new User(
                dto.getEMail().toLowerCase(),
                dto.getPassWord(),
                dto.getUserType()
        ));
    }

    @Override
    public boolean updateUser(UserDto dto) throws SQLException {
        return userDao.update(new User(
                dto.getEMail(),
                dto.getPassWord(),
                dto.getUserType()
        ));
    }

    @Override
    public boolean deleteUser(String id) throws SQLException {
        return false;
    }

    @Override
    public List<UserDto> allUsers() throws SQLException {
        return null;
    }

}
