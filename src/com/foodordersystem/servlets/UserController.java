package com.foodordersystem.servlets;

import com.foodordersystem.servlets.DatabaseUtil;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.net.URLEncoder;
import java.sql.*;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String item = request.getParameter("item");

        // Registration Logic
        if (username != null && password != null && email != null) {
            try (Connection conn = DatabaseUtil.getConnection()) {
                String query = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setString(1, username);
                    stmt.setString(2, password);  
                    stmt.setString(3, email);
                    stmt.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Optionally redirect to an error page
                response.sendRedirect("error.jsp");
                return;
            }

            // Redirect to login after successful registration
            response.sendRedirect("login.jsp");
        } else if (item != null) {
            // Redirect to add to cart if item is provided and user details are not
            response.sendRedirect("placeOrder.jsp?item=" + URLEncoder.encode(item, "UTF-8"));
        } else {
            // Fallback redirect
            response.sendRedirect("registration.jsp");
        }
    }
}