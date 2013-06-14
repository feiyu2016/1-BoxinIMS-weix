/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.ecard.service;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;
import com.boxin.ims.modules.ecard.entity.OrganEvent;
import com.boxin.ims.modules.ecard.dao.OrganEventDao;

/**
 * 公司活动Service
 * @author Jakemanse
 * @version 2013-06-10
 */
@Component
@Transactional(readOnly = true)
public class OrganEventService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(OrganEventService.class);
	
	@Autowired
	private OrganEventDao organEventDao;
	
	public OrganEvent get(Long id) {
		return organEventDao.findOne(id);
	}
	
	public Page<OrganEvent> find(Page<OrganEvent> page, OrganEvent organEvent) {
		DetachedCriteria dc = organEventDao.createDetachedCriteria();
		if (organEvent.getUser()!=null && organEvent.getUser().getId()>0){
			dc.add(Restrictions.eq("user.id", organEvent.getUser().getId()));
		}
		if (StringUtils.isNotEmpty(organEvent.getTitle())){
			dc.add(Restrictions.like("title", "%"+organEvent.getTitle()+"%"));
		}
		if (StringUtils.isNotEmpty(organEvent.getRemarks())){
			dc.add(Restrictions.like("remarks", "%"+organEvent.getRemarks()+"%"));
		}
		dc.add(Restrictions.eq("delFlag", OrganEvent.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return organEventDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(OrganEvent organEvent) {
		
		if (organEvent.getContent()!=null){
			organEvent.setContent(StringEscapeUtils.unescapeHtml4(
					organEvent.getContent()));
		}
		organEventDao.save(organEvent);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		organEventDao.deleteById(id);
	}
	
}
