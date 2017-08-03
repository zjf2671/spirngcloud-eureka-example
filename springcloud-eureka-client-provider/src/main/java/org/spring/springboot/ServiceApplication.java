package org.spring.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description: 服务端 
 * @author harry.zhang
 * @CreateDate:	2017年8月3日
 * @version 1.0
 */
@SpringBootApplication
// mapper 接口类扫描包配置
@MapperScan("org.spring.springboot.dao")
@EnableDiscoveryClient
public class ServiceApplication {

    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        //SpringApplication.run(Application.class,args);
        new SpringApplicationBuilder(ServiceApplication.class).web(true).run(args);
    }
}
