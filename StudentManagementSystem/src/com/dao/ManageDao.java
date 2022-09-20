package com.dao;

import com.model.Manage;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageDao extends BaseDao{
    /**
     *类名： ManageDao.java
     *作者： 19241045王彪
     *描述： 
     *时间:  2021/12/5 18:20
     *版本:  1.8 
     */

    /**
     * 系统管理员登录
     * @param manage
     * @return
     */
    public Manage login(Manage manage){
        String sql = "select * from user where name = ? and password = ? and identity = '管理员'";
        Manage manageRst = null;
        try {
            PreparedStatement pare = con.prepareStatement(sql);
            pare.setString(1, manage.getName());
            pare.setString(2, manage.getPassword());
            ResultSet executeQuery = pare.executeQuery();
            if (executeQuery.next()){
                manageRst = new Manage();
                manageRst.setId(executeQuery.getInt("id"));
                manageRst.setName(executeQuery.getString("name"));
                manageRst.setPassword(executeQuery.getString("password"));
                manageRst.setIdentity(executeQuery.getString("identity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closecon();
        return manageRst;
    }

    /**
     * 学生登录
     * @param manage
     * @return
     */
    public Manage studentlogin(Manage manage){
        String sql = "select * from user where name = ? and password = ? and identity = '学生'";
        Manage manageRst = null;
        try {
            PreparedStatement pare = con.prepareStatement(sql);
            pare.setString(1, manage.getName());
            pare.setString(2, manage.getPassword());
            ResultSet executeQuery = pare.executeQuery();
            if (executeQuery.next()){
                manageRst = new Manage();
                manageRst.setId(executeQuery.getInt("id"));
                manageRst.setName(executeQuery.getString("name"));
                manageRst.setPassword(executeQuery.getString("password"));
                manageRst.setIdentity(executeQuery.getString("identity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closecon();
        return manageRst;
    }

    /**
     * 班主任登录
     * @param manage
     * @return
     */
    public Manage bzrlogin(Manage manage){
        String sql = "select * from user where name = ? and password = ? and identity = '班主任'";
        Manage manageRst = null;
        try {
            PreparedStatement pare = con.prepareStatement(sql);
            pare.setString(1, manage.getName());
            pare.setString(2, manage.getPassword());
            ResultSet executeQuery = pare.executeQuery();
            if (executeQuery.next()){
                manageRst = new Manage();
                manageRst.setId(executeQuery.getInt("id"));
                manageRst.setName(executeQuery.getString("name"));
                manageRst.setPassword(executeQuery.getString("password"));
                manageRst.setIdentity(executeQuery.getString("identity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closecon();
        return manageRst;
    }

    /**
     * 辅导员登录
     * @param manage
     * @return
     */
    public Manage fdylogin(Manage manage){
        String sql = "select * from user where name = ? and password = ? and identity = '辅导员'";
        Manage manageRst = null;
        try {
            PreparedStatement pare = con.prepareStatement(sql);
            pare.setString(1, manage.getName());
            pare.setString(2, manage.getPassword());
            ResultSet executeQuery = pare.executeQuery();
            if (executeQuery.next()){
                manageRst = new Manage();
                manageRst.setId(executeQuery.getInt("id"));
                manageRst.setName(executeQuery.getString("name"));
                manageRst.setPassword(executeQuery.getString("password"));
                manageRst.setIdentity(executeQuery.getString("identity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closecon();
        return manageRst;
    }

    /**
     * 教师登录
     * @param manage
     * @return
     */
    public Manage teacherlogin(Manage manage){
        String sql = "select * from user where name = ? and password = ? and identity = '教师'";
        Manage manageRst = null;
        try {
            PreparedStatement pare = con.prepareStatement(sql);
            pare.setString(1, manage.getName());
            pare.setString(2, manage.getPassword());
            ResultSet executeQuery = pare.executeQuery();
            if (executeQuery.next()){
                manageRst = new Manage();
                manageRst.setId(executeQuery.getInt("id"));
                manageRst.setName(executeQuery.getString("name"));
                manageRst.setPassword(executeQuery.getString("password"));
                manageRst.setIdentity(executeQuery.getString("identity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closecon();
        return manageRst;
    }

    /**
     * 找回密码
     * @param manage
     * @param newpassword
     * @return
     */
    public String CMBpassword(Manage manage, String newpassword) {
        String sql = "select * from user where name = ?";
        int id = 0;
        Manage manageRst = null;
        PreparedStatement prst = null;
        try {
            prst = con.prepareStatement(sql);
            prst.setString(1, manage.getName());
//            prst.setString(2, student.getPassword());
            ResultSet executeQuery = prst.executeQuery();
            if (!executeQuery.next()){
                String retString = "账号错误！";
                return retString;
            }
            id = executeQuery.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String retString = "修改失败";
        String sqlString = "update user set password = ? where id = ?";
        try {
            prst = con.prepareStatement(sqlString);
            prst.setString(1,newpassword);
            prst.setInt(2,id);
            int rat  =  prst.executeUpdate();
            if (rat > 0 ){
                retString = "密码修改成功！";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closecon();
        return retString;
    }

    /**
     * 添加账号
     * @param manage
     * @return
     */
    public boolean AddAccount(Manage manage){
        String sql = "insert into user values(null,?,?,?)";
        try {
            PreparedStatement prst = con.prepareStatement(sql);
            prst.setString(1, manage.getName());
            prst.setString(2, manage.getPassword());
            prst.setString(3, manage.getIdentity());
            if (prst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closecon();
        return false;
    }

    /**
     * 删除账号
     * @param manage
     * @return
     */
    public boolean deleteAccount(Manage manage){
        String sql = "delete from user where name = ? and Identity = ?";
        try {
            PreparedStatement prst = con.prepareStatement(sql);
            prst.setString(1, manage.getName());
            prst.setString(2, manage.getIdentity());
            if (prst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closecon();
        return false;
    }

    /**
     * 修改账号
     * @param manage
     * @return
     */
    public boolean UpdateAccount(Manage manage){
        String sql = "update user set identity = ?,password = ? where name = ?";
        try {
            PreparedStatement prst = con.prepareStatement(sql);
            prst.setString(1, manage.getIdentity());
            prst.setString(2, manage.getPassword());
            prst.setString(3, manage.getName());
            if (prst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closecon();
        return false;
    }
}
