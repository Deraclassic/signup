package com.dera.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

@WebServlet(name = "loginServlet", value = "/login-servlet")

public class LoginServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/userDB";
    private static final String JDBC_USER = "Deraclassic";
    private static final String JDBC_PASSWORD = "08033468393dad";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
                String sql = "SELECT * FROM user WHERE email=? AND password=?";

                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, email);
                    statement.setString(2, password);
                    try (ResultSet result = statement.executeQuery()) {
                        if (result.next()) {
                            // User authenticated
                            String userEmail = result.getString("email");
                            req.setAttribute("email", userEmail);
                            req.getRequestDispatcher("login-success.jsp").forward(req, resp);
                            // response.sendRedirect("login-success.jsp");
                        } else {
                            // Invalid credentials
                            resp.sendRedirect("signup-error.jsp");
                        }
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                resp.sendRedirect("signup-error.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            resp.sendRedirect("signup-error.jsp");
        }

    }


}
