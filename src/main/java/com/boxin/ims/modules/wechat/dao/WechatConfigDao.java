/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.wechat.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.thinkgem.jeesite.common.persistence.BaseDao;
import com.thinkgem.jeesite.common.persistence.BaseDaoImpl;
import com.boxin.ims.modules.wechat.entity.WechatConfig;

/**
 * 微信上下行数据交互DAO接口
 * @author Jakemanse
 * @version 2013-06-19
 */
public interface WechatConfigDao extends WechatConfigDaoCustom, CrudRepository<WechatConfig, Long> {

	@Modifying
	@Query("update WechatConfig set delFlag='" + WechatConfig.DEL_FLAG_DELETE + "' where id = ?1")
	public int deleteById(Long id);
	
}

/**
 * DAO自定义接口
 * @author Jakemanse
 */
interface WechatConfigDaoCustom extends BaseDao<WechatConfig> {

}

/**
 * DAO自定义接口实现
 * @author Jakemanse
 */
@Component
class WechatConfigDaoImpl extends BaseDaoImpl<WechatConfig> implements WechatConfigDaoCustom {

}
