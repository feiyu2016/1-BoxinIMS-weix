package com.boxin.framework.base.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.boxin.framework.base.ibatis.ConnectionCallback;
import com.boxin.framework.base.ibatis.PagiParam;
import com.ibatis.common.beans.Probe;
import com.ibatis.common.beans.ProbeFactory;

/**
 * 数据访问辅助类 <br>
 * 大多数情况下，可在Action中注入DaoHelper，直接调用DaoHelper的方法，免去Dao编写工作
 * 
 * @author
 * @version 1.0 2010-9-2 下午01:01:30
 * @since 1.0
 */
public class DaoHelper implements InitializingBean {
	private static final Probe PROBE = ProbeFactory.getProbe();

	private IBatisTemplate ibatisTemplate;

	private DataSource dataSource;

	public IBatisTemplate getIbatisTemplate() {
		return ibatisTemplate;
	}

	public void setIbatisTemplate(IBatisTemplate ibatisTemplate) {
		this.ibatisTemplate = ibatisTemplate;
	}

	/**
	 * 查询单条数据结果，查询结果为一个对象
	 * 
	 * @param statementName
	 *            ibatis语句ID
	 * @param parameterObject
	 *            查询参数对象
	 * @return Object 结果对象
	 * @throws DataAccessException
	 *             Object
	 */
	public Object queryForObject(final String statementName,
			final Object parameterObject) throws DataAccessException {
		return getIbatisTemplate().queryForObject(statementName,
				parameterObject);
	}

	/**
	 * 查询多条记录，查询结果为List
	 * 
	 * @param statementName
	 *            ibatis语句ID
	 * @param parameterObject
	 *            查询参数对象
	 * @return List 结果集合
	 * @throws DataAccessException
	 *             List
	 */
	public List queryForList(final String statementName,
			final Object parameterObject) throws DataAccessException {
		return getIbatisTemplate().queryForList(statementName, parameterObject);
	}

	/**
	 * 查询共有多少条记录
	 * 
	 * @param statementName
	 *            ibatis语句ID
	 * @param parameterObject
	 *            查询参数对象
	 * @return int 记录数
	 * @throws DataAccessException int
	 */
	public int queryForTotalRow(String statementName, Object parameterObject)
			throws DataAccessException {
		return getIbatisTemplate().queryForTotalRow(statementName,
				parameterObject);
	}

	/**
	 * 分页查询 <br/>
	 * （参数中已经带有PagiParam类型的对象，并且是可见的，只有在分页对象的结果数没有初始化情况下才会去查询数据库中数据集总数） <br/>
	 * 
	 * @param statementName
	 *            ibatis语句ID
	 * @param parameterObject
	 *            查询参数对象
	 * @return List 查询结果集
	 * @throws DataAccessException
	 *             List
	 */
	public List queryForPagiList(final String statementName,
			final Object parameterObject) throws DataAccessException {
		return this.queryForPagiList(statementName, parameterObject, false);
	}

	/**
	 * 分页查询 ，无分页PagiParam辅助对象
	 * 
	 * @param statementName
	 *            ibatis语句ID
	 * @param parameterObject
	 *            查询参数对象
	 * @param skipResults
	 *            起始记录数
	 * @param maxResults
	 *            最大数据数
	 * @return List 查询结果集
	 * @throws DataAccessException
	 * 
	 */
	public List queryForPagiList(final String statementName,
			final Object parameterObject, int skipResults, int maxResults)
			throws DataAccessException {
		// 返回分页查询结果
		return getIbatisTemplate().queryForList(statementName, parameterObject,
				skipResults, maxResults);
	}

	/**
	 * 分页查询 <br/>
	 * 显示指定PagiParam参数，用于解决页面同时存在多个PagiParam分页数据
	 * 
	 * @param statementName
	 *            ibatis语句ID
	 * @param parameterObject
	 *            查询参数对象
	 * @param pagiParam
	 *            分页变量,不能为空，否则无法修改该对象里面的变量，如果为空则第一页记录
	 * @return List
	 * @throws DataAccessException
	 * 
	 */
	public List queryForPagiList(final String statementName,
			final Object parameterObject, PagiParam pagiParam)
			throws DataAccessException {
		return this.queryForPagiList(statementName, parameterObject, pagiParam,
				false);
	}

