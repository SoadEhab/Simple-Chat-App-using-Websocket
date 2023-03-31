package com.myservlet.Controller;

import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;


import com.myservlet.Model.User;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Check extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String userName = request.getParameter("name");
        User user = new User(userName, request.getParameter("gender").charAt(0));

        boolean isValid = true;

        if (userName.equals("") || !(userName.matches("^[A-Za-z]\\w{3,29}$")))
            isValid = false;
        else {
            for (User u : ChatEndPoint.users) {
                System.out.println(u.getName());
                if (u.getName().equals(user.getName())) {
                    isValid = false;
                    break;
                }
            }
        }

        if (isValid) {
            out.print("Valid Name");
        } else
            out.print("Invalid Name");

    }
}
