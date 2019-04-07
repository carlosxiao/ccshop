package com.cc.shop.site.dto;

import com.cc.shop.groupon.deal.entity.Deal;
import com.cc.shop.support.favorite.entity.Favorite;
import lombok.Getter;
import lombok.Setter;

/**
 * 个人收藏显示
 */
public class FavoriteDTO {

    @Getter @Setter private Favorite favorite;
    @Getter @Setter private Deal deal;

    public FavoriteDTO(Favorite favorite, Deal deal) {
        this.favorite = favorite;
        this.deal = deal;
    }

}
