package com.dao;

import com.model.Grade;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

/**
 *类名： GradeDao.java
 *作者： 19241045王彪
 *描述： 成绩信息与数据库操作
 *时间:  2021/12/16 4:15
 *版本:  1.8
 */
public class GradeDao extends BaseDao {
    /**
     * 添加成绩
     *
     * @param grade
     * @return
     */
    public boolean addCourse(Grade grade) {
        String sql = "insert into grade values(null,?,?,?,?)";
        try {
            PreparedStatement prst = con.prepareStatement(sql);
            prst.setString(1, grade.getName());
            prst.setString(2, grade.getClassname());
            prst.setString(3, grade.getCourse());
            prst.setInt(4, grade.getGrade());
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
     * 删除成绩
     *
     * @param grade
     * @return
     */
    public boolean deleteCourse(Grade grade) {
        String sql = "delete from grade where name = ? and course = ?";
        try {
            PreparedStatement prst = con.prepareStatement(sql);
            prst.setString(1, grade.getName());
            prst.setString(2, grade.getCourse());
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
     * 修改成绩
     *
     * @param grade
     * @return
     */
    public boolean updateCourse(Grade grade) {
        String sql = "update grade set grade = ? where name = ? and course = ?";
        try {
            PreparedStatement prst = con.prepareStatement(sql);
            prst.setInt(1, grade.getGrade());
            prst.setString(2, grade.getName());
            prst.setString(3, grade.getCourse());
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
