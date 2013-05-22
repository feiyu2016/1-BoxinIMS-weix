package com.boxin.framework.base.ibatis.dialect;

public interface Dialect {

	/**
	 * 是否支持物理分页方式
	 * 
	 * @return boolean true表示支持物理分页，false表示不支持物理分
	 * @see
	 * @throws
	 */
	public boolean supportsPagination();

	/**
	 * 获取分页SQL
	 * 
	 * @param sql
	 *            待处理的SQL语句
	 * @param begin
	 *            ��记录
	 * @param end
	 *            ��记录
	 * @return String
	 * @see
	 * @throws
	 */
	public String getPaginationSQL(String sql,int begin, int end);

	/**
	 * 包装SQL为计SQL并返回结
	 * 
	 * @param sql
	 *            SQL语句
	 * @return String 该SQL语句包装后的总计SQL
	 * @see
	 * @throws
	 */
	public String getTotalSQL(String sql);

}