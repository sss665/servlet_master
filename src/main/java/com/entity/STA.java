package com.entity;
/*
 *映射数据库创建的user表
 *
 */

public class STA {
    private int id;
    private float power;
    private float temperature;
    private float softpower;
    private boolean connected;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }
    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
    public float getSoftpower() {
        return softpower;
    }

    public void setSoftpower(float softpower) {
        this.softpower = softpower;
    }
    public boolean getConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

 /*   public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
*/
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + power + '\'' +
                ", pwd='" + temperature + '\'' +
                ", sex='" + softpower + '\'' +
                ", home='" +  connected+ '\'' +
                '}';
    }
}

