package com.JavaMan.mapper;

import org.apache.ibatis.annotations.Param;

import com.JavaMan.pojo.Account;

public interface AccountMapper {
	/**
	 * 通过账号和密码选择账号
	 * mybatis将参数转为map，其中Param("key")value
	 * @return
	 */
	Account selByAccnoPwd(@Param("accno")String accno,@Param("password")String password);
	
	/**
	 * 通过账号和名字选择账号
	 * @return
	 */
	Account selByAccnoName(@Param("accno")String accno,@Param("name")String name);
	
	/**
	 * 通过账号更新金钱
	 * @return
	 */
	int updBalanceByAccno(@Param("balance")double balance,@Param("accno")String accno);
}
