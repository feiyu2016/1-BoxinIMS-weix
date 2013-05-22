package com.boxin.framework.base.ibatis.dialect;
import java.sql.Connection;

public interface DialectFactory {

	/**
	 * 获得方言实例
	 * 
	 * @param conn
	 *            当前 使用的数据库连接
	 * @return Dialect 物理分页方言
	 * @see
	 * @throws
	 */
	public Dialect getInstance(Connection conn);

	/**
	 * 获得实例类型
	 * 
	 * @return Class 实例类型
	 * @see
	 * @throws
	 */
	public Class getObjectType();

	/**
	 * 是否单列模式
	 * 
	 * @return boolean
	 * @see
	 * @throws
	 */
	public boolean isSingleton();

	/**
	 * 设置是否是单列模
	 * 
	 * @param singleton
	 *            void
	 * @see
	 * @throws
	 */
	public void setSingleton(boolean singleton);
}
