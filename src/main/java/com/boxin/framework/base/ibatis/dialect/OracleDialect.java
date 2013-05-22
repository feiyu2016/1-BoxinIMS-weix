package com.boxin.framework.base.ibatis.dialect;

class OracleDialect extends AbstractDialect {

	public String getPaginationSQL(String sql, int begin, int end) {
		sql = trim(sql);
		StringBuffer sb = new StringBuffer(sql.length() + 20);

		sb
				.append(" SELECT * FROM (SELECT PAGI269TABLE.*,ROWNUM "+PAGI_ROWNUM_COLUMN+" FROM ( ");
		sb.append(sql);
		if (begin > 1) {
			sb.append(" )PAGI269TABLE WHERE ROWNUM <= ").append(end).append(
					" ) WHERE "+PAGI_ROWNUM_COLUMN+" >= ").append(begin);
		} else {
			sb.append(" )PAGI269TABLE WHERE ROWNUM < =").append(end).append(
					" ) ");
		}

		if (hasDelimiter) {
			sb.append(SQL_END_DELIMITER);
		}
		return sb.toString();
	}

	public String nvl(String col, String value) {
		return "nvl(" + col + ",'" + value + "')";
	}

	public String nvl(String col, String value, boolean valueType) {
		return "nvl(" + col + "," + value + ")";
	}

	public String decode(String column, String value, String ret1, String ret2) {
		return "decode(" + column + "," + (value == null ? "" : "'") + value
				+ (value == null ? "" : "'") + "," + "'" + ret1 + "','" + ret2
				+ "')";
	}

	public String decode(String column, String value, boolean valueType,
			String ret1, boolean ret1Type, String ret2, boolean ret2Type) {

		if (value == null)
			return "decode(" + column + "," + value + ","
					+ (ret1Type ? "'" : "") + ret1 + (ret1Type ? "'" : "")
					+ "," + (ret2Type ? "'" : "") + ret2
					+ (ret2Type ? "'" : "") + ")";
		else
			return "decode(" + column + "," + (valueType ? "'" : "") + value
					+ (valueType ? "'" : "") + "," + (ret1Type ? "'" : "")
					+ ret1 + (ret1Type ? "'" : "") + ","
					+ (ret2Type ? "'" : "") + ret2 + (ret2Type ? "'" : "")
					+ ")";
	}

	public String getTamestampFunc() {
		return "sysdate";
	}

	public String user_object() {
		return "user_objects";
	}

	public String userObj_name() {
		return "object_name";
	}

	public String seq(String seqname, String alias) {
		return "select " + seqname + ".nextval +0.0 " + alias + "  from "
				+ dummyTable();
	}

	public String dummyTable() {
		return "dual";
	}

	public String datefunc() {
		return "sysdate";
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
		return "rownum";
	}

}