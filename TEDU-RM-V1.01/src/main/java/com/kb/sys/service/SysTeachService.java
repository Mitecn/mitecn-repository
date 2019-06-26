package com.kb.sys.service;

import com.kb.sys.entity.SysTeach;
import com.kb.sys.util.PageObject;
import com.kb.sys.util.PageUtil;
import com.kb.sys.vo.SysTeachVo;

public interface SysTeachService {
	/** 分页查询 */
	PageObject<SysTeachVo> FindPageObjects(String tname,Integer pageCurrent);
	/** 删除教师信息 */
	int deleteObject(Integer id);
	/** 添加教师信息 */
	int insertObject(SysTeach st);
	/** 根据id查询教师信息 */
	SysTeach findObjectById(Integer id);
	/** 修改用户信息 */
	int updateObject(SysTeach st);
	/** 登录功能 */
	boolean doTeachLogin(String loginname,String password);
	
	
}
