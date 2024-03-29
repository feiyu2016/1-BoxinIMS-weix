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

import com.boxin.ims.modules.wechat.entity.Product;
import com.thinkgem.jeesite.common.persistence.BaseEntity;
import com.thinkgem.jeesite.modules.sys.entity.User;

/**
 * 优惠券Entity
 * @author Jakemanse
 * @version 2013-05-25
 */
@Entity
@Table(name = "ims_coupon")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Coupon extends BaseEntity {
	
	public static final String VIEW_QRCODE_URL_PRIX="http://www.hdzhx.com/zxims/f/mobsite/wp/vrqr?id=";
	
	public static final String CANCEL_FLAG_NORMAL = "0";
	public static final String CANCEL_FLAG_DELETE = "1";
	
	private static final long serialVersionUID = 1L;
	private Long id; 			// 编号
	private User user;			//所属用户
	private Product product;	//对应的项目
	private QRCode qrCode;		//对应的对维码
	private String number; 		// 优惠券序列号
	private String mobile;		//对应的手机号
	private String email;		//邮箱
	private String name; 		// 名称
	private Integer sendType;	//发送方式  0:不发短彩信  1：短信+彩信   2：只彩信  3：只短信	
	private String remarks; 	// 备注
	private Date createDate;	// 创建日期
	private Date startTime;		//开始生效时间
	private Date endTime;		//失效时间
	private String delFlag;		// 删除标记（0：正常；1：删除/作废）

	public Coupon() {
		this.createDate = new Date();
		this.delFlag = DEL_FLAG_NORMAL;
	}

	public Coupon(Long id){
		this();
		this.id = id;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_momarketing_coupon")
	//@SequenceGenerator(name = "seq_momarketing_coupon", sequenceName = "seq_momarketing_coupon")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="product_id")
	@NotFound(action = NotFoundAction.IGNORE)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public Product getProduct() {
		return product;
	}

	public void setProject(Product product) {
		this.product = product;
	}
	
	@Length(min=1, max=200)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Length(min=0, max=255)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getSendType() {
		return sendType;
	}

	public void setSendType(Integer sendType) {
		this.sendType = sendType;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@NotFound(action = NotFoundAction.IGNORE)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@NotNull
	public User getUser() {
		return user;
	}
	
	

	public void setUser(User user) {
		this.user = user;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ManyToOne
	@JoinColumn(name="qrcode_id")
	@NotFound(action = NotFoundAction.IGNORE)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@NotNull
	public QRCode getQrCode() {
		return qrCode;
	}

	public void setQrCode(QRCode qrCode) {
		this.qrCode = qrCode;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	
	
	
}


