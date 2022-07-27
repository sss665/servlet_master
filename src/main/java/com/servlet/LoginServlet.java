package com.servlet;

import com.dao.UserDao;
import com.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*req.getParameter获取前台输入框的值即input框里的name属性的值*/
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        UserDao ud = new UserDaoImpl();
        if(ud.login(name,pwd)){
            /*如果要获取request存放的参数则使用请求转发，路径加不加/都行 */
            System.out.println("用户" + name + "登录成功");
            /*req.setAttribute向request域中添加名为msg对象object为string类型的信息*/
            req.setAttribute("msg", name );

            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }else {
            /*如果不获取参数则使用重定向到错误页面*/
            resp.sendRedirect("error.jsp");
        }
    }
}

