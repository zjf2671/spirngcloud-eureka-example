package org.spring.springboot.configure;

import org.spring.springboot.Interceptor.TestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Description: 拦截路径配置项目 
 * @author harry.zhang
 * @CreateDate:	2017年8月4日
 * @version 1.0
 */
@Configuration   //标注此文件为一个配置项，spring boot才会扫描到该配置。该注解类似于之前使用xml进行配置
public class CustomWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestInterceptor()).addPathPatterns("/city/**");  //对来自/user/** 这个链接来的请求进行拦截
    }

}
