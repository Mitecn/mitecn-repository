package com.kb.sys.service;


import org.apache.ibatis.annotations.Param;

import com.kb.sys.entity.SysDept;
import com.kb.sys.util.PageObject;


public interface SysDeptService {
		
	PageObject<SysDept> findPageObjects(
			@Param("dept")String dept,
		@Param("pageCurrent")Integer pageCurrent);
	
	int insertObject(SysDept entity);//添加学生信息

	int updateObject(SysDept entity);//修改学生信息
	
	int deleteObject(Integer id);
	
	int getRowCount(@Param("dept")String dept);
	
	SysDept findObjectById(Integer id);

}
