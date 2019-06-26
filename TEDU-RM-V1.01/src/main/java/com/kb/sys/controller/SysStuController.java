package com.kb.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kb.sys.entity.SysStu;
import com.kb.sys.service.SysStuService;
import com.kb.sys.util.JsonResult;


@RequestMapping("/stu/")
@Controller
public class SysStuController {
	@Autowired
	private SysStuService sysStuService;

	@RequestMapping("doIndexUI")
	public String  test() {
		return "teacher";
	}
	@RequestMapping("doStuListUI")
	public String doLogListUI() {
		//return "ajax/log";
		return "sys/stu_list";
	}
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindObjects( String sname,
			Integer pageCurrent) {
		return new JsonResult(
				sysStuService.findPageObjects(
						sname, pageCurrent));
	}
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteOnject(Integer id) {
		int rows = sysStuService.deleteObject(id);
		return new JsonResult("delete ok.rows="+rows);
	}
	@RequestMapping("doStuEditUI")
	public String doEditListUI() {
		return "sys/stu_edit";
	}
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObject(Integer id) {
		return new JsonResult(sysStuService.findObjectById(id));
	}
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysStu entity) {
		
		int rows = sysStuService.insertObject(entity);
		return new JsonResult("insert ok");
	}
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysStu entity) {
		int rows = sysStuService.updateObject(entity);
		return new JsonResult("update ok");
	}
}
