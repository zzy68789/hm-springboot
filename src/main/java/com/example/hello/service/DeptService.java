package com.example.hello.service;

import com.example.hello.entity.Dept;

import java.util.List;

/**
 * 部门管理 Service 接口
 */
public interface DeptService {
    
    /**
     * 查询所有部门
     */
    List<Dept> listAll();
    
    /**
     * 根据ID查询部门
     */
    Dept getById(Integer id);
    
    /**
     * 添加部门
     */
    void add(Dept dept);
    
    /**
     * 修改部门
     */
    void update(Dept dept);
    
    /**
     * 删除部门
     */
    void deleteById(Integer id);
}

