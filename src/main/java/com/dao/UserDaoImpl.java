package com.dao;
import com.entity.User;
import com.util.DBCoon;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    /*创建一个返回值标志*/
    static boolean flag = false;
    /*提高sql作用域，每个方法里都要编写sql语句*/
    static String sql = null;
    public boolean login(String name, String pwd) {
        try {
            DBCoon.init();
            sql = "select * from user where name= ? and pwd = ?";
            /*使用预编译SQL传递参数*/
            Object[] args = {name,pwd};
            ResultSet rs = DBCoon.searchSql(sql, args);
            /*遍历数据库里的账号密码与从jsp传来的账号密码作对比*/
            while (rs.next()) {
                if (rs.getString("name").equals(name)&&rs.getString("pwd").equals(pwd)){
                    flag = true;
                    System.out.println("登录成功");
                }
            }
        }catch (Exception e) {
            System.out.println("登录失败");
            e.printStackTrace();
        } finally {
            DBCoon.close();
        }
        return flag;
    }

    public boolean register(User user) {
        try {
            DBCoon.init();
            sql="insert into user(name,pwd,sex,home,info)"+"values(?,?,?,?,?)";
            Object[] args = {user.getName(),user.getPwd(),user.getSex(),user.getHome(),user.getInfo()};
            int i = DBCoon.addUpdDel(sql,args);
            if (i>0){
                flag = true;
                System.out.println("注册成功");
            }
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("注册失败");
        }finally {
            DBCoon.close();
        }
        return flag;
    }

    public List<User> searchAll() {
        List<User> list = new ArrayList<User>();
        try {
            DBCoon.init();
            sql = "select * from user";
            ResultSet rs = DBCoon.getUsers(sql);
            System.out.println("获取所有用户信息成功");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPwd(rs.getString("pwd"));
                user.setSex(rs.getString("sex"));
                user.setHome(rs.getString("home"));
                user.setInfo(rs.getString("info"));
                list.add(user);
            }
        }catch (Exception e){
            System.out.println("获取所有用户信息失败");
            e.printStackTrace();
        }finally{
            DBCoon.close();
        }
        return list;
    }


    public boolean add(User user) {
        try {
            DBCoon.init();
            sql="insert into user(name,pwd,sex,home,info)"+"values(?,?,?,?,?)";
            Object[] args = {user.getName(),user.getPwd(),user.getSex(),user.getHome(),user.getInfo()};
            int i = DBCoon.addUpdDel(sql,args);
            if (i>0){
                flag = true;
                System.out.println("添加成功");
            }
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("添加失败");
        }finally {
            DBCoon.close();
        }
        return flag;
    }

    public boolean update(int id, String name, String pwd, String sex, String home, String info) {
        try {
            DBCoon.init();
            sql = "update user set name=?,pwd=?,sex=?,home=?,info=? where id=?";
            Object[] args={name,pwd,sex,home,info,id};
            int i = DBCoon.addUpdDel(sql,args);
            if (i>0){
                flag=true;
                System.out.println("数据更新成功");
            }
        }catch (Exception e) {
            System.out.println("数据更新失败");
            e.printStackTrace();
        }finally {
            DBCoon.close();
        }
        return flag;
    }

    public boolean delete(int id) {
        try {
            DBCoon.init();
            sql = "delete from user where id = ?";
            Object[] args = {id};
            int i = DBCoon.addUpdDel(sql,args);
            if (i>0){
                flag=true;
                System.out.println("删除成功");
            }
        }catch (Exception e) {
            System.out.println("删除失败");
            e.printStackTrace();
        }finally {
            DBCoon.close();
        }
        return flag;
    }
}

