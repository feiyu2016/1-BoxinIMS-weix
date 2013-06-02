/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.momarketing.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.boxin.ims.modules.momarketing.entity.ProjectVisit;
import com.thinkgem.jeesite.common.persistence.BaseDao;
import com.thinkgem.jeesite.common.persistence.BaseDaoImpl;

/**
 * 访问量DAO接口
 * @author Jakemanse
 * @version 2013-05-28
 */
public interface ProjectVisitDao extends ProjectVisitDaoCustom, CrudRepository<ProjectVisit, Long> {

	@Modifying
	@Query("delete from  ProjectVisit  where id = ?1")
	public int deleteById(Long id);
	
}

/**
 * DAO自定义接口
 * @author Jakemanse
 */
interface ProjectVisitDaoCustom extends BaseDao<ProjectVisit> {

}

/**
 * DAO自定义接口实现
 * @author Jakemanse
 */
@Component
class ProjectVisitDaoImpl extends BaseDaoImpl<ProjectVisit> implements ProjectVisitDaoCustom {

}
