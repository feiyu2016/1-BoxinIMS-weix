package com.boxin.framework.base.ibatis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.boxin.framework.base.utils.ReflectUtils;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.engine.execution.SqlExecutor;
import com.ibatis.sqlmap.engine.impl.SqlMapClientImpl;
import com.ibatis.sqlmap.engine.impl.SqlMapExecutorDelegate;

public class SqlMapClientFactoryBean extends
		org.springframework.orm.ibatis.SqlMapClientFactoryBean {
	private static final Log logger = LogFactory
			.getLog(SqlMapClientFactoryBean.class);
	private SqlExecutor sqlExecutor = null;

	public SqlExecutor getSqlExecutor() {
		return sqlExecutor;

	}

	public void setSqlExecutor(SqlExecutor sqlExecutor) {
		this.sqlExecutor = sqlExecutor;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		super.afterPropertiesSet();
		// 设置分页sqlExecutor
		SqlMapClient c = (SqlMapClient) getObject();
		if (sqlExecutor != null && c instanceof SqlMapClientImpl) {
			SqlMapClientImpl client = (SqlMapClientImpl) c;

			SqlMapExecutorDelegate delegate = client.getDelegate();
			try {
				ReflectUtils.setFieldValue(delegate, "sqlExecutor", sqlExecutor);
				logger.debug("success set ibatis  SqlMapClient's sqlExecutor["
						+ sqlExecutor.getClass().getName() + "]");
			} catch (Exception e) {
				logger.error("cannot set ibatis SqlMapClient's sqlExecutor["
						+ sqlExecutor.getClass().getName() + "]cause:" + e);
			}
		}
	}
}