/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.momarketing.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.thinkgem.jeesite.common.persistence.BaseDao;
import com.thinkgem.jeesite.common.persistence.BaseDaoImpl;
import com.boxin.ims.modules.momarketing.entity.PageNavigate;

/**
 * 项目模板模板页导航DAO接口
 * @author Jakemanse
 * @version 2013-05-26
 */
public interface PageNavigateDao extends PageNavigateDaoCustom, CrudRepository<PageNavigate, Long> {

	@Modifying
	@Query("update PageNavigate set delFlag='" + PageNavigate.DEL_FLAG_DELETE + "' where id = ?1")
	public int deleteById(Long id);
	
}

/**
 * DAO自定义接口
 * @author Jakemanse
 */
interface PageNavigateDaoCustom extends BaseDao<PageNavigate> {

}

/**
 * DAO自定义接口实现
 * @author Jakemanse
 */
@Component
class PageNavigateDaoImpl extends BaseDaoImpl<PageNavigate> implements PageNavigateDaoCustom {

}
