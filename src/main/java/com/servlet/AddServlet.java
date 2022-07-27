package com.servlet;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @SuppressWarnings("all")
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        String sex = req.getParameter("sex");
        String home = req.getParameter("home");
        String info = req.getParameter("info");
        //实例化一个对象，组装属性
        User user = new User();
        user.setName(name);
        user.setPwd(pwd);
        user.setSex(sex);
        user.setHome(home);
        user.setInfo(info);
        UserDao ud = new UserDaoImpl();
        if (ud.add(user)){
            System.out.println("用户" + name + "新增成功");
            req.setAttribute("msg","用户" + name + "新增成功");
            req.getRequestDispatcher("searchAll").forward(req, resp);
        }else {
            resp.sendRedirect("error.jsp");
        }
    }
}

