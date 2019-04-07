package com.cc.shop.support.address.dao;

import com.cc.shop.framework.common.page.PagingResult;
import com.cc.shop.framework.common.persistence.BaseMybatisDAO;
import com.cc.shop.framework.common.search.Search;
import com.cc.shop.support.address.entity.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 地址
 */
@Repository
public class AddressDAO extends BaseMybatisDAO {

    private final String MAPPER_NAMESPACE = "com.cc.shop.support.address.entity.AddressMapper";

    /**
     * 保存
     * @param address
     */
    public void save(Address address) {
        super.save(MAPPER_NAMESPACE + ".insertSelective", address);
    }

    /**
     * 查询全部
     * @return
     */
    public List<Address> findByUserId(Long userId) {
        return super.findAll(MAPPER_NAMESPACE + ".selectByUserId", userId);
    }

    /**
     * 查询
     * @return
     */
    public Address findById(Long id) {
        return super.findOne(MAPPER_NAMESPACE + ".selectById", id);
    }

    /**
     * 分页查询
     * @param search
     * @return
     */
    public PagingResult<Address> findPage(Search search) {
        return super.findForPage(MAPPER_NAMESPACE + ".countPage", MAPPER_NAMESPACE + ".selectPage", search);
    }

}
