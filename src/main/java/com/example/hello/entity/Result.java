package com.example.hello.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一响应结果封装类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    /**
     * 响应码，1 表示成功，0 表示失败
     */
    private Integer code;
    
    /**
     * 提示信息
     */
    private String msg;
    
    /**
     * 返回的数据
     */
    private Object data;

    /**
     * 操作成功响应（无数据）
     */
    public static Result success() {
        return new Result(1, "success", null);
    }

    /**
     * 操作成功响应（带数据）
     */
    public static Result success(Object data) {
        return new Result(1, "success", data);
    }

    /**
     * 操作失败响应
     */
    public static Result error(String msg) {
        return new Result(0, msg, null);
    }
}

