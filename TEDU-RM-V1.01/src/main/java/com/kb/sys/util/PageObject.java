package com.kb.sys.util;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 封装业务层当前页记录已经分页信息
 * @author tarena
 *
 * @param <T>
 */
@Data
public class PageObject<T> implements Serializable {

	private static final long serialVersionUID = -5817475228207576629L;
	/**当前页的页码值*/
	private Integer pageCurrent=1;
    /**页面大小*/
    private Integer pageSize=3;
    /**总行数(通过查询获得)*/
    private Integer rowCount=0;
    /**总页数(通过计算获得)*/
    private Integer pageCount=0;
    /**当前页记录*/
    private List<T> records;


}
