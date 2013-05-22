package com.boxin.framework.base.ibatis.dialect;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;


public class DialectFactoryImpl implements DialectFactory, InitializingBean {

	private static Map<String, Dialect> dialectMap = null;

	private boolean initDone = false;
	/**
	 * dialect 数据库方
	 */
	private static Dialect dialect = null;

	/**
	 * singleton 是否单列模式
	 */
	private boolean singleton = true;

	public Dialect getInstance(Connection conn) {
		// 如果dialect为空，或者非单列
		if (null == dialect || !isSingleton()) {
			try {
				String driver = conn.getMetaData().getDatabaseProductName()
						.toLowerCase();
				for (String o : dialectMap.keySet()) {
					if (driver.indexOf(o.toString()) > -1)
						dialect = dialectMap.get(o);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dialect;
	}

	public Class getObjectType() {
		return Dialect.class;
	}

	public boolean isSingleton() {
		return singleton;
	}

	public void setSingleton(boolean singleton) {
		this.singleton = singleton;
	}

	public void afterPropertiesSet() throws Exception {
		if (dialectMap == null)
			throw new NullPointerException("property \"dialectMap\" is null!");
		initDone = true;
	}

	public void setDialectMap(Map<String, String> dialectMap) {
		if (initDone) {
			throw new java.lang.UnsupportedOperationException();
		}
		if (null != dialectMap) {
			DialectFactoryImpl.dialectMap = new HashMap<String, Dialect>();
			for (String o : dialectMap.keySet()) {
				String dialectClass = dialectMap.get(o);
				try {
					DialectFactoryImpl.dialectMap.put(o, (Dialect) Class.forName(
							dialectClass).newInstance());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
