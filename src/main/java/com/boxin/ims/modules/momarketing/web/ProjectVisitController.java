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

import com.boxin.framework.base.dao.DaoHelper;
import com.boxin.ims.modules.momarketing.entity.ProjectVisit;
import com.boxin.ims.modules.momarketing.service.ProjectVisitService;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;

/**
 * 访问量Controller
 * @author Jakemanse
 * @version 2013-05-28
 */
//@Controller
//@RequestMapping(value = Global.ADMIN_PATH+"/momarketing/projectVisit")
public class ProjectVisitController extends BaseController {

	@Autowired
	private ProjectVisitService projectVisitService;
	
	@Autowired
	private DaoHelper daoHelper;
	
	@ModelAttribute
	public ProjectVisit get(@RequestParam(required=false) Long id) {
		if (id != null){
			return projectVisitService.get(id);
		}else{
			return new ProjectVisit();
		}
	}
	
	@RequiresPermissions("momarketing:projectVisit:view")
	@RequestMapping(value = {"list", ""})
	public String list(ProjectVisit projectVisit, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<ProjectVisit> page = projectVisitService.find(new Page<ProjectVisit>(request, response), projectVisit); 
        model.addAttribute("page", page);
		return "modules/momarketing/projectVisitList";
	}

	@RequiresPermissions("momarketing:projectVisit:view")
	@RequestMapping(value = "form")
	public String form(ProjectVisit projectVisit, Model model) {
		model.addAttribute("projectVisit", projectVisit);
		return "modules/momarketing/projectVisitForm";
	}

	@RequiresPermissions("momarketing:projectVisit:edit")
	@RequestMapping(value = "save")
	public String save(ProjectVisit projectVisit, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, projectVisit)){
			return form(projectVisit, model);
		}
		projectVisitService.save(projectVisit);
		addMessage(redirectAttributes, "保存访问量'" + projectVisit.getIp() + "'成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/momarketing/projectVisit/?repage";
	}
	
	@RequiresPermissions("momarketing:projectVisit:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		projectVisitService.delete(id);
		addMessage(redirectAttributes, "删除访问量成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/momarketing/projectVisit/?repage";
	}

}
