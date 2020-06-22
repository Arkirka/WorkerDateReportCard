package ru.vorobyov.database.service;

import ru.vorobyov.database.bl.DatabaseUtil;
import ru.vorobyov.database.dao.JobInfoDAO;
import ru.vorobyov.database.entity.JobInfo;
import ru.vorobyov.database.entity.Worker;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobInfoService implements JobInfoDAO {
    Connection connection;

    public JobInfoService() throws IOException {
        connection = DatabaseUtil.getConnection();
    }

    @Override
    public void add(JobInfo jobInfo) {
        PreparedStatement preparedStatement = null;

        String sql = "MERGE INTO JOB_INFO KEY (POSITION) VALUES(?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, jobInfo.getPosition());

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
    public List<JobInfo> getAll() throws SQLException {
        List<JobInfo> jobInfoList = new ArrayList<>();

        String sql = "SELECT POSITION FROM JOB_INFO";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                JobInfo jobInfo = new JobInfo();

               jobInfo.setPosition(resultSet.getString("POSITION"));

                jobInfoList.add(jobInfo);
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
        return jobInfoList;
    }

    @Override
    public void update(JobInfo jobInfo) {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE JOB_INFO SET POSITION=? WHERE POSITION =?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, jobInfo.getPosition());

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
    public void remove(JobInfo jobInfo) {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM JOB_INFO WHERE POSITION =?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, jobInfo.getPosition());

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
        stmt.execute("CREATE TABLE IF NOT EXISTS Job_Info (\n" +
                "    position VARCHAR(30) PRIMARY KEY\n" +
                ");");
        stmt.close();
    }

    @Override
    public void truncateTable() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("DELETE FROM JOB_INFO");
        stmt.close();
    }
}
