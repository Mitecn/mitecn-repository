package com.kb.sys.util;

import java.util.List;

import com.kb.sys.exception.ServiceException;


public class PageUtil {
	/**
	 * 将数据封装为PageObject对象
	 * @param <T>
	 * @param pageCurrent 当前页数
	 * @param rowCount 总记录数据
	 * @param pageSize 页面大小
	 * @param list 查询到的结果
	 * @return
	 */
	public static <T>PageObject<T> newPageObject(Integer pageCurrent, int rowCount, int pageSize, List<T> list){
		PageObject<T> po = new PageObject<>();
		po.setRowCount(rowCount);
		po.setRecords(list);
		po.setPageSize(pageSize);
		po.setPageCount((rowCount-1)/pageSize+1 );
		po.setPageCurrent(pageCurrent);
		return po;
	}
	/**
	 * 判断输入是否正确
	 * @param pageCurrent 当前页码数
	 */
	public static void judgePageCurrent(Integer pageCurrent) {
		if(pageCurrent==null|| pageCurrent<1)
		throw new IllegalArgumentException("页面不正确");
	}
	/**
	 * 判断是否查询到记录
	 * @param rowCount	总记录数
	 */
	public static void judgeRowCount(Integer rowCount) {
		if(rowCount==0)
			throw new ServiceException("记录不存在");
	}
	/**
	 * 计算分页查询开始位置
	 * @param pageCurrent	当前页数
	 * @param pageSize 页面大小
	 * @return
	 */
	public static int getStartIndex(Integer pageCurrent,Integer pageSize) {
		return (pageCurrent-1)*pageSize;
	}

}
