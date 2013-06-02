/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.momarketing.entity;

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
 * 留言Entity
 * @author Jakemanse
 * @version 2013-05-28
 */
@Entity
@Table(name = "ims_guest_book")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class GuestBook extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	private Long id; 			// 编号
	private Project project;	//所属项目
	private String userName; 	// 名称
	private String content; 	// 留言内容
	private String ip;			//留言IP
	private String email;		//留言邮箱
	private String mobile;		//留言手机号
	private Date createDate;	// 创建日期

	public GuestBook() {
		this.createDate = new Date();
	}

	public GuestBook(Long id){
		this();
		this.id = id;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_momarketing_guestBook")
	//@SequenceGenerator(name = "seq_momarketing_guestBook", sequenceName = "seq_momarketing_guestBook")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="user_id")
	@NotFound(action = NotFoundAction.IGNORE)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@NotNull
	public Project getProject() {
		return project;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	
	
}


