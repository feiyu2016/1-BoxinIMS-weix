package com.boxin.framework.base.ibatis;

import java.io.Serializable;

public class PagiParam implements Serializable {

	/**
	 * serialVersionUID
	 */

	private static final long serialVersionUID = 4494986239857390820L;

	public static final String PAGI_PARAM = "pagiParam";
	private int pageSize;
	private int currentPageNum = 1;
	private int totalRowNum = -1;

	private int pagiRowParam1;
	private int pagiRowParam2;

	public int getTotalPageNum() {
		return totalRowNum < 0 ? 0 : (int) Math.ceil(1.0f * totalRowNum
				/ pageSize);
	}

	public int getPageSize() {
		return pageSize < 1 ? defaultPageSize : pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize <= 0)
			throw new IllegalArgumentException("illegal pagesize :" + pageSize);
		this.pageSize = pageSize;
	}

	public int getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public int getTotalRowNum() {
		return totalRowNum;
	}

	public void setTotalRowNum(int totalRowNum) {
		this.totalRowNum = totalRowNum;
	}

	public void setTotalRowNum(String totalRowNum) {
		totalRowNum = totalRowNum.replace(",", "");
		this.totalRowNum = Integer.parseInt(totalRowNum);
	}

	public PagiParam() {
		this.pageSize = defaultPageSize;
	}

	public int getFirstResult() {
		return (this.currentPageNum - 1) * this.pageSize;
	}

	public PagiParam(int pageSize) {
		if (pageSize <= 0)
			throw new IllegalArgumentException("illegal pagesize :" + pageSize);
		this.pageSize = pageSize;
	}

	public PagiParam(int pageSize, int totalRowNum) {
		if (pageSize <= 0)
			throw new IllegalArgumentException("illegal pagesize :" + pageSize);
		if (totalRowNum <= 0)
			throw new IllegalArgumentException("illegal totalRowNum :"
					+ totalRowNum);
		this.pageSize = pageSize;
		this.totalRowNum = totalRowNum;
	}

	int getPagiRowParam1() {
		return pagiRowParam1;
	}

	void setPagiRowParam1(int pagiRowParam1) {
		this.pagiRowParam1 = pagiRowParam1;
	}

	int getPagiRowParam2() {
		return pagiRowParam2;
	}

	void setPagiRowParam2(int pagiRowParam2) {
		this.pagiRowParam2 = pagiRowParam2;
	}

	public String toString() {
		return "[PagiParam:pageSize:" + pageSize + ",currentPageNum:"
				+ currentPageNum + ",totalRowNum:" + totalRowNum + "]";
	}

	private static final int defaultPageSize = 20;
}
