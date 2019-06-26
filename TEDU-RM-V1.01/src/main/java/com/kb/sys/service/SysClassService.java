package com.kb.sys.service;

import com.kb.sys.entity.SysClass;
import com.kb.sys.util.PageObject;

public interface SysClassService {
	PageObject<SysClass> findPageObjects(
			 String claname,	
			 Integer pageCurrent);

	int insertObjects(SysClass entity);
	int deleteObject (int id);
	
}
