package com.javen.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shiro")
public class LoginShiroController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		
		//获取subject类
		Subject currentUser = SecurityUtils.getSubject();
		
		//调用currentUser.isAuthenticated()方法验证是否登录
		if (!currentUser.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			token.setRememberMe(true);
			try {
				System.out.println(token.hashCode());
				//执行登录
				currentUser.login(token);
			} catch (AuthenticationException ae) {
				// unexpected condition? error?
				System.out.println("登录失败！！！！"+ae.getMessage());
			}
		}
		return "index";
	}
}
