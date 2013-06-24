/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.wechat.web;

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
import com.boxin.ims.modules.wechat.entity.Region;
import com.boxin.ims.modules.wechat.service.RegionService;

/**
 * 天气预报的区域码表Controller
 * @author Jakemanse
 * @version 2013-06-17
 */
@Controller
@RequestMapping(value = Global.ADMIN_PATH+"/wechat/region")
public class RegionController extends BaseController {

	@Autowired
	private RegionService regionService;
	
	@ModelAttribute
	public Region get(@RequestParam(required=false) Long id) {
		if (id != null){
			return regionService.get(id);
		}else{
			return new Region();
		}
	}
	
	@RequiresPermissions("wechat:region:view")
	@RequestMapping(value = {"list", ""})
	public String list(Region region, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<Region> page = regionService.find(new Page<Region>(request, response), region); 
        model.addAttribute("page", page);
		return "modules/wechat/regionList";
	}

	@RequiresPermissions("wechat:region:view")
	@RequestMapping(value = "form")
	public String form(Region region, Model model) {
		model.addAttribute("region", region);
		return "modules/wechat/regionForm";
	}

	@RequiresPermissions("wechat:region:edit")
	@RequestMapping(value = "save")
	public String save(Region region, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, region)){
			return form(region, model);
		}
		regionService.save(region);
		addMessage(redirectAttributes, "保存天气预报的区域码表'" + region.getName() + "'成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/wechat/region/?repage";
	}
	
	@RequiresPermissions("wechat:region:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		regionService.delete(id);
		addMessage(redirectAttributes, "删除天气预报的区域码表成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/wechat/region/?repage";
	}

}
