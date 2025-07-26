package com.foodordersystem.servlets;

import com.foodordersystem.servlets.DatabaseUtil;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String foodItemName = request.getParameter("foodItem");

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("user");

        // Retrieve user ID from database
        int userId = -1;
        try (Connection conn = DatabaseUtil.getConnection()) {
            String userQuery = "SELECT id FROM users WHERE username = ?";
            try (PreparedStatement userStmt = conn.prepareStatement(userQuery)) {
                userStmt.setString(1, username);
                ResultSet userRs = userStmt.executeQuery();
                if (userRs.next()) {
                    userId = userRs.getInt("id");
                }
            }

            // Retrieve food item ID from database
            int foodItemId = -1;
            String foodQuery = "SELECT id FROM food_items WHERE name = ?";
            try (PreparedStatement foodStmt = conn.prepareStatement(foodQuery)) {
                foodStmt.setString(1, foodItemName);
                ResultSet foodRs = foodStmt.executeQuery();
                if (foodRs.next()) {
                    foodItemId = foodRs.getInt("id");
                }
            }

            // Insert order into orders table
            if (userId != -1 && foodItemId != -1) {
                String insertOrderQuery = "INSERT INTO orders (user_id, food_item_id, quantity) VALUES (?, ?, 1)";
                try (PreparedStatement insertOrderStmt = conn.prepareStatement(insertOrderQuery)) {
                    insertOrderStmt.setInt(1, userId);
                    insertOrderStmt.setInt(2, foodItemId);
                    insertOrderStmt.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("payment.jsp");
    }
}
