package com.example.hello.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 员工信息实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    /**
     * 员工ID
     */
    private Integer id;
    
    /**
     * 用户名（2-20位）
     */
    private String username;
    
    /**
     * 登录密码
     */
    private String password;
    
    /**
     * 姓名（2-10位）
     */
    private String name;
    
    /**
     * 性别, 1: 男, 2: 女
     */
    private Integer gender;
    
    /**
     * 手机号（11位）
     */
    private String phone;
    
    /**
     * 职位, 1: 班主任, 2: 讲师, 3: 学工主管, 4: 教研主管, 5: 咨询师
     */
    private Integer position;
    
    /**
     * 薪资（整数存储）
     */
    private Integer salary;
    
    /**
     * 头像路径
     */
    private String image;
    
    /**
     * 入职日期
     */
    private LocalDate hireDate;
    
    /**
     * 所属部门ID
     */
    private Integer deptId;
    
    /**
     * 部门名称（关联查询）
     */
    private String deptName;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 最后操作时间
     */
    private LocalDateTime updateTime;
    
    /**
     * 工作经历列表
     */
    private List<EmpExpr> exprList;
}

