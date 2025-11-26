package com.example.hello.mapper;

import com.example.hello.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 部门管理 Mapper 接口
 */
@Mapper
public interface DeptMapper {
    
    /**
     * 查询所有部门
     */
    List<Dept> selectAll();
    
    /**
     * 根据ID查询部门
     */
    Dept selectById(Integer id);
    
    /**
     * 添加部门
     */
    int insert(Dept dept);
    
    /**
     * 修改部门
     */
    int update(Dept dept);
    
    /**
     * 删除部门
     */
    int deleteById(Integer id);
}

