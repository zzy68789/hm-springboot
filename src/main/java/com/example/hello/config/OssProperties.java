package com.example.hello.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 对象存储配置属性类
 */
@Data
@Component
@ConfigurationProperties(prefix = "oss")
public class OssProperties {
    /**
     * Access Key
     */
    private String accessKey;
    
    /**
     * Secret Key
     */
    private String secretKey;
    
    /**
     * 内网端点
     */
    private String endpointInternal;
    
    /**
     * 外网端点
     */
    private String endpointExternal;
    
    /**
     * 存储桶名称
     */
    private String bucketName;
    
    /**
     * 区域
     */
    private String region;
}

