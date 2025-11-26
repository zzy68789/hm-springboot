package com.example.hello.utils;

import com.example.hello.config.OssProperties;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * 对象存储工具类
 */
@Component
public class OssUtil {

    @Autowired
    private MinioClient minioClient;

    @Autowired
    private OssProperties ossProperties;

    /**
     * 上传文件到对象存储
     *
     * @param file 要上传的文件
     * @return 文件的访问URL
     */
    public String upload(MultipartFile file) throws Exception {
        // 获取原始文件名
        String originalFilename = file.getOriginalFilename();
        
        // 生成唯一的文件名：时间戳 + UUID + 原始文件扩展名
        String fileName = generateFileName(originalFilename);
        
        // 构建对象存储的文件路径（可以按日期分目录）
        String objectKey = buildObjectKey(fileName);
        
        // 上传文件到 MinIO
        minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket(ossProperties.getBucketName())
                        .object(objectKey)
                        .stream(file.getInputStream(), file.getSize(), -1)
                        .contentType(file.getContentType())
                        .build()
        );
        
        // 返回文件的访问URL
        return buildFileUrl(objectKey);
    }

    /**
     * 生成唯一的文件名
     */
    private String generateFileName(String originalFilename) {
        // 获取文件扩展名
        String extension = "";
        if (originalFilename != null && originalFilename.contains(".")) {
            extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        }
        
        // 生成唯一文件名：UUID + 扩展名
        return UUID.randomUUID().toString().replace("-", "") + extension;
    }

    /**
     * 构建对象存储的文件路径（按日期分目录）
     */
    private String buildObjectKey(String fileName) {
        // 按日期分目录：2025/11/26/文件名
        String datePath = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        return datePath + "/" + fileName;
    }

    /**
     * 构建文件的访问URL
     */
    private String buildFileUrl(String objectKey) {
        // 返回外网访问地址
        return String.format("https://%s/%s/%s",
                ossProperties.getEndpointExternal(),
                ossProperties.getBucketName(),
                objectKey);
    }
}
