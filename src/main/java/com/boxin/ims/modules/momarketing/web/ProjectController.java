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

import com.boxin.ims.modules.momarketing.entity.Project;
import com.boxin.ims.modules.momarketing.entity.QRCode;
import com.boxin.ims.modules.momarketing.service.ProjectService;
import com.boxin.ims.modules.momarketing.service.QrCodeService;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * 移动营销项目Controller
 * @author Jakemanse
 * @version 2013-05-25
 */
@Controller
@RequestMapping(value = Global.ADMIN_PATH+"/mom/project")
public class ProjectController extends BaseController {

	@Autowired
	private ProjectService projectService;
	@Autowired
	private QrCodeService qrCodeService;
	
	@ModelAttribute
	public Project get(@RequestParam(required=false) Long id) {
		if (id != null){
			return projectService.get(id);
		}else{
			return new Project();
		}
	}
	
	@RequiresPermissions("momarketing:project:view")
	@RequestMapping(value = {"list", ""})
	public String list(Project project, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (!user.isAdmin()){
			project.setUser(user);
		}
        Page<Project> page = projectService.find(new Page<Project>(request, response), project); 
        model.addAttribute("page", page);
		return "modules/momarketing/projectList";
	}

	@RequiresPermissions("momarketing:project:view")
	@RequestMapping(value = "form")
	public String form(Project project, Model model) {
		model.addAttribute("project", project);
		return "modules/momarketing/projectForm";
	}

	@RequiresPermissions("momarketing:project:edit")
	@RequestMapping(value = "save")
	public String save(Project project, Model model, RedirectAttributes redirectAttributes) {
		
		//生成二维码
		
		QRCode qrCode = new QRCode();
		
		
		qrCodeService.save(qrCode);
		
		project.setUser(UserUtils.getUser());
		if (!beanValidator(model, project)){
			return form(project, model);
		}
		projectService.save(project);
		addMessage(redirectAttributes, "保存移动营销项目'" + project.getName() + "'成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/momarketing/project/?repage";
	}
	
	@RequiresPermissions("momarketing:project:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		projectService.delete(id);
		addMessage(redirectAttributes, "删除移动营销项目成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/momarketing/project/?repage";
	}

}
