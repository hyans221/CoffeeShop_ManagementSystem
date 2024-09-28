package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {
    private static final String URL = "jdbc:sqlserver://THY:1433;databaseName=QuanLyCaPhe;"
            + "encrypt=false;trustServerCertificate=true;"
            + "hostNameInCertificate=QUETRAN";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "sa";

    // Method to establish and return the database connection
    public static Connection getConnection() throws SQLException {
        try {
            // Load the JDBC driver for SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Establish the connection
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new SQLException("Database Connection Error: " + ex.getMessage(), ex);
        }
    }

    // Method to close the database connection
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error closing connection: " + ex.getMessage());
        }
    }
}
