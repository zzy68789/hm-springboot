package com.example.hello.controller;

import com.example.hello.entity.Dept;
import com.example.hello.entity.Result;
import com.example.hello.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理控制器
 */
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 查询所有部门
     * GET /depts
     */
    @GetMapping
    public Result list() {
        List<Dept> deptList = deptService.listAll();
        return Result.success(deptList);
    }

    /**
     * 根据ID查询部门
     * GET /depts/{id}
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Dept dept = deptService.getById(id);
        if (dept != null) {
            return Result.success(dept);
        } else {
            return Result.error("部门不存在");
        }
    }

    /**
     * 添加部门
     * POST /depts
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 修改部门
     * PUT /depts
     */
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        deptService.update(dept);
        return Result.success();
    }

    /**
     * 删除部门
     * DELETE /depts/{id}
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        deptService.deleteById(id);
        return Result.success();
    }
}

