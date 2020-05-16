package ru.vorobyov.database.service;

import ru.vorobyov.database.bl.DatabaseUtil;
import ru.vorobyov.database.entity.Accounting;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataListService {

    private int idCount;

    public List<Accounting> getDataList(String sql) throws SQLException, IOException {
        Statement stmt = null;
        Connection connection = null;
        connection = DatabaseUtil.getConnection();
        List<Accounting> accountingList = new ArrayList<>();

        stmt = connection.createStatement();

        if(!sql.equals("")) {
            ResultSet rst = stmt.executeQuery(sql);

            while (rst.next()) {
                Accounting accounting = new Accounting();
                accounting.setWorkerId(rst.getInt(1));
                accounting.setEncoding(rst.getString(2));
                accounting.setDay(rst.getDate(3));
                accountingList.add(accounting);
            }

            //count the amount of workers
            int currentId = accountingList.get(0).getWorkerId();
            idCount = 1;
            for (int i = 0; i < accountingList.size(); i++) {
                if(currentId != accountingList.get(i).getWorkerId()) {
                    idCount++;
                    currentId = accountingList.get(i).getWorkerId();
                }
            }
        }
        return accountingList;
    }

    public int getIdCount() {
        return idCount;
    }
}
