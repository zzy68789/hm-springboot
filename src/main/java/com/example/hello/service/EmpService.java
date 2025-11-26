package com.example.hello.service;

import com.example.hello.entity.Emp;
import com.example.hello.entity.LoginDto;
import com.example.hello.entity.PageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理 Service 接口
 */
public interface EmpService {
    
    /**
     * 员工登录
     */
    Emp login(LoginDto loginDto);
    
    /**
     * 条件分页查询员工列表
     */
    PageBean page(String name, Integer gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize);
    
    /**
     * 根据ID查询员工（包含工作经历）
     */
    Emp getById(Integer id);
    
    /**
     * 查询所有员工
     */
    List<Emp> listAll();
    
    /**
     * 添加员工（包含工作经历）
     */
    void add(Emp emp);
    
    /**
     * 修改员工（包含工作经历）
     */
    void update(Emp emp);
    
    /**
     * 批量删除员工（包含工作经历）
     */
    void deleteByIds(List<Integer> ids);
}

