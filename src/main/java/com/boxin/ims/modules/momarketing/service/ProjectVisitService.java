/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.momarketing.service;

import org.hibernate.criterion.DetachedCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.boxin.ims.modules.momarketing.dao.ProjectVisitDao;
import com.boxin.ims.modules.momarketing.entity.ProjectVisit;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;

/**
 * 访问量Service
 * @author Jakemanse
 * @version 2013-05-28
 */
@Component
@Transactional(readOnly = true)
public class ProjectVisitService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(ProjectVisitService.class);
	
	@Autowired
	private ProjectVisitDao projectVisitDao;
	
	public ProjectVisit get(Long id) {
		return projectVisitDao.findOne(id);
	}
	
	public Page<ProjectVisit> find(Page<ProjectVisit> page, ProjectVisit projectVisit) {
		DetachedCriteria dc = projectVisitDao.createDetachedCriteria();
		return projectVisitDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(ProjectVisit projectVisit) {
		projectVisitDao.save(projectVisit);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		projectVisitDao.deleteById(id);
	}
	
}
