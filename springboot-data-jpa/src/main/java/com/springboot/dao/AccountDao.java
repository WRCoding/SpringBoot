package com.springboot.dao;

import com.springboot.pojo.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author LB
 * @create 2019-05-03 16:33
 */
public interface AccountDao extends JpaRepository<Account,Long> {

    /**
     *使用的是NamedQuery里定义的查询语句，而不是根据方法名称查询
     * @param name
     * @return
     */
    Account findByName(String name);

    @Query("select a from tb_account a where a.price=?1")
    List<Account> findByPrice(Double price);
}
