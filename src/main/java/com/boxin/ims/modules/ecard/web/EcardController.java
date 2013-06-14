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
import com.boxin.ims.modules.ecard.entity.Ecard;
import com.boxin.ims.modules.ecard.entity.OrganInfo;
import com.boxin.ims.modules.ecard.service.EcardService;
import com.boxin.ims.modules.ecard.service.OrganInfoService;
import com.boxin.ims.modules.momarketing.common.QRCodeUtils;

/**
 * 公司活动Controller
 * @author Jakemanse
 * @version 2013-06-10
 */
@Controller
@RequestMapping(value = Global.ADMIN_PATH+"/ecard/ecard")
public class EcardController extends BaseController {

	@Autowired
	private EcardService ecardService;
	
	@Autowired
	private OrganInfoService organInfoService;
	
	@ModelAttribute
	public Ecard get(@RequestParam(required=false) Long id) {
		if (id != null){
			return ecardService.get(id);
		}else{
			return new Ecard();
		}
	}
	
	@RequiresPermissions("ecard:ecard:view")
	@RequestMapping(value = {"list", ""})
	public String list(Ecard ecard, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (!user.isAdmin()){
			ecard.setUser(user);
		}
        Page<Ecard> page = ecardService.find(new Page<Ecard>(request, response), ecard); 
        model.addAttribute("page", page);
		return "modules/ecard/ecardList";
	}

	@RequiresPermissions("ecard:ecard:view")
	@RequestMapping(value = "form")
	public String form(Ecard ecard, Model model,RedirectAttributes redirectAttributes) {
		
		User user = UserUtils.getUser();
		OrganInfo organInfo = 	organInfoService.getByUserId(user.getId());
		if(organInfo == null){
			addMessage(redirectAttributes, "请先建立单位信息!");
		}else{
			ecard.setOrganInfo(organInfo);
		}
		if(ecard.getUser() == null){
			ecard.setUser(user);
		}
		
		
		model.addAttribute("ecard", ecard);
		return "modules/ecard/ecardForm";
	}

	@RequiresPermissions("ecard:ecard:edit")
	@RequestMapping(value = "save")
	public String save(Ecard ecard, Model model, RedirectAttributes redirectAttributes) {
		
		if (!beanValidator(model, ecard)){
			return form(ecard, model,redirectAttributes);
		}
		
		
		ecardService.save(ecard);
		addMessage(redirectAttributes, "保存公司活动'" + ecard.getName() + "'成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/ecard/ecard/?repage";
	}
	
	@RequiresPermissions("ecard:ecard:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		ecardService.delete(id);
		addMessage(redirectAttributes, "删除公司活动成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/ecard/ecard/?repage";
	}

}
