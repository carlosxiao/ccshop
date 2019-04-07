package com.cc.shop.support.help.dao;

import java.util.List;

import com.cc.shop.framework.common.persistence.BaseMybatisDAO;
import org.springframework.stereotype.Repository;

import com.cc.shop.support.help.entity.HelpInfo;

/**
 * 帮助信息
 */
@Repository
public class HelpInfoDAO extends BaseMybatisDAO {

	private static final String MAPPER_NAMESPACE = "com.cc.shop.support.help.entity.HelpInfoMapper";
	
	/**
	 * 查询用于在页面显示的帮助信息
	 * @return
	 */
	public List<HelpInfo> getListForShow() {
		return findAll(MAPPER_NAMESPACE + ".selectListForShow");
	}
}