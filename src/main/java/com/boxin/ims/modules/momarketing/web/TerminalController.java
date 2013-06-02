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
import com.boxin.ims.modules.momarketing.entity.Terminal;
import com.boxin.ims.modules.momarketing.service.TerminalService;

/**
 * 手动终端Controller
 * @author Jakemanse
 * @version 2013-05-28
 */
@Controller
@RequestMapping(value = Global.ADMIN_PATH+"/momarketing/terminal")
public class TerminalController extends BaseController {

	@Autowired
	private TerminalService terminalService;
	
	@ModelAttribute
	public Terminal get(@RequestParam(required=false) Long id) {
		if (id != null){
			return terminalService.get(id);
		}else{
			return new Terminal();
		}
	}
	
	@RequiresPermissions("momarketing:terminal:view")
	@RequestMapping(value = {"list", ""})
	public String list(Terminal terminal, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (!user.isAdmin()){
			terminal.setUser(user);
		}
        Page<Terminal> page = terminalService.find(new Page<Terminal>(request, response), terminal); 
        model.addAttribute("page", page);
		return "modules/momarketing/terminalList";
	}

	@RequiresPermissions("momarketing:terminal:view")
	@RequestMapping(value = "form")
	public String form(Terminal terminal, Model model) {
		model.addAttribute("terminal", terminal);
		return "modules/momarketing/terminalForm";
	}

	@RequiresPermissions("momarketing:terminal:edit")
	@RequestMapping(value = "save")
	public String save(Terminal terminal, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, terminal)){
			return form(terminal, model);
		}
		terminalService.save(terminal);
		addMessage(redirectAttributes, "保存手动终端'" + terminal.getName() + "'成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/momarketing/terminal/?repage";
	}
	
	@RequiresPermissions("momarketing:terminal:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		terminalService.delete(id);
		addMessage(redirectAttributes, "删除手动终端成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/momarketing/terminal/?repage";
	}

}
