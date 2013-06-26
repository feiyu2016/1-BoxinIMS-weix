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
import com.boxin.ims.modules.wechat.entity.WechatWelcome;

/**
 * 欢迎词DAO接口
 * @author Jakemanse
 * @version 2013-06-20
 */
public interface WechatWelcomeDao extends WechatWelcomeDaoCustom, CrudRepository<WechatWelcome, Long> {

	@Modifying
	@Query("update WechatWelcome set delFlag='" + WechatWelcome.DEL_FLAG_DELETE + "' where id = ?1")
	public int deleteById(Long id);
	
}

/**
 * DAO自定义接口
 * @author Jakemanse
 */
interface WechatWelcomeDaoCustom extends BaseDao<WechatWelcome> {

}

/**
 * DAO自定义接口实现
 * @author Jakemanse
 */
@Component
class WechatWelcomeDaoImpl extends BaseDaoImpl<WechatWelcome> implements WechatWelcomeDaoCustom {

}
