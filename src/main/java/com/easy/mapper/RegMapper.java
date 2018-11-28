package com.easy.mapper;

import org.apache.ibatis.annotations.Param;

import com.easy.model.Reg;

public interface RegMapper {

	void insertReg(Reg reg);

	/**
     * 注册新用户
     * @param reg
     * @return
     */
	void addUsers(Reg reg);

	/**
	 * 查询昵称
	 * @param loginname
	 * @return
	 */
	int checkName(String checkname);

	/**
	 * 查询用户名
	 * @param checkname
	 * @return
	 */
	int loginName(String loginname);

	void addMembers(@Param(value = "loginname") String loginname, @Param(value = "password")String password);


	
    
}