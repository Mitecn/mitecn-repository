package com.kb.sys.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class SysRole implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5316671548588336948L;
	private Integer id;//角色id
	private String role;//角色名
	
}
