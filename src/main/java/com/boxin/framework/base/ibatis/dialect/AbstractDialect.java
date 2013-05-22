package com.boxin.framework.base.ibatis.dialect;

public abstract class AbstractDialect implements Dialect {

	public static String PAGI_ROWNUM_COLUMN = "PAGI_ROWNUM_COLUMN";

	/**
	 * SQL_END_DELIMITER sql语句结束�?
	 */
	protected static final String SQL_END_DELIMITER = ";";

	/**
	 * hasDelimiter sql语句是否有结束符
	 */
	protected boolean hasDelimiter = false;

	/**
	 * sb 分页后的sql语句
	 */
	protected StringBuffer sb = null;

	/*
	 * (非Javadoc) 是否支持物理分页�?默认是true(支持物理分页)
	 * 
	 * @return
	 * 
	 * @see com.ql.framework.dao.ibatis.dialect.Dialect#supportsPagination()
	 */
	public boolean supportsPagination() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bonc.commons.orm.ibatis.dialect.Dialect#getPaginationSQL(java.lang
	 * .String, int, int)
	 */
	public abstract String getPaginationSQL(String sql, int begin, int end);

	/*
	 * (not Javadoc) getTotalSQL 将SQL语句字符串包装为总计SQL返回<br/>
	 * 
	 * @param sql SQL语句字符�?
	 * 
	 * @return 总计SQL
	 * 
	 * @see
	 * com.bonc.commons.dao.ibatis.dialect.Dialect#getTotalSQL(java.lang.String)
	 */
	public String getTotalSQL(String sql) {

		sql = trim(sql);

		StringBuffer sb = new StringBuffer(sql.length() + 20);
		sb.append(" SELECT COUNT(1) st_count FROM ( ");
		sb.append(sql);
		sb.append(" ) a991qe ");

		if (hasDelimiter) {
			sb.append(SQL_END_DELIMITER);
		}
		return sb.toString();
	}

	/**
	 * 预处理sql语句，去掉sql语句结束符�?
	 * 
	 * @param sql
	 *            SQL语句
	 * @return String 返回不包含语句结束符的SQL语句
	 * @see
	 * @throws
	 */
	protected String trim(String sql) {
		sql = sql.trim();
		if (sql.endsWith(SQL_END_DELIMITER)) {
			hasDelimiter = true;
			sql = sql.substring(0, sql.length() - 1
					- SQL_END_DELIMITER.length());
		} else {
			hasDelimiter = false;
		}
		return sql;
	}
}