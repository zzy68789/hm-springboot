package com.example.hello.mapper;

import com.example.hello.entity.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理 Mapper 接口
 */
@Mapper
public interface EmpMapper {
    
    /**
     * 条件分页查询员工列表（PageHelper自动分页）
     */
    List<Emp> selectByCondition(@Param("name") String name,
                                 @Param("gender") Integer gender,
                                 @Param("begin") LocalDate begin,
                                 @Param("end") LocalDate end);
    
    /**
     * 根据ID查询员工
     */
    Emp selectById(Integer id);
    
    /**
     * 根据用户名查询员工（用于登录）
     */
    Emp selectByUsername(String username);
    
    /**
     * 查询所有员工（不分页）
     */
    List<Emp> selectAll();
    
    /**
     * 添加员工
     */
    void insert(Emp emp);
    
    /**
     * 修改员工
     */
    void update(Emp emp);
    
    /**
     * 根据ID列表批量删除员工
     */
    void deleteByIds(List<Integer> ids);
}

