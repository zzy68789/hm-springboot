package com.example.hello.mapper;

import com.example.hello.entity.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 员工工作经历 Mapper 接口
 */
@Mapper
public interface EmpExprMapper {
    
    /**
     * 根据员工ID查询工作经历列表
     */
    List<EmpExpr> selectByEmpId(Integer empId);
    
    /**
     * 批量插入工作经历
     */
    void insertBatch(List<EmpExpr> exprList);
    
    /**
     * 根据员工ID删除工作经历
     */
    void deleteByEmpId(Integer empId);
    
    /**
     * 根据员工ID列表批量删除工作经历
     */
    void deleteByEmpIds(List<Integer> empIds);
}

