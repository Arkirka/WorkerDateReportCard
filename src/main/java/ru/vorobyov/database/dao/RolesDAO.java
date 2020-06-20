package ru.vorobyov.database.dao;

import ru.vorobyov.database.entity.JobInfo;
import ru.vorobyov.database.entity.Roles;

import java.sql.SQLException;
import java.util.List;

public interface RolesDAO {
    //create
    void add(Roles roles);

    //read
    List<Roles> getAll() throws SQLException;

    void createTable() throws SQLException;

    void truncateTable() throws SQLException;
}
