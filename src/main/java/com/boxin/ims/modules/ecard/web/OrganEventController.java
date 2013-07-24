/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.ecard.web;

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
import com.boxin.ims.modules.ecard.entity.OrganEvent;
import com.boxin.ims.modules.ecard.entity.OrganInfo;
import com.boxin.ims.modules.ecard.service.OrganEventService;
import com.boxin.ims.modules.ecard.service.OrganInfoService;

/**
 * 公司活动Controller
 * @author Jakemanse
 * @version 2013-06-10
 */
@Controller
@RequestMapping(value = Global.ADMIN_PATH+"/ecard/organEvent")
public class OrganEventController extends BaseController {

	@Autowired
	private OrganEventService organEventService;
	
	@Autowired
	private OrganInfoService organInfoService;
	
	@ModelAttribute
	public OrganEvent get(@RequestParam(required=false) Long id) {
		if (id != null){
			return organEventService.get(id);
		}else{
			return new OrganEvent();
		}
	}
	
	@RequiresPermissions("ecard:organEvent:view")
	@RequestMapping(value = {"list", ""})
	public String list(OrganEvent organEvent, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (!user.isAdmin()){
			organEvent.setUser(user);
		}
        Page<OrganEvent> page = organEventService.find(new Page<OrganEvent>(request, response), organEvent); 
        model.addAttribute("page", page);
		return "modules/ecard/organEventList";
	}

	@RequiresPermissions("ecard:organEvent:view")
	@RequestMapping(value = "form")
	public String form(OrganEvent organEvent, Model model,RedirectAttributes redirectAttributes) {
		User user = UserUtils.getUser();
		OrganInfo organInfo = 	organInfoService.getByUserId(user.getId());
		if(organInfo == null){
			addMessage(redirectAttributes, "请先建立单位信息!");
		}else{
			organEvent.setOrganInfo(organInfo);
		}
		if(organEvent.getUser() == null){
			organEvent.setUser(user);
		}
		model.addAttribute("organEvent", organEvent);
		return "modules/ecard/organEventForm";
	}

	@RequiresPermissions("ecard:organEvent:edit")
	@RequestMapping(value = "save")
	public String save(@RequestParam(value="organEvent",required=false) OrganEvent organEvent, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, organEvent)){
			return form(organEvent, model,redirectAttributes);
		}
		organEventService.save(organEvent);
		addMessage(redirectAttributes, "保存公司活动'" + organEvent.getTitle() + "'成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/ecard/organEvent/?repage";
	}
	
	@RequiresPermissions("ecard:organEvent:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		organEventService.delete(id);
		addMessage(redirectAttributes, "删除公司活动成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/ecard/organEvent/?repage";
	}

}
