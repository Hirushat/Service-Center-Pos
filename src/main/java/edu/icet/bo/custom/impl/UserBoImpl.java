package edu.icet.bo.custom.impl;

import edu.icet.bo.custom.UserBo;
import edu.icet.dao.util.custom.UserDao;
import edu.icet.dao.util.custom.impl.UserDaoImpl;
import edu.icet.dto.UserDto;
import edu.icet.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
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
        return userDao.delete(id);
    }

    @Override
    public List<UserDto> allUsers() throws SQLException {
        List<User> entityList = userDao.getAll();
        List<UserDto> list = new ArrayList<>();
        for (User user: entityList) {
            list.add(new UserDto(
                    user.getEMail(),
                    user.getPassWord(),
                    user.getUserType()
            ));
        }
        return list;
    }

}
