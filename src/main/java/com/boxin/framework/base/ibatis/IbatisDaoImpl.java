package com.boxin.framework.base.ibatis;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DaoSupport;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.util.Assert;

import com.boxin.framework.base.ibatis.dialect.DialectFactory;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapException;
import com.ibatis.sqlmap.engine.impl.SqlMapClientImpl;
import com.ibatis.sqlmap.engine.impl.SqlMapExecutorDelegate;
import com.ibatis.sqlmap.engine.mapping.statement.MappedStatement;

/**
 * 
 * IbatisDaoImpl<br>
 * 大多数情况下，可在Action中注入IBatisDaoImpl，直接调用IBatisDao的方法，免去Dao编写工作
 * 
 */
public class IbatisDaoImpl extends DaoSupport implements IbatisDao {

	/**
	 * dialectFactory 方言工厂
	 */
	private DialectFactory dialectFactory = null;

	public Object queryForObject(String statementName)
			throws DataAccessException {
		return getSqlMapClientTemplate().queryForObject(statementName);
	}

	public Object queryForObject(final String statementName,
			final Object parameterObject) throws DataAccessException {
		return getSqlMapClientTemplate().queryForObject(statementName,
				parameterObject);
	}

	public Object queryForObject(String statementName, Object parameterObject,
			Object resultObject) throws DataAccessException {
		return getSqlMapClientTemplate().queryForObject(statementName,
				parameterObject, resultObject);
	}

	public List queryForList(String statementName) throws DataAccessException {
		return getSqlMapClientTemplate().queryForList(statementName);
	}

	public List queryForList(String statementName, int skipResults,
			int maxResults) throws DataAccessException {
		return getSqlMapClientTemplate().queryForList(statementName,
				skipResults, maxResults);
	}

	public List queryForList(final String statementName,
			final Object parameterObject) throws DataAccessException {
		return getSqlMapClientTemplate().queryForList(statementName,
				parameterObject);
	}

	public List queryForList(String statementName, Object parameterObject,
			int skipResults, int maxResults) throws DataAccessException {
		return getSqlMapClientTemplate().queryForList(statementName,
				parameterObject, skipResults, maxResults);
	}

	public List queryForPagiList(final String statementName,
			final Object parameterObject, final PagiParam pagiParam)
			throws DataAccessException {
		return queryForPagiList(statementName, parameterObject, pagiParam,
				false);
	}

	/**
	 * 分页查询
	 * 
	 * @param statementName
	 *            查询statementId
	 * @param parameterObject
	 *            参数对象，参数对象中应包含一个属性名为�?pagiParam�?类型为PagiParam的对�?
	 * @param pagiParam
	 *            分页对象,当前页参数可以小于等�?，如果小�?则从尾部查询，如果等�?，则从第1页查�?
	 * @param exactTotal
	 *            是否强制获取总计记录数，如果设置为true，则忽略pagiParam中是否已经包含�?计记录数
	 * @return
	 * @throws DataAccessException
	 *             List
	 * @see
	 * @throws
	 */
	public List queryForPagiList(final String statementName,
			final Object parameterObject, final PagiParam pagiParam,
			boolean exactTotal) throws DataAccessException {
		// 获取param分页bean
		if (pagiParam == null)
			throw new NullPointerException("pagiParam is null!");

		int current = pagiParam.getCurrentPageNum();

		if (current < 0) {// 如果页数小于0，则从尾�?��查询，如-3则查询�?数第3�?
			int total = pagiParam.getTotalRowNum();
			if (total < 0 || exactTotal) {
				total = queryForTotalRow(statementName, parameterObject);// 设置param分页bean的�?页数
				pagiParam.setTotalRowNum(total);
				exactTotal = false;
			}
			current = pagiParam.getTotalPageNum() + current + 1;
			pagiParam.setCurrentPageNum(current);
		}
		if (current <= 0) {// 如果设置�?页，则自动变为第�?��
			pagiParam.setCurrentPageNum(1);
			current = 1;
		}

		int begin = (current - 1) * pagiParam.getPageSize();
		List list = queryForList(statementName, parameterObject, begin + 1,
				current * pagiParam.getPageSize());
		if (pagiParam.getTotalRowNum() < 0 || exactTotal) {
			if (list.size() > 0 && list.size() < pagiParam.getPageSize()) {
				// 如果当前页的数据量不满页，则总计页为当前页的,减少与数据库交互次数
				pagiParam.setTotalRowNum(begin + list.size());
			} else {
				// 设置param分页bean的�?页数
				pagiParam.setTotalRowNum(queryForTotalRow(statementName,
						parameterObject));
			}
		}
		// 返回分页查询结果
		return list;

	}

	public Map queryForMap(final String statementName,
			final Object parameterObject, final String keyProperty)
			throws DataAccessException {
		return getSqlMapClientTemplate().queryForMap(statementName,
				parameterObject, keyProperty);
	}

	public Map queryForMap(final String statementName,
			final Object parameterObject, final String keyProperty,
			final String valueProperty) throws DataAccessException {
		return getSqlMapClientTemplate().queryForMap(statementName,
				parameterObject, keyProperty, valueProperty);
	}

