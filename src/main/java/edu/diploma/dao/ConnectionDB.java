package edu.diploma.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDB {

    private static Connection connection = null;

    public static PreparedStatement getPrepareStatement(String sql) throws SQLException {
        return getConnection().prepareStatement(sql);
    }

    private static Connection getConnection() {
        if (connection == null) {
            Properties prop = loadPropertiesFile();

            final String DB_DRIVER = prop.getProperty("flyway.driver");
            final String DB_URL = prop.getProperty("flyway.url");
            final String DB_USERNAME = prop.getProperty("flyway.user");
            final String DB_PASSWORD = prop.getProperty("flyway.password");

            try {
                Class.forName(DB_DRIVER);
                connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }

    private static Properties loadPropertiesFile() {
        Properties prop = new Properties();
        try (InputStream in = new FileInputStream("src/main/resources/flyway.properties")) {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

}
