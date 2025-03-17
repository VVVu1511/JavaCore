package Sec22.MySQLMusic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private final static String URL = "jdbc:sqlserver://DESKTOP-0E72VR4:1433;databaseName=QLyChuyenBay;integratedSecurity=true;encrypt=false";
    
    public static void main(String[] args) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    
            Connection connection = DriverManager.getConnection(URL);
            System.out.println("Successfully connected to music DB!");
    
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}

    