	/**
	 * 分页查询 <br/>
	 * 显示指定PagiParam参数，用于解决页面同时存在多个PagiParam分页数据
	 * 
	 * @param statementName
	 *            ibatis语句ID
	 * @param parameterObject
	 *            查询参数对象
	 * @param pagiParam
	 *            分页变量,不能为空，否则无法修改该对象里面的变量，如果为空则第一页记录
	 * @param exactTotal
	 *            当为true时， 强制查询数据库获得数据集总数
	 * @return List
	 * @throws DataAccessException
	 * 
	 */
	public List queryForPagiList(final String statementName,
			final Object parameterObject, PagiParam pagiParam,
			boolean exactTotal) throws DataAccessException {
		if (pagiParam == null)
			throw new NullPointerException("param pagiParam can't be null !");
		return getIbatisTemplate().queryForPagiList(statementName,
				parameterObject, pagiParam, exactTotal);
	}

	/**
	 * 分页查询 <br/>
	 * （参数中已经带有PagiParam对象，并且是可见的，根据参数exactTotal查询数据库中数据集总数）
	 * 
	 * @param statementName
	 *            ibatis语句ID
	 * @param parameterObject
	 *            查询参数对象
	 * @param exactTotal
	 *            当为true时， 强制查询数据库获得数据集总数
	 * @return List
	 * @throws DataAccessException
	 * 
	 */
	public List queryForPagiList(final String statementName,
			final Object parameterObject, boolean exactTotal)
			throws DataAccessException {
		// 获取param分页bean
		if (parameterObject == null)
			throw new NullPointerException("parameterObject is null!");
		PagiParam param = (PagiParam) PROBE.getObject(parameterObject,
				"pagiParam");
		if (param == null)
			throw new NullPointerException(
					"can't find PagiParam in parameterObject with name \"pagiParam\"!");
		return this.queryForPagiList(statementName, parameterObject, param,
				exactTotal);
	}

	/**
	 * 类似于queryForList，但结果集是Map，键值为keyProperty指定的属性值。
	 * 
	 * @param statementName
	 *            ibatis语句ID
	 * @param parameterObject
	 *            查询参数对象
	 * @param keyProperty
	 *            map的key
	 * @return Map
	 * @throws DataAccessException
	 * 
	 */
	public Map queryForMap(final String statementName,
			final Object parameterObject, final String keyProperty)
			throws DataAccessException {
		return getIbatisTemplate().queryForMap(statementName, parameterObject,
				keyProperty);
	}

	/**
	 * 类似于queryForList,但结果集是Map，键值为keyProperty指定的属性值，值为valueProperty
	 * 
	 * @param statementName
	 *            ibatis语句ID
	 * @param parameterObject
	 *            查询参数对象
	 * @param keyProperty
	 * @param valueProperty
	 * @return Map
	 * @throws DataAccessException
	 * 
	 */
	public Map queryForMap(final String statementName,
			final Object parameterObject, final String keyProperty,
			final String valueProperty) throws DataAccessException {
		return getIbatisTemplate().queryForMap(statementName, parameterObject,
				keyProperty, valueProperty);
	}

	/**
	 * 插入操作
	 * 
	 * @param statementName
	 *            ibatis语句ID
	 * @return
	 * @throws DataAccessException
	 * @see OpResult
	 */
	public OpResult insert(final String statementName)
			throws DataAccessException {
		try {
			return new OpResult(true,
					getIbatisTemplate().insert(statementName), null);
		} catch (Exception e) {
			return new OpResult(false, null, e);
		}
	}

	/**
	 * 插入操作
	 * 
	 * @param statementName
	 *            ibatis语句ID
	 * @param parameterObject
	 *            查询参数对象
	 * @return OpResult
	 * @throws DataAccessException
	 * @see OpResult
	 */
	public OpResult insert(final String statementName,
			final Object parameterObject) throws DataAccessException {
		try {
			return new OpResult(true, getIbatisTemplate().insert(statementName,
					parameterObject), null);
		} catch (Exception e) {
			return new OpResult(false, null, e);
		}
	}

	/**
	 * 更新操作
	 * 
	 * @param statementName
	 *            ibatis语句ID
	 * @return OpResult
	 * @throws DataAccessException
	 * @see OpResult
	 */
	public OpResult update(final String statementName)
			throws DataAccessException {
		try {
			return new OpResult(true,
					getIbatisTemplate().update(statementName), null);
		} catch (Exception e) {
			return new OpResult(false, null, e);
		}
	}

