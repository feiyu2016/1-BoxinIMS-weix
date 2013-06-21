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
 * 微信上下行数据交互Entity
 * @author Jakemanse
 * @version 2013-06-19
 */
@Entity
@Table(name = "wp_chat_config")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WechatConfig extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	private Long id; 		// 编号
	private WeChat weChat;	//对应的微信账号
	private String upContent; 	// 上行数据内容
	private String downContent; // 下行数据内容
	private String msgType;		//消息类型
	private Date createTime;	// 创建日期
	private Date updateTime;	//更新时间
	private String delFlag ;

	public WechatConfig() {
		this.createTime = new Date();
		this.delFlag = super.DEL_FLAG_NORMAL;
	}

	public WechatConfig(Long id){
		this();
		this.id = id;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_wechat_wechatConfig")
	//@SequenceGenerator(name = "seq_wechat_wechatConfig", sequenceName = "seq_wechat_wechatConfig")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="wechat_id")
	@NotFound(action = NotFoundAction.IGNORE)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@NotNull
	public WeChat getWeChat() {
		return weChat;
	}

	public String getUpContent() {
		return upContent;
	}

	public void setUpContent(String upContent) {
		this.upContent = upContent;
	}

	public String getDownContent() {
		return downContent;
	}

	public void setDownContent(String downContent) {
		this.downContent = downContent;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
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

	public void setWeChat(WeChat weChat) {
		this.weChat = weChat;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}


	
	
}


