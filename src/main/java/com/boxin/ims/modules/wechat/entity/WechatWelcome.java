/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.wechat.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import com.google.common.collect.Lists;
import com.thinkgem.jeesite.common.persistence.BaseEntity;

/**
 * 欢迎词Entity
 * @author Jakemanse
 * @version 2013-06-20
 */
@Entity
@Table(name = "wp_welcome")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WechatWelcome extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	private Long id; 		// 编号
	private String content;	//欢迎内容
	private String type;	//欢迎内容类型
	private String filePath;	//文件 路径
	private String musicUrl;	//
	private String hqmusicUrl;	//
	private String title;		//声音或图片标题
	private String description;	//声音或图片描述
	private String picUrl;		//图片URL
	private String url;		//	连接地址
	private List<NewsReply> newsReplyList  = Lists.newArrayList();		//图文回复
	private Date createTime;	// 创建日期
	private String delFlag;	// 删除标记（0：正常；1：删除）

	public WechatWelcome() {
		this.createTime = new Date();
		this.delFlag = DEL_FLAG_NORMAL;
	}

	public WechatWelcome(Long id){
		this();
		this.id = id;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_wechat_wechatWelcome")
	//@SequenceGenerator(name = "seq_wechat_wechatWelcome", sequenceName = "seq_wechat_wechatWelcome")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Length(min=1, max=1)
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}


	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getMusicUrl() {
		return musicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}

	public String getHqmusicUrl() {
		return hqmusicUrl;
	}

	public void setHqmusicUrl(String hqmusicUrl) {
		this.hqmusicUrl = hqmusicUrl;
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

	
	@OneToMany
	@JoinColumn(name="welcome_id")
	@Where(clause="del_flag='"+DEL_FLAG_NORMAL+"' and welcome = 1")
	@NotFound(action = NotFoundAction.IGNORE)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@NotNull
	public List<NewsReply> getNewsReplyList() {
		return newsReplyList;
	}

	public void setNewsReplyList(List<NewsReply> newsReplyList) {
		this.newsReplyList = newsReplyList;
	}

	
	
	
	
}


