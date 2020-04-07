package com.dlszy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dlszy.dao.impl.ViperDaoImpl;
import com.dlszy.entity.Page;
import com.dlszy.entity.Viper;
import com.dlszy.service.ViperService;

@Service
public class ViperServiceImpl implements ViperService {
	@Autowired
	private ViperDaoImpl viperDaoImpl;
	public Page<Viper> findAllVip(int currentPage, int pageSize, String condition) {
		Page<Viper> page =new Page<Viper>();
		page = viperDaoImpl.findAllVip(currentPage,pageSize,condition);
		return page;
	}
	public boolean addViper(Viper vip) {
		return viperDaoImpl.addViper(vip);
	}

	public boolean delViper(String vid) {
		return viperDaoImpl.delViper(vid);
	}

	public boolean updateViper(Viper vip) {
		return viperDaoImpl.updateViper(vip);
	}

	public Viper findByVid(int vid) {
		return viperDaoImpl.findByVid(vid);
	}

}
