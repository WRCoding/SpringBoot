package com.lb.springboot.contorller;

import com.lb.springboot.bean.Department;
import com.lb.springboot.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LB
 * @create 2019-05-11 15:50
 */
@RestController
public class DeptController {
    @Autowired
    DeptService deptService;

    @GetMapping("/dept/{id}")
    public Department getById(@PathVariable("id") int id){
        return deptService.getDeptById(id);
    }
}
