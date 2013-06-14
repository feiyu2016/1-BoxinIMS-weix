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
import com.boxin.ims.modules.momarketing.entity.AboutUs;

/**
 * 关于我们DAO接口
 * @author Jakemanse
 * @version 2013-06-05
 */
public interface AboutUsDao extends AboutUsDaoCustom, CrudRepository<AboutUs, Long> {

	@Modifying
	@Query("update AboutUs set delFlag='" + AboutUs.DEL_FLAG_DELETE + "' where id = ?1")
	public int deleteById(Long id);
	
}

/**
 * DAO自定义接口
 * @author Jakemanse
 */
interface AboutUsDaoCustom extends BaseDao<AboutUs> {

}

/**
 * DAO自定义接口实现
 * @author Jakemanse
 */
@Component
class AboutUsDaoImpl extends BaseDaoImpl<AboutUs> implements AboutUsDaoCustom {

}
