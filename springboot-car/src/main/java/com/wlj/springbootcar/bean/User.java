package com.wlj.springbootcar.bean;

/**
 * @author LB
 * @create 2019-03-09 16:21
 */
public class User {
    private Integer user_id;
    private Integer user_level_id;
    private String user_name;
    private String user_password;

    public User(Integer user_level_id, String user_name, String user_password) {
        this.user_level_id = user_level_id;
        this.user_name = user_name;
        this.user_password = user_password;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_level_id=" + user_level_id +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                '}';
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getUser_level_id() {
        return user_level_id;
    }

    public void setUser_level_id(Integer user_level_id) {
        this.user_level_id = user_level_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
}
