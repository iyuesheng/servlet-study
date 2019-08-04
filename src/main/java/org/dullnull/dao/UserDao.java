package org.dullnull.dao;

import org.dullnull.domain.UserDO;
import org.dullnull.utils.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author iisheng
 * @date 2018/03/20 20:41:36
 */
public class UserDao {

    public UserDO getById(String id) {
        String sql = "SELECT * FROM t_user WHERE id = ? ";
        Object[] params = new Object[]{
                id
        };
        try {
            ResultSet resultSet = DatabaseConnection.resultSet(sql, params);
            resultSet.next();
            UserDO userDO = UserDO.builder()
                    .id(resultSet.getString("id"))
                    .name(resultSet.getString("name"))
                    .build();
            return userDO;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
