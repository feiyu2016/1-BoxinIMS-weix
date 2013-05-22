package com.boxin.framework.base.ibatis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import com.boxin.framework.base.ibatis.dialect.AbstractDialect;
import com.boxin.framework.base.ibatis.dialect.Dialect;
import com.boxin.framework.base.ibatis.dialect.DialectFactory;
import com.ibatis.sqlmap.engine.execution.SqlExecutor;
import com.ibatis.sqlmap.engine.impl.SqlMapClientImpl;
import com.ibatis.sqlmap.engine.impl.SqlMapExecutorDelegate;
import com.ibatis.sqlmap.engine.mapping.result.AutoResultMap;
import com.ibatis.sqlmap.engine.mapping.result.ResultMap;
import com.ibatis.sqlmap.engine.mapping.result.ResultMapping;
import com.ibatis.sqlmap.engine.mapping.result.ResultObjectFactoryUtil;
import com.ibatis.sqlmap.engine.mapping.statement.MappedStatement;
import com.ibatis.sqlmap.engine.mapping.statement.RowHandlerCallback;
import com.ibatis.sqlmap.engine.scope.ErrorContext;
import com.ibatis.sqlmap.engine.scope.SessionScope;
import com.ibatis.sqlmap.engine.scope.StatementScope;

/**
 * 分页sql执行
 * 
 * @version 1.0 2010-03-24 下午04:09:01
 * @see SqlExecutor
 * @since 1.0
 */
public class PaginationSqlExecutor extends SqlExecutor {

	/**
	 * dialect 数据库方 
	 */
	private DialectFactory dialectFactory = null;

	/**
	 * dialect 数据库方 
	 */
	private Dialect dialect = null;

	/**
	 * supportsPagination 是否支持物理分页
	 */
	private boolean supportsPagination = true;

	public void executeQuery(StatementScope statementScope, Connection conn,
			String sql, Object[] parameters, int currentPage, int pageSize,
			RowHandlerCallback callback) throws SQLException {
		if ((currentPage != NO_SKIPPED_RESULTS || pageSize != NO_MAXIMUM_RESULTS)
				&& dialectFactory != null) {
			// 通过方言工厂获得方言
			dialect = dialectFactory.getInstance(conn);
			if (isSupportsPagination()) {
				// 从接口中，获取分页SQL
				sql = dialect.getPaginationSQL(sql, currentPage, pageSize);
				// 设置属�?，让执行器不执行逻辑分页，直接查询，得到结果即是物理分页结果
				currentPage = NO_SKIPPED_RESULTS;
				pageSize = NO_MAXIMUM_RESULTS;
			}
		}
		// 自动映射的resultMap在分页查询后会自动添加一个rowNum的映射， 
		ResultMap rm = statementScope.getResultMap();
		if (null != rm && rm instanceof AutoResultMap) {
			ResultMapping[] resultMappings = rm.getResultMappings();
			if (resultMappings != null
					&& resultMappings[resultMappings.length - 1]
							.getColumnName().equals(
									AbstractDialect.PAGI_ROWNUM_COLUMN)) {
				rm.setResultMappingList(Arrays.asList(Arrays.copyOfRange(
						resultMappings, 0, resultMappings.length - 1)));
			}
		}
		super.executeQuery(statementScope, conn, sql, parameters,
				currentPage, pageSize, callback);
	}

	private void _setupResultObjectFactory(StatementScope statementScope) {
		SqlMapClientImpl client = (SqlMapClientImpl) statementScope
				.getSession().getSqlMapClient();
		ResultObjectFactoryUtil.setResultObjectFactory(client
				.getResultObjectFactory());
		ResultObjectFactoryUtil.setStatementId(statementScope.getStatement()
				.getId());
	}

