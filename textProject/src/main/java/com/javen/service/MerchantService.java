package com.javen.service;

import java.util.List;

import com.javen.entity.Merchant;

public interface MerchantService {
	/**
	 * 获取Merchant全部数据
	 * @return
	 */
	public List<Merchant> getMerchant();
}
