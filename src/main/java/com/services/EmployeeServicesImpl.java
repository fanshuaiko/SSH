package com.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.Dao;
import com.dao.EmployeeDaoImpl;
import com.entity.PageBean;

@Service
@Transactional
public class EmployeeServicesImpl implements Services {

	@Autowired
	private Dao employeeDaoImpl;
	public void setEmployeeDaoImpl(EmployeeDaoImpl employeeDaoImpl) {
		this.employeeDaoImpl = employeeDaoImpl;
	}

	public <T> void update(T t) {
		// TODO Auto-generated method stub
		employeeDaoImpl.update(t);
	}

	public <T> int deleleList(int[] ids) {
		// TODO Auto-generated method stub
		int n = employeeDaoImpl.deleleList(ids);
		return n;
	}
	public <T> void insert(T t) {
		// TODO Auto-generated method stub
		employeeDaoImpl.insert(t);
	}

	public <T> T query(T t) {
		// TODO Auto-generated method stub
		T t2= (T) employeeDaoImpl.query(t);
		return t2;
	}


	public <T> List<T> queryList() {
		// TODO Auto-generated method stub
		List<T> list = employeeDaoImpl.queryList();
		return list;
	}

	

	public <T> T findById(int id) {
		// TODO Auto-generated method stub
		T employee = employeeDaoImpl.findById(id);
		return employee;
	}


	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		int totalCount = employeeDaoImpl.getTotalCount();
		return totalCount;
	}

	@Override
	public <T> PageBean<T> queryByPage(int pageSize, int currentPage) {
		// TODO Auto-generated method stub
		PageBean<T> pageBean = new PageBean<T>();
		int startRow = (currentPage-1)*pageSize;
		int totalCount = employeeDaoImpl.getTotalCount();
		int totalPage = totalCount % pageSize ==0 ? totalCount/pageSize : totalCount/pageSize + 1;
		
		List<T> list = employeeDaoImpl.queryByPage(startRow, pageSize);
		
		pageBean.setStartRow(startRow);
		pageBean.setPageSize(pageSize);
		pageBean.setList(list);
		pageBean.setAllRow(totalCount);
		pageBean.setTotalPage(totalPage);
		pageBean.setCurrentPage(currentPage);
		
		return pageBean;
	}
	
}
