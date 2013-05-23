package com.boxin.ims.modules.customer.web;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boxin.framework.base.dao.DaoHelper;
import com.boxin.ims.modules.customer.entity.Customer;
import com.boxin.ims.modules.customer.service.CustomerService;
import com.google.common.collect.Lists;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.Area;
import com.thinkgem.jeesite.modules.sys.entity.Menu;

/**
 * @author Jakemanse
 *
 */

@Controller
@RequestMapping(value = Global.ADMIN_PATH+"/customer")
public class CustomerController extends BaseController {
	
	@Autowired
	DaoHelper daoHelper;
	
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
        model.addAttribute("list", sourcelist);
		return "modules/ims/customerList";
	}
	
	@RequiresPermissions("ims:customer:view")
	@RequestMapping(value = "form")
	public String form(Customer customer, Model model) {
		return "modules/ims/customerForm";
	}
	
	
	
	@RequiresPermissions("ims:customer:edit")
	@RequestMapping(value = "save")
	public String save(Customer customer, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, customer)){
			return form(customer, model);
		}
		customerService.save(customer);
		addMessage(redirectAttributes, "保存区域'" + customer.getName() + "'成功");
		return "redirect:"+Global.ADMIN_PATH+"/customer";
	}

	
	
}
