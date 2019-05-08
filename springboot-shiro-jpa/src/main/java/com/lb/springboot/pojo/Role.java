package com.lb.springboot.pojo;

import javax.persistence.*;
import java.util.List;

/**
 * @author LB
 * @create 2019-05-07 15:19
 */
@Entity
public class Role {
    @Id
    @GeneratedValue
    private int id;
    private String role;
    private String description;

    @ManyToMany
    @JoinTable(name="UserRole",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="uid")})
    private List<User> userInfos;// 一个角色对应多个用户

    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="RolePermission",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="permissionId")})
    private List<Premisson> permissions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUserInfos() {
        return userInfos;
    }

    public void setUserInfos(List<User> userInfos) {
        this.userInfos = userInfos;
    }

    public List<Premisson> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Premisson> permissions) {
        this.permissions = permissions;
    }
}
