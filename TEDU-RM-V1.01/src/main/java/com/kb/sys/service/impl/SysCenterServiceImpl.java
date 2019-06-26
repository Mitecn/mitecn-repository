package com.kb.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kb.sys.dao.SysCenterDao;
import com.kb.sys.entity.SysCenter;
import com.kb.sys.exception.ServiceException;
import com.kb.sys.service.SysCenterService;
import com.kb.sys.util.PageObject;

import io.micrometer.core.instrument.util.StringUtils;

@Service
public class SysCenterServiceImpl implements SysCenterService {
	@Autowired
	private SysCenterDao sysCenterDao;

	@Override
	public int saveObject(SysCenter sysCenter) {
		if (sysCenter==null) {
			throw new ServiceException("插入对象不能为空");
		}
		if (StringUtils.isEmpty(sysCenter.getCentername())) {
			throw new ServiceException("中心名不能为空");
		}
		int rows;
		try {
			rows = sysCenterDao.insertObject(sysCenter);
		}catch(Exception e){
			e.printStackTrace();
			throw new ServiceException("保存失败");
		}

		return rows;
	}

	@Override
	public int deleteObjects(Integer... ids) {
		//1.验证参数的合法性
		if(ids==null|| ids.length==0)
			throw new IllegalArgumentException("请选择一个");
		//2.执行dao操作
		int rows;
		try {
			rows=sysCenterDao.deleteObjects(ids);
		}catch(Throwable t) {
			t.printStackTrace();
			throw new ServiceException("系统故障，正在恢复...");
		}
		if (rows==0) {
			throw new ServiceException("记录可能已经不存在");
		}
		//3.返回结果
		return rows;

	}




	@Override
	public PageObject<SysCenter> findPageObjects(String centername, Integer pageCurrent) {
		//验证参数合法性
		if(pageCurrent==null || pageCurrent<1) {
			throw new IllegalArgumentException("当前页码不正确");
		}
		//基于条件查询总记录数
		int rowCount = sysCenterDao.getRowCount(centername);
		//验证查询结果，加入结果为0，不再执行如下操作
		if (rowCount==0) {
			throw new ServiceException("系统没有查询到对应记录");
		}
		//基于条件查询当前页记录
		int pageSize=3;
		int startIndex=(pageCurrent-1)*pageSize;
		//执行当前数据查询操作
		List<SysCenter> records = sysCenterDao.findPageObjects(centername, startIndex, pageSize);

		//对分页信息及当前页记录进行封装
		//构建PageObjec对象
		PageObject<SysCenter> pageObject = new PageObject<>();
		pageObject.setPageCount((rowCount-1)/pageSize+1);
		pageObject.setPageCurrent(pageCurrent);;
		pageObject.setPageSize(pageSize);
		pageObject.setRecords(records);
		pageObject.setRowCount(rowCount);
		//返回封装结果
		return pageObject;
	}

	@Override
	public int updateObject(SysCenter sysCenter) {
		//1.合法验证
				if(sysCenter==null)
				throw new ServiceException("保存对象不能为空");
				if(StringUtils.isEmpty(sysCenter.getCentername()))
				throw new ServiceException("中心名不能为空");
				
				//2.更新数据
				int rows=sysCenterDao.updateObject(sysCenter);
				if(rows==0)
				throw new ServiceException("记录可能已经不存在");
				//3.返回数据
				return rows;
			}

	@Override
	public SysCenter findObjectById(Integer id) {
		if (id==null) {
			throw new ServiceException("请选中一条记录");
		}
		SysCenter center = sysCenterDao.findObjectById(id);
		
		return center;
	}

	@Override
	public List<String> findAllAddr(Integer id) {
		if(id<0)
			throw new ServiceException("id值不正确");
		List<String> addr = sysCenterDao.findAllAddr(id);
		if(addr==null)
			throw new ServiceException("为查询到结果");
		return addr;
	}



	






}
