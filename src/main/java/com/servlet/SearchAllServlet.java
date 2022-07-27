package com.servlet;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao ud = new UserDaoImpl();
        List<User> users = ud.searchAll();
        req.setAttribute("users",users);
        System.out.println("查询全部用户成功");
        req.getRequestDispatcher("/showAll.jsp").forward(req, resp);
    }
}

