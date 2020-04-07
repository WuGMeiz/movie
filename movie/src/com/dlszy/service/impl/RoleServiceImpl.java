package com.dlszy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlszy.dao.RoleDao;
import com.dlszy.entity.Role;
import com.dlszy.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
    private RoleDao roleDao;
	public Role findByRid(int rid) {
		return roleDao.findByRid(rid);
	}

}
