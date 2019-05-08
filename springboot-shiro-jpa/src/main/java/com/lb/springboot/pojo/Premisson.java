package com.lb.springboot.pojo;

import javax.persistence.*;
import java.util.List;

/**
 * @author LB
 * @create 2019-05-07 15:19
 */
@Entity
public class Premisson {
    @Id
    @GeneratedValue
    private int id;
    private String name;//名称
    private String url;
    private String permission;




    @ManyToMany
    @JoinTable(name="RolePermission",joinColumns={@JoinColumn(name="permissionId")},inverseJoinColumns={@JoinColumn(name="roleId")})
    private List<Role> Roles;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public List<Role> getRoles() {
        return Roles;
    }

    public void setRoles(List<Role> Roles) {
        this.Roles = Roles;
    }
}
