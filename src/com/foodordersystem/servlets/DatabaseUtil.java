package com.foodordersystem.servlets;

import java.sql.*;

public class DatabaseUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/restaurant_ordering_system";
    private static final String USER = "root";  
    private static final String PASSWORD = "root123"; 

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
