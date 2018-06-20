package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Department;
import com.entity.Employee;

@Repository
@SuppressWarnings("unchecked")
/**
 * 部门管理DAO 凡帅 2018年4月16日下午6:58:43
 *
 *
 */
public class DepartmentDaoImpl implements Dao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public <T> void insert(T t) {
		sessionFactory.getCurrentSession().saveOrUpdate(t);
	}

	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public <T> T query(T t) {

		return null;
	}

	// 查询多个对象
	public <T> List<T> queryList() {
		String hql = "from Department";
		List<T> list = sessionFactory.getCurrentSession().createQuery(hql).list();
		return list;
	}

	public <T> T findById(int id) {
		String hql = "from Department where id = ?";
		T department = (T) sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, id).uniqueResult();
		return department;
	}

	public <T> void update(T t) {
		sessionFactory.getCurrentSession().update(t);
	}

	public <T> int deleleList(int[] ids) {
		String hql = " from Department where ";
		String hqlCondition = " ";
		String hql2 = "from Employee where ";
		String hql2Condition = "";

		for (int i = 0; i < ids.length; i++) {
			if (i == 0) {
				hqlCondition = "id = " + ids[i];
				hql2Condition = "did = " + ids[i];
			} else {
				hqlCondition += " or id = " + ids[i];
				hql2Condition += " or did = " + ids[i];
			}
		}
		List<Employee> employeeList = sessionFactory.getCurrentSession().createQuery(hql2 + hql2Condition).list();
		List<Department> departmentList = sessionFactory.getCurrentSession().createQuery(hql + hqlCondition).list();
		for (Employee employee : employeeList) {
			employee.setDepartment(null);
			sessionFactory.getCurrentSession().update(employee);
		}
		for (Department department : departmentList) {
			sessionFactory.getCurrentSession().delete(department);
		}
		// int n =
		// sessionFactory.getCurrentSession().createQuery(hql+hqlCondition).executeUpdate();

		return 0;
	}

	@Override
	public <T> List<T> queryByPage(int startRow, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
