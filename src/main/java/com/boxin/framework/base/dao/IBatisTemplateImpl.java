package com.boxin.framework.base.dao;

import com.boxin.framework.base.ibatis.IbatisDaoImpl;


/**
 * IBatisTemplate
 * 
 * @version 1.0 2010-4-18 上午12:05:50
 * @see
 * @since 1.0
 */
public class IBatisTemplateImpl extends IbatisDaoImpl implements IBatisTemplate {

	protected void checkDaoConfig() {
		// 取消父类中校
	}

	/**
	 * 事务处理
	 * 
	 * @param callback
	 * @return
	 * @throws Exception
	 * @see DaoCallback
	 * @see OpResult
	 */
	public Object execute(final DaoCallback callback) throws Exception {
		return callback.exec(this);
	}
}
