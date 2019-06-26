package com.kb.sys.service;

import java.util.List;

import com.kb.sys.entity.SysCenter;
import com.kb.sys.util.PageObject;

public interface SysCenterService {
	int saveObject(SysCenter sysCenter);

	PageObject<SysCenter> findPageObjects(String centername, Integer pageCurrent);

	int deleteObjects(Integer... ids);

	int updateObject(SysCenter sysCenter);

	SysCenter findObjectById(Integer id);
	
	List<String> findAllAddr(Integer id );

}
