package com.cc.shop.groupon.deal.entity;

import com.cc.shop.framework.base.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * Deal详细信息
 */
public class DealDetail extends BaseEntity {

    @Getter @Setter private Long dealId;

    @Getter @Setter private String dealDetail; // 商品详细描述信息

}
