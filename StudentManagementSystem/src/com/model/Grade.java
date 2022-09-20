package com.model;

/**
 *类名： Grade.java
 *作者： 19241045王彪
 *描述： 成绩实体类
 *时间:  2021/12/16 0:50
 *版本:  1.8
 */
public class Grade {
    private int id;
    private String name;
    private String classname;
    private String course;
    private int grade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
