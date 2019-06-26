package com.kb.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kb.sys.entity.SysKB;
import com.kb.sys.service.SysKBService;
import com.kb.sys.util.JsonResult;
import com.kb.sys.util.PageObject;

/**
 * 口碑模块控制层
 * @author lincx
 *
 */
@Controller
@RequestMapping("/kb/")
public class SysKBController {

	/**依赖注入业务层接口*/
	@Autowired
	private SysKBService service;
	
	@RequestMapping("doKBListUI")
	public String doKBListUI() {
		return "sys/kb_list";
	}
	
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String name,Integer pageCurrent) {
		PageObject<SysKB> findPageObjects = service.findPageObjects(name, pageCurrent);
		return new JsonResult(findPageObjects);
	}
	
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer... ids) {
		return new JsonResult(service.deleteSysKB(ids));
	}
	
	@RequestMapping("doEditUI")
	public String doEditUI() {
		return "sys/kb_edit";
	}
	
	@RequestMapping("dofindSysKB")
	@ResponseBody
	public JsonResult dofindSysKB(Integer id) {
		return new JsonResult(service.findSysKB(id));
	}
	
	@RequestMapping("doinsertSysKB")
	@ResponseBody
	public JsonResult doinsertSysKB(SysKB sysKB) {
		return new JsonResult(service.insertSysKB(sysKB));
	}
	
	@RequestMapping("doupdateSysKB")
	@ResponseBody
	public JsonResult doupdateSysKB(SysKB sysKB) {
		return new JsonResult(service.updateSysKB(sysKB));
	}
	
}












