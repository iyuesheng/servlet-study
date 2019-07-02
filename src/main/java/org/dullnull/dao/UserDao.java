package org.dullnull.dao;

import org.dullnull.domain.User;
import org.dullnull.utils.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author iisheng
 * @date 2018/03/20 20:41:36
 */
public class UserDao {

    public User getById(String id) {
        String sql = "SELECT * FROM user WHERE id = ? ";
        Object[] params = new Object[]{
                id
        };
        try {
            ResultSet resultSet = DatabaseConnection.resultSet(sql, params);
            resultSet.next();
            User user = User.builder()
                    .id(resultSet.getString("id"))
                    .mobile(resultSet.getString("mobile"))
                    .name(resultSet.getString("name"))
                    .build();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
