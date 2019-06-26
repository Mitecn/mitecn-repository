package com.kb.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.kb.sys.dao.SysDeptDao;
import com.kb.sys.entity.SysDept;
import com.kb.sys.exception.ServiceException;
import com.kb.sys.service.SysDeptService;
import com.kb.sys.util.PageObject;
import com.kb.sys.util.PageUtil;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class SysDeptServiceImpl  implements SysDeptService{
	@Autowired
	private SysDeptDao sysDeptDao;
	
	@Override
	public PageObject<SysDept> findPageObjects(String dept, Integer pageCurrent) {
		//1.参数校验
				if(pageCurrent==null||pageCurrent<1)
				throw new IllegalArgumentException("页码不正确");
				//2.查询总记录数并进行校验
				int rowCount=sysDeptDao.getRowCount(dept);
				if(rowCount==0)
				throw new ServiceException("记录不存在");
				//3.查询当前页要呈现的记录
				//3.1页面大小,例如每页最多显示3条
				int pageSize=3;
				//3.2当前页起始位置
				int startIndex=PageUtil.getStartIndex(pageCurrent, pageSize);
				List<SysDept> records=
				sysDeptDao.findPageObjects(dept, startIndex, pageSize);
				//4.对查询结果进行计算和封装并返回
				return PageUtil.newPageObject(
			    pageCurrent, rowCount, pageSize, records);
	}

	@Override
	public int insertObject(SysDept entity) {
		// TODO Auto-generated method stub
		int rows = sysDeptDao.insertObject(entity); 
		return rows;
	}

	@Override
	public int updateObject(SysDept entity) {
		if(entity==null)
			throw new IllegalArgumentException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getDept()))
			throw new IllegalArgumentException("角色名不能为空");
		//2.保存数据
				//2.1保存角色自身信息
				int rows=sysDeptDao.updateObject(entity);
				//2.2保存角色菜单关系数据
		/*
		 * sysStuDao.deleteObject(entity.getId()); sysStuDao.insertObject(entity);
		 */
				//3.返回结果
				return rows;	}

	@Override
	public int deleteObject(Integer id) {
		//1.参数校验(参数校验)
		//2.执行删除
		int rows=sysDeptDao.deleteObject(id);
		if(rows>0) {
		log.info("delete ok,rows="+rows);
		}
		//3.验证并返回结果
		return rows;
	}

	@Override
	public int getRowCount(String dept) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SysDept findObjectById(Integer id) {
		//1.参数校验
		
		  if(id==null||id<1) 
			  throw new IllegalArgumentException("id值无效");
				//2.查询角色以及菜单
				SysDept rm=sysDeptDao.findObjectById(id);
				//3.返回结果
				if(rm==null)
				throw new ServiceException("没有找到对应结果");
				return rm;
	}

}
