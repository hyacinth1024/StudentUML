package com.model;
/**
 *类名： Manage.java
 *作者： 19241045王彪
 *描述： 账号实体类
 *时间:  2021/12/16 0:49
 *版本:  1.8
 */
public class Manage {
    private int id;
    private String name;
    private String password;
    private String identity;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String createDate) {
        this.identity = createDate;
    }
}