	public Object insert(final String statementName) throws DataAccessException {
		return getSqlMapClientTemplate().insert(statementName);
	}

	public Object insert(final String statementName,
			final Object parameterObject) throws DataAccessException {
		return getSqlMapClientTemplate().insert(statementName, parameterObject);
	}

	public int update(final String statementName) throws DataAccessException {
		return getSqlMapClientTemplate().update(statementName);
	}

	public int update(final String statementName, final Object parameterObject)
			throws DataAccessException {
		return getSqlMapClientTemplate().update(statementName, parameterObject);
	}

	public void update(String statementName, Object parameterObject,
			int requiredRowsAffected) throws DataAccessException {
		getSqlMapClientTemplate().update(statementName, parameterObject,
				requiredRowsAffected);
	}

	public int delete(final String statementName) throws DataAccessException {
		return getSqlMapClientTemplate().delete(statementName);
	}

	public int delete(final String statementName, final Object parameterObject)
			throws DataAccessException {
		return getSqlMapClientTemplate().delete(statementName, parameterObject);
	}

	public void delete(String statementName, Object parameterObject,
			int requiredRowsAffected) throws DataAccessException {
		getSqlMapClientTemplate().delete(statementName, parameterObject,
				requiredRowsAffected);
	}

	public Object execute(final SqlMapClientCallback callback) {
		return getSqlMapClientTemplate().execute(callback);
	}

	public Object execute(ConnectionCallback callback)
			throws DataAccessException {
		Connection conn = null;
		Object result = null;
		try {
			conn = getSqlMapClientTemplate().getDataSource().getConnection();
			result = callback.exec(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != conn) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	/**
	 * 查询总记录数
	 * 
	 * @param selectQuery
	 *            查询语句ID
	 * @param parameterObject
	 *            查询参数对象
	 * @return
	 * @throws DataAccessException int
	 * @see
	 * @throws
	 */
	public int queryForTotalRow(String selectQuery, Object parameterObject)
			throws DataAccessException {
		SqlMapClient sqlMapClient = getSqlMapClientTemplate().getSqlMapClient();
		if (sqlMapClient instanceof SqlMapClientImpl) {
			SqlMapExecutorDelegate delegate = ((SqlMapClientImpl) sqlMapClient)
					.getDelegate();
			try {
				delegate.getMappedStatement(CountStatement
						.getCountStatementId(selectQuery));
			} catch (SqlMapException e) {
				try {
					CountStatement countStatement = new CountStatement(
							 delegate
									.getMappedStatement(selectQuery));
					countStatement.setDialectFactory(dialectFactory);
					delegate
							.addMappedStatement((MappedStatement) countStatement);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		return (Integer) getSqlMapClientTemplate().queryForObject(
				CountStatement.getCountStatementId(selectQuery),
				parameterObject);
	}

	/**
	 * 设置物理分页方言工厂
	 * 
	 * @param dialectFactory
	 *            void
	 * @see
	 * @throws
	 */
	public void setDialectFactory(DialectFactory dialectFactory) {
		this.dialectFactory = dialectFactory;
	}


	private SqlMapClientTemplate sqlMapClientTemplate = new SqlMapClientTemplate();

	private boolean externalTemplate = false;

	/**
	 * Set the JDBC DataSource to be used by this DAO. Not required: The
	 * SqlMapClient might carry a shared DataSource.
	 * 
	 * @see #setSqlMapClient
	 */
	public void setDataSource(DataSource dataSource) {
		if (!this.externalTemplate) {
			this.sqlMapClientTemplate.setDataSource(dataSource);
		}
	}

	/**
	 * Return the JDBC DataSource used by this DAO.
	 */
	public DataSource getDataSource() {
		return this.sqlMapClientTemplate.getDataSource();
	}

	/**
	 * Set the iBATIS Database Layer SqlMapClient to work with. Either this or a
	 * "sqlMapClientTemplate" is required.
	 * 
	 * @see #setSqlMapClientTemplate
	 */
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		if (!this.externalTemplate) {
			this.sqlMapClientTemplate.setSqlMapClient(sqlMapClient);
		}
	}

	/**
	 * Return the iBATIS Database Layer SqlMapClient that this template works
	 * with.
	 */
	public SqlMapClient getSqlMapClient() {
		return this.sqlMapClientTemplate.getSqlMapClient();
	}

	/**
	 * Set the SqlMapClientTemplate for this DAO explicitly, as an alternative
	 * to specifying a SqlMapClient.
	 * 
	 * @see #setSqlMapClient
	 */
	public void setSqlMapClientTemplate(
			SqlMapClientTemplate sqlMapClientTemplate) {
		Assert.notNull(sqlMapClientTemplate,
				"SqlMapClientTemplate must not be null");
		this.sqlMapClientTemplate = sqlMapClientTemplate;
		this.externalTemplate = true;
	}

	/**
	 * Return the SqlMapClientTemplate for this DAO, pre-initialized with the
	 * SqlMapClient or set explicitly.
	 */
	public SqlMapClientTemplate getSqlMapClientTemplate() {
		return this.sqlMapClientTemplate;
	}

	protected void checkDaoConfig() {
		if (!this.externalTemplate) {
			this.sqlMapClientTemplate.afterPropertiesSet();
		}
	}

}
