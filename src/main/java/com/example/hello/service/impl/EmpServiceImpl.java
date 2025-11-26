package com.example.hello.service.impl;

import com.example.hello.entity.Emp;
import com.example.hello.entity.EmpExpr;
import com.example.hello.entity.LoginDto;
import com.example.hello.entity.PageBean;
import com.example.hello.mapper.EmpExprMapper;
import com.example.hello.mapper.EmpMapper;
import com.example.hello.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理 Service 实现类
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Override
    public Emp login(LoginDto loginDto) {
        // 根据用户名查询员工
        Emp emp = empMapper.selectByUsername(loginDto.getUsername());
        
        // 验证员工是否存在以及密码是否正确
        if (emp != null && emp.getPassword().equals(loginDto.getPassword())) {
            return emp;
        }
        
        return null;
    }

    @Override
    public PageBean page(String name, Integer gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {
        // 使用PageHelper进行分页
        PageHelper.startPage(page, pageSize);
        
        // 执行查询
        List<Emp> empList = empMapper.selectByCondition(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;
        
        // 封装分页结果
        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public Emp getById(Integer id) {
        // 查询员工信息
        Emp emp = empMapper.selectById(id);
        
        // 查询工作经历
        if (emp != null) {
            List<EmpExpr> exprList = empExprMapper.selectByEmpId(id);
            emp.setExprList(exprList);
        }
        
        return emp;
    }

    @Override
    public List<Emp> listAll() {
        return empMapper.selectAll();
    }

    @Override
    @Transactional
    public void add(Emp emp) {
        // 设置默认密码
        if (emp.getPassword() == null || emp.getPassword().isEmpty()) {
            emp.setPassword("123456");
        }
        
        // 插入员工信息
        empMapper.insert(emp);
        
        // 插入工作经历
        if (emp.getExprList() != null && !emp.getExprList().isEmpty()) {
            // 设置员工ID
            emp.getExprList().forEach(expr -> expr.setEmpId(emp.getId()));
            empExprMapper.insertBatch(emp.getExprList());
        }
    }

    @Override
    @Transactional
    public void update(Emp emp) {
        // 更新员工信息
        empMapper.update(emp);
        
        // 删除原有工作经历
        empExprMapper.deleteByEmpId(emp.getId());
        
        // 插入新的工作经历
        if (emp.getExprList() != null && !emp.getExprList().isEmpty()) {
            // 设置员工ID
            emp.getExprList().forEach(expr -> expr.setEmpId(emp.getId()));
            empExprMapper.insertBatch(emp.getExprList());
        }
    }

    @Override
    @Transactional
    public void deleteByIds(List<Integer> ids) {
        // 删除员工工作经历
        empExprMapper.deleteByEmpIds(ids);
        
        // 删除员工信息
        empMapper.deleteByIds(ids);
    }
}

