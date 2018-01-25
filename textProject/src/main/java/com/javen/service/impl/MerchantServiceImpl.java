package com.javen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javen.dao.MerchantDao;
import com.javen.entity.Merchant;
import com.javen.service.MerchantService;

@Service(value = "merchantService")
public class MerchantServiceImpl implements MerchantService{
    
	@Autowired()
	private MerchantDao merchantDao;
	
	public void setMerchantDao(MerchantDao merchantDao) {
		this.merchantDao = merchantDao;
	}

	@Override
	public List<Merchant> getMerchant() {
		// TODO Auto-generated method stub
		return merchantDao.getMerchant();
	}


}
