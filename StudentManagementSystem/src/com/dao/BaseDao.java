package com.dao;

import com.util.DbUTil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *类名： BaseCon.java
 *作者： 19241045王彪
 *描述： 创建对数据库连接对象,整个项目与数据库交互都用这个对象
 *时间:  2021/12/4
 *版本:  1.8 
 */
public class BaseDao {
    public Connection con = new DbUTil().getCon();

    public void closecon() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
