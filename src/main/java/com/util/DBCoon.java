package com.util;
import java.sql.*;



/*
 * 用于连接数据库,执行SQL语句和返回执行结果
 * 数据库工具类：
 * 1.连接数据库
 * 2.增删改查
 * 3.执行SQL语句并返回执行结果
 * 4.关流
 * */
public class DBCoon {
    //serverTimezone=UTC设置连接时区，不设置可能会报时区错误
    static String url = "jdbc:mysql://localhost:3306/Servlet?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
    static String username = "root";
    //密码换成自己的
    static String password = "B10921";
    static Connection conn = null;
    static ResultSet rs = null;
    static PreparedStatement ps = null;// 使用了PreparedStatement 预编译SQL方法通过遍历Object数组的方式传递SQL参数

    /*连接数据库*/
    public static void init() {
        try {
            /*1.加载驱动获得驱动管理器*/
            Class.forName("com.mysql.jdbc.Driver");//5.x com.mysql.jdbc.Driver   8.x  com.mysql.cj.jdbc.Driver
            /*2.连接数据库*/
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("数据库连接成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }
    /*查询数据(传递参数)*/
    public static ResultSet searchSql(String sql,Object[] args){
        try {
            ps = conn.prepareStatement(sql);
            for (int j = 0; j < args.length; j++) {
                ps.setObject(j+1, args[j]);
            }
            rs = ps.executeQuery();
            System.out.println("数据查询成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据查询失败");
        }
        return rs;
    }
    /*增删改查数据(传递参数)*/
    public static int addUpdDel(String sql,Object[] args){
        int i = 0;
        try{
            ps = conn.prepareStatement(sql);
            for (int j = 0; j < args.length; j++) {
                ps.setObject(j+1, args[j]);
            }
            i = ps.executeUpdate();
            System.out.println("增删改成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("增删改失败");
        }
        return i;
    }
    /*不传递参数查询所有用户信息*/
    public static ResultSet getUsers(String sql){
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println("数据查询成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据查询失败");
        }
        return rs;
    }
    /*关流*/
    public static void close() {
        try {
            if (rs != null){
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null){
                conn.close();
            }
        }catch (SQLException e) {
            System.out.println("数据流关闭异常");
        }
    }
}
