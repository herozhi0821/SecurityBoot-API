package net.cnki.usermanage.service;

import java.util.List;

import net.cnki.usermanage.bean.SysUser;

public interface SysUserService {
	SysUser selectByPrimaryKey(Integer userId);
	SysUser selectByUserName(String userName);
	List<SysUser> selectSysUserByUnameOrCompany(String username,String company);
}