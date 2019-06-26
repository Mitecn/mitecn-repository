package com.kb.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kb.sys.dao.SysRoleDao;
import com.kb.sys.entity.SysRole;
import com.kb.sys.exception.ServiceException;
import com.kb.sys.service.SysRoleService;
import com.kb.sys.util.PageObject;
import com.kb.sys.util.PageUtil;


@Service
public class SysRoleServiceImpl implements SysRoleService {
	
	@Autowired
	private SysRoleDao sysRoleDao;
		@Override
		public PageObject<SysRole> findPageObjects(String role, Integer pageCurrent) {
			//1.判定pageCurrent参数合法性
			if(pageCurrent==null||pageCurrent<1) 
				throw new IllegalArgumentException("当前页码值不正确");
			//2.查询日志总记录数,并进行判定
			int rowCount=sysRoleDao.getRowCount(role);
			if(rowCount==0)
				throw new ServiceException("没有找到对应记录");
			//3.查询当前页日志记录
			int pageSize=6;
			int startIndex=(pageCurrent-1)*pageSize;
			List<SysRole> records=
					sysRoleDao.findPageObjects(role,
							startIndex, pageSize);
			//4.对查询结果进行封装并返回
			PageObject<SysRole> po = 
			PageUtil.newPageObject(pageCurrent, rowCount, pageSize, records);
			return po;
	}
		@Override
		public int saveObject(SysRole entity) {
			//1.合法性验证
	    	if(entity==null)
	    throw new ServiceException("保存数据不能为空");
	    	//2.保存数据
	    	int rows=sysRoleDao.saveObject(entity);
	    	//3.返回结果
	    	return rows;
		}
		@Override
		public int deleteObject(Integer id) {
			//1.验证参数的合法性
			if(id==null||id<1)
				throw new ServiceException("id的值不正确,id="+id);
			if(id==0)
				throw new ServiceException("你输入的第值不存在,id="+id);
			//2.执行dao操作
			int rows = sysRoleDao.deleteObject(id);
			return rows;
		}
	
}
