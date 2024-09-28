    package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String hostname = "localhost";
        String sqlInstanceName = "THY"; 
        String sqlDatabase = "QuanLyCaPhe"; 
        String sqlUser = "sa";
        String sqlPassword = "sa"; 

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        String connectURL = "jdbc:sqlserver://" + hostname + ":1433"
        + ";instance=" + sqlInstanceName + ";databaseName=" + sqlDatabase
        + ";encrypt=false;trustServerCertificate=true";


        return DriverManager.getConnection(connectURL, sqlUser, sqlPassword);
    }

    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            System.out.println("Connect to database successful!!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Connect to database failed!!");
        }
    }
}
