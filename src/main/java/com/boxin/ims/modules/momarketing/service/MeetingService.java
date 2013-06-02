/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.momarketing.service;

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
import com.boxin.ims.modules.momarketing.entity.Meeting;
import com.boxin.ims.modules.momarketing.dao.MeetingDao;

/**
 * 产品Service
 * @author Jakemanse
 * @version 2013-05-25
 */
//@Component
//@Transactional(readOnly = true)
public class MeetingService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(MeetingService.class);
	
	@Autowired
	private MeetingDao meetingDao;
	
	public Meeting get(Long id) {
		return meetingDao.findOne(id);
	}
	
	public Page<Meeting> find(Page<Meeting> page, Meeting meeting) {
		DetachedCriteria dc = meetingDao.createDetachedCriteria();
		if (meeting.getUser()!=null && meeting.getUser().getId()>0){
			dc.add(Restrictions.eq("user.id", meeting.getUser().getId()));
		}
		if (StringUtils.isNotEmpty(meeting.getName())){
			dc.add(Restrictions.like("name", "%"+meeting.getName()+"%"));
		}
		if (StringUtils.isNotEmpty(meeting.getRemarks())){
			dc.add(Restrictions.like("remarks", "%"+meeting.getRemarks()+"%"));
		}
		dc.add(Restrictions.eq("delFlag", Meeting.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return meetingDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(Meeting meeting) {
		meetingDao.save(meeting);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		meetingDao.deleteById(id);
	}
	
}
