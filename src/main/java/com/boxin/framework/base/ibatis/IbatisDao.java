package com.boxin.framework.base.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

public interface IbatisDao {

	/**
	 * 查询��对象
	 * 
	 * @throws org.springframework.dao.DataAccessException
	 *             in case of errors
	 */
	Object queryForObject(String statementName) throws DataAccessException;

	/**
	 * 查询��对象
	 * 
	 * @param statementName
	 *            statement的ID
	 * @throws org.springframework.dao.DataAccessException
	 *             in case of errors
	 */
	Object queryForObject(String statementName, Object parameterObject)
			throws DataAccessException;

	/**
	 * 查询��对象
	 * 
	 * @param statementName
	 *            statement的ID
	 * @param parameterObject
	 *            参数对象
	 * @param resultObject
	 *            参数对象
	 * @throws org.springframework.dao.DataAccessException
	 *             in case of errors
	 */
	Object queryForObject(String statementName, Object parameterObject,
			Object resultObject) throws DataAccessException;

	/**
	 * 查询多条记录
	 * 
	 * @param statementName
	 *            statement的ID
	 * @throws org.springframework.dao.DataAccessException
	 *             in case of errors
	 */
	List queryForList(String statementName) throws DataAccessException;

	/**
	 * 查询多条记录
	 * 
	 * @param statementName
	 *            statement的ID
	 * @param parameterObject
	 *            参数对象
	 * @throws org.springframework.dao.DataAccessException
	 *             in case of errors
	 */
	List queryForList(String statementName, Object parameterObject)
			throws DataAccessException;

	/**
	 * 查询多条记录
	 * 
	 * @param statementName
	 *            statement的ID
	 * @param skipResults
	 *            记录数开始位置，记录数从0��
	 * @param maxResults
	 *            记录数结束位	 * @return
	 * @throws DataAccessException
	 *             List
	 */
	List queryForList(String statementName, int skipResults, int maxResults)
			throws DataAccessException;

	/**
	 * 查询多条记录
	 * 
	 * @param statementName
	 *            statement的ID
	 * @param parameterObject
	 *            参数对象
	 * @param skipResults
	 *            记录数开始位置，记录数从0��
	 * @param maxResults
	 *            记录数结束位	 * @return
	 * @throws DataAccessException
	 *             List
	 */
	List queryForList(String statementName, Object parameterObject,
			int skipResults, int maxResults) throws DataAccessException;

	/**
	 * 查询操作，返回一个Map
	 * 
	 * @param statementName
	 *            statement的ID
	 * @param parameterObject
	 *            参数对象
	 * @param keyProperty
	 *            键属	 * @throws org.springframework.dao.DataAccessException
	 *             in case of errors
	 */
	Map queryForMap(String statementName, Object parameterObject,
			String keyProperty) throws DataAccessException;

	/**
	 * 查询操作，返回一个Map
	 * 
	 * @param statementName
	 *            statement的ID
	 * @param parameterObject
	 *            参数对象
	 * @param keyProperty
	 *            键属	 * @param valueProperty
	 *            值属	 * @return
	 * @throws DataAccessException
	 *             Map
	 */
	Map queryForMap(String statementName, Object parameterObject,
			String keyProperty, String valueProperty)
			throws DataAccessException;

	/**
	 * 插入记录
	 * 
	 * @param statementName
	 *            statement的ID
	 * @throws org.springframework.dao.DataAccessException
	 *             in case of errors
	 */
	Object insert(String statementName) throws DataAccessException;

	/**
	 * 插入记录
	 * 
	 * @param statementName
	 *            statement的ID
	 * @param parameterObject
	 *            参数对象
	 * @throws org.springframework.dao.DataAccessException
	 *             in case of errors
	 */
	Object insert(String statementName, Object parameterObject)
			throws DataAccessException;

	/**
	 * 更新数据库中的记	 * 
	 * @param statementName
	 *            statement的ID
	 * @throws org.springframework.dao.DataAccessException
	 *             in case of errors
	 */
	int update(String statementName) throws DataAccessException;

	/**
	 * 更新数据库中的记	 * 
	 * @param statementName
	 *            statement的ID
	 * @param parameterObject
	 *            参数对象
	 * @throws org.springframework.dao.DataAccessException
	 *             in case of errors
	 */
	int update(String statementName, Object parameterObject)
			throws DataAccessException;

	/**
	 * 更新数据库中的记录，当被更新的记录数不等于requiredRowsAffected时抛出异常，并回	 * 
	 * @param statementName
	 *            statement的ID
	 * @param parameterObject
	 *            参数对象
	 * @param requiredRowsAffected
	 *            被更新的记录	 * @throws org.springframework.dao.DataAccessException
	 *             in case of errors
	 */
	void update(String statementName, Object parameterObject,
			int requiredRowsAffected) throws DataAccessException;

	/**
	 * 删除数据库中的记	 * 
	 * @param statementName
	 *            statement的ID
	 * @throws org.springframework.dao.DataAccessException
	 *             in case of errors
	 */
	int delete(String statementName) throws DataAccessException;

	/**
	 * 删除数据库中的记 
	 * @param statementName
	 *            statement的ID
	 * @param parameterObject
	 *            参数对象
	 * 
	 * @throws org.springframework.dao.DataAccessException
	 *             in case of errors
	 */
	int delete(String statementName, Object parameterObject)
			throws DataAccessException;

	/**
	 * 删除数据库中的记录，当被删除的记录数不等于requiredRowsAffected时抛出异常，并回  
	 * @param statementName
	 *            statement的ID
	 * @param parameterObject
	 *            参数对象
	 * @param requiredRowsAffected
	 *            被删除的记录 @throws org.springframework.dao.DataAccessException
	 *             in case of errors
	 */
	void delete(String statementName, Object parameterObject,
			int requiredRowsAffected) throws DataAccessException;

	/**
	 * 事务管理，当抛出异常时，自动回滚操作
	 * 
	 * @param callback
	 * @return
	 * @throws DataAccessException
	 *             Object
	 */
	Object execute(ConnectionCallback callback) throws DataAccessException;

	/**
	 * 事务管理操作，当抛出异常时，自动回滚操作
	 * 
	 * @param callback
	 * @return
	 * @throws DataAccessException
	 *             Object
	 */
	Object execute(SqlMapClientCallback callback) throws DataAccessException;

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
	int queryForTotalRow(String selectQuery, Object parameterObject)
			throws DataAccessException;

	/**
	 * 返回SqlMapClientTemplate
	 * 
	 * @return SqlMapClientTemplate
	 */
	SqlMapClientTemplate getSqlMapClientTemplate();

	/**
	 * 查询分页数据
	 * 
	 * @param statementName
	 *            statement的ID
	 * @param parameterObject
	 *            参数对象
	 * @param pagiParam
	 *            分页参数对象
	 * @return List
	 * 
	 */
	List queryForPagiList(final String statementName,
			final Object parameterObject, final PagiParam pagiParam)
			throws DataAccessException;

	/**
	 * 查询分页数据
	 * 
	 * @param statementName
	 *            statement的ID
	 * @param parameterObject
	 *            参数对象
	 * @param pagiParam
	 *            分页参数对象
	 * @param exactTotal
	 *            是否强制获取总计记录数，如果设置为true，则忽略pagiParam中是否已经包含 计记录数
	 * @return List
	 */
	List queryForPagiList(final String statementName,
			final Object parameterObject, final PagiParam pagiParam,
			boolean exactTotal) throws DataAccessException;


}
