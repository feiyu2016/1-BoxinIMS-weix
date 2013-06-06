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
import com.boxin.ims.modules.momarketing.entity.CompanyNews;
import com.boxin.ims.modules.momarketing.service.CompanyNewsService;

/**
 * 公司动态Controller
 * @author Jakemanse
 * @version 2013-05-28
 */
@Controller
@RequestMapping(value = Global.ADMIN_PATH+"/mom/comnews")
public class CompanyNewsController extends BaseController {

	@Autowired
	private CompanyNewsService companyNewsService;
	
	@ModelAttribute
	public CompanyNews get(@RequestParam(required=false) Long id) {
		if (id != null){
			return companyNewsService.get(id);
		}else{
			return new CompanyNews();
		}
	}
	
	@RequiresPermissions("momarketing:companyNews:view")
	@RequestMapping(value = {"list", ""})
	public String list(CompanyNews companyNews, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (!user.isAdmin()){
			companyNews.setUser(user);
		}
        Page<CompanyNews> page = companyNewsService.find(new Page<CompanyNews>(request, response), companyNews); 
        model.addAttribute("page", page);
		return "modules/momarketing/companyNewsList";
	}

	@RequiresPermissions("momarketing:companyNews:view")
	@RequestMapping(value = "form")
	public String form(CompanyNews companyNews, Model model) {
		CompanyNews cnews = companyNewsService.getByProjectId(companyNews.getProject().getId());
		if(cnews!=null ){
			companyNews = cnews;
		}else{
			companyNews.setUser(UserUtils.getUser());
		}
		model.addAttribute("companyNews", companyNews);
		return "modules/momarketing/companyNewsForm";
	}

	@RequiresPermissions("momarketing:companyNews:edit")
	@RequestMapping(value = "save")
	public String save(CompanyNews companyNews, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, companyNews)){
			return form(companyNews, model);
		}
		companyNewsService.save(companyNews);
		addMessage(redirectAttributes, "保存公司动态'" + companyNews.getName() + "'成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/momarketing/companyNews/?repage";
	}
	
	@RequiresPermissions("momarketing:companyNews:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		companyNewsService.delete(id);
		addMessage(redirectAttributes, "删除公司动态成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/momarketing/companyNews/?repage";
	}

}
