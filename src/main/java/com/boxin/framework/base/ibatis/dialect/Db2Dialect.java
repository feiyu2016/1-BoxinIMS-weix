package com.boxin.framework.base.ibatis.dialect;

class Db2Dialect extends AbstractDialect {

	/**
	 * 由于db2在做递归查询（树状结构）的时候需要使用以下结构的语句
	 * 
	 * <pre>
	 * WITH RPL(id,parent_id,name) AS
	 *  (SELECT ROOT.id, ROOT.parent_id, ROOT.name
	 *     FROM tree_table ROOT
	 *    WHERE ROOT.id = 'root'
	 *   UNION ALL
	 *   SELECT CHILD.id, CHILD.parent_id, CHILD.name
	 *     FROM RPL PARENT, tree_table CHILD
	 *    WHERE PARENT.id = CHILD.parent_id)
	 *</pre>
	 * 
	 * 本语句必须放在一个查询之前�?不能嵌套在查询里面，因此在做分页查询的时候，�?��将本部分提取出来，放在分页查询之前�?
	 * 
	 * 
	 * @see com.bonc.commons.orm.ibatis.dialect.AbstractDialect#getPaginationSQL(java.lang.String,
	 *      int, int)
	 */
	public String getPaginationSQL(String sql, int begin, int end) {
		sql = trim(sql);
		int position = this.withEndPosition(sql);
		StringBuffer sb = new StringBuffer(sql.length() + 20);
		if (position > 0) {// 如果位置大于0，则先输出with语句，然后将sql中的with去掉
			sb.append(sql.substring(0, position));
			sql = sql.substring(position);
		}
		sb
				.append("SELECT PAGIDB2TABLEOUT.* FROM (SELECT PAGIDB2TABLEIN.*, rownumber() over() as "+PAGI_ROWNUM_COLUMN+" FROM (");
		sb.append(sql);
		sb
				.append(" )PAGIDB2TABLEIN )PAGIDB2TABLEOUT WHERE PAGIDB2TABLEOUT."+PAGI_ROWNUM_COLUMN+" <= ");
		sb.append(end);
		if (begin > 1) {
			sb.append(" AND PAGIDB2TABLEOUT."+PAGI_ROWNUM_COLUMN+" >= ").append(begin);
		}
		if (hasDelimiter) {
			sb.append(SQL_END_DELIMITER);
		}
		return sb.toString();
	}

	public String getTotalSQL(String sql) {

		sql = trim(sql);

		StringBuffer sb = new StringBuffer(sql.length() + 20);
		int position = this.withEndPosition(sql);
		if (position > 0) {// 如果位置大于0，则先输出with语句，然后将sql中的with去掉
			sb.append(sql.substring(0, position));
			sql = sql.substring(position);
		}
		sb.append(" SELECT COUNT(1) st_count FROM ( ");
		sb.append(sql);
		sb.append(" ) a991qe ");

		if (hasDelimiter) {
			sb.append(SQL_END_DELIMITER);
		}
		return sb.toString();
	}

	private static final String lBracket = "(", rBracket = ")", WITH = "WITH ",
			AS = " AS ";// 常量

	/**
	 * 如果返回0表示没有with
	 * 
	 * @param sql
	 * @return int
	 */
	private int withEndPosition(String sql) {
		int currentPos = 0, tmpPos, lBracketNum = 0;// 当前位置
		String sqltmp = sql.toUpperCase();
		if ((tmpPos = sqltmp.indexOf(WITH)) >= 0
				&& (tmpPos = sqltmp.indexOf(AS)) >= 0) {
			currentPos = tmpPos + AS.length();
			sqltmp = sqltmp.substring(currentPos);
			do {
				int lBracketPos = sqltmp.indexOf(lBracket);
				int rBracketPos = sqltmp.indexOf(rBracket);
				if (lBracketPos >= 0 && lBracketPos < rBracketPos) {// 如果左括号位置在右括号位置前面，则加1，并漂移
					lBracketNum++;
					currentPos += lBracketPos + 1;
					sqltmp = sqltmp.substring(lBracketPos + 1);
				}// 如果左括号位置在右括号位置前面，则减1，并漂移
				else {
					lBracketNum--;
					currentPos += rBracketPos + 1;
					sqltmp = sqltmp.substring(rBracketPos + 1);
				}
			} while (lBracketNum != 0);
			return currentPos;
		}
		return 0;
	}

	public String decode(String column, String value, String ret1, String ret2) {
		String ret = " CASE ";
		if (value == null) {
			ret = ret + " when " + column + " is null then '" + ret1 + "'";
		} else {
			ret = ret + column;
			ret = ret + " when '" + value + "' then '" + ret1 + "'";
		}
		ret = ret + " else '" + ret2 + "'";
		ret = ret + "END";
		return ret;
	}

	public String decode(String column, String value, boolean valueType,
			String ret1, boolean ret1Type, String ret2, boolean ret2Type) {
		if (value != null) {
			String ret = "CASE " + column;
			if (valueType) {
				ret = ret + " when '" + value + "'";
			} else {
				ret = ret + " when " + value;
			}

			if (ret1Type) {
				ret = ret + " then '" + ret1 + "'";
			} else {
				ret = ret + " then" + ret1;
			}

			if (ret2Type) {
				ret = ret + " else '" + ret2 + "'";
			} else {
				ret = ret + " else " + ret2;
			}

			ret = ret + " END ";
			return ret;
		} else {
			String ret = "CASE ";

			ret = ret + " when " + column + " is null";

			if (ret1Type) {
				ret = ret + " then '" + ret1 + "'";
			} else {
				ret = ret + " then" + ret1;
			}

			if (ret2Type) {
				ret = ret + " else '" + ret2 + "'";
			} else {
				ret = ret + " else " + ret2;
			}

			ret = ret + " END ";
			return ret;
		}
	}

	public String getTamestampFunc() {
		return "current timestamp";
	}

	public String user_object() {
		return "sysibm.systables";
	}

	public String userObj_name() {
		return "name";
	}

	public String seq(String seqname, String alias) {
		return "select NEXTVAL for " + seqname + " + 0.0 as " + alias
				+ " from " + dummyTable();
	}

	public String dummyTable() {
		return "SYSIBM.SYSDUMMY1";
	}

	public String datefunc() {
		return "current date";
	}

	public String nvl(String col, String value) {
		return "COALESCE(" + col + ",'" + value + "')";
	}

	public String nvl(String col, String value, boolean valueType) {
		if (value != null) {
			if (valueType) {
				return "COALESCE(" + col + ",'" + value + "')";
			} else {
				return "COALESCE(" + col + "," + value + ")";
			}

		} else {
			return "";
		}
	}

	public String Row_Number(String PartitionBy, String orderBy, String sort) {
		return "Row_Number() Over(Partition By " + PartitionBy + " Order By "
				+ orderBy + " " + sort + ")";
	}

	public String Row_Number(int PartitionBy, String orderBy, String sort) {
		return "Row_Number() Over(Partition By " + PartitionBy + "Order By "
				+ orderBy + " " + sort + ")";
	}

	public String rownum() {
		return "row_number() over()";
	}

}