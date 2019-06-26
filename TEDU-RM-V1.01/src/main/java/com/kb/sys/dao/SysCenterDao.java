package com.kb.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.kb.sys.entity.SysCenter;
@Mapper
public interface SysCenterDao {

	//添加中心
	int insertObject(SysCenter sysCenter);
	
	//根据id删除中心
	int deleteObjects(@Param("ids")Integer... ids);
	
	//分页查询所有中心
	List<SysCenter> findPageObjects(
			@Param("centername")String centerName,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	
	//根据id修改中心
	int updateObject(SysCenter sysCenter);
	
	int getRowCount(@Param("centername")String centername);
	@Select("select * from sys_center where id=#{id}")
	SysCenter findObjectById(Integer id);
	/** 根据id查询地址信息 */
	List<String> findAllAddr(Integer id);
}
