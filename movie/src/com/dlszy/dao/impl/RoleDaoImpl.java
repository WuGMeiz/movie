package com.dlszy.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.dlszy.dao.RoleDao;
import com.dlszy.entity.Role;
@Repository
public class RoleDaoImpl implements RoleDao{
	@Autowired
    private SqlSessionFactory sqlSessionFactory;
	public Role findByRid(int rid) {
		SqlSession sqlSession= sqlSessionFactory.openSession();
		Role role=sqlSession.selectOne("Role.findByRid", rid);
		return role;
	}

}
