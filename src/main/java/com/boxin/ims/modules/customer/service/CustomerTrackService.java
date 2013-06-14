/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.customer.service;

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
import com.boxin.ims.modules.customer.entity.CustomerTrack;
import com.boxin.ims.modules.customer.dao.CustomerTrackDao;

/**
 * 客户跟踪Service
 * @author Jakemanse
 * @version 2013-06-07
 */
@Component
@Transactional(readOnly = true)
public class CustomerTrackService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(CustomerTrackService.class);
	
	@Autowired
	private CustomerTrackDao customerTrackDao;
	
	public CustomerTrack get(Long id) {
		return customerTrackDao.findOne(id);
	}
	
	public Page<CustomerTrack> find(Page<CustomerTrack> page, CustomerTrack customerTrack) {
		DetachedCriteria dc = customerTrackDao.createDetachedCriteria();
		if (customerTrack.getUser()!=null && customerTrack.getUser().getId()>0){
			dc.add(Restrictions.eq("user.id", customerTrack.getUser().getId()));
		}
		if (customerTrack.getCustomer()!=null && customerTrack.getCustomer().getId()>0){
			dc.add(Restrictions.eq("customer.id", customerTrack.getCustomer().getId()));
		}
		if (StringUtils.isNotEmpty(customerTrack.getRemarks())){
			dc.add(Restrictions.like("remarks", "%"+customerTrack.getRemarks()+"%"));
		}
		dc.add(Restrictions.eq("delFlag", CustomerTrack.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return customerTrackDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(CustomerTrack customerTrack) {
		if (customerTrack.getContent()!=null){
			customerTrack.setContent(StringEscapeUtils.unescapeHtml4(
					customerTrack.getContent()));
		}
		customerTrackDao.save(customerTrack);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		customerTrackDao.deleteById(id);
	}
	
}
