package com.kb.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.kb.sys.entity.SysClass;

@Mapper
public interface SysClassDao {

	/** 查询编辑信息 */
	@Select("select * from sys_class")
	List<SysClass> findObjects();

	/** 根据id查询 */
	SysClass findObjectById(Integer classNo);

	List<SysClass> findPageObjects(@Param("claname") String claname, @Param("startIndex") Integer startIndex,
			@Param("pageSize") Integer pageSize);

	int getRowCount(@Param("claname") String claname);

	int insertObjects(SysClass entity);

	int deleteObject(int id);

}
