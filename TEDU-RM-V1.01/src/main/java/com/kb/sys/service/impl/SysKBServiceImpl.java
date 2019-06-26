package com.kb.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kb.sys.dao.SysKBDao;
import com.kb.sys.entity.SysKB;
import com.kb.sys.exception.ServiceException;
import com.kb.sys.service.SysKBService;
import com.kb.sys.util.PageObject;

/**
 * 口碑模块业务层实现类
 * @author lincx
 *
 */
@Service
public class SysKBServiceImpl implements SysKBService{

	/**依赖注入数据层接口*/
	@Autowired
	private SysKBDao dao;
	
	/**根据口碑姓名从数据库模糊查询出的行数*/
	@Override
	public int findRows(String name) {
		return dao.findRows(name);
	}

	/**查询所有口碑数据*/
	@Override
	public List<SysKB> findAll() {
		List<SysKB> list = dao.findAll();
		return list;
	}

	/**根据id查询当前选中的口碑记录*/
	@Override
	public SysKB findSysKB(Integer id) {
		if(id == null) {
			throw new ServiceException("请选中一条记录");
		}
		SysKB findSysKB = dao.findSysKB(id);
		return findSysKB;
	}

	/**根据id删除当前选中的口碑记录*/
	@Override
	public int deleteSysKB(Integer... ids) {
		if(ids==null||ids.length==0)throw new IllegalArgumentException("请选择一个记录");
		int rows = dao.deleteSysKB(ids);
		if(rows == 0)throw new ServiceException("记录可能不存在了");
		return rows;
	}

	/**修改口碑记录*/
	@Override
	public int updateSysKB(SysKB sysKB) {
		return dao.updateSysKB(sysKB);
	}

	/**新增口碑*/
	@Override
	public int insertSysKB(SysKB sysKB) {
		return dao.insertSysKB(sysKB);
	}

	/**基于条件执行分页查询,获取当前页的数据*/
	@Override
	public PageObject<SysKB> findPageObjects(String name, Integer pageCurrent) {
		if(pageCurrent == null || pageCurrent < 1)throw new ServiceException("页码不正确");
		int rowCount = dao.findRows(name);
		int pageSize = 5;
		int startIndex = (pageCurrent-1)*pageSize;
		List<SysKB> records = dao.findPageObjects(name, startIndex, pageSize);
		PageObject<SysKB> po = new PageObject<>();
		po.setPageCount((rowCount-1)/pageSize+1);
		po.setPageCurrent(pageCurrent);
		po.setPageSize(pageSize);
		po.setRecords(records);
		po.setRowCount(rowCount);
		return po;
	}
}
