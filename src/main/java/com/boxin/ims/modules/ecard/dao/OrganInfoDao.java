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
import com.boxin.ims.modules.ecard.entity.OrganInfo;

/**
 * 单位信息DAO接口
 * @author Jakemanse
 * @version 2013-06-10
 */
public interface OrganInfoDao extends OrganInfoDaoCustom, CrudRepository<OrganInfo, Long> {

	@Modifying
	@Query("update OrganInfo set delFlag='" + OrganInfo.DEL_FLAG_DELETE + "' where id = ?1")
	public int deleteById(Long id);
	
}

/**
 * DAO自定义接口
 * @author Jakemanse
 */
interface OrganInfoDaoCustom extends BaseDao<OrganInfo> {

}

/**
 * DAO自定义接口实现
 * @author Jakemanse
 */
@Component
class OrganInfoDaoImpl extends BaseDaoImpl<OrganInfo> implements OrganInfoDaoCustom {

}
