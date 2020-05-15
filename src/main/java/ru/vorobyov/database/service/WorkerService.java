package ru.vorobyov.database.service;

import ru.vorobyov.database.bl.DatabaseUtil;
import ru.vorobyov.database.dao.WorkerDAO;
import ru.vorobyov.database.entity.Worker;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkerService implements WorkerDAO {
    Connection connection;

    public WorkerService() throws IOException {
        connection = DatabaseUtil.getConnection();
    }

    @Override
    public void add(Worker worker) {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO WORKER (WORKER_ID, PREVIEW, NAME, LASTNAME, BIRTHDAY, AGE, ADDRESS, REMOTE_WORK, DEPARTMENT, POSITION) VALUES(?, ?, ?, ?, ?, ?, ?, ? , ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, worker.getWorkerId());
            preparedStatement.setString(2, worker.getPreview());
            preparedStatement.setString(3, worker.getName());
            preparedStatement.setString(4, worker.getLastName());
            preparedStatement.setDate(5, worker.getBirthday());
            preparedStatement.setInt(6, worker.getAge());
            preparedStatement.setString(7, worker.getAddress());
            preparedStatement.setBoolean(8, worker.getRemoteWork());
            preparedStatement.setString(9, worker.getDepartment());
            preparedStatement.setString(10, worker.getPosition());

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
    public List<Worker> getAll() throws SQLException {
        List<Worker> workersList = new ArrayList<>();

        String sql = "SELECT WORKER_ID, PREVIEW, NAME, LASTNAME, BIRTHDAY, AGE, ADDRESS, REMOTE_WORK, DEPARTMENT, POSITION FROM WORKER";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Worker worker = new Worker();

                worker.setWorkerId(resultSet.getInt("WORKER_ID"));
                worker.setPreview(resultSet.getString("PREVIEW"));
                worker.setName(resultSet.getString("NAME"));
                worker.setLastName(resultSet.getString("LASTNAME"));
                worker.setBirthday(resultSet.getDate("BIRTHDAY"));
                worker.setAge(resultSet.getInt("AGE"));
                worker.setAddress(resultSet.getString("ADDRESS"));
                worker.setRemoteWork(resultSet.getBoolean("REMOTE_WORK"));
                worker.setDepartment(resultSet.getString("DEPARTMENT"));
                worker.setPosition(resultSet.getString("POSITION"));

                workersList.add(worker);
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
        return workersList;
    }


    @Override
    public void update(Worker worker) {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE WORKER SET PREVIEW=?, NAME=?, LASTNAME=?, BIRTHDAY=?, AGE=?, ADDRESS=?, REMOTE_WORK=?, DEPARTMENT=?, POSITION=? WHERE WORKER_ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, worker.getPreview());
            preparedStatement.setString(2, worker.getName());
            preparedStatement.setString(3, worker.getLastName());
            preparedStatement.setDate(4, worker.getBirthday());
            preparedStatement.setInt(5, worker.getAge());
            preparedStatement.setString(6, worker.getAddress());
            preparedStatement.setBoolean(7, worker.getRemoteWork());
            preparedStatement.setString(8, worker.getDepartment());
            preparedStatement.setString(9, worker.getPosition());
            preparedStatement.setInt(10, worker.getWorkerId());

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
    public void remove(Worker worker) {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM WORKER WHERE WORKER_ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, worker.getWorkerId());

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
    public void createTable() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("create table IF NOT EXISTS Worker (\n" +
                "      worker_id INT PRIMARY KEY,\n" +
                "      preview VARCHAR(100),\n" +
                "      name VARCHAR(10),\n" +
                "      last_Name VARCHAR(15),\n" +
                "      birthday DATE,\n" +
                "      age INT,\n" +
                "      address VARCHAR(30),\n" +
                "      remote_Work BOOLEAN,\n" +
                "      department VARCHAR(100),\n" +
                "      position VARCHAR(30),\n" +
                "      FOREIGN KEY (department) REFERENCES Department(department),\n" +
                "      FOREIGN KEY (position) REFERENCES Job_Info(position)\n" +
                ");");
        stmt.close();
    }
}
