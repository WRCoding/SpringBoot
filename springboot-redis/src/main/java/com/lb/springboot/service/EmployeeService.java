package com.lb.springboot.service;

import com.lb.springboot.bean.Employee;
import com.lb.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author LB
 * @create 2019-05-10 19:46
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Cacheable(value = "emp")
    public Employee getEmp(int id){
        System.out.println("查询用户ID："+id);
        return employeeMapper.getEmp(id);
    }
}
