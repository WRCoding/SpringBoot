package com.lb.springboot.mapper;

import com.lb.springboot.bean.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author LB
 * @create 2019-05-10 19:36
 */
@Mapper
public interface EmployeeMapper {

    @Select("select *from employee where id = #{id}")
    public Employee getEmp(int id);

    @Insert("insert into employee values(#{lastName},#{email},#{gender},#{dId})")
    public int addEmp(Employee employee);

    @Update("update employee set last_name=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} where id=#{id}")
    public void updateEmp(Employee employee);
}
