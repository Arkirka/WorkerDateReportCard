package ru.vorobyov.database.service;

import ru.vorobyov.database.bl.DatabaseUtil;
import ru.vorobyov.database.dao.DepartmentDAO;
import ru.vorobyov.database.entity.Department;
import ru.vorobyov.database.entity.Encoding;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentService implements DepartmentDAO {
    Connection connection;

    public DepartmentService() throws IOException {
        connection = DatabaseUtil.getConnection();
    }

    @Override
    public void add(Department department) {
        PreparedStatement preparedStatement = null;

        String sql = "MERGE INTO DEPARTMENT KEY (DEPARTMENT) VALUES(?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, department.getDepartment());

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
    public List<Department> getAll() throws SQLException {
        List<Department> departmentList = new ArrayList<>();

        String sql = "SELECT DEPARTMENT FROM DEPARTMENT";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Department department = new Department();

                department.setDepartment(resultSet.getString("DEPARTMENT"));

                departmentList.add(department);
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
        return departmentList;
    }

    @Override
    public void update(Department department) {
//todo
    }

    @Override
    public void remove(Department department) {
//todo
    }

    @Override
    public void createTable() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("create table if not exists Department (\n" +
                "    department VARCHAR(100) PRIMARY KEY\n" +
                ");");
        stmt.close();
    }

    @Override
    public void truncateTable() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("DELETE FROM DEPARTMENT");
        stmt.close();
    }
}
