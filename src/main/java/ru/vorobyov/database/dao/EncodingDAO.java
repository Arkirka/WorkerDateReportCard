package ru.vorobyov.database.dao;

import ru.vorobyov.database.entity.Encoding;
import ru.vorobyov.database.entity.JobInfo;

import java.sql.SQLException;
import java.util.List;

public interface EncodingDAO {

    //create
    void add(Encoding encoding);

    //read
    List<Encoding> getAll() throws SQLException;

    //update
    void update(Encoding encoding);

    //delete
    void remove(Encoding encoding);

    //create table
    void createTable() throws SQLException;

    void truncateTable() throws SQLException;
}
