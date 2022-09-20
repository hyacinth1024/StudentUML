package com.dao;

import com.model.SchoolClass;

import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *类名： SchoolClassDao.java
 *作者： 19241045王彪
 *描述： 班级信息与数据库操作
 *时间:  2021/12/16 1:43
 *版本:  1.8
 */
public class SchoolClassDao extends BaseDao{
    /**
     * 添加班级
     * @param schoolClass
     * @return
     */
    public boolean AddClass(SchoolClass schoolClass){
        String sql = "insert into class values(null,?,?,?)";
        try {
            PreparedStatement prst = con.prepareStatement(sql);
            prst.setString(1, schoolClass.getClassname());
            prst.setString(2, schoolClass.getYear());
            prst.setInt(3, schoolClass.getNum());
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
     * 删除班级
     * @param schoolClass
     * @return
     */
    public boolean DeleteClass(SchoolClass schoolClass){
        String sql = "delete from class where classname = ? and year = ?";
        try {
            PreparedStatement prst = con.prepareStatement(sql);
            prst.setString(1, schoolClass.getClassname());
            prst.setString(2, schoolClass.getYear());
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
     * 修改班级
     * @param schoolClass
     * @return
     */
    public boolean UpdateClass(SchoolClass schoolClass){
        String sql = "update class set num = ?,year = ? where classname = ?";
        try {
            PreparedStatement prst = con.prepareStatement(sql);
            prst.setInt(1, schoolClass.getNum());
            prst.setString(2, schoolClass.getYear());
            prst.setString(3, schoolClass.getClassname());
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
