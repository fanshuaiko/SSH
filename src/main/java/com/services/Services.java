package com.services;

import java.util.List;

import com.entity.PageBean;



public interface Services {
	<T> void insert(T t);//保存单个对象
	<T> T query(T t);//查询单个对象
	<T> List<T> queryList();//查询所有的对象
	<T> T findById(int id);//根据id查询单个对象
	<T> void update(T t);//更新单个对象
	<T> int deleleList(int ids[]);//删除多个对象
	 <T> PageBean<T> queryByPage(int pageSize,int currentPage);//分页查询
	 int getTotalCount();//获得总记录数
}
