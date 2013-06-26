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
import com.boxin.ims.modules.wechat.entity.NewsReply;

/**
 * 图文富内容回复DAO接口
 * @author Jakemanse
 * @version 2013-06-21
 */
public interface NewsReplyDao extends NewsReplyDaoCustom, CrudRepository<NewsReply, Long> {

	@Modifying
	@Query("update NewsReply set delFlag='" + NewsReply.DEL_FLAG_DELETE + "' where id = ?1")
	public int deleteById(Long id);
	
}

/**
 * DAO自定义接口
 * @author Jakemanse
 */
interface NewsReplyDaoCustom extends BaseDao<NewsReply> {

}

/**
 * DAO自定义接口实现
 * @author Jakemanse
 */
@Component
class NewsReplyDaoImpl extends BaseDaoImpl<NewsReply> implements NewsReplyDaoCustom {

}
