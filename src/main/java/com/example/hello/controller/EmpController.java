package com.example.hello.controller;

import com.example.hello.entity.Emp;
import com.example.hello.entity.PageBean;
import com.example.hello.entity.Result;
import com.example.hello.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 员工管理控制器
 */
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 条件分页查询员工列表
     * GET /emps?name=张&gender=1&begin=2007-09-01&end=2022-09-01&page=1&pageSize=10
     */
    @GetMapping
    public Result page(@RequestParam(required = false) String name,
                       @RequestParam(required = false) Integer gender,
                       @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize) {
        PageBean pageBean = empService.page(name, gender, begin, end, page, pageSize);
        return Result.success(pageBean);
    }

    /**
     * 根据ID查询员工（包含工作经历）
     * GET /emps/{id}
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Emp emp = empService.getById(id);
        if (emp != null) {
            return Result.success(emp);
        } else {
            return Result.error("员工不存在");
        }
    }

    /**
     * 查询所有员工
     * GET /emps/list
     */
    @GetMapping("/list")
    public Result listAll() {
        List<Emp> empList = empService.listAll();
        return Result.success(empList);
    }

    /**
     * 添加员工（包含工作经历）
     * POST /emps
     */
    @PostMapping
    public Result add(@RequestBody Emp emp) {
        empService.add(emp);
        return Result.success();
    }

    /**
     * 修改员工（包含工作经历）
     * PUT /emps
     */
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        empService.update(emp);
        return Result.success();
    }

    /**
     * 批量删除员工
     * DELETE /emps?ids=1,2,3
     */
    @DeleteMapping
    public Result delete(@RequestParam String ids) {
        // 将字符串ID列表转换为Integer列表
        List<Integer> idList = Arrays.stream(ids.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        
        empService.deleteByIds(idList);
        return Result.success();
    }
}

