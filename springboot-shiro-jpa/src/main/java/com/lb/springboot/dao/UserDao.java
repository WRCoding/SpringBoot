package com.lb.springboot.dao;

import com.lb.springboot.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author LB
 * @create 2019-05-07 15:49
 */
public interface UserDao extends JpaRepository<User, Long> {
    public User findByName(String name);
}
