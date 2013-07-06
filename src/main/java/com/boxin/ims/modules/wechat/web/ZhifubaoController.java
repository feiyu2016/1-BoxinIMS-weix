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
import com.boxin.ims.modules.wechat.entity.Zhifubao;
import com.boxin.ims.modules.wechat.service.ZhifubaoService;

/**
 * 支付宝帐号信息Controller
 * @author Jakemanse
 * @version 2013-06-28
 */
@Controller
@RequestMapping(value = Global.ADMIN_PATH+"/wechat/zhifubao")
public class ZhifubaoController extends BaseController {

	@Autowired
	private ZhifubaoService zhifubaoService;
	
	@ModelAttribute
	public Zhifubao get(@RequestParam(required=false) Long id) {
		if (id != null){
			return zhifubaoService.get(id);
		}else{
			return new Zhifubao();
		}
	}
	
	@RequiresPermissions("wechat:zhifubao:view")
	@RequestMapping(value = {"list", ""})
	public String list(Zhifubao zhifubao, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		zhifubao.setUser(user);
        Page<Zhifubao> page = zhifubaoService.find(new Page<Zhifubao>(request, response), zhifubao); 
        model.addAttribute("page", page);
		return "modules/wechat/zhifubaoList";
	}

	@RequiresPermissions("wechat:zhifubao:view")
	@RequestMapping(value = "form")
	public String form(Zhifubao zhifubao, Model model) {
		User user = UserUtils.getUser();
		zhifubao.setUser(user);
		//if(zhifubao == null || zhifubao.getId()!=null){
			
			Zhifubao zb = zhifubaoService.getZhifubaoByUserId(user.getId());
			if(zb != null){//已绑定导致到列表页面
//				return "redirect:"+Global.ADMIN_PATH+"/wechat/zhifubao/?repage";
				zhifubao = zb;
			} 
//		} 
		
		model.addAttribute("zhifubao", zhifubao);
		return "modules/wechat/zhifubaoForm";
	}

	@RequiresPermissions("wechat:zhifubao:edit")
	@RequestMapping(value = "save")
	public String save(Zhifubao zhifubao, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, zhifubao)){
			return form(zhifubao, model);
		}
		zhifubaoService.save(zhifubao);
		addMessage(redirectAttributes, "保存支付宝帐号信息'" + zhifubao.getName() + "'成功");
		return "redirect:"+Global.ADMIN_PATH+"/wechat/zhifubao/?repage";
	}
	
	@RequiresPermissions("wechat:zhifubao:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		zhifubaoService.delete(id);
		addMessage(redirectAttributes, "删除支付宝帐号信息成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/wechat/zhifubao/?repage";
	}

}
