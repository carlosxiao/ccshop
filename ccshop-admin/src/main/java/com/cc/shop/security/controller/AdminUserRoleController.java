package com.cc.shop.security.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cc.shop.base.controller.AjaxResult;
import com.cc.shop.base.controller.BaseAdminController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.shop.security.entity.AdminRole;
import com.cc.shop.security.entity.AdminUser;
import com.cc.shop.security.entity.AdminUserRole;
import com.cc.shop.security.service.AdminRoleService;
import com.cc.shop.security.service.AdminUserRoleService;
import com.cc.shop.security.service.AdminUserService;
import com.cc.shop.framework.common.page.PagingResult;
import com.cc.shop.framework.common.search.Search;

/**
 * Admin用户授权
 */
@Controller
@RequestMapping(value = "/security/adminUserRole")
public class AdminUserRoleController extends BaseAdminController {
	
	@Autowired private AdminUserService adminUserService;
	
	@Autowired private AdminRoleService adminRoleService;
	
	@Autowired private AdminUserRoleService adminUserRoleService;
	
	@RequestMapping(value = "/index")
	public String adminUserList(Model model, Search search) {
		return "/security/user/authorize_adminuser_list";
	}
	
	@RequestMapping(value = "/listAdminUser", method = RequestMethod.POST)
	@ResponseBody
	public PagingResult<AdminUser> listAdminUser(Model model, Search search) {
		return adminUserService.findAdminUserForPage(search);
	}
	
	@RequestMapping(value = "/setAdminUserAuthorize", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult setAdminUserAuthorize(AdminUser adminUser, String roleIds) {
		List<AdminUserRole> adminUserRoles = new ArrayList<AdminUserRole>();
		AdminUserRole adminUserRole;
		for (String roleId : roleIds.split(",")) {
			adminUserRole = new AdminUserRole();
			adminUserRole.setAdminRoleId(Long.valueOf(roleId));
			adminUserRole.setAdminUserId(adminUser.getId());
			adminUserRole.setCreateTime(new Date());
			adminUserRoles.add(adminUserRole);
		}
		this.adminUserRoleService.saveBatchAdminUserRole(adminUserRoles);
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setStatusCode(AjaxResult.AJAX_STATUS_CODE_SUCCESS);
		return ajaxResult;
	}
	
	@RequestMapping(value = "/deleteAdminUserAuthorize", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult deleteAdminUser(AdminUser adminUser) {
		this.adminUserRoleService.deleteAdminUserRoleByUserId(adminUser.getId());
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setStatusCode(AjaxResult.AJAX_STATUS_CODE_SUCCESS);
		return ajaxResult;
	}
	
	@RequestMapping(value = "/getAdminRole", method = RequestMethod.POST)
	@ResponseBody
	public List<AdminRole> getAdminRole(String idList) {
		if (null == idList || "".equals(idList)) {
			return null;
		}
		List<Long> ids = new ArrayList<>();
		for (String id :idList.split(",")) {
			ids.add(Long.valueOf(id));
		}
		return this.adminRoleService.getAdminRoleByIds(ids);
	}

}
