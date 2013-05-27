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
import com.boxin.ims.modules.momarketing.entity.Meeting;
import com.boxin.ims.modules.momarketing.service.MeetingService;

/**
 * 产品Controller
 * @author Jakemanse
 * @version 2013-05-25
 */
@Controller
@RequestMapping(value = Global.ADMIN_PATH+"/mom/meeting")
public class MeetingController extends BaseController {

	@Autowired
	private MeetingService meetingService;
	
	@ModelAttribute
	public Meeting get(@RequestParam(required=false) Long id) {
		if (id != null){
			return meetingService.get(id);
		}else{
			return new Meeting();
		}
	}
	
	@RequiresPermissions("momarketing:meeting:view")
	@RequestMapping(value = {"list", ""})
	public String list(Meeting meeting, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (!user.isAdmin()){
			meeting.setUser(user);
		}
        Page<Meeting> page = meetingService.find(new Page<Meeting>(request, response), meeting); 
        model.addAttribute("page", page);
		return "modules/momarketing/meetingList";
	}

	@RequiresPermissions("momarketing:meeting:view")
	@RequestMapping(value = "form")
	public String form(Meeting meeting, Model model) {
		model.addAttribute("meeting", meeting);
		return "modules/momarketing/meetingForm";
	}

	@RequiresPermissions("momarketing:meeting:edit")
	@RequestMapping(value = "save")
	public String save(Meeting meeting, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, meeting)){
			return form(meeting, model);
		}
		meetingService.save(meeting);
		addMessage(redirectAttributes, "保存产品'" + meeting.getName() + "'成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/momarketing/meeting/?repage";
	}
	
	@RequiresPermissions("momarketing:meeting:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		meetingService.delete(id);
		addMessage(redirectAttributes, "删除产品成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/momarketing/meeting/?repage";
	}

}
