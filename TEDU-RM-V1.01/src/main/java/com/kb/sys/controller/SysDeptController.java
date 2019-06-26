package com.kb.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kb.sys.dao.SysDeptDao;
import com.kb.sys.entity.SysDept;
import com.kb.sys.service.SysDeptService;
import com.kb.sys.util.JsonResult;

@Controller
@RequestMapping("dept")
public class SysDeptController {

	@Autowired
	private SysDeptDao sysDeptDao;
	@Autowired
	private SysDeptService sysDeptService;

	@RequestMapping("doDeptListUI")
	public String doIndexUI() {
		return "sys/dept_list";
	}

	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindObjects(String dept, Integer pageCurrent) {
		return new JsonResult(sysDeptService.findPageObjects(dept, pageCurrent));
	}

	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteOnject(Integer id) {
		int rows = sysDeptService.deleteObject(id);
		return new JsonResult("delete ok.rows=" + rows);
	}

	@RequestMapping("doDeptEditUI")
	public String doEditListUI() {
		return "sys/dept_edit";
	}

	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObject(Integer id) {
		return new JsonResult(sysDeptService.findObjectById(id));
	}

	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysDept entity) {

		int rows = sysDeptService.insertObject(entity);
		return new JsonResult("insert ok");
	}

	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysDept entity) {
		int rows = sysDeptService.updateObject(entity);
		return new JsonResult("update ok");
	}
	@RequestMapping("doFindRoles")
	@ResponseBody
	public JsonResult doFindRoles() {
		return new JsonResult(sysDeptDao.findObjects());
	}
}
