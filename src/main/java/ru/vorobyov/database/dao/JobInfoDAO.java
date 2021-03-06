package ru.vorobyov.database.dao;

import ru.vorobyov.database.entity.JobInfo;

import java.sql.SQLException;
import java.util.List;

public interface JobInfoDAO {

    //create
    void add(JobInfo jobInfo);

    //read
    List<JobInfo> getAll() throws SQLException;

    //update
    void update(JobInfo jobInfo);

    //delete
    void remove(JobInfo jobInfo);

    void createTable() throws SQLException;

    void truncateTable() throws SQLException;
}
