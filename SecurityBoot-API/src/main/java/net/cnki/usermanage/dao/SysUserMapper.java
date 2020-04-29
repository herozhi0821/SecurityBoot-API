package net.cnki.usermanage.dao;

import java.util.List;

import net.cnki.usermanage.bean.SysUser;

public interface SysUserMapper {
	SysUser selectByPrimaryKey(Integer userId);
	SysUser selectByUserName(String userName);
	List<SysUser> selectSysUserByUnameOrCompany(String username,String company);
}