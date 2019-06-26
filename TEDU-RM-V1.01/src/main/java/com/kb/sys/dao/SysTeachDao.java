package com.kb.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.kb.sys.entity.SysTeach;
import com.kb.sys.vo.SysTeachVo;

@Mapper
public interface SysTeachDao {
	/** 添加教师信息  */
	int insertObject(SysTeach sysTeach);
	/**  分页查询教师信息*/
	List<SysTeach> findObject(@Param("tname")String tname,@Param("startIndex")Integer startIndex,@Param("pageSize")Integer pageSize);
	/** 删除教师信息表 */
	@Delete("delete from sys_teach where id=#{id}")
	int deleteObject(Integer id);
	/** 修改教师信息表*/
	int updateObject(SysTeach sysTeach);
	/** 查询记录条数 */
	int getRowCount(@Param("tname")String tname);
	/** 根据id查询教师信息 */
	@Select("select * from sys_teach where id=#{id}")	
	SysTeach findObjectById(Integer id);
	/** 测试关联查询结果*/
	List<SysTeachVo> findVo(@Param("tname")String tname,@Param("startIndex")Integer startIndex,@Param("pageSize")Integer pageSize);
	
	@Select("select password from sys_teach where loginname = #{loginname} ")
	String findObjectByName(@Param("loginname")String loginname);
	

}
