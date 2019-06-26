package com.kb.sys.entity;

import java.io.Serializable;

import lombok.Data;
@Data
public class SysTeach implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4912188393560419525L;
	/** 教师id */
	private Integer id;
	/** 教师姓名 */
	private String tname;
	/** 登录账户 */
	private String loginname;
	/** 密码 */
	private String password;
	/** 角色id */
	private Integer roleId;
	/** 部门id */
	private Integer deptId;
	/**  班级号*/
	private Integer classNo;
	

}
