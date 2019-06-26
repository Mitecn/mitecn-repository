package com.kb.sys.vo;

import java.io.Serializable;

import com.kb.sys.entity.SysClass;
import com.kb.sys.entity.SysDept;
import com.kb.sys.entity.SysRole;

import lombok.Data;

@Data
public class SysTeachVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4134377315532672315L;
	/** 教师id */
	private Integer id;
	/** 教师姓名 */
	private String tname;
	/** 登录账户 */
	private String loginname;
	/** 密码 */
	private String password;
	/** 教师相关角色信息*/
	private SysRole role;
	/** 教师相关部门信息 */
	private SysDept dept;
	/** 教师相关班级信息  */
	private SysClass cla;
	

}
