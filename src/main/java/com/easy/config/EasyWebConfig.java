package com.easy.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.easy.interceptor.LoginInterceptor;

//设置静态路径
@Configuration
public class EasyWebConfig implements WebMvcConfigurer{

	public static final String STATIC_PATH="/img/";
	public static final String STATIC_DIR="D:\\uploadfile\\";
	
	@Autowired
	LoginInterceptor loginInt;
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//添加路径，，地址
		registry.addResourceHandler(STATIC_PATH+"**").addResourceLocations("file:"+STATIC_DIR);
	}
	/*
	 * 配置拦截器  让拦截器生效
	 */
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器 声明哪些地址要拦截
        //所有请求都要经历验证
        registry.addInterceptor(loginInt).addPathPatterns("/course/**","/employee/**"
        		,"/equip/**","/equipstate/**","/maintenance/**","/member/**","/history/**","/trainer/**")
        .excludePathPatterns("/getCodeImg","/getCode","/user/**","/equip/equipfile");
    }
	
}
