package com.javen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javen.service.AccountService;

@Controller
@RequestMapping("/Account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
   
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public void updAccount(){
		accountService.transfer("aaa", "bbb", 200d);
	}
}
