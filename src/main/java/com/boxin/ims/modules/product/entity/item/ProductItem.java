/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.product.entity.item;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.Indexed;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.boxin.ims.modules.product.entity.classify.ProductClassify;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.common.persistence.BaseEntity;
import com.thinkgem.jeesite.modules.sys.entity.User;

/**
 * 产品Entity
 * @author xuxiang
 * @version 2013-05-20
 */
@Entity
@Table(name = "ims_product_item")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Indexed @Analyzer(impl = IKAnalyzer.class)
public class ProductItem extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private Long id; 		// 编号
	private String serialNumber;			//序列号
	private Boolean publish;	//是否发布
	private String name;
	private String shortName;				//短名称
	private Date createTime;				//创建时间
	private BigDecimal price;				//价格
	private BigDecimal preferentialPrice;	//优惠价
	private String introduction;			//介绍
	private String delFlag;
	private ProductClassify type; 			//类型

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product_item_productItem")
	//@SequenceGenerator(name = "seq_product_item_productItem", sequenceName = "seq_product_item_productItem")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	@Basic
	@NotNull
	@Column(name="serial_number")
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Basic
	@NotNull
	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@NotNull
	@Column(name="short_name")
	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	@Basic
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="create_time")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Basic
	@NotNull
	@Column(name="price")
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Basic
	@NotNull
	@Column(name="preferential_price")
	public BigDecimal getPreferentialPrice() {
		return preferentialPrice;
	}

	public void setPreferentialPrice(BigDecimal preferentialPrice) {
		this.preferentialPrice = preferentialPrice;
	}

	@Basic
	@NotNull
	@Column(name="introduction")
	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Basic
	@Column(name="publish")
	@NotNull
	public Boolean getPublish() {
		return publish;
	}

	public void setPublish(Boolean publish) {
		this.publish = publish;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type")
	public ProductClassify getType() {
		return type;
	}

	public void setType(ProductClassify type) {
		this.type = type;
	}


	@Column(name="del_flag")
	@Basic
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}



}