	/**
	 * 更新操作
	 * 
	 * @param statementName
	 *            ibatis语句ID
	 * @param parameterObject
	 *            查询参数对象
	 * @return
	 * @throws DataAccessException
	 */
	public OpResult update(final String statementName,
			final Object parameterObject) throws DataAccessException {
		try {
			return new OpResult(true, getIbatisTemplate().update(statementName,
					parameterObject), null);
		} catch (Exception e) {
			return new OpResult(false, null, e);
		}
	}

	/**
	 * 更新操作
	 * 
	 * @param statementName
	 *            ibatis语句ID
	 * @param parameterObject
	 *            查询参数对象
	 * @param requiredRowsAffected
	 *            预期被更新记录数，如果被更新记录数不等于该数值，则更新失败
	 * @return OpResult
	 * @throws DataAccessException
	 */
	public OpResult update(String statementName, Object parameterObject,
			int requiredRowsAffected) throws DataAccessException {
		try {
			getIbatisTemplate().update(statementName, parameterObject,
					requiredRowsAffected);
			return new OpResult(true, null, null);
		} catch (Exception e) {
			return new OpResult(false, null, e);
		}
	}

	/**
	 * 删除操作
	 * 
	 * @param statementName
	 *            ibatis语句ID
	 * @return OpResult
	 * @throws DataAccessException
	 * @see OpResult
	 */
	public OpResult delete(final String statementName)
			throws DataAccessException {
		try {
			return new OpResult(true,
					getIbatisTemplate().delete(statementName), null);
		} catch (Exception e) {
			return new OpResult(false, null, e);
		}
	}

	/**
	 * 删除操作
	 * 
	 * @param statementName
	 *            ibatis语句ID
	 * @param parameterObject
	 *            查询参数对象
	 * @return
	 * @throws DataAccessException
	 */
	public OpResult delete(final String statementName,
			final Object parameterObject) throws DataAccessException {
		try {
			return new OpResult(true, getIbatisTemplate().delete(statementName,
					parameterObject), null);
		} catch (Exception e) {
			return new OpResult(false, null, e);
		}
	}

	/**
	 * 删除
	 * 
	 * @param statementName
	 *            ibatis语句ID
	 * @param parameterObject
	 *            查询参数对象
	 * @param requiredRowsAffected
	 *            预期被删除的记录数，如果实际被删除记录数不等于该记录数，则删除操作失败
	 * @return OpResult
	 * @throws DataAccessException
	 * @see OpResult
	 */
	public OpResult delete(String statementName, Object parameterObject,
			int requiredRowsAffected) throws DataAccessException {
		try {
			getIbatisTemplate().delete(statementName, parameterObject,
					requiredRowsAffected);
			return new OpResult(true, null, null);
		} catch (Exception e) {
			return new OpResult(false, null, e);
		}
	}

	/**
	 * 事务处理
	 * 
	 * @param callback
	 * @return OpResult
	 * @see SqlMapClientCallback
	 * @see OpResult
	 */
	public OpResult execute(final SqlMapClientCallback callback) {
		try {
			Object result = getIbatisTemplate().execute(callback);
			return new OpResult(true, result, null);
		} catch (Exception e) {
			return new OpResult(false, null, e);
		}
	}

	/**
	 * 事务处理
	 * 
	 * @param callback
	 * @return
	 * @throws DataAccessException
	 *             OpResult
	 * @see DaoCallback
	 * @see OpResult
	 */
	public OpResult execute(final DaoCallback callback)
			throws DataAccessException {
		try {
			Object result = getIbatisTemplate().execute(callback);
			return new OpResult(true, result, null);
		} catch (Exception e) {
			return new OpResult(false, null, e);
		}
	}


	/**
	 * 事务处理
	 * 
	 * @param callback
	 * @return
	 * @throws DataAccessException
	 * @see ConnectionCallback
	 * @see OpResult
	 * @throws
	 */
	public OpResult execute(final ConnectionCallback callback)
			throws DataAccessException {
		try {
			Object result = getIbatisTemplate().execute(callback);
			return new OpResult(true, result, null);
		} catch (Exception e) {
			return new OpResult(false, null, e);
		}
	}

	public void afterPropertiesSet() throws Exception {
		if (null == this.ibatisTemplate) {
			throw new NullPointerException("propertiy iBatisTemplate  is null ");
		}
		if (null == dataSource) {
			throw new NullPointerException("propertiy dataSource  is null ");
		}
		getSqlMapClientTemplate().setDataSource(dataSource);
		getSqlMapClientTemplate().afterPropertiesSet();
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public SqlMapClientTemplate getSqlMapClientTemplate() {
		return ibatisTemplate.getSqlMapClientTemplate();
	}

}
