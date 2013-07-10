/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.wechat.web;

import java.io.File;
import java.util.List;

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

import com.boxin.ims.modules.momarketing.common.QRCodeUtils;
import com.boxin.ims.modules.wechat.entity.ImageMessage;
import com.boxin.ims.modules.wechat.entity.NewsReply;
import com.boxin.ims.modules.wechat.entity.WeChat;
import com.boxin.ims.modules.wechat.entity.WechatConfig;
import com.boxin.ims.modules.wechat.service.NewsReplyService;
import com.boxin.ims.modules.wechat.service.WeChatService;
import com.boxin.ims.modules.wechat.service.WechatConfigService;
import com.boxin.ims.modules.wechat.service.WechatMybatisService;
import com.boxin.ims.modules.wechat.utils.WeChatUtils;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * 图文富内容回复Controller
 * @author Jakemanse
 * @version 2013-06-21
 */
@Controller
@RequestMapping(value = Global.ADMIN_PATH+"/wechat/newsReply")
public class NewsReplyController extends BaseController {

	@Autowired
	private NewsReplyService newsReplyService;
	
	@Autowired
	private WeChatService weChatService;
	
	@Autowired
	private WechatConfigService wechatConfigService;
	
	@Autowired
	private WechatMybatisService wechatMybatisService;
	
	@ModelAttribute
	public NewsReply get(@RequestParam(required=false) Long id) {
		if (id != null){
			return newsReplyService.get(id);
		}else{
			return new NewsReply();
		}
	}
	
	@RequiresPermissions("wechat:newsReply:view")
	@RequestMapping(value = {"list", ""})
	public String list(NewsReply newsReply, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		WeChat weChat = weChatService.getWeChatByUserId(user.getId());
		newsReply.setWeChat(weChat);
        Page<NewsReply> page = newsReplyService.find(new Page<NewsReply>(request, response), newsReply); 
        model.addAttribute("page", page);
		return "modules/wechat/newsReplyList";
	}

	@RequiresPermissions("wechat:newsReply:view")
	@RequestMapping(value = "form")
	public String form(NewsReply newsReply,HttpServletRequest request, HttpServletResponse response, Model model ) {
		String wid = request.getParameter("wid");		//对应的 WeChat 用户配置
		String cfid= request.getParameter("cfid");		//对应的 WechatConfig 回复的问题名称
		WeChat weChat = weChatService.getWeChatByUserId(UserUtils.getUser().getId());
		
		if(cfid==null || cfid.trim().length()==0){	//未添加对应的问题
			//保存问题
			if(weChat == null ){
				//需要返回绑家微信公众平台
				model.addAttribute("message", "请先绑定微信!");
				return "modules/wechat/newsReplyForm";
			}
			WechatConfig config = new WechatConfig();
			config.setWeChat(weChat);
			config.setMsgType(ImageMessage.MSG_TYPE);
			
			//保存新闻消息回复
			newsReply.setWechatConfig(config);
			
			
		}else{
			WechatConfig config = wechatConfigService.get(Long.parseLong(cfid));
			
//			config.setUpContent(newsReply.getWechatConfig().getUpContent());
//			config.setMsgType(ImageMessage.MSG_TYPE);
			Integer count = wechatMybatisService.getNewsReplyCountByConfigId(config.getId());
			if(count <= ImageMessage.NEWS_ITEMS_COUNT){//可以继续添加
				model.addAttribute("addFlag", true);
			}else{
				model.addAttribute("addFlag", false);
			}
			//保存新闻消息回复
			newsReply.setWechatConfig(config);
		}
			
		newsReply.setWeChat(weChat);
		model.addAttribute("newsReply", newsReply);
		
		return "modules/wechat/newsReplyForm";
	}

	@RequiresPermissions("wechat:newsReply:edit")
	@RequestMapping(value = "save")
	public String save(@RequestParam("file") MultipartFile image,@RequestParam("qrfile") MultipartFile qrfile,NewsReply newsReply,HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, newsReply)){
			return form(newsReply,request,response, model);
		}
		if(image != null){
			String wpPath = WeChatUtils.getWechatResourceSavePath();
			String sname = image.getOriginalFilename();
			String fileType = sname.substring(sname.lastIndexOf("."));
			String fname  = UserUtils.getUser().getLoginName()+	"_wp_"+System.currentTimeMillis()+fileType;
			File file = new File(wpPath+fname);
			System.out.println("保存文件:"+wpPath+fname);
			try {
				image.transferTo(file);
				newsReply.setFilePath(file.getPath());	
			} catch (Exception e) {
				System.out.println("上传文件失败:"+wpPath+fname);
				e.printStackTrace();
			}
			
		}
		
			try {
				if(qrfile != null && qrfile.getBytes().length>10){
					String wpPath = WeChatUtils.getWechatResourceSavePath();
					File file = new File(wpPath+image.getOriginalFilename());
					qrfile.transferTo(file);
					String content = QRCodeUtils.decode(file);
					if(content != null && content.length()>0){
						newsReply.setUrl(content);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		newsReplyService.save(newsReply);
		
		
		addMessage(redirectAttributes, "保存图文富内容回复'" + newsReply.getTitle() + "'成功");
		return "redirect:"+Global.ADMIN_PATH+"/wechat/newsReply/?repage";
	}
	
	@RequiresPermissions("wechat:newsReply:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		newsReplyService.delete(id);
		addMessage(redirectAttributes, "删除图文富内容回复成功");
		return "redirect:"+Global.ADMIN_PATH+"/wechat/newsReply/?repage";
	}

}
