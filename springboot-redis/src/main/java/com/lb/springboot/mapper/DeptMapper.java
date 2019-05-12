package com.lb.springboot.mapper;

import com.lb.springboot.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author LB
 * @create 2019-05-11 15:46
 */
@Mapper
public interface DeptMapper {

    @Select("select * from department where id = #{id}")
    Department getDeptById(int id);
}
