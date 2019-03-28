package com.bootdo.system.domain;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @author zhouliang
 * @date 2018-09-26 13:36:46
 */

public class BasicHouseOrderDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Long id;
	//订单号
	private Long orderNo;
	//运单号
	private String mailno;
	//寄件人姓名
	private String senderPerson;
	//寄件人电话
	private String senderPersonTel;
	//寄件人省
	private String senderPersonProvince;
	//寄件人市
	private String senderPersonCity;
	//寄件人区
	private String senderPersonCounty;
	//寄件人详细地址
	private String senderPersonAddress;
	//寄件人门店编码（成本中心）
	private String senderStoreCode;
	//寄件人门店类型（成本类型）
	private Integer senderStoreType;
	//收件人姓名
	private String recPerson;
	//收件人电话
	private String recPersonTel;
	//收件人省
	private String recPersonProvince;
	//收件人市
	private String recPersonCity;
	//收件人区
	private String recPersonCounty;
	//收件人详细地址
	private String recPersonAddress;
	//收件人门店编码（成本中心）
	private String recStoreCode;
	//收件人门店类型（成本类型）
	private Integer recStoreType;
	//取件类型（0、一小时内 1、次日九点）
	private Integer takePartType;
	//取件时间
	private Date takePartTime;
	//产品类型（0、顺丰标快 1、顺丰特惠）
	private Integer productType;
	//付款类型（0、寄付月结）
	private Integer paymentMethod;
	//增值类型（0、保价）
	private Integer incrementService;
	//保价金额
	private BigDecimal insureValue;
	//运费
	private BigDecimal freight;
	//件数
	private Integer parcelQuantity;
	//备注
	private String remark;
	//创建时间
	private Date createTime;
	//创建人
	private String createBy;
	//修改时间
	private Date updateTime;
	//修改人
	private String updateBy;
	//运单创建时间
	private Date createMailTime;
	//物品名称 1、文件 2、衣服
	private String productName;

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "BasicHouseOrderDO{" +
				"id=" + id +
				", orderNo=" + orderNo +
				", mailno='" + mailno + '\'' +
				", senderPerson='" + senderPerson + '\'' +
				", senderPersonTel='" + senderPersonTel + '\'' +
				", senderPersonProvince='" + senderPersonProvince + '\'' +
				", senderPersonCity='" + senderPersonCity + '\'' +
				", senderPersonCounty='" + senderPersonCounty + '\'' +
				", senderPersonAddress='" + senderPersonAddress + '\'' +
				", senderStoreCode='" + senderStoreCode + '\'' +
				", senderStoreType=" + senderStoreType +
				", recPerson='" + recPerson + '\'' +
				", recPersonTel='" + recPersonTel + '\'' +
				", recPersonProvince='" + recPersonProvince + '\'' +
				", recPersonCity='" + recPersonCity + '\'' +
				", recPersonCounty='" + recPersonCounty + '\'' +
				", recPersonAddress='" + recPersonAddress + '\'' +
				", recStoreCode='" + recStoreCode + '\'' +
				", recStoreType=" + recStoreType +
				", takePartType=" + takePartType +
				", takePartTime=" + takePartTime +
				", productType=" + productType +
				", paymentMethod=" + paymentMethod +
				", incrementService=" + incrementService +
				", insureValue=" + insureValue +
				", freight=" + freight +
				", parcelQuantity=" + parcelQuantity +
				", remark='" + remark + '\'' +
				", createTime=" + createTime +
				", createBy='" + createBy + '\'' +
				", updateTime=" + updateTime +
				", updateBy='" + updateBy + '\'' +
				", createMailTime=" + createMailTime +
				", productName='" + productName + '\'' +
				'}';
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

	public String getMailno() {
		return mailno;
	}

	public void setMailno(String mailno) {
		this.mailno = mailno;
	}

	public String getSenderPerson() {
		return senderPerson;
	}

	public void setSenderPerson(String senderPerson) {
		this.senderPerson = senderPerson;
	}

	public String getSenderPersonTel() {
		return senderPersonTel;
	}

	public void setSenderPersonTel(String senderPersonTel) {
		this.senderPersonTel = senderPersonTel;
	}

	public String getSenderPersonProvince() {
		return senderPersonProvince;
	}

	public void setSenderPersonProvince(String senderPersonProvince) {
		this.senderPersonProvince = senderPersonProvince;
	}

	public String getSenderPersonCity() {
		return senderPersonCity;
	}

	public void setSenderPersonCity(String senderPersonCity) {
		this.senderPersonCity = senderPersonCity;
	}

	public String getSenderPersonCounty() {
		return senderPersonCounty;
	}

	public void setSenderPersonCounty(String senderPersonCounty) {
		this.senderPersonCounty = senderPersonCounty;
	}

	public String getSenderPersonAddress() {
		return senderPersonAddress;
	}

	public void setSenderPersonAddress(String senderPersonAddress) {
		this.senderPersonAddress = senderPersonAddress;
	}

	public String getSenderStoreCode() {
		return senderStoreCode;
	}

	public void setSenderStoreCode(String senderStoreCode) {
		this.senderStoreCode = senderStoreCode;
	}

	public Integer getSenderStoreType() {
		return senderStoreType;
	}

	public void setSenderStoreType(Integer senderStoreType) {
		this.senderStoreType = senderStoreType;
	}

	public String getRecPerson() {
		return recPerson;
	}

	public void setRecPerson(String recPerson) {
		this.recPerson = recPerson;
	}

	public String getRecPersonTel() {
		return recPersonTel;
	}

	public void setRecPersonTel(String recPersonTel) {
		this.recPersonTel = recPersonTel;
	}

	public String getRecPersonProvince() {
		return recPersonProvince;
	}

	public void setRecPersonProvince(String recPersonProvince) {
		this.recPersonProvince = recPersonProvince;
	}

	public String getRecPersonCity() {
		return recPersonCity;
	}

	public void setRecPersonCity(String recPersonCity) {
		this.recPersonCity = recPersonCity;
	}

	public String getRecPersonCounty() {
		return recPersonCounty;
	}

	public void setRecPersonCounty(String recPersonCounty) {
		this.recPersonCounty = recPersonCounty;
	}

	public String getRecPersonAddress() {
		return recPersonAddress;
	}

	public void setRecPersonAddress(String recPersonAddress) {
		this.recPersonAddress = recPersonAddress;
	}

	public String getRecStoreCode() {
		return recStoreCode;
	}

	public void setRecStoreCode(String recStoreCode) {
		this.recStoreCode = recStoreCode;
	}

	public Integer getRecStoreType() {
		return recStoreType;
	}

	public void setRecStoreType(Integer recStoreType) {
		this.recStoreType = recStoreType;
	}

	public Integer getTakePartType() {
		return takePartType;
	}

	public void setTakePartType(Integer takePartType) {
		this.takePartType = takePartType;
	}

	public Date getTakePartTime() {
		return takePartTime;
	}

	public void setTakePartTime(Date takePartTime) {
		this.takePartTime = takePartTime;
	}

	public Integer getProductType() {
		return productType;
	}

	public void setProductType(Integer productType) {
		this.productType = productType;
	}

	public Integer getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(Integer paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Integer getIncrementService() {
		return incrementService;
	}

	public void setIncrementService(Integer incrementService) {
		this.incrementService = incrementService;
	}

	public BigDecimal getInsureValue() {
		return insureValue;
	}

	public void setInsureValue(BigDecimal insureValue) {
		this.insureValue = insureValue;
	}

	public BigDecimal getFreight() {
		return freight;
	}

	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}

	public Integer getParcelQuantity() {
		return parcelQuantity;
	}

	public void setParcelQuantity(Integer parcelQuantity) {
		this.parcelQuantity = parcelQuantity;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getCreateMailTime() {
		return createMailTime;
	}

	public void setCreateMailTime(Date createMailTime) {
		this.createMailTime = createMailTime;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}
