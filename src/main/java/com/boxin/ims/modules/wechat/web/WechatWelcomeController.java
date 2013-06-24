/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.wechat.web;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boxin.ims.modules.wechat.entity.ImageMessage;
import com.boxin.ims.modules.wechat.entity.MusicMessage;
import com.boxin.ims.modules.wechat.entity.WeChat;
import com.boxin.ims.modules.wechat.entity.WechatWelcome;
import com.boxin.ims.modules.wechat.service.WeChatService;
import com.boxin.ims.modules.wechat.service.WechatWelcomeService;
import com.boxin.ims.modules.wechat.utils.WeChatUtils;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.DictUtils;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * 欢迎词Controller
 * @author Jakemanse
 * @version 2013-06-20
 */
@Controller
@RequestMapping(value = Global.ADMIN_PATH+"/wechat/welcome")
public class WechatWelcomeController extends BaseController {

	@Autowired
	private WechatWelcomeService wechatWelcomeService;
	
	@Autowired
	private WeChatService weChatService;
	
	@ModelAttribute
	public WechatWelcome get(@RequestParam(required=false) Long id) {
		if (id != null){
			return wechatWelcomeService.get(id);
		}else{
			return new WechatWelcome();
		}
	}
	
	@RequiresPermissions("wechat:wechatWelcome:view")
	@RequestMapping(value = {"list", ""})
	public String list(WechatWelcome wechatWelcome, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
        Page<WechatWelcome> page = wechatWelcomeService.find(new Page<WechatWelcome>(request, response), wechatWelcome); 
        model.addAttribute("page", page);
		return "modules/wechat/wechatWelcomeList";
	}

	@RequiresPermissions("wechat:wechatWelcome:view")
	@RequestMapping(value = "form")
	public String form(WechatWelcome wechatWelcome, Model model) {
		WeChat weChat = weChatService.getWeChatByUserId(UserUtils.getUser().getId());
		if(weChat.getWechatWelcome()!= null){
			wechatWelcome = weChat.getWechatWelcome();
		}
		model.addAttribute("wechatWelcome", wechatWelcome);
		
		
		return "modules/wechat/wechatWelcomeForm";
	}

	@RequiresPermissions("wechat:wechatWelcome:edit")
	@RequestMapping(value = "save")
	public String save(@RequestParam("file") MultipartFile image,WechatWelcome wechatWelcome, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, wechatWelcome)){
			return form(wechatWelcome, model);
		}
		
		if(MusicMessage.MSG_TYPE.equals(wechatWelcome.getType()) || ImageMessage.MSG_TYPE.equals(wechatWelcome.getType())){
			String wpPath = WeChatUtils.getWechatResourceSavePath();
			File file = new File(wpPath+image.getOriginalFilename());
			try {
				image.transferTo(file);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			//FileUtils.copyFile(, "D:\\temp\\"+image.getOriginalFilename());
			wechatWelcome.setFilePath(file.getPath());
		}
			
		wechatWelcomeService.save(wechatWelcome);
		
		
		addMessage(redirectAttributes, "保存欢迎设置成功");
		return "redirect:"+Global.ADMIN_PATH+"/wechat/welcome/form";
	}
	
	@RequiresPermissions("wechat:wechatWelcome:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		wechatWelcomeService.delete(id);
		addMessage(redirectAttributes, "删除欢迎词成功");
		return "redirect:"+Global.ADMIN_PATH+"/wechat/welcoome/?repage";
	}

}
