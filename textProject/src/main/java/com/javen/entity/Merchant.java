package com.javen.entity;

import java.io.Serializable;


/**
 * @author XiaoGui
 * @Description 车辆表(对应数据库的t_car数据表)
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
	 * 车牌号码（最大30个字符）
	 */
	private String carNo;
	/**
	 * 车主（最大100个字符）
	 */
	private String ownerName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
}
