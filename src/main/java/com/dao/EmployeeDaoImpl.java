package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
@SuppressWarnings("unchecked")
public class EmployeeDaoImpl implements Dao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public <T> void update(T t) {
		sessionFactory.getCurrentSession().update(t);
	}

	public <T> int deleleList(int[] ids) {
		
		int n = 0;
		String hqlCondition = "";
		String hql = "delete from Employee where ";
		for (int i = 0; i < ids.length; i++) {
			if (i == 0) {
				hqlCondition = "id = " + ids[i];
			} else {
				hqlCondition += " or id = " + ids[i];
			}
		}
		sessionFactory.getCurrentSession().createQuery(hql + hqlCondition).executeUpdate();
		return n;
	}

	public <T> void insert(T t) {
		sessionFactory.getCurrentSession().save(t);
	}

	public <T> T query(T t) {
		return null;
	}

	public <T> List<T> queryList() {
		String hql = "from Employee";
		List<T> list = sessionFactory.getCurrentSession().createQuery(hql).list();
		return list;
	}

	public <T> T findById(int id) {
		String hql = " from Employee  where id = ?";
		List<T> list = sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, id).list();
		return (T) list.get(0);
	}

	@Override
	public <T> List<T> queryByPage(int startRow,int pageSize) {
		// TODO Auto-generated method stub
		String hql = "from Employee";
		List<T> list = sessionFactory.getCurrentSession().createQuery(hql).setFirstResult(startRow).setMaxResults(pageSize).list();
		return list;
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Employee";
		int totalCount = Integer.parseInt(String.valueOf(sessionFactory.getCurrentSession().createQuery(hql).uniqueResult()));
		return totalCount;
	}

}
