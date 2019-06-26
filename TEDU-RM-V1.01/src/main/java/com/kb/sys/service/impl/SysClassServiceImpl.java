package com.kb.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import com.kb.sys.dao.SysClassDao;
import com.kb.sys.entity.SysClass;
import com.kb.sys.exception.ServiceException;
import com.kb.sys.service.SysClassService;
import com.kb.sys.util.PageObject;
@Service
public class SysClassServiceImpl implements SysClassService {
	@Autowired
	private SysClassDao sysClassDao;

	@Override
	public PageObject<SysClass> findPageObjects(String claname, Integer pageCurrent) {
		//1.验证参数合法性
		  //1.1验证pageCurrent的合法性，
		  //不合法抛出IllegalArgumentException异常
		  if(pageCurrent==null||pageCurrent<1)
		  throw new IllegalArgumentException("当前页码不正确");
		  //2.基于条件查询总记录数
		  //2.1) 执行查询
		  int rowCount=sysClassDao.getRowCount(claname);
		  //2.2) 验证查询结果，假如结果为0不再执行如下操作
		  if(rowCount==0)
        throw new ServiceException("系统没有查到对应记录");
		  //3.基于条件查询当前页记录(pageSize定义为2)
		  //3.1)定义pageSize
		  int pageSize=10;
		  //3.2)计算startIndex
		  int startIndex=(pageCurrent-1)*pageSize;
		  //3.3)执行当前数据的查询操作
		  List<SysClass> records=
		  sysClassDao.findPageObjects(claname, startIndex, pageSize);
		  //4.对分页信息以及当前页记录进行封装
		  //4.1)构建PageObject对象
		  PageObject<SysClass> pageObject=new PageObject<>();
		  //4.2)封装数据
		  pageObject.setPageCurrent(pageCurrent);
		  pageObject.setPageSize(pageSize);
		  pageObject.setRowCount(rowCount);
		  pageObject.setRecords(records);
        pageObject.setPageCount((rowCount-1)/pageSize+1);
		  //5.返回封装结果。
		  return pageObject;
	  }

	@Override
	public int insertObjects(SysClass entity) {
		    	//1.合法性验证
		    	if(entity==null)
		    throw new ServiceException("保存数据不能为空");
		    	if(StringUtils.isEmpty(entity.getClaname()))
		    	throw new ServiceException("角色名不能为空");
		 //  	if(menuIds==null||menuIds.length==0)
		  //  	throw new ServiceException("必须为角色赋予权限");
		    	//2.保存数据
		    	int rows=sysClassDao.insertObjects(entity);
		   // sysClassDao.insertObjects(
		    //		entity.getId());
		   //3.返回结果
		    	return rows;
		 }

	@Override
	public int deleteObject(int id) {
				//1.验证参数的合法性
			//	if(id==null||id<1)
			//	throw new ServiceException("id的值不正确,id="+id);
				//2.执行dao操作
				int rows=sysClassDao.deleteObject(id);
				if(rows==0)
				throw new ServiceException("数据可能已经不存在");
	     //  sysRoleMenuDao.deleteObjectsByRoleId(id);
		//sysUserRoleDao.deleteObjectsByRoleId(id);
				//3.返回结果
				return rows;
		}

	



	}
	
	
	
	


