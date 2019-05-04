package com.springboot.controller;

import com.springboot.dao.AccountDao;
import com.springboot.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author LB
 * @create 2019-05-03 16:36
 */
@RestController
public class AccountController {

    @Autowired
    AccountDao accountDao;

    @RequestMapping("/save")
    public Account saveAccount(Account account){
        Account account1 = accountDao.save(account);
        return account1;
    }
    @RequestMapping("/findById/{id}")
    public Account findById(@PathVariable("id") Long id){
        Optional<Account> account = accountDao.findById(id);
        return account.get();
    }
    @RequestMapping("/update")
    public Account updateAccount(Account account){
        Account account1 = accountDao.save(account);
        return account1;
    }
    @RequestMapping("/find")
    public Account findByName(String name){
        Account account = accountDao.findByName(name);
        return account;
    }
    @RequestMapping("/findByPrice")
    public List<Account> findByPrice(Double price){
        List<Account> accountList = accountDao.findByPrice(price);
        return accountList;
    }
    @RequestMapping("/sort")
    public List<Account> sort(){
        List<Account> accountList = accountDao.findAll(new Sort(Sort.Direction.ASC, "price"));
        return accountList;
    }
    @RequestMapping("/page")
    public Page<Account> page(){
        Page<Account> accountPage = accountDao.findAll(PageRequest.of(0, 2));
        return accountPage;
    }
}
