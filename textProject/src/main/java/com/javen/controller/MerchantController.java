package com.javen.controller;

import java.util.List;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    
	@RequestMapping(value="/getMerchant",method=RequestMethod.GET)
	@ResponseBody
	public String getMerchant(String callback){
		List<Merchant> list = merchantService.getMerchant();
		//jackson转换
		ObjectMapper mapper = new ObjectMapper();
		//忽略 在json字符串中存在，但是在java对象中不存在对应属性的情况。防止错误
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,false);
		String result = null;
		try {
			//将list转为字符串
			result = mapper.writeValueAsString(list);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	    //加上返回参数
	    result=callback+"("+result+")";
		return result;
	}
	
	@RequestMapping(value="/getMerchants",method=RequestMethod.GET)
	@ResponseBody
	public List<Merchant> getMerchants(){
		List<Merchant> list = merchantService.getMerchant();

		return list;
	}
	
	@RequestMapping(value="/getMerchants1",method=RequestMethod.GET)
	@ResponseBody
	public String  getMerchants1(){
        String result="呵呵";
		return result;
	}
}
