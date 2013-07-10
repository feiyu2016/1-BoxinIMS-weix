/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.wechat.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.BaseEntity;
import com.thinkgem.jeesite.modules.sys.entity.User;

/**
 * 图文富内容回复Entity
 * @author Jakemanse
 * @version 2013-06-21
 */
@Entity
@Table(name = "wp_news_reply")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class NewsReply extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	private Long id; 		// 编号
	private String title;	//微信ID
	private WeChat weChat;	
	private WechatConfig wechatConfig;	//对应的上行
	private WechatWelcome wechatWelcome;	//对应的欢迎信息
	private String description; 	// 微信名称
	private String filePath;		//存储路径
	private String picUrl;	//Token 微信接口标识
	private String url; 		// 用户
	private Integer ord; // 备注
	private Boolean isWelcome=false;				//是否欢迎词项
	private Integer articleCount; // 备注
	private Date createTime;	// 创建日期
	private Date updateTime;	//更新时间
	private String delFlag;	// 删除标记（0：正常；1：删除）
	
	
	public NewsReply() {
		this.createTime = new Date();
		this.updateTime = new Date();
		this.delFlag = DEL_FLAG_NORMAL;
	}
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_wechat_weChat")
	//@SequenceGenerator(name = "seq_wechat_weChat", sequenceName = "seq_wechat_weChat")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public Integer getOrd() {
		return ord;
	}
	public void setOrd(Integer ord) {
		this.ord = ord;
	}
	public Integer getArticleCount() {
		return articleCount;
	}
	public void setArticleCount(Integer articleCount) {
		this.articleCount = articleCount;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@ManyToOne
	@JoinColumn(name="config_id")
	@NotFound(action = NotFoundAction.IGNORE)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public WechatConfig getWechatConfig() {
		return wechatConfig;
	}
	public void setWechatConfig(WechatConfig wechatConfig) {
		this.wechatConfig = wechatConfig;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}



	public Boolean getIsWelcome() {
		return isWelcome;
	}



	public void setIsWelcome(Boolean isWelcome) {
		this.isWelcome = isWelcome;
	}


	@ManyToOne
	@JoinColumn(name="welcome_id")
	@NotFound(action = NotFoundAction.IGNORE)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public WechatWelcome getWechatWelcome() {
		return wechatWelcome;
	}



	public void setWechatWelcome(WechatWelcome wechatWelcome) {
		this.wechatWelcome = wechatWelcome;
	}


	@ManyToOne
	@JoinColumn(name="wechat_id")
	@NotFound(action = NotFoundAction.IGNORE)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public WeChat getWeChat() {
		return weChat;
	}



	public void setWeChat(WeChat weChat) {
		this.weChat = weChat;
	}
	
	
	
	
}


