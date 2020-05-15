package ru.vorobyov.database.dao;

import ru.vorobyov.database.entity.Accounting;
import ru.vorobyov.database.entity.Department;

import java.sql.SQLException;
import java.util.List;

public interface AccountingDAO {

    //create
    void add(Accounting accounting);

    //read
    List<Accounting> getAll() throws SQLException;

    //update
    void update(Accounting accounting);

    //delete
    void remove(Accounting accounting);

    //create table
    void createTable() throws SQLException;

    void truncateTable() throws SQLException;
}
