package com.dlszy.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dlszy.dao.UserDao;
import com.dlszy.entity.Movie;
import com.dlszy.entity.Page;
import com.dlszy.entity.User;
@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	public User findByNameAndPsw(String uname, String upsw) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		String[] arr={uname,upsw};
		User user=sqlSession.selectOne("User.findUnameAndUpsw", arr);
		return user;
	}
	public List<User> findAll() {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		 List<User> users=sqlSession.selectList("User.findAll");
		return users;
	}
	public void doDelUser(int id) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		sqlSession.delete("User.doDel",id);
		sqlSession.commit();
	}
	public void doAddUser(User user) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		sqlSession.insert("User.doAdd",user);
		sqlSession.commit();
	}
	public void doUpdateUser(User user) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		sqlSession.update("User.doUpdate",user);
		sqlSession.commit();
		
	}
	public User findById(int id) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		User user=sqlSession.selectOne("User.findbyid",id);
		return user;
	}
	public Page<User> findByPage(int currentPage, int pageSize,
			String condition) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		Page<User> page=null;
		List<User> users=new ArrayList<User>();
		int totalNum=sqlSession.selectOne("User.count",condition.trim());
		int beginIndex=(currentPage-1)*pageSize;
		int totalPage=(totalNum % pageSize==0)?totalNum/pageSize:totalNum/pageSize+1;
		Object[] arr={beginIndex,pageSize,condition};
		users=sqlSession.selectList("User.findUserListByPage", arr);
		page=new Page<User>(totalNum,pageSize,totalPage,currentPage,users);
		return page;
	}
}
