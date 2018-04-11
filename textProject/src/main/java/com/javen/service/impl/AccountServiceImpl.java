package com.javen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javen.dao.AccountDao;
import com.javen.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
    
	@Autowired
	private AccountDao accountDao;
	

    /**
     * @param out   转出帐号
     * @param in    转入帐号
     * @param money 转账金额
     */
	public void transfer(String out, String in, Double money) {
		//转账
		accountDao.outMoney(out, money);
		//转入
		accountDao.inMoney(in, money);
		
	}

}
