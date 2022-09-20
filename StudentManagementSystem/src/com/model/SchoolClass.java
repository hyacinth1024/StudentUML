package com.model;
/**
 *类名： SchoolClass.java
 *作者： 19241045王彪
 *描述： 课程实体类
 *时间:  2021/12/16 1:40
 *版本:  1.8
 */
public class SchoolClass {
    private int id;
    private String classname;
    private String year;//年级
    private int num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
