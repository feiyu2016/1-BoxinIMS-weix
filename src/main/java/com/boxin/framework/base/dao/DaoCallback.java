package com.boxin.framework.base.dao;



public interface DaoCallback {

	Object exec(IBatisTemplate template) throws Exception;
}
