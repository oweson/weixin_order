package com.imooc.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 类目
 * Created by SqMax on 2018/3/17.
 * CREATE TABLE `product_category` (
 * `category_id` int(11) NOT NULL AUTO_INCREMENT,
 * `category_name` varchar(64) NOT NULL COMMENT '类目名字',
 * `category_type` int(11) NOT NULL COMMENT '类目编号',
 * `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 * `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
 * PRIMARY KEY (`category_id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
 */
@Entity
@DynamicUpdate
@Data
//@Table(name = "product_category")
public class ProductCategory {
    /**
     * 类目id.
     **/
    @Id
    @GeneratedValue
    private Integer categoryId;
    /**
     * 类目名字
     **/
    private String categoryName;
    /**
     * 类目编号
     **/
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
    // 字段不对应！！！

    public ProductCategory() {

    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }


}
