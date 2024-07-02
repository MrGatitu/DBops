package com.DBops;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class dbconnection {

    private Connection connection = null;
    private final String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
    private final String username = "postgres";
    private final String password = "@";

    public dbconnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            if (connection != null) {
                System.out.println("200 Ok");
            } else {
                System.out.println("Error");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

     public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        dbconnection dbConnection = new dbconnection();
        
        //dbConnection.closeConnection();
    }
}
