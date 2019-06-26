package com.kb.sys.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;
/**
 * 口碑实体类,存储数据库查询的数据.
 * @author lincx
 *
 */
@Data
@ToString
public class SysKB implements Serializable{
	private static final long serialVersionUID = 1294057356099473199L;
	private Integer id;
	private String name;
	private Integer uId;
	private String tName;
}
