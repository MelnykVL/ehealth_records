package edu.diploma.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/ehealth_records";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "123456";

    public static Connection getConnection(){

        Connection connection = null;

        try{
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection successful");
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
            System.out.println("Connection failed");
        }

        return connection;

    }

}
