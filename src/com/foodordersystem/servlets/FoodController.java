package com.foodordersystem.servlets;

import com.foodordersystem.servlets.DatabaseUtil;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

@WebServlet("/FoodController")
public class FoodController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> foodItems = new ArrayList<>();
        String searchTerm = request.getParameter("search");

        try (Connection conn = DatabaseUtil.getConnection()) {
            String query = "SELECT name FROM food_items";
            if (searchTerm != null && !searchTerm.isEmpty()) {
                query += " WHERE name LIKE ?";
            }
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                if (searchTerm != null && !searchTerm.isEmpty()) {
                    stmt.setString(1, "%" + searchTerm + "%");
                }
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    foodItems.add(rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("foodItems", foodItems);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
