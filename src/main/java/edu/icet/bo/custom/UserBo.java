package edu.icet.bo.custom;

import edu.icet.bo.SuperBo;
import edu.icet.dto.UserDto;
import edu.icet.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserBo extends SuperBo {
    boolean saveUser(UserDto dto) throws SQLException;
    boolean updateUser(UserDto dto) throws SQLException;
    boolean deleteUser(String id) throws SQLException;
    List<UserDto> allUsers() throws SQLException;
}
