package com.javen.dao;

import java.util.List;

import com.javen.entity.Merchant;

/**
 * MerchantDao
 * @author Administrator
 *
 */
public interface MerchantDao {
	/**
	 * 获取Merchant全部数据
	 * @return
	 */
	public List<Merchant> getMerchant();
}
