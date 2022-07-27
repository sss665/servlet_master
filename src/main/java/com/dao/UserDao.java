package com.dao;
import com.entity.User;
import com.entity.STA;
import java.util.List;

//接口是为了使代码更简洁规范,注意每个方法传递的参数意义

public interface UserDao {
    /*获取前台的账号密码判断能否登录成功*/
    public boolean login(String name, String pwd);
    /*获取前台的注册信息，封装成user对象*/
    public boolean register(User user);
    /*返回所有的用户信息*/
    public List<STA> searchAll();
    /*获取前台的新增信息，封装成user对象*/
    public boolean add(User user);
    /*根据获取到的内容更新用户信息*/
    public boolean update(int id,String power, String temperature,String softpower, String connected) ;//更新用户信息
    /*获取前台传递的id删除用户*/
    public boolean delete(int id);
}
