/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.customer.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.boxin.ims.modules.customer.entity.Customer;
import com.boxin.ims.modules.customer.entity.CustomerTrack;
import com.boxin.ims.modules.customer.service.CustomerService;
import com.boxin.ims.modules.customer.service.CustomerTrackService;

/**
 * 客户跟踪Controller
 * @author Jakemanse
 * @version 2013-06-07
 */
@Controller
@RequestMapping(value = Global.ADMIN_PATH+"/customer/ct")
public class CustomerTrackController extends BaseController {

	@Autowired
	private CustomerTrackService customerTrackService;
	
	@Autowired
	private CustomerService customerService;
	
	@ModelAttribute
	public CustomerTrack get(@RequestParam(required=false) Long id) {
		if (id != null){
			return customerTrackService.get(id);
		}else{
			return new CustomerTrack();
		}
	}
	
	@RequiresPermissions("customer:customerTrack:view")
	@RequestMapping(value = {"list", ""})
	public String list(CustomerTrack customerTrack, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		 String names = user.getRoleNames();
		 customerTrack.setUser(user);
		if(names.indexOf("CEO") != -1  || names.indexOf("系统管理员") != -1){
			customerTrack.setUser(null);
		 } 
		
		Customer customer = new Customer();
		customer.setId(Long.parseLong(request.getParameter("cid")));
		customerTrack.setCustomer(customer);
        Page<CustomerTrack> page = customerTrackService.find(new Page<CustomerTrack>(request, response), customerTrack); 
        model.addAttribute("page", page);
        request.setAttribute("customer", customer);
		return "modules/customer/customerTrackList";
	}

	@RequiresPermissions("customer:customerTrack:view")
	@RequestMapping(value = "form")
	public String form(CustomerTrack customerTrack, Model model ) {
		if(customerTrack.getUser() == null){
			User user = UserUtils.getUser();
			customerTrack.setUser(user);
		}
		Customer customer = customerService.get(customerTrack.getCustomer().getId());
		customerTrack.setCustomer(customer);
		model.addAttribute("customerTrack", customerTrack);
		model.addAttribute("customer", customer);
		return "modules/customer/customerTrackForm";
	}

	@RequiresPermissions("customer:customerTrack:edit")
	@RequestMapping(value = "save")
	public String save(CustomerTrack customerTrack, Model model, RedirectAttributes redirectAttributes ) {
		if (!beanValidator(model, customerTrack)){
			return form(customerTrack, model);
		}
		customerTrackService.save(customerTrack);
		addMessage(redirectAttributes, "保存客户跟踪'"+ "'成功");
		return "redirect:"+Global.ADMIN_PATH+"/customer/ct?cid="+customerTrack.getCustomer().getId()+"&repage";
	}
	
	@RequiresPermissions("customer:customerTrack:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		customerTrackService.delete(id);
		addMessage(redirectAttributes, "删除客户跟踪成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/customer/customerTrack/?repage";
	}

}
