package com.easy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easy.mapper.RegMapper;
import com.easy.mapper.UserRoleMapper;
import com.easy.model.Reg;
import com.easy.model.UserRole;
import com.easy.service.RegService;

@Service
public class RegServiceImpl implements RegService {

    @Autowired
    private RegMapper regMapper;
    
    @Autowired
    private UserRoleMapper userRoleMapper;
    /**
     * 注册
     */
	@Override
	public void addReg(Reg reg) throws Exception {
		regMapper.insertReg(reg);
	}

	/**
     * 注册新用户
     */
	@Override
	public void addUsers(Reg reg) {
		regMapper.addUsers(reg);
		UserRole userRole = new UserRole();
		userRole.setRoleId(9L);
		userRole.setUserId(reg.getId());
		userRoleMapper.insert(userRole);
		// regMapper.addMembers(reg.getLoginname(),reg.getPassword());
	}

	/**
	 * 判断是否有此用户名
	 */
	@Override
	public int checkLoginName(String loginname) throws Exception{
		return regMapper.loginName(loginname);
	}

	/**
	 * 判断是否有此昵称
	 */
	@Override
	public int checkName(String checkname) throws Exception {
		return regMapper.checkName(checkname);
	}
	
	/**
	 * 为注册用户添加权限
	 */
	public int insert(UserRole userRole) throws Exception{
		return userRoleMapper.insert(userRole);
	}

}
