package com.model;

import java.sql.*;

public class MysqlTest {
    /*public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");

        *//*jdbc:mysql://主机名或IP地址:端口号/数据库名?useUnicode=true
        &characterEncoding=UTF-8
        控制台查看电脑端口:netstat -na
         *//*
        String url = "jdbc:mysql://localhost:3306/studentsystem?serverTimezone=GMT&useSSL=false";
        String user = "root";
        String password = "1234";
        //获取连接对象
        Connection connection = DriverManager.getConnection(url,user,password);
        //获取执行者
        Statement statement = connection.createStatement();

        ResultSet rs = null;
        //判断连接对象
        if (connection == null)
            System.out.println("error!");
        else{
            System.out.println("success");
            String sql = "select * from test";
            rs = statement.executeQuery(sql);

            while (rs.next()){
                String name = rs.getString("姓名");
                int age = rs.getInt("年龄");
                String sex = rs.getString("性别");
                System.out.println("姓名："+name+" 年龄："+age+"  性别："+sex+"");
            }
            rs.close();
            connection.close();
        }
    }*/
}
