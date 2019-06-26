package com.kb;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kb.sys.dao.SysTeachDao;
import com.kb.sys.entity.SysTeach;
import com.kb.sys.vo.SysTeachVo;



@RunWith(SpringRunner.class)
@SpringBootTest
public class SysTeachTests01 {
	@Autowired
	private SysTeachDao sysTeachDao;
	
	@Test
	public void testInsert() {
		SysTeach st = new SysTeach();
		st.setTname("杨莉");
		st.setLoginname("yl123456");
		st.setPassword("123456");
		st.setRoleId(1);
		st.setDeptId(1);
		st.setClassNo(1);
		int result = sysTeachDao.insertObject(st);
		System.out.println(result);
		Assert.assertNotEquals(0, result);
	}
	
	
	@Test
	public void testFindObject() {
		List<SysTeach> list = sysTeachDao.findObject(null, 0, 2);
		
		System.out.println(list);
		Assert.assertNotEquals(null, list);
	}
	@Test
	public void testDeleteObject() {
		int rows = sysTeachDao.deleteObject(5);
		Assert.assertNotEquals(0, rows);
	}
	@Test
	public void testUpdateObject() {
		SysTeach st = new SysTeach();
		st.setId(6);
		st.setTname("杨晓");
		
		st.setPassword("123456");
		st.setRoleId(1);
		st.setDeptId(1);
		st.setClassNo(1);
		int rows = sysTeachDao.updateObject(st);
		Assert.assertNotEquals(0, rows);
		
	}
	@Test
	public void testGetRowCount() {
		int rows = sysTeachDao.getRowCount(null);
		Assert.assertNotEquals(0, rows);
	}
	
	@Test
	public void testFindVo() {
		List<SysTeachVo> vo = sysTeachDao.findVo(null, 0, 1);
		System.out.println(vo);
	}
	
}
