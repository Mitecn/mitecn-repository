package com.kb.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kb.sys.entity.SysStu;

@Mapper
public interface SysStuDao {
	List<SysStu> findPageObjects(@Param("sname") String sname, @Param("startIndex") Integer startIndex,
			@Param("pageSize") Integer pageSize);

	// 查询所有学生
	List<SysStu> findObjects();

	// 根据id删除信息
	int deleteObject(@Param("ids") Integer... ids);

	int deleteObject(Integer id);

	// 增加学生信息
	int insertObject(SysStu entity);

	// 修改学生信息
	int updateObject(SysStu entity);

	int getRowCount(@Param("sname") String sname);

	SysStu findObjectById(Integer id);

}
