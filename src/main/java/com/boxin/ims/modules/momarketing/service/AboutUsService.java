/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.momarketing.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.boxin.ims.modules.momarketing.dao.AboutUsDao;
import com.boxin.ims.modules.momarketing.entity.AboutUs;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;

/**
 * 关于我们Service
 * @author Jakemanse
 * @version 2013-06-05
 */
@Component
@Transactional(readOnly = true)
public class AboutUsService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(AboutUsService.class);
	
	@Autowired
	private AboutUsDao aboutUsDao;
	
	public AboutUs get(Long id) {
		return aboutUsDao.findOne(id);
	}
	
	public AboutUs getByProjectId(Long pid){
		List<AboutUs>  aboutList = aboutUsDao.find(" from AboutUs where project.id = ? ", pid);
		if(aboutList!=null && !aboutList.isEmpty()){
			return aboutList.get(0);
		}
		return null;
	}
	
	public Page<AboutUs> find(Page<AboutUs> page, AboutUs aboutUs) {
		DetachedCriteria dc = aboutUsDao.createDetachedCriteria();
		if (aboutUs.getUser()!=null && aboutUs.getUser().getId()>0){
			dc.add(Restrictions.eq("user.id", aboutUs.getUser().getId()));
		}
		if (StringUtils.isNotEmpty(aboutUs.getName())){
			dc.add(Restrictions.like("name", "%"+aboutUs.getName()+"%"));
		}
		if (StringUtils.isNotEmpty(aboutUs.getRemarks())){
			dc.add(Restrictions.like("remarks", "%"+aboutUs.getRemarks()+"%"));
		}
		dc.add(Restrictions.eq("delFlag", AboutUs.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return aboutUsDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(AboutUs aboutUs) {
		aboutUsDao.save(aboutUs);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		aboutUsDao.deleteById(id);
	}
	
}
