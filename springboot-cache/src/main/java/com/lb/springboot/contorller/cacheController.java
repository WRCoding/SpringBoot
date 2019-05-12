package com.lb.springboot.contorller;

import com.lb.springboot.bean.Employee;
import com.lb.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LB
 * @create 2019-05-10 19:51
 */
@RestController
public class cacheController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getEmp/{id}")
    public Employee get(@PathVariable("id") int id){
        Employee employee = employeeService.getEmp(id);
        return employee;
    }
    @GetMapping("/update")
    public Employee update(Employee employee){
        Employee emp = employeeService.updateEmp(employee);
        return emp;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        employeeService.deleteEmp(id);
        return "success delete";
    }
}
