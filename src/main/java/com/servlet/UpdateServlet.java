package com.servlet;

import com.dao.UserDao;
import com.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int userId = Integer.parseInt(id);

        String power = req.getParameter("power");
        String temperature = req.getParameter("temperature");
        String softpower = req.getParameter("softpower");
        String connected = req.getParameter("connected");

        UserDao ud = new UserDaoImpl();

        if(ud.update(userId, power, temperature, softpower, connected)){
            req.getRequestDispatcher("searchAll").forward(req, resp);
        }else{
            resp.sendRedirect("error.jsp");
        }
    }
}

