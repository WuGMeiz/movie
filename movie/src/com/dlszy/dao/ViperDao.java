package com.dlszy.dao;

import com.dlszy.entity.Page;
import com.dlszy.entity.Viper;

public interface ViperDao {
	public abstract Page<Viper> findAllVip(int currentPage, int pageSize, String condition);
	public abstract boolean addViper(Viper vip);
	public abstract boolean delViper(String vid);
	public abstract boolean updateViper(Viper vip);
	public abstract Viper findByVid(int vid);
}
