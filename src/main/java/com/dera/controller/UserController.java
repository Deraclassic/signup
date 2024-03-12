package com.dera.controller;

import com.dera.dao.UserDao;
import com.dera.model.User;
import com.dera.util.ConnectionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "user", value = "/signup")
public class UserController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User newUser = new User(firstName,lastName,email,password);
        UserDao userDao = new UserDao(ConnectionUtil.getConnection());
        userDao.addUser(newUser);

        resp.sendRedirect("signup-success.jsp");
    }

}
