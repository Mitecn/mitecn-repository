package com.kb.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.kb.sys.dao.SysStuDao;
import com.kb.sys.entity.SysStu;
import com.kb.sys.exception.ServiceException;
import com.kb.sys.service.SysStuService;
import com.kb.sys.util.PageObject;
import com.kb.sys.util.PageUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SysStuServiceImpl implements SysStuService {
	@Autowired
	private SysStuDao sysStuDao;
	
	@Override
	public List<SysStu> findObjects() {
		List<SysStu> obj = sysStuDao.findObjects();
		return obj;
	}

	
	@Override
	public int updateObject(SysStu entity) {
		if(entity==null)
			throw new IllegalArgumentException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getSname()))
			throw new IllegalArgumentException("角色名不能为空");
		//2.保存数据
				//2.1保存角色自身信息
				int rows=sysStuDao.updateObject(entity);
				//2.2保存角色菜单关系数据
		/*
		 * sysStuDao.deleteObject(entity.getId()); sysStuDao.insertObject(entity);
		 */
				//3.返回结果
				return rows;
	}






	@Override
	public int insertObject(SysStu entity) {
		// TODO Auto-generated method stub
		return sysStuDao.insertObject(entity);
	}


	@Override
	public int deleteObjects(Integer...ids) {
		//1.参数校验(参数校验)
				//2.执行删除
				int rows=sysStuDao.deleteObject(ids);
				if(rows>0) {
				log.info("delete ok,rows="+rows);
				}
				//3.验证并返回结果
				return rows;
	}


	@Override
	public PageObject<SysStu> findPageObjects(String sname, Integer pageCurrent) {
		//1.参数校验
		if(pageCurrent==null||pageCurrent<1)
		throw new IllegalArgumentException("页码不正确");
		//2.查询总记录数并进行校验
		int rowCount=sysStuDao.getRowCount(sname);
		if(rowCount==0)
		throw new ServiceException("记录不存在");
		//3.查询当前页要呈现的记录
		//3.1页面大小,例如每页最多显示3条
		int pageSize=3;
		//3.2当前页起始位置
		int startIndex=PageUtil.getStartIndex(pageCurrent, pageSize);
		List<SysStu> records=
		sysStuDao.findPageObjects(sname,
				startIndex,pageSize);
		//4.对查询结果进行计算和封装并返回
		return PageUtil.newPageObject(
	    pageCurrent, rowCount, pageSize, records);
	}


	@Override
	public int getRowCount(String sname) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int deleteObject(Integer id) {
		int rows = sysStuDao.deleteObject(id);
		return rows;
	}


	@Override
	public SysStu findObjectById(Integer id) {
		//1.参数校验
		
		  if(id==null||id<1) 
			  throw new IllegalArgumentException("id值无效");
		 
				//2.查询角色以及菜单
				SysStu rm=sysStuDao.findObjectById(id);
				//3.返回结果
				if(rm==null)
				throw new ServiceException("没有找到对应结果");
				return rm;
	}


	

	

}
