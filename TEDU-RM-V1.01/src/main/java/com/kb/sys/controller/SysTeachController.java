package com.kb.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kb.sys.entity.SysTeach;
import com.kb.sys.service.SysTeachService;
import com.kb.sys.util.JsonResult;

@Controller
@RequestMapping("/teach/")
public class SysTeachController {

	@Autowired
	private SysTeachService sysTeachService;
	
	@RequestMapping("doTeachListUI")
	public String doTeachListUI() {
		return "sys/teach_list";
	}
	
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String tname,Integer pageCurrent) {
		return new JsonResult(sysTeachService.FindPageObjects(tname, pageCurrent));
	}
	
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id) {
		return new JsonResult(sysTeachService.deleteObject(id));
	}
	
	@RequestMapping("doTeachEditUI")
	public String doTeachEditUI() {
		return "sys/teach_edit";
	}
	
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysTeach st) {
		return new JsonResult(sysTeachService.insertObject(st));
	}
	
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer id) {
		return new JsonResult(sysTeachService.findObjectById(id));
	}
	
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysTeach st) {
		return new JsonResult(sysTeachService.updateObject(st));
	}
	
	@RequestMapping("doLogin")
	@ResponseBody
	public JsonResult doLogin(String loginname,String password) {
		return new JsonResult(sysTeachService.doTeachLogin(loginname, password));
	}
}
