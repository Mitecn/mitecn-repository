package com.kb.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kb.sys.dao.SysClassDao;
import com.kb.sys.entity.SysClass;
import com.kb.sys.service.SysClassService;
import com.kb.sys.util.JsonResult;
import com.kb.sys.util.PageObject;

@Controller
@RequestMapping("class")
public class SysClassController {
	@Autowired
	private SysClassDao sysClassDao;
	@Autowired
	private SysClassService sysClassService;

	@RequestMapping("doFindClassNo")
	@ResponseBody
	public JsonResult doFindClassNo() {
		return new JsonResult(sysClassDao.findObjects());
	}
	@RequestMapping("doClassListUI")
	public String doClassListUI() {
		return "sys/class_list";
	}
	@RequestMapping("doRoleEditUI")
	public String doRoleEditUI(){
			return "sys/class_edit";
	}

	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String claname,Integer pageCurrent){
	 PageObject<SysClass> pageObject=
		sysClassService.findPageObjects(claname, pageCurrent);
	return new JsonResult(pageObject);
	}
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(
	    		SysClass entity){
	    	sysClassService.insertObjects(entity);
	return new JsonResult("save ok");    
	}
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id){
	 sysClassService.deleteObject(id);
	return new JsonResult("delete Ok");
	}
}
