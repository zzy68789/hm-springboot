package com.example.hello.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录请求数据传输对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    /**
     * 用户名
     */
    private String username;
    
    /**
     * 密码
     */
    private String password;
}

