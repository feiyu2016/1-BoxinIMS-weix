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
import com.boxin.ims.modules.momarketing.entity.PageNavigate;
import com.boxin.ims.modules.momarketing.service.PageNavigateService;

/**
 * 项目模板模板页导航Controller
 * @author Jakemanse
 * @version 2013-05-26
 */
@Controller
@RequestMapping(value = Global.ADMIN_PATH+"/mom/pageNavigate")
public class PageNavigateController extends BaseController {

	@Autowired
	private PageNavigateService pageNavigateService;
	
	@ModelAttribute
	public PageNavigate get(@RequestParam(required=false) Long id) {
		if (id != null){
			return pageNavigateService.get(id);
		}else{
			return new PageNavigate();
		}
	}
	
	@RequiresPermissions("momarketing:pageNavigate:view")
	@RequestMapping(value = {"list", ""})
	public String list(PageNavigate pageNavigate, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (!user.isAdmin()){
			pageNavigate.setUser(user);
		}
        Page<PageNavigate> page = pageNavigateService.find(new Page<PageNavigate>(request, response), pageNavigate); 
        model.addAttribute("page", page);
		return "modules/momarketing/pageNavigateList";
	}

	@RequiresPermissions("momarketing:pageNavigate:view")
	@RequestMapping(value = "form")
	public String form(PageNavigate pageNavigate, Model model) {
		model.addAttribute("pageNavigate", pageNavigate);
		return "modules/momarketing/pageNavigateForm";
	}

	@RequiresPermissions("momarketing:pageNavigate:edit")
	@RequestMapping(value = "save")
	public String save(PageNavigate pageNavigate, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, pageNavigate)){
			return form(pageNavigate, model);
		}
		pageNavigateService.save(pageNavigate);
		addMessage(redirectAttributes, "保存项目模板模板页导航'" + pageNavigate.getName() + "'成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/momarketing/pageNavigate/?repage";
	}
	
	@RequiresPermissions("momarketing:pageNavigate:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		pageNavigateService.delete(id);
		addMessage(redirectAttributes, "删除项目模板模板页导航成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/momarketing/pageNavigate/?repage";
	}

}
