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
 * 二维码Entity
 * @author Jakemanse
 * @version 2013-05-27
 */

@Entity
@Table(name = "ims_qrcode")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class QRCode extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	private Long id; 		// 编号
	private Integer type;		//二维码类型
	private Date createDate;	// 创建日期
	private Date updateDate;	//更新时间
	private String content;		//二维码内容
	private String pngPath;		//PNG 路径
	private String jpegPath;	//jpeg 路径
	private String delFlag;	// 删除标记（0：正常；1：删除）

	public QRCode() {
		this.createDate = new Date();
		this.delFlag = DEL_FLAG_NORMAL;
	}

	public QRCode(Long id){
		this();
		this.id = id;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_momarketing_qrCode")
	//@SequenceGenerator(name = "seq_momarketing_qrCode", sequenceName = "seq_momarketing_qrCode")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPngPath() {
		return pngPath;
	}

	public void setPngPath(String pngPath) {
		this.pngPath = pngPath;
	}

	public String getJpegPath() {
		return jpegPath;
	}

	public void setJpegPath(String jpegPath) {
		this.jpegPath = jpegPath;
	}

	@NotNull
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Length(min=1, max=1)
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	
}


