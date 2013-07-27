package com.boxin.framework.base.utils;

import com.thinkgem.jeesite.modules.sys.utils.DictUtils;

/**
 * @author Jakemanse
 *	常量类
 */
public class Constants {
	
	public final static String SESSION_LOGIN_USER = "user";				//user 对象
	public final static String SESSION_ORGAN = "organ";					//组织对象
	
	
	
	public final static String SESSION_LOGIN_NAME = "username";			//登录名
	public final static String SESSION_LOGIN_ID = "user_id";			//用户ID
	public final static String SESSION_ORGAN_ID = "organ_id";			//机构ID
	public final static String SESSION_ORGAN_NAME = "organ_name";		//机构ID
	
	public final static String SESSION_REGION_ID = "region_id";			//机构ID
	public final static String SESSION_REGION_NAME = "region_name";		//机构ID
	
	
	public final static String SESSION_GROUP_NAME = "group_name";		//组织名称
	public final static String SESSION_GROUP_ID = "group_id";			//组织ID
	public final static String SESSION_GROUP_NAME_SET = "group_name_set";//组名集合
	public final static String SESSION_GROUP_ID_SET = "group_id_set";	 //组ID集合
	
	
	
	public final static String MOBILE_SITE_NAV_HOME = "1";				//首页
	public final static String MOBILE_SITE_NAV_PRODUCT= "2";			//产品信息
	public final static String MOBILE_SITE_NAV_ABOUT= "3";				//关于
	public final static String MOBILE_SITE_NAV_INVEST= "4";				//有奖调查
	public final static String MOBILE_SITE_NAV_BONUS= "5";				//抽奖活动
	public final static String MOBILE_SITE_NAV_NEWS= "6";				//公司动态新闻
	public final static String MOBILE_SITE_NAV_CONTACT= "7";			//联系我们
	
	
	
	
	
	/**
	 * @author Jakemanse
	 * @time 2013-6-22  上午12:31:38
	 * @function <p>获取微信设置中上传的文件资源路径  </p>
	 * @return
	 */
	public static String getWechatResourceSavePath(){
		 return DictUtils.getDictValue("微信资源目录", "res_wp_path", "微信资源目录");
	}
	
	
	/**
	 * @author Jakemanse
	 * @time 2013-7-1  下午3:00:23
	 * @function <p> 电子名称的二维码存储路径 </p>
	 * @return
	 */
	public static String getEcardQRCodeResourceSavePath(){
		return DictUtils.getDictValue("电子名片二维码路径", "res_qr_ecard_path", "电子名片二维码存储路径");
	}
	
	/**
	 * @author Jakemanse
	 * @time 2013-7-1  下午3:00:23
	 * @function <p> 优惠券的二维码存储路径 </p>
	 * @return
	 */
	public static String getCouponQRCodeResourceSavePath(){
		return DictUtils.getDictValue("优惠券二维码路径", "res_qr_coupon_path", "优惠券二维码存储路径");
	}
	
	/**
	 * @author Jakemanse
	 * @time 2013-7-1  下午3:00:47
	 * @function <p> 电子名片的照片路径 </p>
	 * @return
	 */
	public static String getEcardResourceSavePath(){
		return DictUtils.getDictValue("电子名片图片路径", "res_ecard_path", "电子名片图片存储路径");
	}
	
	
	public static String getGiftResourceSavePath(){
		return DictUtils.getDictValue("礼物音频路径", "res_gift_voice_path", "礼物音频存储路径");
	}
	
	
	
	
	
	
	
	
	
	

}
