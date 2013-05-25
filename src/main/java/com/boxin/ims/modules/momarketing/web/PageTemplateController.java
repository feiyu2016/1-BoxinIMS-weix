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
import com.boxin.ims.modules.momarketing.entity.PageTemplate;
import com.boxin.ims.modules.momarketing.service.PageTemplateService;

/**
 * 项目模板Controller
 * @author Jakemanse
 * @version 2013-05-26
 */
@Controller
@RequestMapping(value = Global.ADMIN_PATH+"/momarketing/pageTemplate")
public class PageTemplateController extends BaseController {

	@Autowired
	private PageTemplateService pageTemplateService;
	
	@ModelAttribute
	public PageTemplate get(@RequestParam(required=false) Long id) {
		if (id != null){
			return pageTemplateService.get(id);
		}else{
			return new PageTemplate();
		}
	}
	
	@RequiresPermissions("momarketing:pageTemplate:view")
	@RequestMapping(value = {"list", ""})
	public String list(PageTemplate pageTemplate, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (!user.isAdmin()){
			pageTemplate.setUser(user);
		}
        Page<PageTemplate> page = pageTemplateService.find(new Page<PageTemplate>(request, response), pageTemplate); 
        model.addAttribute("page", page);
		return "modules/momarketing/pageTemplateList";
	}

	@RequiresPermissions("momarketing:pageTemplate:view")
	@RequestMapping(value = "form")
	public String form(PageTemplate pageTemplate, Model model) {
		model.addAttribute("pageTemplate", pageTemplate);
		return "modules/momarketing/pageTemplateForm";
	}

	@RequiresPermissions("momarketing:pageTemplate:edit")
	@RequestMapping(value = "save")
	public String save(PageTemplate pageTemplate, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, pageTemplate)){
			return form(pageTemplate, model);
		}
		pageTemplateService.save(pageTemplate);
		addMessage(redirectAttributes, "保存项目模板'" + pageTemplate.getName() + "'成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/momarketing/pageTemplate/?repage";
	}
	
	@RequiresPermissions("momarketing:pageTemplate:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		pageTemplateService.delete(id);
		addMessage(redirectAttributes, "删除项目模板成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/momarketing/pageTemplate/?repage";
	}

}
