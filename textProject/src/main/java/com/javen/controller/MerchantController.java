package com.javen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javen.entity.Merchant;
import com.javen.service.MerchantService;

@Controller
@RequestMapping("/Merchant")
public class MerchantController {
	@Autowired
	private MerchantService merchantService;
	
	public void setMerchantService(MerchantService merchantService) {
		this.merchantService = merchantService;
	}
    
	@RequestMapping("/getMerchant")
	@ResponseBody
	public List<Merchant> getMerchant(){
		List<Merchant> list = merchantService.getMerchant();
		return list;
	}
}
