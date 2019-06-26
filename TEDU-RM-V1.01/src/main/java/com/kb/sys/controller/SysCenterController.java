package com.kb.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kb.sys.entity.SysCenter;
import com.kb.sys.service.SysCenterService;
import com.kb.sys.util.JsonResult;
import com.kb.sys.util.PageObject;


@Controller
@RequestMapping("/center/")
public class SysCenterController {

	@Autowired
	private SysCenterService sysCenterService;
	
	
	@RequestMapping("doCenterListUI")
	public String doCenterListUI() {
		return "sys/center_list";	
	}
	
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String centername,Integer pageCurrent) {
		PageObject<SysCenter> pageObject = sysCenterService.findPageObjects(centername, pageCurrent);
		return new JsonResult(pageObject);
	}
	

	@RequestMapping("doCenterEditUI")
	 public String doCenterEditUI(){
		 return "sys/center_edit";
	 }

	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(
	    		SysCenter sysCenter){
	    	sysCenterService.saveObject(sysCenter);
	return new JsonResult("添加成功");    
	}


	@RequestMapping("doDeleteObjects")
	@ResponseBody
	public JsonResult doDeleteObjects(Integer...ids ) {
		sysCenterService.deleteObjects(ids);
		return new JsonResult("删除成功");
	}
	
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysCenter sysCenter){
	    sysCenterService.updateObject(sysCenter);
	    return new JsonResult("修改成功");
	}

	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer id) {
		return new JsonResult(sysCenterService.findObjectById(id));
	}
	@RequestMapping("doMapUI")
	public String doMapUI() {
		return "map";
	}
	@RequestMapping("doFindAddr")
	@ResponseBody
	public JsonResult doFindAddr(Integer id) {
		return new JsonResult(sysCenterService.findAllAddr(id));
	}
}
