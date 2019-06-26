package com.kb.sys.service;

import org.springframework.stereotype.Service;

import com.kb.sys.entity.SysRole;
import com.kb.sys.util.PageObject;


@Service
public interface SysRoleService {

	 /**
     * 本方法中要分页查询角色信息,并查询角色总记录数据
     * @param pageCurrent 当表要查询的当前页的页码值
     * @return 封装当前实体数据以及分页信息
     */
	PageObject<SysRole> findPageObjects(
			 String role,Integer pageCurrent);
	
	int saveObject(SysRole entity);
	
	int deleteObject(Integer id);
}
