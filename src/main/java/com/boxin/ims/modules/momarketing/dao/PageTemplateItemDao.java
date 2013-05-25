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
import com.boxin.ims.modules.momarketing.entity.PageTemplateItem;

/**
 * 项目模板模板实例页DAO接口
 * @author Jakemanse
 * @version 2013-05-26
 */
public interface PageTemplateItemDao extends PageTemplateItemDaoCustom, CrudRepository<PageTemplateItem, Long> {

	@Modifying
	@Query("update PageTemplateItem set delFlag='" + PageTemplateItem.DEL_FLAG_DELETE + "' where id = ?1")
	public int deleteById(Long id);
	
}

/**
 * DAO自定义接口
 * @author Jakemanse
 */
interface PageTemplateItemDaoCustom extends BaseDao<PageTemplateItem> {

}

/**
 * DAO自定义接口实现
 * @author Jakemanse
 */
@Component
class PageTemplateItemDaoImpl extends BaseDaoImpl<PageTemplateItem> implements PageTemplateItemDaoCustom {

}
