package com.easy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.easy.common.CommonResult;
import com.easy.util.JWTUtil;

@Component
public class LoginInterceptor implements HandlerInterceptor{

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//在处理handler之前执行
		//返回true  可以执行对应handler 
		//return true/false是springmvc中的运行路线需求  不是回应给浏览器的
		// 在处理handler之前执行  返回true 返回false执行不到handler
		//token在哪？  在header中  叫做Authorization
		String token=request.getHeader("Authorization");
		if(token!=null && JWTUtil.verifyToken(token)) {
			//token token有效 登录
			return true;
		}else {
			CommonResult result=CommonResult.fail(400,"未登录");
			//将数据解析成JSON
			String json=JSON.toJSONString(result);
			//回应数据
			response.getWriter().write(json);
			return false;
		}
		
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
