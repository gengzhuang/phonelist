package com.easy.service;

import com.easy.model.Reg;
import com.easy.model.UserRole;

/**
 * 
 * @author Administrator
 *
 */
public interface RegService {

	/**
	 * 注册
	 * @param id 
	 */
	void addReg(Reg reg) throws Exception;

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
	 * @throws Exception
	 */
	int checkLoginName(String loginname) throws Exception;

	/**
	 * 查询用户名
	 * @param checkname
	 * @return
	 * @throws Exception
	 */
	int checkName(String checkname) throws Exception;
	
	/**
	 * 为新用户设置权限
	 */
	int insert(UserRole userRole) throws Exception;

	
}
