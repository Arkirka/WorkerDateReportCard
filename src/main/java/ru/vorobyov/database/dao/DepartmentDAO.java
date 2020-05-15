package ru.vorobyov.database.dao;

import ru.vorobyov.database.entity.Department;
import ru.vorobyov.database.entity.Encoding;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDAO {

    //create
    void add(Department department);

    //read
    List<Department> getAll() throws SQLException;

    //update
    void update(Department department);

    //delete
    void remove(Department department);

    //create table
    void createTable() throws SQLException;
}
