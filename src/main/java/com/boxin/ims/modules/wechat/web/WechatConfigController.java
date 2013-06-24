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

import com.boxin.ims.modules.wechat.entity.TextMessage;
import com.boxin.ims.modules.wechat.entity.WeChat;
import com.boxin.ims.modules.wechat.entity.WechatConfig;
import com.boxin.ims.modules.wechat.service.WeChatService;
import com.boxin.ims.modules.wechat.service.WechatConfigService;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * 微信上下行数据交互Controller
 * @author Jakemanse
 * @version 2013-06-19
 */
@Controller
@RequestMapping(value = Global.ADMIN_PATH+"/wechat/config")
public class WechatConfigController extends BaseController {

	@Autowired
	private WechatConfigService wechatConfigService;
	
	@Autowired
	private WeChatService weChatService;
	
	@ModelAttribute
	public WechatConfig get(@RequestParam(required=false) Long id) {
		if (id != null){
			return wechatConfigService.get(id);
		}else{
			return new WechatConfig();
		}
	}
	
	@RequiresPermissions("wechat:wechatConfig:view")
	@RequestMapping(value = {"list", ""})
	public String list(WechatConfig wechatConfig, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<WechatConfig> page = wechatConfigService.find(new Page<WechatConfig>(request, response), wechatConfig); 
        model.addAttribute("page", page);
		return "modules/wechat/wechatConfigList";
	}

	@RequiresPermissions("wechat:wechatConfig:view")
	@RequestMapping(value = "form")
	public String form(WechatConfig wechatConfig, Model model) {
		
		if(wechatConfig.getWeChat() == null || wechatConfig.getWeChat().getId() == null){
			WeChat weChat =  weChatService.getWeChatByUserId(UserUtils.getUser().getId());
			wechatConfig.setWeChat(weChat);
		}
		
		model.addAttribute("wechatConfig", wechatConfig);
		return "modules/wechat/wechatConfigForm";
	}

	@RequiresPermissions("wechat:wechatConfig:edit")
	@RequestMapping(value = "save")
	public String save(WechatConfig wechatConfig, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, wechatConfig)){
			return form(wechatConfig, model);
		}
		
		wechatConfig.setMsgType(TextMessage.MSG_TYPE);
		
		wechatConfigService.save(wechatConfig);
		addMessage(redirectAttributes, "保存微信上下行数据交互'" + wechatConfig.getUpContent() + "'成功");
		return "redirect:"+Global.ADMIN_PATH+"/wechat/config/?repage";
	}
	
	@RequiresPermissions("wechat:wechatConfig:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		wechatConfigService.delete(id);
		addMessage(redirectAttributes, "删除微信上下行数据交互成功");
		return "redirect:"+Global.ADMIN_PATH+"/wechat/config/?repage";
	}

}
