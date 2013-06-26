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
import com.boxin.ims.modules.customer.entity.CustomerCase;
import com.boxin.ims.modules.customer.service.CustomerCaseService;

/**
 * 案例展示Controller
 * @author Jakemanse
 * @version 2013-06-16
 */
@Controller
@RequestMapping(value = Global.ADMIN_PATH+"/customer/customerCase")
public class CustomerCaseController extends BaseController {

	@Autowired
	private CustomerCaseService customerCaseService;
	
	@ModelAttribute
	public CustomerCase get(@RequestParam(required=false) Long id) {
		if (id != null){
			return customerCaseService.get(id);
		}else{
			return new CustomerCase();
		}
	}
	
	@RequiresPermissions("customer:customerCase:view")
	@RequestMapping(value = {"list", ""})
	public String list(CustomerCase customerCase, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (!user.isAdmin()){
			customerCase.setUser(user);
		}
        Page<CustomerCase> page = customerCaseService.find(new Page<CustomerCase>(request, response), customerCase); 
        model.addAttribute("page", page);
		return "modules/customer/customerCaseList";
	}

	@RequiresPermissions("customer:customerCase:view")
	@RequestMapping(value = "form")
	public String form(CustomerCase customerCase, Model model) {
		model.addAttribute("customerCase", customerCase);
		return "modules/customer/customerCaseForm";
	}

	@RequiresPermissions("customer:customerCase:edit")
	@RequestMapping(value = "save")
	public String save(CustomerCase customerCase, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, customerCase)){
			return form(customerCase, model);
		}
		customerCaseService.save(customerCase);
		addMessage(redirectAttributes, "保存案例展示'" + customerCase.getName() + "'成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/customer/customerCase/?repage";
	}
	
	@RequiresPermissions("customer:customerCase:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		customerCaseService.delete(id);
		addMessage(redirectAttributes, "删除案例展示成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/customer/customerCase/?repage";
	}

}
