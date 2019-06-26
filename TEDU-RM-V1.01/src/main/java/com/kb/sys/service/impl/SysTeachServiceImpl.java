package com.kb.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kb.sys.dao.SysClassDao;
import com.kb.sys.dao.SysDeptDao;
import com.kb.sys.dao.SysRoleDao;
import com.kb.sys.dao.SysTeachDao;
import com.kb.sys.entity.SysClass;
import com.kb.sys.entity.SysDept;
import com.kb.sys.entity.SysRole;
import com.kb.sys.entity.SysTeach;
import com.kb.sys.exception.ServiceException;
import com.kb.sys.service.SysTeachService;
import com.kb.sys.util.PageObject;
import com.kb.sys.util.PageUtil;
import com.kb.sys.vo.SysTeachVo;
@Service
public class SysTeachServiceImpl implements SysTeachService {

	@Autowired
	private SysTeachDao sysTeachDao;
	@Autowired
	private SysClassDao sysClassDao;
	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private SysDeptDao sysDeptDao;
	
	@Override
	public PageObject<SysTeachVo> FindPageObjects(String tname, Integer pageCurrent) {
		if(pageCurrent==0||pageCurrent<0)
			throw new ServiceException("页面不正确");
		int rows = sysTeachDao.getRowCount(tname);
		if(rows==0)
			throw new ServiceException("记录不存在");
		int pageSize = 3;
		int startIndex = PageUtil.getStartIndex(pageCurrent, pageSize);
		List<SysTeach> list = sysTeachDao.findObject(tname, startIndex, pageSize);
		
		List<SysTeachVo> sl = new ArrayList<>();
		for (SysTeach st : list) {
			SysTeachVo stv = new SysTeachVo();
			SysRole role = sysRoleDao.findObjectById(st.getRoleId());
			SysDept dept = sysDeptDao.findObjectById(st.getDeptId());
			SysClass cla = sysClassDao.findObjectById(st.getClassNo());
			stv.setId(st.getId());
			stv.setTname(st.getTname());
			stv.setLoginname(st.getLoginname());
			stv.setPassword(st.getPassword());
			stv.setRole(role);
			stv.setDept(dept);
			stv.setCla(cla);
			sl.add(stv);
		}
		
		System.out.println(sl);
		PageObject<SysTeachVo> po = PageUtil.newPageObject(pageCurrent, rows, pageSize,sl);
		return po;
	}

	@Override
	public int deleteObject(Integer id) {
		// TODO Auto-generated method stub
		if(id==0 || id<0)
			throw new ServiceException("id值不正确");
		int row = sysTeachDao.deleteObject(id);
		return row;
	}

	@Override
	public int insertObject(SysTeach st) {
		if(st==null)
			throw new ServiceException("对象不能为空");
		if(st.getTname()==null)
			throw new ServiceException("姓名不能为空");
		int row = sysTeachDao.insertObject(st);
		if(row==0)
			throw new ServiceException("添加失败");
		return row;
	}

	@Override
	public SysTeach findObjectById(Integer id) {
		if(id<=0)
			throw new IllegalArgumentException("id值不正确");
		SysTeach ob = sysTeachDao.findObjectById(id);
		if(ob==null)
			throw new ServiceException("记录已经不存在了");
		
		return ob;
	}

	@Override
	public int updateObject(SysTeach st) {
		if(st==null)
			throw new IllegalArgumentException("对象不能为空");
		if(st.getLoginname()==null)
			throw new ServiceException("账号不能为空");
		/*		 
		 *
		 */
		int row = sysTeachDao.updateObject(st);
		if(row==0)
			throw new ServiceException("修改失败");
		return row;
	}

	@Override
	public boolean doTeachLogin(String loginname, String password) {
		if(loginname==null)
			throw new ServiceException("账号不能为空");
		if(password==null)
			throw new ServiceException("密码不能为空");
		String pass = sysTeachDao.findObjectByName(loginname);
		if(pass==null)
			throw new ServiceException("账号或密码不正确");
		if(!pass.equals(password))
			throw new ServiceException("账号或密码不正确");
		return true;
	}

}
