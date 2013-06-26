/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.customer.service;

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
import com.boxin.ims.modules.customer.entity.CustomerCase;
import com.boxin.ims.modules.customer.dao.CustomerCaseDao;

/**
 * 案例展示Service
 * @author Jakemanse
 * @version 2013-06-16
 */
@Component
@Transactional(readOnly = true)
public class CustomerCaseService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(CustomerCaseService.class);
	
	@Autowired
	private CustomerCaseDao customerCaseDao;
	
	public CustomerCase get(Long id) {
		return customerCaseDao.findOne(id);
	}
	
	public Page<CustomerCase> find(Page<CustomerCase> page, CustomerCase customerCase) {
		DetachedCriteria dc = customerCaseDao.createDetachedCriteria();
		if (customerCase.getUser()!=null && customerCase.getUser().getId()>0){
			dc.add(Restrictions.eq("user.id", customerCase.getUser().getId()));
		}
		if (StringUtils.isNotEmpty(customerCase.getName())){
			dc.add(Restrictions.like("name", "%"+customerCase.getName()+"%"));
		}
		if (StringUtils.isNotEmpty(customerCase.getRemarks())){
			dc.add(Restrictions.like("remarks", "%"+customerCase.getRemarks()+"%"));
		}
		dc.add(Restrictions.eq("delFlag", CustomerCase.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return customerCaseDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(CustomerCase customerCase) {
		customerCaseDao.save(customerCase);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		customerCaseDao.deleteById(id);
	}
	
}
