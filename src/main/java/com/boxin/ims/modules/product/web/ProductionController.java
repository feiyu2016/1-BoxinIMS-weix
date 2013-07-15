package com.boxin.ims.modules.product.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boxin.ims.modules.product.entity.ProductClassify;
import com.boxin.ims.modules.product.entity.ProductItem;
import com.boxin.ims.modules.product.service.ProductClassifyService;
import com.boxin.ims.modules.product.service.ProductItemService;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

@Controller
@RequestMapping(value = Global.ADMIN_PATH+"/mproduct")
public class ProductionController extends BaseController{
	@Autowired
	private ProductClassifyService productClassifyService;
	@Autowired
	private ProductItemService productItemService;




	@RequiresPermissions("ims:product:view")
	@RequestMapping(value = {"list", ""})
	public String list(ProductItem item, ProductModel productModel, HttpServletRequest request, HttpServletResponse response,Model model) {
		if(productModel.getProductType() == null || productModel.getProductType() == 0){
			productModel.setProductType(null);
		}
		User user = UserUtils.getUser();
		selectClassify(user,model);
		model.addAttribute("productModel", productModel);
		item.setName(productModel.getProductName());
		Page<ProductItem> page = productItemService.find(new Page<ProductItem>(request, response), productModel.getProductType(),item);
		model.addAttribute("list", page.getList());
		model.addAttribute("page", page);
		return "modules/ims/product/myproduct";
	}

	/**
	 * 产品页面
	 * @param classify
	 * @param model
	 * @return
	 */
	@RequiresPermissions("ims:product:edit")
	@RequestMapping(value = "form")
	public String form(ProductClassify classify, Model model) {
		return "modules/ims/product/product";
	}
	private void selectClassify(User user,Model model){
		model.addAttribute("classify", productClassifyService.find(user));
	}
	
	
	/**
	 * 添加产品类型页面
	 * @param classify
	 * @param model
	 * @return
	 * @throws CloneNotSupportedException 
	 */
	@RequiresPermissions("ims:product:edit")
	@RequestMapping(value = "formClassify")
	public String formClassify(Long id,ProductClassify classify,HttpServletRequest request, HttpServletResponse response, Model model) {
		if(id != null){
			classify = productClassifyService.get(id);
			try {
				model.addAttribute("classify",classify.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			classify.setName(null);
		}else{
			User user = UserUtils.getUser();
			classify.setUser(user);
			model.addAttribute("classify",classify);
		}
		Page<ProductClassify> page = productClassifyService.find(new Page<ProductClassify>(request, response,5), classify);
		model.addAttribute("page", page);
		model.addAttribute("list", page.getList());
		
		return "modules/ims/product/addClassify";
	}
	
	/**
	 * 添加产品项页面
	 * @param productItem
	 * @param model
	 * @return
	 */
	@RequiresPermissions("ims:product:edit")
	@RequestMapping(value = "formItem")
	public String formItem(ProductItem productItem, Model model) {
		productItem.setPublish(true);
		model.addAttribute("item", productItem);
		return "modules/ims/product/addItem";
	}

	/**
	 * 保存产品类型
	 * @param classify
	 * @param request
	 * @param response
	 * @param model
	 * @param redirectAttributes
	 * @return
	 */
	@RequiresPermissions("ims:product:edit")
	@RequestMapping(value = "saveClassify")
	public String saveClassify(ProductClassify classify,HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {
		User user = UserUtils.getUser();
		classify.setUser(user);
		if (!beanValidator(model, classify)){
			return formClassify(null,classify, request,response,model);
		}
		classify.setDelFlag("0");
		productClassifyService.save(classify);
		addMessage(redirectAttributes, "保存产品'" + classify.getName() + "'成功");
		return "redirect:"+Global.ADMIN_PATH+"/product/formClassify/?repage";
	}

	@RequiresPermissions("ims:product:edit")
	@RequestMapping(value = "saveItem")
	public String saveItem(ProductItem productItem, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, productItem)){
			return formItem(productItem, model);
		}
		productItemService.save(productItem);
		addMessage(redirectAttributes, "操作产品'" + productItem.getName() + "'成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/product/item/productItem/?repage";
	}

	/**
	 * 删除产品类型
	 * @param id
	 * @param redirectAttributes
	 * @return
	 */
	@RequiresPermissions("ims:product:edit")
	@RequestMapping(value = "deleteClassify")
	public String deleteClassify(Long id, RedirectAttributes redirectAttributes) {
		productClassifyService.delete(id);
		addMessage(redirectAttributes, "删除产品分类成功");
		return "redirect:"+Global.ADMIN_PATH+"/product/formClassify/?repage";
	}
}
