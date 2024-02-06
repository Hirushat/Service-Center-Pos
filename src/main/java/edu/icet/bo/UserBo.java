package edu.icet.bo;

import edu.icet.dto.UserDto;
import edu.icet.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserBo {
    boolean saveUser(UserDto dto) throws SQLException;
    boolean updateUser(UserDto dto) throws SQLException;
    boolean deleteUser(String id) throws SQLException;
    List<UserDto> allUsers() throws SQLException;
}
