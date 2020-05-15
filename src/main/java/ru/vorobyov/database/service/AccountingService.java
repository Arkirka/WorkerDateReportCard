package ru.vorobyov.database.service;

import ru.vorobyov.database.bl.DatabaseUtil;
import ru.vorobyov.database.dao.AccountingDAO;
import ru.vorobyov.database.entity.Accounting;
import ru.vorobyov.database.entity.Department;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountingService implements AccountingDAO {
    Connection connection;

    public AccountingService() throws IOException {
        connection = DatabaseUtil.getConnection();
    }

    @Override
    public void add(Accounting accounting) {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO ACCOUNTING (DAY, ENCODING, WORKER_ID) VALUES(?, ?, ?);";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setDate(1, accounting.getDay());
            preparedStatement.setString(2, accounting.getEncoding());
            preparedStatement.setInt(3,accounting.getWorkerId());

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
    public List<Accounting> getAll() throws SQLException {
        List<Accounting> accountingList = new ArrayList<>();

        String sql = "SELECT DAY, ENCODING, WORKER_ID FROM ACCOUNTING";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Accounting accounting = new Accounting();

                accounting.setDay(resultSet.getDate("DAY"));
                accounting.setEncoding(resultSet.getString("ENCODING"));
                accounting.setWorkerId(resultSet.getInt("WORKER_ID"));

                accountingList.add(accounting);
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
        return accountingList;
    }

    @Override
    public void update(Accounting accounting) {
//todo
    }
    @Override
    public void remove(Accounting accounting) {
//todo
    }

    @Override
    public void createTable() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("create table if not exists Accounting(\n" +
                "    day DATE,\n" +
                "    encoding VARCHAR(2),\n" +
                "    worker_id INT,\n" +
                "    FOREIGN KEY (encoding) REFERENCES Encoding(encoding),\n" +
                "    FOREIGN KEY (worker_id) REFERENCES Worker(worker_id)\n" +
                ");\n");
        stmt.close();
    }

    @Override
    public void truncateTable() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("DELETE FROM ACCOUNTING");
        stmt.close();
    }
}
