package com.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.Dao;
import com.entity.PageBean;
@Service
@Transactional
public class ManagerAccountServicesImpl implements Services {

	@Autowired
	private Dao managerAccountDaoImpl;
	public void setDao(Dao managerAccountDaoImpl) {
		this.managerAccountDaoImpl = managerAccountDaoImpl;
	}

	public <T> void insert(T t) {
		// TODO Auto-generated method stub
		
	}

	public <T> T query(T t) {
		// TODO Auto-generated method stub
		T t2= (T) managerAccountDaoImpl.query(t);
		return t2;
	}


	public <T> List<T> queryList() {
		// TODO Auto-generated method stub
		List<T> list = managerAccountDaoImpl.queryList();
		return list;
	}

	

	public <T> T findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> void update(T t) {
		// TODO Auto-generated method stub
		
	}

	public <T> int deleleList(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
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
