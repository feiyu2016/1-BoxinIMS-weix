package com.boxin.ims.modules.customer.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boxin.ims.modules.customer.dao.CustomerDao;
import com.boxin.ims.modules.customer.entity.Customer;
import com.boxin.ims.modules.customer.entity.CustomerTrack;
import com.boxin.ims.modules.momarketing.entity.Coupon;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;


@Service
@Transactional(readOnly = true)
public class CustomerService extends BaseService{
	
	@Autowired
	private CustomerDao customerDao;
	
	
	public Customer get(Long id) {
		return customerDao.findOne(id);
	}
	
	
	@Transactional(readOnly = false)
	public void save(Customer customer){
		customerDao.save(customer);
	}
	
	
	@RequiresPermissions("ims:customer:view")
	@RequestMapping(value = {"list", ""})
	public List<Customer> findAllCustomer(){
		List<Customer> cList  =  customerDao.findAllList();
		return cList;
	}
	
	public List<Customer> findCustomerByUserId(Long id){
		List<Customer> cList  =  customerDao.findAllList();
		return cList;
	}
	
	public Page<Customer> find(Page<Customer> page, Customer customer) {
		DetachedCriteria dc = customerDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(customer.getName())){
			dc.add(Restrictions.like("name", "%"+customer.getName()+"%"));
		}
		if (StringUtils.isNotEmpty(customer.getTel())){
			dc.add(Restrictions.like("tel", "%"+customer.getTel()+"%"));
		}
		if (StringUtils.isNotEmpty(customer.getMobile())){
			dc.add(Restrictions.like("mobile", "%"+customer.getMobile()+"%"));
		}
		if (StringUtils.isNotEmpty(customer.getAddress())){
			dc.add(Restrictions.like("address", "%"+customer.getAddress()+"%"));
		}
		
		if(customer.getUser()!= null && customer.getUser().getId() != null){
			dc.add(Restrictions.eq("user.id", customer.getUser().getId()));
		}
		
//		if (customer.getUser()!= null && StringUtils.isNotEmpty(customer.getUser().getName())){
//			dc.add(Restrictions.like("user.name", "%"+customer.getUser().getName()+"%"));
//		}
		if (StringUtils.isNotEmpty(customer.getCompanyName())){
			dc.add(Restrictions.like("companyName", "%"+customer.getCompanyName()+"%"));
		}
		dc.add(Restrictions.eq("delFlag", Coupon.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return customerDao.find(page, dc);
	}
	

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	
	
	
	
 
}
