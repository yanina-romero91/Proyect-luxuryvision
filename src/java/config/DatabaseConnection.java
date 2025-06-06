package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/luxury_vision_db";  // Cambia esto con tu URL
    private static final String USER = "admin";  // Cambia esto con tu usuario de DB
    private static final String PASSWORD = "123";  // Cambia esto con tu contraseña de DB

    public static Connection getConnection() throws SQLException {
        try {
            // Registra el driver JDBC para MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("JDBC Driver no encontrado", e);
        }
    }
}
