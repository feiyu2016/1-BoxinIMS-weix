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
import com.boxin.ims.modules.momarketing.entity.GuestBook;
import com.boxin.ims.modules.momarketing.dao.GuestBookDao;

/**
 * 留言Service
 * @author Jakemanse
 * @version 2013-05-28
 */
@Component
@Transactional(readOnly = true)
public class GuestBookService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(GuestBookService.class);
	
	@Autowired
	private GuestBookDao guestBookDao;
	
	public GuestBook get(Long id) {
		return guestBookDao.findOne(id);
	}
	
	public Page<GuestBook> find(Page<GuestBook> page, GuestBook guestBook) {
		DetachedCriteria dc = guestBookDao.createDetachedCriteria();
		if (guestBook.getProject()!=null && guestBook.getProject().getId()>0){
		}
		if (StringUtils.isNotEmpty(guestBook.getContent())){
			dc.add(Restrictions.like("content", "%"+guestBook.getContent()+"%"));
		}
		dc.addOrder(Order.desc("id"));
		return guestBookDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(GuestBook guestBook) {
		guestBookDao.save(guestBook);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		guestBookDao.deleteById(id);
	}
	
}
