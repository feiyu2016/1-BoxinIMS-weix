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
import com.boxin.ims.modules.wechat.entity.WeChat;
import com.boxin.ims.modules.wechat.service.WeChatService;

/**
 * 微信公众平台用户Controller
 * @author Jakemanse
 * @version 2013-06-17
 */
@Controller
@RequestMapping(value = Global.ADMIN_PATH+"/wechat/weChat")
public class WeChatController extends BaseController {

	@Autowired
	private WeChatService weChatService;
	
	@ModelAttribute
	public WeChat get(@RequestParam(required=false) Long id) {
		if (id != null){
			return weChatService.get(id);
		}else{
			return new WeChat();
		}
	}
	
	@RequiresPermissions("wechat:weChat:view")
	@RequestMapping(value = {"list", ""})
	public String list(WeChat weChat, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (!user.isAdmin()){
			weChat.setUser(user);
		}
        Page<WeChat> page = weChatService.find(new Page<WeChat>(request, response), weChat); 
        model.addAttribute("page", page);
		return "modules/wechat/weChatList";
	}

	@RequiresPermissions("wechat:weChat:view")
	@RequestMapping(value = "form")
	public String form(WeChat weChat, Model model) {
		
		if(weChat.getUser() == null || weChat.getUser().getId() == null){
			User user = UserUtils.getUser();
			weChat  = weChatService.getWeChatByUserId(user.getId());
			if(weChat == null) {
				weChat = new WeChat();
				weChat.setUser(UserUtils.getUser());
				weChatService.save(weChat);
			}
		}
		model.addAttribute("weChat", weChat);
		return "modules/wechat/weChatForm";
	}

	@RequiresPermissions("wechat:weChat:edit")
	@RequestMapping(value = "save")
	public String save(WeChat weChat, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, weChat)){
			return form(weChat, model);
		}
		weChatService.save(weChat);
		addMessage(redirectAttributes, "保存微信公众平台用户'" + weChat.getToken()+ "'成功");
		return "redirect:"+Global.ADMIN_PATH+"/wechat/weChat/?repage";
	}
	
	@RequiresPermissions("wechat:weChat:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		weChatService.delete(id);
		addMessage(redirectAttributes, "删除微信公众平台用户成功");
		return "redirect:"+Global.ADMIN_PATH+"/wechat/weChat/?repage";
	}

}
