package cn.iisheng.utils;

import cn.iisheng.config.DatabaseConfig;

import java.sql.*;

/**
 * @author iisheng
 * @date 2018/03/21 10:23:29
 */
public class DatabaseConnection {

    public static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 数据库连接
     */
    public static void connection() {
        try {
            connection = DriverManager.getConnection(
                    DatabaseConfig.URL,
                    DatabaseConfig.USER_NAME,
                    DatabaseConfig.USER_PASSWORD
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建PreparedStatement对象
     */
    public static PreparedStatement preparedStatement(String sql, Object[] params) throws SQLException {
        connection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        if (params == null) {
            return preparedStatement;
        }
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1, params[i]);
        }
        return preparedStatement;
    }

    /**
     * 创建ResultSet对象
     */
    public static ResultSet resultSet(String sql, Object[] params) throws SQLException {
        return preparedStatement(sql, params).executeQuery();
    }

    /**
     * 关闭数据库连接
     */
    public static void close(Object obj) throws SQLException {
        if (obj == null) {
            return;
        }
        if (obj instanceof ResultSet) {
            ((ResultSet) obj).close();
        }
        if (obj instanceof PreparedStatement) {
            ((PreparedStatement) obj).close();
        }
        if (obj instanceof Connection) {
            ((Connection) obj).close();
        }
    }

}
