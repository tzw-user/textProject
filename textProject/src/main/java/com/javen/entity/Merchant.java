package com.javen.entity;

import java.io.Serializable;


/**
 * @author XiaoGui
 * @Description 商户表(对应数据库的dd_merchant数据表)
 * @date  2018年1月8日16:14:17
 * @version V1.0
 */
public class Merchant  implements Serializable{

	/**
	 * 版本号,随机生成
	 */
	private static final long serialVersionUID = -1242179625865985166L;
	/**
	 * id
	 */
	private int id;
	/**
	 * 商户名称（最大30个字符）
	 */
	private String name;
	/**
	 * 商户地址（最大100个字符）
	 */
	private String address;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
	
	
    
}
