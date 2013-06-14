/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.ecard.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.thinkgem.jeesite.common.persistence.BaseDao;
import com.thinkgem.jeesite.common.persistence.BaseDaoImpl;
import com.boxin.ims.modules.ecard.entity.OrganEvent;

/**
 * 公司活动DAO接口
 * @author Jakemanse
 * @version 2013-06-10
 */
public interface OrganEventDao extends OrganEventDaoCustom, CrudRepository<OrganEvent, Long> {

	@Modifying
	@Query("update OrganEvent set delFlag='" + OrganEvent.DEL_FLAG_DELETE + "' where id = ?1")
	public int deleteById(Long id);
	
}

/**
 * DAO自定义接口
 * @author Jakemanse
 */
interface OrganEventDaoCustom extends BaseDao<OrganEvent> {

}

/**
 * DAO自定义接口实现
 * @author Jakemanse
 */
@Component
class OrganEventDaoImpl extends BaseDaoImpl<OrganEvent> implements OrganEventDaoCustom {

}
