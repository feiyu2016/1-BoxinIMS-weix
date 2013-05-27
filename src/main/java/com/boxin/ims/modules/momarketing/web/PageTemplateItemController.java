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
import com.boxin.ims.modules.momarketing.entity.PageTemplateItem;
import com.boxin.ims.modules.momarketing.service.PageTemplateItemService;

/**
 * 项目模板模板实例页Controller
 * @author Jakemanse
 * @version 2013-05-26
 */
@Controller
@RequestMapping(value = Global.ADMIN_PATH+"/mom/pageTemplateItem")
public class PageTemplateItemController extends BaseController {

	@Autowired
	private PageTemplateItemService pageTemplateItemService;
	
	@ModelAttribute
	public PageTemplateItem get(@RequestParam(required=false) Long id) {
		if (id != null){
			return pageTemplateItemService.get(id);
		}else{
			return new PageTemplateItem();
		}
	}
	
	@RequiresPermissions("momarketing:pageTemplateItem:view")
	@RequestMapping(value = {"list", ""})
	public String list(PageTemplateItem pageTemplateItem, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (!user.isAdmin()){
			pageTemplateItem.setUser(user);
		}
        Page<PageTemplateItem> page = pageTemplateItemService.find(new Page<PageTemplateItem>(request, response), pageTemplateItem); 
        model.addAttribute("page", page);
		return "modules/momarketing/pageTemplateItemList";
	}

	@RequiresPermissions("momarketing:pageTemplateItem:view")
	@RequestMapping(value = "form")
	public String form(PageTemplateItem pageTemplateItem, Model model) {
		model.addAttribute("pageTemplateItem", pageTemplateItem);
		return "modules/momarketing/pageTemplateItemForm";
	}

	@RequiresPermissions("momarketing:pageTemplateItem:edit")
	@RequestMapping(value = "save")
	public String save(PageTemplateItem pageTemplateItem, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, pageTemplateItem)){
			return form(pageTemplateItem, model);
		}
		pageTemplateItemService.save(pageTemplateItem);
		addMessage(redirectAttributes, "保存项目模板模板实例页'" + pageTemplateItem.getName() + "'成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/momarketing/pageTemplateItem/?repage";
	}
	
	@RequiresPermissions("momarketing:pageTemplateItem:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		pageTemplateItemService.delete(id);
		addMessage(redirectAttributes, "删除项目模板模板实例页成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/momarketing/pageTemplateItem/?repage";
	}

}
