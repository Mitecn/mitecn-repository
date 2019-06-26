package com.kb.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.kb.sys.entity.SysRole;

@Mapper
public interface SysRoleDao {

	/** 查询角色名 */
	@Select("select * from sys_role")
	List<SysRole> findObject();

	SysRole findObjectById(Integer roleId);

	/**
	 * 分页查询角色信息
	 * 
	 * @param 通过tname查询
	 * @param startIndex 上一页的结束位置
	 * @param pageSize   每页要查询的记录数
	 * @return
	 */
	List<SysRole> findPageObjects(@Param("role") String role, @Param("startIndex") Integer startIndex,
			@Param("pageSize") Integer pageSize);

	/**
	 * 查询记录总数
	 * 
	 * @return
	 */
	int getRowCount(@Param("role") String role);

	int saveObject(SysRole entity);

	int deleteObject(Integer id);

}
