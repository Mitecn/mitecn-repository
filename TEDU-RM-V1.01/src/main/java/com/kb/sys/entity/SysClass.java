package com.kb.sys.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class SysClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4590218383566034469L;
	private Integer id;
	private String claname;//班级名
}
