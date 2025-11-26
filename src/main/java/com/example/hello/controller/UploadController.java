package com.example.hello.controller;

import com.example.hello.entity.Result;
import com.example.hello.utils.OssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传控制器
 */
@RestController
public class UploadController {

    @Autowired
    private OssUtil ossUtil;

    /**
     * 文件上传接口
     * POST /upload
     *
     * @param file 上传的文件
     * @return 文件的访问URL
     */
    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file) {
        try {
            // 验证文件是否为空
            if (file == null || file.isEmpty()) {
                return Result.error("文件不能为空");
            }

            // 上传文件到对象存储
            String fileUrl = ossUtil.upload(file);

            // 返回文件访问URL
            return Result.success(fileUrl);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("文件上传失败: " + e.getMessage());
        }
    }
}

