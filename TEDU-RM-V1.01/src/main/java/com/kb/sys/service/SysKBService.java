package com.kb.sys.service;

import java.util.List;

import com.kb.sys.entity.SysKB;
import com.kb.sys.util.PageObject;


/**
 * 口碑模块业务层接口
 * @author lincx
 *
 */
public interface SysKBService {

	/**根据口碑姓名从数据库模糊查询出的行数*/
	int findRows(String name);
	
	/**查询所有口碑数据*/
	List<SysKB> findAll();
	
	/**根据id查询当前选中的口碑记录*/
	SysKB findSysKB(Integer id);
	
	/**根据id删除当前选中的口碑记录*/
	int deleteSysKB(Integer... ids);
	
	/**修改口碑记录*/
	int updateSysKB(SysKB sysKB);
	
	/**新增口碑*/
	int insertSysKB(SysKB sysKB);
	
	/**基于条件执行分页查询,获取当前页的数据*/
	PageObject<SysKB> findPageObjects(String name,Integer pageCurrent);
}
