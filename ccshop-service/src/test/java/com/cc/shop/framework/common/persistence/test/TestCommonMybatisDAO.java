package com.cc.shop.framework.common.persistence.test;

import com.cc.shop.framework.common.persistence.CommonMybatisDAO;
import org.junit.Test;

/**
 * 单元测试类
 */
public class TestCommonMybatisDAO {

    @Test
    public void testSave() {
        CommonMybatisDAO.save(null);
    }

}
