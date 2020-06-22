package ru.vorobyov.database.service;

import ru.vorobyov.database.bl.DatabaseUtil;
import ru.vorobyov.database.dao.RolesDAO;
import ru.vorobyov.database.entity.JobInfo;
import ru.vorobyov.database.entity.Roles;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RolesService implements RolesDAO {
    Connection connection;

    public RolesService() throws IOException {
        connection =  DatabaseUtil.getConnection();
    }

    @Override
    public void add(Roles roles) {
        PreparedStatement preparedStatement = null;

        String sql = "MERGE INTO ROLES KEY (LOGIN, PASSWORD) VALUES(?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, roles.getLogin());
            preparedStatement.setString(2, roles.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Roles> getAll() throws SQLException {
        List<Roles> rolesList = new ArrayList<>();

        String sql = "SELECT LOGIN, PASSWORD FROM ROLES";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Roles roles = new Roles();

                roles.setLogin(resultSet.getString("LOGIN"));
                roles.setPassword(resultSet.getString("PASSWORD"));

                rolesList.add(roles);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return rolesList;
    }


    @Override
    public void createTable() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("CREATE TABLE IF NOT EXISTS ROLES (\n" +
                "    LOGIN VARCHAR PRIMARY KEY,\n" +
                "    PASSWORD VARCHAR);");
        stmt.close();
    }

    @Override
    public void truncateTable() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("DELETE FROM ROLES");
        stmt.close();
    }
}
