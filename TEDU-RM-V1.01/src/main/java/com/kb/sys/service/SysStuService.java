package com.kb.sys.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kb.sys.entity.SysStu;
import com.kb.sys.util.PageObject;


public interface SysStuService {
	
	List<SysStu> findObjects();//查寻学生信息
	
	PageObject<SysStu> findPageObjects(
			String sname,
		Integer pageCurrent);
	
	
	int insertObject(SysStu entity);//添加学生信息

	int updateObject(SysStu entity);//修改学生信息
	
	int deleteObject(Integer id);
	
	int deleteObjects(Integer...ids);//删除学生信息
	
	int getRowCount(@Param("sname")String sname);
	
	SysStu findObjectById(Integer id);

}
