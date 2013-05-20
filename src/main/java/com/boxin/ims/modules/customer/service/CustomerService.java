package com.boxin.ims.modules.customer.service;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boxin.ims.modules.customer.dao.CustomerDao;
import com.boxin.ims.modules.customer.entity.Customer;
import com.thinkgem.jeesite.common.service.BaseService;


@Service
@Transactional(readOnly = true)
public class CustomerService extends BaseService{
	
	@Autowired
	private CustomerDao customerDao;
	
	
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
	

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	
	
	
	
 
}
