package com.example.hello.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 员工工作经历实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpExpr {
    /**
     * 经历ID
     */
    private Integer id;
    
    /**
     * 关联员工的ID
     */
    private Integer empId;
    
    /**
     * 公司名称
     */
    private String company;
    
    /**
     * 担任职位
     */
    private String position;
    
    /**
     * 开始日期
     */
    private LocalDate startDate;
    
    /**
     * 结束日期
     */
    private LocalDate endDate;
}

