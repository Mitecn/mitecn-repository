package com.kb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kb.sys.entity.SysTeach;
import com.kb.sys.service.SysTeachService;
import com.kb.sys.util.PageObject;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTeachSerivce {
	
	@Autowired
	private SysTeachService sts;
	
	@Test
	public void testFind() {
		
	}

}
