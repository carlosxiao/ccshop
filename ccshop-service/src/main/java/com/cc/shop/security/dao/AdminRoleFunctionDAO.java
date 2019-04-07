package com.cc.shop.security.dao;

import com.cc.shop.framework.common.persistence.BaseMybatisDAO;
import com.cc.shop.security.entity.AdminRoleFunction;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AdminRoleFunctionDAO
 */
@Repository
public class AdminRoleFunctionDAO extends BaseMybatisDAO {
	
	private final String MAPPER_NAMESPACE = "com.cc.shop.security.entity.AdminRoleFunctionMapper";

	/**
	 *
	 * @param adminRoleFunctions
     */
	public void saveBatch(List<AdminRoleFunction> adminRoleFunctions) {
		super.saveBatch(MAPPER_NAMESPACE + ".batchInsertAdminUserRoles", adminRoleFunctions);
	}

	/**
	 *
	 * @param roleId
     */
	public void deleteByRoleId(Long roleId) {
		super.delete(MAPPER_NAMESPACE + ".deleteByRoleId", roleId);
	}

	/**
	 *
	 * @param roleId
	 * @return
     */
	public List<AdminRoleFunction> findByRoleId(Long roleId) {
		return super.findAll(MAPPER_NAMESPACE + ".findByRoleId", roleId);
	}

	/**
	 * 
	 * @param roleIds
	 * @return
     */
	public List<AdminRoleFunction> findByRoleIds(List<Long> roleIds) {
		Map<String, Object> params = new HashMap<>();
		params.put("roleIds", roleIds);
		return super.findAll(MAPPER_NAMESPACE + ".findByRoleIds", params);
	}

}
