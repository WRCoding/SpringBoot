package com.lb.springboot.service;

import com.lb.springboot.bean.Employee;
import com.lb.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.naming.Name;

/**
 * @author LB
 * @create 2019-05-10 19:46
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Cacheable(value = "emp",key = "#id")
    public Employee getEmp(int id){
        System.out.println("查询用户ID："+id);
        return employeeMapper.getEmp(id);
    }

    @CachePut(value = "emp",key = "#result.id")
    public Employee updateEmp(Employee employee){
        System.out.println("更新用户ID："+employee.getId());
        employeeMapper.updateEmp(employee);
        return employee;
    }

    @CacheEvict(value = "emp",key = "#id")
    public void deleteEmp(int id){
        System.out.println("deleteEmp: "+id);
    }
}
