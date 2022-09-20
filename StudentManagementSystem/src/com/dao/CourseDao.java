package com.dao;

import com.model.Course;

import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *类名： CourseDao.java
 *作者： 19241045王彪
 *描述： 课程信息与数据库操作
 *时间:  2021/12/16 1:52
 *版本:  1.8
 */
public class CourseDao extends BaseDao{
    /**
     * 添加课程
     * @param course
     * @return
     */
    public boolean AddCourse(Course course){
        String sql = "insert into course values(null,?,?)";
        try {
            PreparedStatement prst = con.prepareStatement(sql);
            prst.setString(1, course.getCoursename());
            prst.setString(2, course.getTeacher());
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
     * 删除课程
     * @param course
     * @return
     */
    public  boolean DeleteCourse(Course course){
        String sql = "delete from course where coursename = ? and teacher = ?";
        try {
            PreparedStatement prst = con.prepareStatement(sql);
            prst.setString(1, course.getCoursename());
            prst.setString(2, course.getTeacher());
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
     * 修改课程信息
     * @param course
     * @return
     */
    public boolean UpdateCourse(Course course){
        String sql = "update course set teacher = ? where coursename = ?";
        try {
            PreparedStatement prst = con.prepareStatement(sql);
            prst.setString(1, course.getTeacher());
            prst.setString(2, course.getCoursename());

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
