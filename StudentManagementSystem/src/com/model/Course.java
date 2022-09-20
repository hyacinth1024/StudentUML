package com.model;
/**
 *类名： Course.java
 *作者： 19241045王彪
 *描述： 课程实体类
 *时间:  2021/12/16 4:15
 *版本:  1.8
 */
public class Course {
    private int id;
    private String coursename;
    private String teacher;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
