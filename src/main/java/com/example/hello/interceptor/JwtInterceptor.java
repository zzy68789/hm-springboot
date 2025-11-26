package com.example.hello.interceptor;

import com.example.hello.utils.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.HashMap;
import java.util.Map;

/**
 * JWT令牌拦截器
 * 用于验证请求头中的JWT令牌
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. 从请求头中获取令牌
        String token = request.getHeader("token");

        // 2. 判断令牌是否存在
        if (token == null || token.isEmpty()) {
            // 令牌不存在，返回401未授权
            responseUnauthorized(response, "未登录，请先登录");
            return false;
        }

        // 3. 验证令牌是否有效
        try {
            Claims claims = JwtUtil.parseToken(token);
            
            // 令牌有效，将用户信息存储到request中，供后续使用
            request.setAttribute("userId", claims.get("id"));
            request.setAttribute("username", claims.get("username"));
            request.setAttribute("name", claims.get("name"));
            
            // 放行
            return true;
        } catch (Exception e) {
            // 令牌无效或已过期，返回401未授权
            responseUnauthorized(response, "令牌无效或已过期，请重新登录");
            return false;
        }
    }

    /**
     * 响应401未授权错误
     */
    private void responseUnauthorized(HttpServletResponse response, String message) throws Exception {
        response.setStatus(401);
        response.setContentType("application/json;charset=UTF-8");
        
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", message);
        result.put("data", null);
        
        String json = new ObjectMapper().writeValueAsString(result);
        response.getWriter().write(json);
    }
}

