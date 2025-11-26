package com.example.hello.controller;

import com.example.hello.entity.Emp;
import com.example.hello.entity.LoginDto;
import com.example.hello.entity.Result;
import com.example.hello.service.EmpService;
import com.example.hello.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录控制器
 */
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    /**
     * 员工登录接口
     * POST /login
     *
     * @param loginDto 登录信息（用户名、密码）
     * @return 登录结果（包含JWT令牌）
     */
    @PostMapping("/login")
    public Result login(@RequestBody LoginDto loginDto) {
        // 调用服务层进行登录验证
        Emp emp = empService.login(loginDto);

        // 判断登录是否成功
        if (emp != null) {
            // 登录成功，生成JWT令牌
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", emp.getId());
            claims.put("username", emp.getUsername());
            claims.put("name", emp.getName());
            
            String token = JwtUtil.generateToken(claims);

            // 构建响应数据
            Map<String, Object> data = new HashMap<>();
            data.put("id", emp.getId());
            data.put("username", emp.getUsername());
            data.put("name", emp.getName());
            data.put("token", token);

            return Result.success(data);
        } else {
            // 登录失败
            return Result.error("用户名或密码错误");
        }
    }
}

