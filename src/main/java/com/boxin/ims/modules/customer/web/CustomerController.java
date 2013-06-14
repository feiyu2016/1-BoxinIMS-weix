package com.boxin.ims.modules.customer.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boxin.framework.base.dao.DaoHelper;
import com.boxin.ims.modules.customer.entity.Customer;
import com.boxin.ims.modules.customer.service.CustomerService;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

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
	public String list(Customer customer,  HttpServletRequest request, HttpServletResponse response,  Model model) {
//		List<Customer> list = Lists.newArrayList();
		if(customer.getUser() == null){
			User user = UserUtils.getUser();
			String names = user.getRoleNames();
			customer.setUser(user);
			if(names.indexOf("CEO") != -1  || names.indexOf("系统管理员") != -1){
				customer.setUser(null);
			} 
			
		} 
		 
		Page<Customer> page = customerService.find(new Page<Customer>(request, response), customer); 
        //model.addAttribute("list", sourcelist);
        
        
       
        model.addAttribute("page", page);
        
        
        
		return "modules/ims/customerList";
	}
	
	@RequiresPermissions("ims:customer:view")
	@RequestMapping(value = "form")
	public String form(Customer customer, Model model) {
		if(customer != null && customer.getId() != null){
			customer = customerService.get(customer.getId());
		}
		model.addAttribute("customer", customer);
		return "modules/ims/customerForm";
	}
	
	
	
	@RequiresPermissions("ims:customer:edit")
	@RequestMapping(value = "save")
	public String save(Customer customer, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, customer)){
			return form(customer, model);
		}
		User user = new UserUtils().getUser();
		customer.setUser(user);
		customerService.save(customer);
		addMessage(redirectAttributes, "保存区域'" + customer.getName() + "'成功");
		return "redirect:"+Global.ADMIN_PATH+"/customer";
	}

	
	
}
