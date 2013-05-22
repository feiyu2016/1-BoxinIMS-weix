package com.boxin.framework.base.ibatis;




public class DaoFactory {

	/**
	 * 获得IbatisDao
	 * 
	 * @return IbatisDao
	 */
	public static final IbatisDao getIbatisDao() {
		return null;//(IbatisDao) SpringUtils.getBean("ibatisDao");
	}
}
