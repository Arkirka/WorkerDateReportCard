package ru.vorobyov.database.service;

import ru.vorobyov.database.bl.DatabaseUtil;
import ru.vorobyov.database.dao.EncodingDAO;
import ru.vorobyov.database.entity.Encoding;
import ru.vorobyov.database.entity.JobInfo;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EncodingService implements EncodingDAO {
    Connection connection;

    public EncodingService() throws IOException {
        connection = DatabaseUtil.getConnection();
    }

    @Override
    public void add(Encoding encoding) {
        PreparedStatement preparedStatement = null;

        String sql = "MERGE INTO ENCODING KEY (ENCODING) VALUES(?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, encoding.getEncoding());

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
    public List<Encoding> getAll() throws SQLException {
        List<Encoding> encodingList = new ArrayList<>();

        String sql = "SELECT ENCODING FROM ENCODING";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Encoding encoding = new Encoding();

                encoding.setEncoding(resultSet.getString("ENCODING"));

                encodingList.add(encoding);
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
        return encodingList;
    }

    @Override
    public void update(Encoding encoding) {
//todo
    }

    @Override
    public void remove(Encoding encoding) {
//todo
    }

    @Override
    public void createTable() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("create table if not exists Encoding (\n" +
                "    encoding VARCHAR(2) PRIMARY KEY\n" +
                ");");
        stmt.close();
    }

    @Override
    public void truncateTable() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("DELETE FROM ENCODING");
        stmt.close();
    }
}
