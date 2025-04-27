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
		//�ڴ���handler֮ǰִ��
		//����true  ����ִ�ж�Ӧhandler 
		//return true/false��springmvc�е�����·������  ���ǻ�Ӧ���������
		// �ڴ���handler֮ǰִ��  ����true ����falseִ�в���handler
		//token���ģ�  ��header��  ����Authorization
		String token=request.getHeader("Authorization");
		if(token!=null && JWTUtil.verifyToken(token)) {
			//token token��Ч ��¼
			return true;
		}else {
			CommonResult result=CommonResult.fail(400,"δ��¼");
			//�����ݽ�����JSON
			String json=JSON.toJSONString(result);
			//��Ӧ����
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
