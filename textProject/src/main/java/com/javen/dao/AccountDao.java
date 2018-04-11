package com.javen.dao;

import org.apache.ibatis.annotations.Param;

/**
 * 转账案例 DAO层接口
 * @author 谭志为
 *
 */
public interface AccountDao {
   /**
    * 
    * @param out   转出帐号
    * @param money 转账 金额
    */
   public void outMoney(@Param("out") String out,@Param("money") Double money);
   
   /**
    * 
    * @param in 转入帐号
    * @param money 转入金额
    */
   public void inMoney(@Param("in")String in,@Param("money") Double money);
   
}
