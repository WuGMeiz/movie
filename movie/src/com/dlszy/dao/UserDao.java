package com.dlszy.dao;

import java.util.List;
import com.dlszy.entity.Page;
import com.dlszy.entity.User;

public interface UserDao {
  public abstract User findByNameAndPsw(String uname,String upsw);
  public abstract List<User> findAll();
	public abstract Page<User> findByPage(int currentPage, int pageSize, String condition);
	public abstract User findById(int id);
	public abstract void doDelUser(int id);
	public abstract void doAddUser(User user);
	public abstract void doUpdateUser(User user);
}
