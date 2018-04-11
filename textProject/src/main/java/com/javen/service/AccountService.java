package com.javen.service;
/**
 * 转账案例实现
 * @author 谭志为
 *
 */
public interface AccountService {
	
	public void transfer(String out,String in,Double money);
}
