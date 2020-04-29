package net.cnki.usermanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.cnki.usermanage.bean.SysUser;
import net.cnki.usermanage.dao.SysUserMapper;
import net.cnki.usermanage.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Override
	public SysUser selectByPrimaryKey(Integer userId) {
		// TODO Auto-generated method stub
		SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
		return sysUser;
	}
	
	@Override
	public SysUser selectByUserName(String userName) {
		// TODO Auto-generated method stub
		SysUser sysUser = sysUserMapper.selectByUserName(userName);
		return sysUser;
	}
	
	@Override
	public List<SysUser> selectSysUserByUnameOrCompany(String username,String company) {
		// TODO Auto-generated method stub
		List<SysUser> listUser = sysUserMapper.selectSysUserByUnameOrCompany(username, company);
		return listUser;
	}
	
}
