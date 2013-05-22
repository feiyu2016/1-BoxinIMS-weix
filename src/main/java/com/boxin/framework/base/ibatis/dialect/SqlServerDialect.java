package com.boxin.framework.base.ibatis.dialect;

class SqlServerDialect extends AbstractDialect {

	public String getPaginationSQL(String sql,  int begin, int end) {
		sql = trim(sql);
		sb = new StringBuffer(sql.length() + 20);
		sb.append(" SELECT TOP " + (end - begin + 1) + " * ");
		sb.append(" FROM (" + sql + ") ");
		sb.append(" WHERE (ID > ");
		sb.append(" 		(SELECT MAX(id) ");
		sb.append("         	FROM (SELECT TOP " + end
				+ " id FROM (");
		sb.append(sql);
		sb.append(") ORDER BY id) AS T )");
		sb.append("		))");
		sb.append("ORDER BY ID");
		return sb.toString();
	}

}