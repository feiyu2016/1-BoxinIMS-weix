/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.momarketing.web;

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
import com.boxin.ims.modules.momarketing.entity.AboutUs;
import com.boxin.ims.modules.momarketing.service.AboutUsService;

/**
 * 关于我们Controller
 * @author Jakemanse
 * @version 2013-06-05
 */
@Controller
@RequestMapping(value = Global.ADMIN_PATH+"/mom/aboutUs")
public class AboutUsController extends BaseController {

	@Autowired
	private AboutUsService aboutUsService;
	
	@ModelAttribute
	public AboutUs get(@RequestParam(required=false) Long id) {
		if (id != null){
			return aboutUsService.get(id);
		}else{
			return new AboutUs();
		}
	}
	
	@RequiresPermissions("momarketing:aboutUs:view")
	@RequestMapping(value = {"list", ""})
	public String list(AboutUs aboutUs, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (!user.isAdmin()){
			aboutUs.setUser(user);
		}
        Page<AboutUs> page = aboutUsService.find(new Page<AboutUs>(request, response), aboutUs); 
        model.addAttribute("page", page);
		return "modules/momarketing/aboutUsList";
	}

	@RequiresPermissions("momarketing:aboutUs:view")
	@RequestMapping(value = "form")
	public String form(AboutUs aboutUs, Model model) {
		AboutUs temp = aboutUsService.getByProjectId(aboutUs.getProject().getId());
		if(temp != null) {
			aboutUs = temp;
		}else{
			aboutUs.setUser(UserUtils.getUser());
		}
		model.addAttribute("aboutUs", aboutUs);
		
		return "modules/momarketing/aboutUsForm";
	}

	@RequiresPermissions("momarketing:aboutUs:edit")
	@RequestMapping(value = "save")
	public String save(AboutUs aboutUs, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, aboutUs)){
			return form(aboutUs, model);
		}
		aboutUsService.save(aboutUs);
		addMessage(redirectAttributes, "保存关于我们'" + aboutUs.getName() + "'成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/momarketing/aboutUs/?repage";
	}
	
	@RequiresPermissions("momarketing:aboutUs:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		aboutUsService.delete(id);
		addMessage(redirectAttributes, "删除关于我们成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/momarketing/aboutUs/?repage";
	}

}
