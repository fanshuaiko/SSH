package com.action;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import com.entity.Department;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.services.Services;
/**
 * 
 * 凡帅  2018年4月16日下午6:51:56
 *部门管理的action，目前只实现了查询所有部门的功能
 *
 */
@Controller
@Scope("prototype")
@Namespace("/DepartmentAction")
@ParentPackage("struts-default")
public class DepartmentAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Department department;
	@Autowired
	private Services departmentServicesImpl;

	public void setDepartmentServicesImpl(Services departmentServicesImpl) {
		this.departmentServicesImpl = departmentServicesImpl;
	}
	private int id;

	private String[] checkboxList;
	
	/**
	 * 查询所有的部门
	 * @return
	 */
	@Action(value="QueryAll",
			results= {
					@Result(name="success",location="/pages/showDepartmentList.jsp"),
					@Result(name="input",location="/pages/showDepartmentList.jsp")
			})
	public String QueryAll() {
		List<Department> departmentList =  departmentServicesImpl.queryList();
		if(!departmentList.isEmpty()) {
			ActionContext.getContext().getValueStack().set("departmentList", departmentList);
			return SUCCESS;
		}else {
			this.addActionError("数据库没有数据！");
			return INPUT;
		}
	}
	/**
	 * 根据id查找部门
	 */
	@Action(value = "findById", results = { @Result(name = "success", location = "/pages/updateDepartment.jsp",type="dispatcher")})
	public String findById() {
		department = departmentServicesImpl.findById(id);
		List<Department> departmentList = departmentServicesImpl.queryList();//查询所有的部门
		ActionContext.getContext().getValueStack().set("departmentList", departmentList);//将查询到的部门集合放入到值栈中
		return SUCCESS;
	}

	/**
	 * 跳转到添加员工的方法
	 */
	@Action(value = "saveUI", results = { @Result(name = "success", location = "/pages/insertDepartment.jsp")})
	public String saveUI() {
		List<Department> departmentList = departmentServicesImpl.queryList();//查询所有的部门
		ActionContext.getContext().getValueStack().set("departmentList", departmentList);//将查询到的部门集合放入到值栈中
		return SUCCESS;
	}
	/**
	 * 添加单个员工
	 */
	@Action(value = "insert", results = { @Result(name = "success", location = "/QueryAll", type = "redirectAction") })
	public String insert() {
		departmentServicesImpl.insert(department);
		return SUCCESS;
	}
	
	/**
	 * 更新员工信息
	 */
	@Action(value = "update", results = { @Result(name = "success", location = "/QueryAll", type = "redirectAction") })
	public String update() {
		departmentServicesImpl.update(department);
		return SUCCESS;
	}


	/**
	 * 删除员工
	 */
	@Action(value = "deleteList", results = {
			@Result(name = "success", location = "/QueryAll", type = "redirectAction") })
	public String deleteList() {
		int[] ids = new int[checkboxList.length];
		for (int i = 0; i < checkboxList.length; i++) {
			ids[i] = Integer.parseInt(checkboxList[i]);
		}
		
		departmentServicesImpl.deleleList(ids);
		return SUCCESS;
	}

	
	
	public String[] getCheckboxList() {
		return checkboxList;
	}

	public void setCheckboxList(String[] checkboxList) {
		this.checkboxList = checkboxList;
	}
	
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
