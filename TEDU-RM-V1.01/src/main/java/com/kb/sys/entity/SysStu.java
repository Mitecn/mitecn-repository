package com.kb.sys.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class SysStu implements Serializable{
	
	private static final long serialVersionUID = 7298330476757422030L;
	private  Integer id;
	private  String sname;
	private  String loginname;
	private  String password;
	private  Integer classNo;
}
