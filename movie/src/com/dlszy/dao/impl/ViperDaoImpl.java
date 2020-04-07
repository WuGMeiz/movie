package com.dlszy.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dlszy.dao.ViperDao;
import com.dlszy.entity.Page;
import com.dlszy.entity.Viper;

@Repository
public class ViperDaoImpl implements ViperDao {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public Page<Viper> findAllVip(int currentPage, int pageSize, String condition) {
		Page<Viper> page = new Page<Viper>();
		List<Viper> vips = new ArrayList<Viper>();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		page.setPageSize(pageSize);
		page.setCurrentPage(currentPage);
		int i = sqlSession.selectOne("Viper.findcount",condition.trim());
		page.setTotalNum(i);
		if(page.getTotalNum()%page.getPageSize()==0){
			page.setTotalPage(page.getTotalNum()/page.getPageSize());
		}else{
			page.setTotalPage(page.getTotalNum()/page.getPageSize()+1);
		}
		int begin = (currentPage-1)*pageSize;
		Object[] objs = {begin,pageSize,condition};
		vips = sqlSession.selectList("Viper.findAllVip",objs);
		page.setContent(vips);
		return page;
	}

	
	public boolean addViper(Viper vip) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("Viper.addViper",vip);
		return true;
	}

	
	public boolean delViper(String vid) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("Viper.delViper",vid);
		return true;
	}


	public boolean updateViper(Viper vip) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("Viper.updateViper",vip);
		return true;
	}


	public Viper findByVid(int vid) {
		Viper vip = new Viper();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		vip = sqlSession.selectOne("Viper.findByVid",vid);
		return vip;
	}
	
}
