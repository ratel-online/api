package com.isnico.api.service;

import java.util.List;

import com.isnico.api.consts.RoleConst;
import com.isnico.api.domain.po.Role;
import com.isnico.api.mapper.RoleMapper;
import org.nico.ourbatis.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService{
	
	@Autowired
	private RoleMapper roleMapper;
	
	public Role selectById(String key) {
		return roleMapper.selectById(key);
	}

	public Role selectEntity(Role condition) {
		return roleMapper.selectEntity(condition);
	}

	public List<Role> selectList(Role condition) {
		return roleMapper.selectList(condition);
	}

	public long selectCount(Object condition) {
		return roleMapper.selectCount(condition);
	}

	public List<Role> selectPage(Page<Object> page) {
		return roleMapper.selectPage(page);
	}

	public String selectId(Role condition) {
		return roleMapper.selectId(condition);
	}

	public List<String> selectIds(Role condition) {
		return roleMapper.selectIds(condition);
	}

	public int insert(Role entity) {
		return roleMapper.insert(entity);
	}

	public int insertSelective(Role entity) {
		return roleMapper.insertSelective(entity);
	}

	public int insertBatch(List<Role> list) {
		return roleMapper.insertBatch(list);
	}

	public int update(Role entity) {
		return roleMapper.update(entity);
	}

	public int updateSelective(Role entity) {
		return roleMapper.updateSelective(entity);
	}

	public int updateBatch(List<Role> list) {
		return roleMapper.updateBatch(list);
	}

	public int delete(Role condition) {
		return roleMapper.delete(condition);
	}

	public int deleteById(String key) {
		return roleMapper.deleteById(key);
	}

	public int deleteBatch(List<String> list) {
		return roleMapper.deleteBatch(list);
	}
	
	public Role selectDefaultRole() {
		return selectEntity(new Role().setType(RoleConst.ROLE_DEFAULT));
	}
}
