package com.springboot.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * @author LB
 * @create 2019-05-03 16:29
 */
@Entity(name = "tb_account")
@NamedQuery(name = "Account.findByName",query = "select a from tb_account a where a.name=?1")
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String password;
    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
