package com.stylefeng.guns.common.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 产品详情
 * </p>
 *
 * @author zhoushunjia
 * @since 2018-06-09
 */
@TableName("wk_product_info")
public class ProductInfo extends Model<ProductInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 商品id
     */
	@TableField("product_id")
	private String productId;
    /**
     * 商品库存
     */
	@TableField("stock_num")
	private Integer stockNum;
    /**
     * 商品价格
     */
	private BigDecimal price;
    /**
     * 商品颜色
     */
	private String colour;
    /**
     * 商品尺寸
     */
	private String dimens;
    /**
     * 创建人id
     */
	@TableField("created_by")
	private Integer createdBy;
    /**
     * 创建时间
     */
	@TableField("created_date")
	private Date createdDate;
    /**
     * 最后更新人ID
     */
	@TableField("last_updated_by")
	private Integer lastUpdatedBy;
    /**
     * 修改时间
     */
	@TableField("last_update_date")
	private Date lastUpdateDate;
    /**
     * 数据状态0:已删除,1正常
     */
	@TableField("data_status")
	private Integer dataStatus;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getStockNum() {
		return stockNum;
	}

	public void setStockNum(Integer stockNum) {
		this.stockNum = stockNum;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getDimens() {
		return dimens;
	}

	public void setDimens(String dimens) {
		this.dimens = dimens;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Integer lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Integer getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ProductInfo{" +
			"id=" + id +
			", productId=" + productId +
			", stockNum=" + stockNum +
			", price=" + price +
			", colour=" + colour +
			", dimens=" + dimens +
			", createdBy=" + createdBy +
			", createdDate=" + createdDate +
			", lastUpdatedBy=" + lastUpdatedBy +
			", lastUpdateDate=" + lastUpdateDate +
			", dataStatus=" + dataStatus +
			"}";
	}
}
