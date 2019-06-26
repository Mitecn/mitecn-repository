package com.kb.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kb.sys.dao.SysRoleDao;
import com.kb.sys.entity.SysRole;
import com.kb.sys.service.SysRoleService;
import com.kb.sys.util.JsonResult;
import com.kb.sys.util.PageObject;


@Controller
@RequestMapping("/role/")
public class SysRoleController {
	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private SysRoleService sysRoleService;
	@RequestMapping("doRoleListUI")
	  public String doRolelistUI(){
		  return "sys/role_list";
	  }
	  @RequestMapping("doFindPageObjects")
	  @ResponseBody
	  public JsonResult doFindPageObjects(
			  String role,Integer pageCurrent){
		  PageObject<SysRole> pageObject=
		  sysRoleService.findPageObjects(role,pageCurrent);
		  return new JsonResult(pageObject);
	 }
	  
	  @RequestMapping("doRoleEditUI")
	  public String doRoleEditUI(){
		  return "sys/role_edit";
	  }
	  @RequestMapping("doSaveObject")
		 @ResponseBody
		 public JsonResult doSaveObject(
				 SysRole entity) {
			 sysRoleService.saveObject(entity);
			 return new JsonResult("保存成功!");
		 }
	  
	  @RequestMapping("doDeleteObject")
	  @ResponseBody
	  public JsonResult doDeleteObject(
			  Integer id) {
		  sysRoleService.deleteObject(id);
		  return new JsonResult("删除成功!");
	  }
	
	@RequestMapping("doFindRoles")
	@ResponseBody
	public JsonResult doFindRoles() {
		return new JsonResult(sysRoleDao.findObject());
	}
}
