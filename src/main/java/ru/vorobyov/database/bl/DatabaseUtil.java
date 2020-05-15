package ru.vorobyov.database.bl;

import ru.vorobyov.database.service.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseUtil {

    public static Connection getConnection() throws IOException {
        Logger log = Logger.getLogger(DatabaseUtil.class.getName());

        Connection connection = null;

        //load database properties
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/main/resources/properties/database.properties"));

        String DB_DRIVER = prop.getProperty("DB_DRIVER");
        String DB_URL = prop.getProperty("DB_URL");
        String DB_USERNAME = prop.getProperty("DB_USERNAME");
        String DB_PASSWORD = prop.getProperty("DB_PASSWORD");

        try {
            //trying get access to db
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            log.log(Level.FINE, "Connection ok");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            log.log(Level.WARNING, "Connection ERROR: class not fond");
        } catch (SQLException e) {
            e.printStackTrace();
            log.log(Level.WARNING, "Connection ERROR: SQL error");
        }

        return connection;
    }

}
