package com.boxin.framework.base.ibatis;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.boxin.framework.base.ibatis.dialect.Dialect;
import com.boxin.framework.base.ibatis.dialect.DialectFactory;
import com.boxin.framework.base.utils.ReflectUtils;
import com.ibatis.common.jdbc.exception.NestedSQLException;
import com.ibatis.sqlmap.client.event.RowHandler;
import com.ibatis.sqlmap.engine.impl.SqlMapClientImpl;
import com.ibatis.sqlmap.engine.mapping.parameter.ParameterMap;
import com.ibatis.sqlmap.engine.mapping.result.AutoResultMap;
import com.ibatis.sqlmap.engine.mapping.result.ResultMap;
import com.ibatis.sqlmap.engine.mapping.sql.Sql;
import com.ibatis.sqlmap.engine.mapping.statement.CachingStatement;
import com.ibatis.sqlmap.engine.mapping.statement.ExecuteListener;
import com.ibatis.sqlmap.engine.mapping.statement.MappedStatement;
import com.ibatis.sqlmap.engine.mapping.statement.RowHandlerCallback;
import com.ibatis.sqlmap.engine.mapping.statement.SelectStatement;
import com.ibatis.sqlmap.engine.scope.ErrorContext;
import com.ibatis.sqlmap.engine.scope.StatementScope;

/**
 * 查询数据分页总数statement
 * 
 * @author liushimin
 * @version 1.0 2010-03-24 下午04:09:01
 * @see SelectStatement
 * @since 1.0
 */
public class CountStatement extends SelectStatement {

	/**
	 * dialect 数据库方��
	 */
	private DialectFactory dialectFactory = null;

	/**
	 * dialect 数据库方
	 */
	private Dialect dialect = null;

	/**
	 * 获得总记录数statementId
	 * 
	 * @param selectStatementId
	 *            当前查询的Id
	 * @return String
	 * @see
	 * @throws
	 */
	public static String getCountStatementId(String selectStatementId) {
		return selectStatementId + "_Count";
	}

	/**
	 * 由一个selectStatement构成一个CountSelectment
	 * 
	 * @param mappedStatement
	 * @throws Exception
	 */
	public CountStatement(MappedStatement mappedStatement) throws Exception {
		super();
		SelectStatement selectStatement = null;
		if (mappedStatement instanceof CachingStatement) {
			selectStatement = (SelectStatement)	ReflectUtils.getFieldValue(mappedStatement, "statement");
		} else {
			selectStatement = (SelectStatement) mappedStatement;
		}

		
		setId(CountStatement.getCountStatementId(selectStatement.getId()));
		setResultSetType(selectStatement.getResultSetType());
		setFetchSize(1);
		setParameterMap(selectStatement.getParameterMap());
		setParameterClass(selectStatement.getParameterClass());
		setSql(selectStatement.getSql());
		setResource(selectStatement.getResource());
		setSqlMapClient(selectStatement.getSqlMapClient());
		setTimeout(selectStatement.getTimeout());
		List<ExecuteListener> executeListeners;
		executeListeners = (List<ExecuteListener>) ReflectUtils.getFieldValue(
				selectStatement, "executeListeners");
		if (executeListeners != null) {
			for (ExecuteListener listener : executeListeners) {
				addExecuteListener(listener);
			}
		}
		ResultMap resultMap = new AutoResultMap(
				((SqlMapClientImpl) getSqlMapClient()).getDelegate(), false);
		resultMap.setId(getId() + "-AutoResultMap");
		resultMap.setResultClass(Integer.class);
		resultMap.setResource(getResource());
		setResultMap(resultMap);

	}

	protected void executeQueryWithCallback(StatementScope statementScope,
			Connection conn, Object parameterObject, Object resultObject,
			RowHandler rowHandler, int skipResults, int maxResults)
			throws SQLException {
		ErrorContext errorContext = statementScope.getErrorContext();
		errorContext
				.setActivity("preparing the mapped statement for execution");
		errorContext.setObjectId(this.getId());
		errorContext.setResource(this.getResource());

		try {
			parameterObject = validateParameter(parameterObject);

			Sql sql = getSql();

			errorContext.setMoreInfo("Check the parameter map.");
			ParameterMap parameterMap = sql.getParameterMap(statementScope,
					parameterObject);

			errorContext.setMoreInfo("Check the result map.");
			ResultMap resultMap = getResultMap();

			statementScope.setResultMap(resultMap);
			statementScope.setParameterMap(parameterMap);

			errorContext.setMoreInfo("Check the parameter map.");
			Object[] parameters = parameterMap.getParameterObjectValues(
					statementScope, parameterObject);

			errorContext.setMoreInfo("Check the SQL statement.");
			String sqlString = sql.getSql(statementScope, parameterObject);
			// 通过方言接口获得查询总数SQL
			if (null != dialectFactory) {
				dialect = dialectFactory.getInstance(conn);
				if (null != dialect)
					sqlString = dialect.getTotalSQL(sqlString);
			}
			errorContext.setActivity("executing mapped statement");
			errorContext
					.setMoreInfo("Check the SQL statement or the result map.");
			RowHandlerCallback callback = new RowHandlerCallback(resultMap,
					resultObject, rowHandler);
			sqlExecuteQuery(statementScope, conn, sqlString, parameters,
					skipResults, maxResults, callback);

			errorContext.setMoreInfo("Check the output parameters.");
			if (parameterObject != null) {
				postProcessParameterObject(statementScope, parameterObject,
						parameters);
			}

			errorContext.reset();
			sql.cleanup(statementScope);
			notifyListeners();
		} catch (SQLException e) {
			errorContext.setCause(e);
			throw new NestedSQLException(errorContext.toString(), e
					.getSQLState(), e.getErrorCode(), e);
		} catch (Exception e) {
			errorContext.setCause(e);
			throw new NestedSQLException(errorContext.toString(), e);
		}
	}

	public DialectFactory getDialectFactory() {
		return dialectFactory;
	}

	public void setDialectFactory(DialectFactory dialectFactory) {
		this.dialectFactory = dialectFactory;
	}

}
