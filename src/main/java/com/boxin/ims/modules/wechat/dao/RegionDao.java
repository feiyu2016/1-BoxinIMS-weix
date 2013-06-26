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
import com.boxin.ims.modules.wechat.entity.Region;

/**
 * 天气预报的区域码表DAO接口
 * @author Jakemanse
 * @version 2013-06-17
 */
public interface RegionDao extends RegionDaoCustom, CrudRepository<Region, Long> {

	@Modifying
	@Query("update Region set delFlag='" + Region.DEL_FLAG_DELETE + "' where id = ?1")
	public int deleteById(Long id);
	
}

/**
 * DAO自定义接口
 * @author Jakemanse
 */
interface RegionDaoCustom extends BaseDao<Region> {

}

/**
 * DAO自定义接口实现
 * @author Jakemanse
 */
@Component
class RegionDaoImpl extends BaseDaoImpl<Region> implements RegionDaoCustom {

}
