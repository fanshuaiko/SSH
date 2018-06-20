package com.dao;

import java.util.List;


public interface Dao {

	 <T> void insert(T t);//添加对象到数据库
	 <T> T query(T t);//查询一个对象
	 <T> List<T> queryList();//查询多个对象
	 <T> T findById(int id);//根据ID查找
	 <T> void update(T t);//更新
	 <T> int deleleList(int ids[]);//删除多个对象
	 <T> List<T> queryByPage(int startRow,int pageSize);//分页查询
	 int getTotalCount();//获得总记录数
	 
}
