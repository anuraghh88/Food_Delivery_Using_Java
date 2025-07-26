package com.foodordersystem.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.net.URLEncoder;

@WebServlet("/PaymentController")
public class PaymentController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// Inside doPost of PaymentController.java
    	String item = request.getParameter("item");
    	String paymentMethod = request.getParameter("paymentMethod");

    	// Save or process payment

    	// Redirect or show confirmation
    	response.sendRedirect("confirmation.jsp?item=" + URLEncoder.encode(item, "UTF-8") + "&method=" + URLEncoder.encode(paymentMethod, "UTF-8"));


        
        if (paymentMethod != null) {
            response.getWriter().write("Payment successful via " + paymentMethod); 
        } else {
            response.sendRedirect("payment.jsp");  
        }
    }
}
