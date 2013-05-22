package com.boxin.framework.base.dao;

import com.boxin.framework.base.ibatis.IbatisDao;

/**
 * IBatisTemplate
 * 
 * @version 1.0 2010-4-18 上午12:05:50
 * @see
 * @since 1.0
 */
public interface IBatisTemplate extends IbatisDao {

	public Object execute(final DaoCallback callback) throws Exception;

}