	private PreparedStatement _prepareStatement(SessionScope sessionScope,
			Connection conn, String sql, Integer rsType) throws SQLException {
		SqlMapExecutorDelegate delegate = ((SqlMapClientImpl) sessionScope
				.getSqlMapExecutor()).getDelegate();
		if (sessionScope.hasPreparedStatementFor(sql)) {
			return sessionScope.getPreparedStatement((sql));
		} else {
			PreparedStatement ps = conn.prepareStatement(sql,
					rsType.intValue(), ResultSet.CONCUR_READ_ONLY);
			sessionScope.putPreparedStatement(delegate, sql, ps);
			return ps;
		}
	}

	private static PreparedStatement _prepareStatement(
			SessionScope sessionScope, Connection conn, String sql)
			throws SQLException {
		SqlMapExecutorDelegate delegate = ((SqlMapClientImpl) sessionScope
				.getSqlMapExecutor()).getDelegate();
		if (sessionScope.hasPreparedStatementFor(sql)) {
			return sessionScope.getPreparedStatement((sql));
		} else {
			PreparedStatement ps = conn.prepareStatement(sql);
			sessionScope.putPreparedStatement(delegate, sql, ps);
			return ps;
		}
	}

	private static void _setStatementTimeout(MappedStatement mappedStatement,
			Statement statement) throws SQLException {
		if (mappedStatement.getTimeout() != null) {
			statement.setQueryTimeout(mappedStatement.getTimeout().intValue());
		}
	}

	public void executeExportQuery(StatementScope statementScope,
			Connection conn, String sql, Object[] parameters, int skipResults,
			int maxResults) throws SQLException {
		ErrorContext errorContext = statementScope.getErrorContext();
		errorContext.setActivity("executing query");
		errorContext.setObjectId(sql);
		PreparedStatement ps = null;
		ResultSet rs = null;
		_setupResultObjectFactory(statementScope);
		try {
			errorContext
					.setMoreInfo("Check the SQL Statement (preparation failed).");
			Integer rsType = statementScope.getStatement().getResultSetType();
			if (rsType != null) {
				ps = _prepareStatement(statementScope.getSession(), conn, sql,
						rsType);
			} else {
				ps = _prepareStatement(statementScope.getSession(), conn, sql);
			}
			_setStatementTimeout(statementScope.getStatement(), ps);
			Integer fetchSize = statementScope.getStatement().getFetchSize();
			if (fetchSize != null) {
				ps.setFetchSize(fetchSize.intValue());
			}
			errorContext
					.setMoreInfo("Check the parameters (set parameters failed).");
			statementScope.getParameterMap().setParameters(statementScope, ps,
					parameters);
			errorContext.setMoreInfo("Check the statement (query failed).");
			ps.execute();
			errorContext
					.setMoreInfo("Check the results (failed to retrieve results).");

			// Begin ResultSet Handling
			// End ResultSet Handling
		} finally {
			try {
				_closeResultSet(rs);
			} finally {
				_closeStatement(statementScope.getSession(), ps);
			}
		}
	}

	private static void _closeStatement(SessionScope sessionScope,
			PreparedStatement ps) {
		if (ps != null) {
			if (!sessionScope.hasPreparedStatement(ps)) {
				try {
					ps.close();
				} catch (SQLException e) {
					// ignore
				}
			}
		}
	}

	private static void _closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// ignore
			}
		}
	}

	/**
	 * 是否支持分页
	 * 
	 * @return boolean
	 * @see
	 * @throws
	 */
	public boolean isSupportsPagination() {
		if (supportsPagination && dialect != null) {
			return dialect.supportsPagination();
		}
		return false;
	}

	/**
	 * 强制设置是否分页
	 * 
	 * @param supportsPagination
	 *            void
	 * @see
	 * @throws
	 */
	public void setSupportsPagination(boolean supportsPagination) {
		this.supportsPagination = supportsPagination;
	}

	public DialectFactory getDialectFactory() {
		return dialectFactory;
	}

	public void setDialectFactory(DialectFactory dialectFactory) {
		this.dialectFactory = dialectFactory;
	}

}