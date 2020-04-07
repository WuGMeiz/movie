package com.dlszy.dao;

import com.dlszy.entity.Role;

public interface RoleDao {
  public abstract Role findByRid(int rid);
}
