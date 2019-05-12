package com.lb.springboot.service;

import com.lb.springboot.bean.Department;
import com.lb.springboot.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author LB
 * @create 2019-05-11 15:46
 */
@Service
public class DeptService {
    @Autowired
    DeptMapper deptMapper;

    @Cacheable(cacheNames = "dept")
    public Department getDeptById(int id){
        System.out.println("getDeptById: "+id);
        return deptMapper.getDeptById(id);
    }

}
