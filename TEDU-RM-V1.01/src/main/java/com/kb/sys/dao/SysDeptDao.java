package com.kb.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.kb.sys.entity.SysDept;

@Mapper
public interface SysDeptDao {
	/** 查询部门信息 */
	@Select("select * from sys_dept")
	List<SysDept> findObjects();

	/** 根据id查询 */
	SysDept findObjectById(Integer deptId);

	// 查询部门所有信息
	List<SysDept> findPageObjects(@Param("dept") String dept, @Param("startIndex") Integer startIndex,
			@Param("pageSize") Integer pageSize);

	// 删除部门信息
	int deleteObject(Integer id);

	// 添加部门信息
	int insertObject(SysDept entity);

	// 修改部门信息
	int updateObject(SysDept entity);

	// 获取记录总数
	int getRowCount(@Param("dept") String dept);
}
