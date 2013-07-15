/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.product.entity.classify;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.boxin.ims.modules.product.entity.item.ProductItem;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.common.persistence.BaseEntity;
import com.thinkgem.jeesite.modules.sys.entity.User;

/**
 * 产品Entity
 * @author xuxiang
 * @version 2013-05-20
 */
@Entity
@Table(name = "ims_product_classify")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ProductClassify extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private Long id; 		// 编号
	private User user; 		// 用户
	private String name; 	// 名称
	private String desc; 	// 描述
	private Date createDate;	// 创建日期
	private String delFlag;
	private Set<ProductItem> items = new LinkedHashSet<ProductItem>(0);

	public ProductClassify() {
		this.createDate = new Date();
	}

	public ProductClassify(Long id){
		this();
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product_classify_productClassify")
	//@SequenceGenerator(name = "seq_product_classify_productClassify", sequenceName = "seq_product_classify_productClassify")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="cust_Id")
	@NotFound(action = NotFoundAction.IGNORE)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@NotNull
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Basic
	@Column(name="name")
	@NotNull
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name="desception")
	@NotNull
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}



	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@NotFound(action = NotFoundAction.IGNORE)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "type")
	public Set<ProductItem> getItems() {
		return items;
	}

	public void setItems(Set<ProductItem> items) {
		this.items = items;
	}

	@Column(name="del_flag")
	@Basic
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}



	
	public Object clone() throws CloneNotSupportedException {
		ProductClassify obj = new ProductClassify();
		obj.setId(this.id);
		obj.setCreateDate(createDate);
		obj.setDelFlag(delFlag);
		obj.setName(name);
		obj.setDesc(desc);
		return obj;
	}
}


