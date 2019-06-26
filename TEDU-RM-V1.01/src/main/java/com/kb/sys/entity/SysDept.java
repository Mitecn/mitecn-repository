package com.kb.sys.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class SysDept implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4138790137541539007L;
	private Integer id;
	private String dept;//部门名
}
