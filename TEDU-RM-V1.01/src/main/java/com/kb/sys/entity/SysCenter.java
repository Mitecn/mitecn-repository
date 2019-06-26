package com.kb.sys.entity;

import java.io.Serializable;

import lombok.Data;
@Data
public class SysCenter implements Serializable {

	private static final long serialVersionUID = 2696752995184252530L;
	private Integer id;
	private String centername;//中心名
	private String addr;//地址
	private String classInfo;//课程内容
}
