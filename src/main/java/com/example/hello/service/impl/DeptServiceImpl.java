package com.example.hello.service.impl;

import com.example.hello.entity.Dept;
import com.example.hello.mapper.DeptMapper;
import com.example.hello.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 部门管理 Service 实现类
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> listAll() {
        return deptMapper.selectAll();
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.selectById(id);
    }

    @Override
    public void add(Dept dept) {
        deptMapper.insert(dept);
    }

    @Override
    public void update(Dept dept) {
        deptMapper.update(dept);
    }

    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }
}

