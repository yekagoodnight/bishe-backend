package com.easy.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class GeneratedCaptcha {

	 @GetMapping("/getCodeImg")
	    public void getCodeImage(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) throws IOException, InterruptedException {
	        BufferedImage image=new BufferedImage(80, 32, BufferedImage.TYPE_3BYTE_BGR);
	        //编辑图像
	        //获取绘图对象
	        Graphics g=image.getGraphics();
	        g.setColor(new Color(239, 239, 239));
	        g.fillRect(0,0,80,32);
	        //设置字体颜色
	        g.setColor(new Color(49, 49, 49));
	        //设置字体
	        g.setFont(new Font("SimSong",Font.ITALIC,20));
	        //绘制字符串；
	        String text="";
	        for(int i=0;i<4;i++) {
	            text +=(int) (Math.random()*10);
	        }
	        //字符串输出内容，水平起始坐标，垂直起始坐标。
	        g.drawString(text, 17, 24);
	        //画线条
	        for (int i = 0; i < 10; i++) {
	            g.setColor(new Color((int) (Math.random()*255), (int) (Math.random()*255), (int) (Math.random()*255)));
	            g.drawLine((int) (Math.random()*50),(int) (Math.random()*30),(int) (Math.random()*80),(int) (Math.random()*80));
	        }
	        //设置session
	        httpSession.setAttribute("code",text);
	        //输出图像
	        //ImageIO.write(image, "png", new FileOutputStream("C:/Users/H/Desktop/"+tet+".png"));
	        ImageIO.write(image, "png",response.getOutputStream());
	        g.dispose();
	    }

		//获取保存在session中的验证码
	    @GetMapping("/getCode")
	    public String getCode(HttpSession httpSession){
	        return (String) httpSession.getAttribute("code");
	    }
}
