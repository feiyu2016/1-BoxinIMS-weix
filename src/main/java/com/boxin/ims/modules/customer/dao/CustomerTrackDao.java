/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.customer.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.thinkgem.jeesite.common.persistence.BaseDao;
import com.thinkgem.jeesite.common.persistence.BaseDaoImpl;
import com.boxin.ims.modules.customer.entity.CustomerTrack;

/**
 * 客户跟踪DAO接口
 * @author Jakemanse
 * @version 2013-06-07
 */
public interface CustomerTrackDao extends CustomerTrackDaoCustom, CrudRepository<CustomerTrack, Long> {

	@Modifying
	@Query("update CustomerTrack set delFlag='" + CustomerTrack.DEL_FLAG_DELETE + "' where id = ?1")
	public int deleteById(Long id);
	
}

/**
 * DAO自定义接口
 * @author Jakemanse
 */
interface CustomerTrackDaoCustom extends BaseDao<CustomerTrack> {

}

/**
 * DAO自定义接口实现
 * @author Jakemanse
 */
@Component
class CustomerTrackDaoImpl extends BaseDaoImpl<CustomerTrack> implements CustomerTrackDaoCustom {

}
