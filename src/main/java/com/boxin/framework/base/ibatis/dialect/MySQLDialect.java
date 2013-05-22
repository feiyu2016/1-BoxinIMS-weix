package com.boxin.framework.base.ibatis.dialect;

class MySQLDialect extends AbstractDialect {

	public String getPaginationSQL(String sql,int begin, int end) {
		sql = trim(sql);
		sb = new StringBuffer(sql.length() + 20);
		sb.append(sql);
		if (begin > 1) {
			sb.append(" limit ").append(begin).append(',')
					.append(end - begin + 1);
		} else {
			sb.append(" limit ").append(end - begin + 1);
		}
		if (hasDelimiter) {
			sb.append(SQL_END_DELIMITER);
		}
		return sb.toString();
	}

}