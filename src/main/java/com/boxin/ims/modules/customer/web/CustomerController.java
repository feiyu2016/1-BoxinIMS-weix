package com.boxin.ims.modules.customer.web;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boxin.ims.modules.customer.entity.Customer;
import com.boxin.ims.modules.customer.service.CustomerService;
import com.google.common.collect.Lists;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.Menu;

/**
 * @author Jakemanse
 *
 */

@Controller
@RequestMapping(value = Global.ADMIN_PATH+"/cust/cust")
public class CustomerController extends BaseController {
	
	public CustomerController() {
		System.out.println("Loading..");
	}
	@Autowired
	private CustomerService customerService;
	
	
	@RequiresPermissions("ims:customer:view")
	@RequestMapping(value = {"list", ""})
	public String list(Customer customer, Model model) {
		List<Customer> list = Lists.newArrayList();
		List<Customer> sourcelist = customerService.findAllCustomer();
		//Menu.sortList(list, sourcelist, 1L);
        model.addAttribute("list", sourcelist);
		return "modules/ims/customerList";
	}
	
	@RequiresPermissions("ims:customer:view")
	@RequestMapping(value = "form")
	public String form(Customer customer, Model model) {
		return "modules/ims/customerForm";
	}

	
	
}
