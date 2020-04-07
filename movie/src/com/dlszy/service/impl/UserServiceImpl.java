package com.dlszy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlszy.dao.UserDao;
import com.dlszy.entity.Page;
import com.dlszy.entity.User;
import com.dlszy.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
    private UserDao userDao;
	public User findByNameAndPsw(String uname, String upsw) {
		return userDao.findByNameAndPsw(uname, upsw);
	}
	public List<User> findAll() {
		return userDao.findAll();
	}
	public Page<User> findByPage(int currentPage, int pageSize, String condition) {
		return userDao.findByPage(currentPage, pageSize, condition);
	}
	public User findById(int id) {
		return userDao.findById(id);
	}
	public void doDelUser(int id) {
		userDao.doDelUser(id);
	}
	public void doAddUser(User user) {
		userDao.doAddUser(user);
	}
	public void doUpdateUser(User user) {
		userDao.doUpdateUser(user);
	}
}
