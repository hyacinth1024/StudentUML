package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUTil {
    /**
     *类名： DbUTil.java
     *作者： 19241045王彪
     *描述： jdbc:mysql://主机名或IP地址:端口号/数据库名?useUnicode=true&characterEncoding=UTF-8
     *      控制台查看电脑端口:netstat -na
     *时间:  2021/12/4
     *版本:  1.8
     */

    private String dbUrl = "jdbc:mysql://localhost:3306/studentsystem?userUnicode=true&characterEncoding=utf-8";//连接地址
    private String dbUserName ="root";
    private String dbPassword = "1234";
    private String jdbcName = "com.mysql.jdbc.Driver";//驱动名称
    /**
     * 获取数据库连接
     */
    public Connection getCon(){
        try{
            Class.forName(jdbcName);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        Connection con = null;
        try {
            con = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }
    /**
     * 关闭数据库连接
     */
    public void closeCon(Connection con) throws SQLException {
        if (con!=null) con.close();
    }

//    public static void main(String[] args) {
//        DbUTil dbUTil = new DbUTil();
//        try {
//            dbUTil.getCon();
//            System.out.println("数据库连接成功！");
//        }catch (Exception e){
//            e.printStackTrace();
//            System.out.println("数据库连接失败！");
//        }
//    }
}
