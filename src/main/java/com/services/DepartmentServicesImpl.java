package com.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.Dao;
import com.entity.PageBean;
@Service
@Transactional
public class DepartmentServicesImpl implements Services {
	@Autowired
	private Dao departmentDaoImpl;
	public void setDepartmentDaoImpl(Dao departmentDaoImpl) {
		this.departmentDaoImpl = departmentDaoImpl;
	}

	public <T> void insert(T t) {
		// TODO Auto-generated method stub
		departmentDaoImpl.insert(t);
	}

	public <T> T query(T t) {
		// TODO Auto-generated method stub
		T department = departmentDaoImpl.query(t);
		return department;
	}

	public <T> List<T> queryList() {
		// TODO Auto-generated method stub
		List<T> list = departmentDaoImpl.queryList();
		return list;
	}

	public <T> T findById(int id) {
		// TODO Auto-generated method stub
		T department = departmentDaoImpl.findById(id);
		return department;
	}

	public <T> void update(T t) {
		// TODO Auto-generated method stub
		departmentDaoImpl.update(t);
	}

	public <T> int deleleList(int[] ids) {
		// TODO Auto-generated method stub
		int n = departmentDaoImpl.deleleList(ids);
		return n;
	}

	

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T> PageBean<T> queryByPage(int pageSize, int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

}
