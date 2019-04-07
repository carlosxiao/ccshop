package com.cc.shop.support.help.service;

import java.util.List;

import com.cc.shop.support.help.dao.HelpInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.shop.support.help.entity.HelpInfo;


/**
 * HelpInfoService
 */
@Service
public class HelpInfoService {
	
	@Autowired private HelpInfoDAO helpInfoDAO;
	
	/**
	 * 获取在页面上显示的帮助信息
	 * @return
	 */
	public List<HelpInfo> getListForShow() {
		return helpInfoDAO.getListForShow();
	}
}