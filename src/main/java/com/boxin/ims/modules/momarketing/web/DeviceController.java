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
import com.boxin.ims.modules.momarketing.entity.Device;
import com.boxin.ims.modules.momarketing.service.DeviceService;

/**
 * 终端设备Controller
 * @author Jakemanse
 * @version 2013-05-25
 */
@Controller
@RequestMapping(value = Global.ADMIN_PATH+"/momarketing/device")
public class DeviceController extends BaseController {

	@Autowired
	private DeviceService deviceService;
	
	@ModelAttribute
	public Device get(@RequestParam(required=false) Long id) {
		if (id != null){
			return deviceService.get(id);
		}else{
			return new Device();
		}
	}
	
	@RequiresPermissions("momarketing:device:view")
	@RequestMapping(value = {"list", ""})
	public String list(Device device, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (!user.isAdmin()){
			device.setUser(user);
		}
        Page<Device> page = deviceService.find(new Page<Device>(request, response), device); 
        model.addAttribute("page", page);
		return "modules/momarketing/deviceList";
	}

	@RequiresPermissions("momarketing:device:view")
	@RequestMapping(value = "form")
	public String form(Device device, Model model) {
		model.addAttribute("device", device);
		return "modules/momarketing/deviceForm";
	}

	@RequiresPermissions("momarketing:device:edit")
	@RequestMapping(value = "save")
	public String save(Device device, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, device)){
			return form(device, model);
		}
		deviceService.save(device);
		addMessage(redirectAttributes, "保存终端设备'" + device.getName() + "'成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/momarketing/device/?repage";
	}
	
	@RequiresPermissions("momarketing:device:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		deviceService.delete(id);
		addMessage(redirectAttributes, "删除终端设备成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/momarketing/device/?repage";
	}

}
