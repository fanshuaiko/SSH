package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.ManagerAccount;
@Repository
public class ManagerAccountDaoImpl  implements Dao {

	@Autowired
	private SessionFactory sessionFactory;
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public <T> void insert(T t) {
		// TODO Auto-generated method stub

	}

	

	@SuppressWarnings("unchecked")
	public <T> T query(T t) {
		String hql = "from ManagerAccount where mname = ? and mpassword = ?";
		List<ManagerAccount> list = sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter(0,((ManagerAccount) t).getMname()).setParameter(1, ((ManagerAccount) t).getMpassword()).list();
		if (list.size()>0) {
			return (T) list.get(0);
		} else {
			return null;
		}
	}



	public <T> List<T> queryList() {
		// TODO Auto-generated method stub
		return null;
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
	public <T> List<T> queryByPage(int startRow,int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return 0;
	}




}
