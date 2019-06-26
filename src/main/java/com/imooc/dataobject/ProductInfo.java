package com.imooc.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.imooc.enums.ProductStatusEnum;
import com.imooc.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品
 * Created by 廖师兄
 * 2017-05-09 11:30
 * CREATE TABLE `product_info` (
 * `product_id` varchar(32) NOT NULL,
 * `product_name` varchar(64) NOT NULL COMMENT '商品名称',
 * `product_price` decimal(8,2) NOT NULL COMMENT '单价',
 * `product_stock` int(11) NOT NULL COMMENT '库存',
 * `product_description` varchar(64) DEFAULT NULL COMMENT '描述',
 * `product_icon` varchar(512) DEFAULT NULL COMMENT '小图',
 * `product_status` tinyint(3) DEFAULT '0' COMMENT '商品状态,0正常1下架',
 * `category_type` int(11) NOT NULL COMMENT '类目编号',
 * `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 * `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
 * PRIMARY KEY (`product_id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 */
@Entity
@Data
/**时间自动的更新*/
@DynamicUpdate
public class ProductInfo {

    @Id
    private String productId;

    /**
     * 名字.
     */
    private String productName;

    /**
     * 单价.
     */
    private BigDecimal productPrice;

    /**
     * 库存.
     */
    private Integer productStock;

    /**
     * 描述.
     */
    private String productDescription;

    /**
     * 小图.
     */
    private String productIcon;

    /**
     * 状态, 0正常1下架.
     * 新增商品的时候默认是在架的
     */
    private Integer productStatus=ProductStatusEnum.UP.getCode();

    /**
     * 类目编号.category和productInfo通过这个字段进行关联
     */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
    /**忽略掉*/
    //todo  下面的这个字段移动要是public否则拿不到value;
    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }

}
