package com.kb.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.kb.sys.entity.SysKB;

/**
 * 口碑模块数据层
 * @author lincx
 *
 */
@Mapper
public interface SysKBDao {

	/**根据口碑姓名从数据库模糊查询出的行数*/
	int findRows(@Param("name")String name);
	
	/**查询所有口碑数据*/
	@Select("select * from sys_kb")
	List<SysKB> findAll();
	
	/**根据id查询当前选中的口碑记录*/
	@Select("select * from sys_kb where id = #{id}")
	SysKB findSysKB(Integer id);
	
	/**根据id删除当前选中的口碑记录*/
	int deleteSysKB(@Param("ids")Integer... ids);
	
	/**修改口碑记录*/
	int updateSysKB(SysKB sysKB);
	
	/**新增口碑*/
	int insertSysKB(SysKB sysKB);
	
	/**基于条件执行分页查询,获取当前页的数据*/
	List<SysKB> findPageObjects(@Param("name")String name,@Param("startIndex")Integer startIndex,@Param("pageSize")Integer pageSize);
}
