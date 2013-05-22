package com.boxin.framework.base.ibatis;

import java.sql.Connection;

/**
 * 供DaoHelper调用的callback接口br>
 */
public interface ConnectionCallback {
	Object exec(Connection conn) throws Exception;
}
