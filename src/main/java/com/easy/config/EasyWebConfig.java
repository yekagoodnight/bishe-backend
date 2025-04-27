package com.easy.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.easy.interceptor.LoginInterceptor;

//���þ�̬·��
@Configuration
public class EasyWebConfig implements WebMvcConfigurer{

	public static final String STATIC_PATH="/img/";
	public static final String STATIC_DIR="D:\\uploadfile\\";
	
	@Autowired
	LoginInterceptor loginInt;
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//���·��������ַ
		registry.addResourceHandler(STATIC_PATH+"**").addResourceLocations("file:"+STATIC_DIR);
	}
	/*
	 * ����������  ����������Ч
	 */
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        //��������� ������Щ��ַҪ����
        //��������Ҫ������֤
        registry.addInterceptor(loginInt).addPathPatterns("/course/**","/employee/**"
        		,"/equip/**","/equipstate/**","/maintenance/**","/member/**","/history/**","/trainer/**")
        .excludePathPatterns("/getCodeImg","/getCode","/user/**","/equip/equipfile");
    }
	
}
