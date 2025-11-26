package com.example.hello.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 部门实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    /**
     * 部门ID（唯一标识，自增主键）
     */
    private Integer id;
    
    /**
     * 部门名称
     */
    private String name;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 最后操作时间
     */
    private LocalDateTime updateTime;
}

