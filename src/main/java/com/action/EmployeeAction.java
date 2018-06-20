package com.action;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.entity.Department;
import com.entity.Employee;
import com.entity.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.services.Services;

/**
 * 
 * 凡帅  2018年4月16日下午6:53:59
 *员工管理的action
 *
 */
@Controller
@Scope("prototype")
@Namespace("/EmployeeAction")
@ParentPackage("json-default")
public class EmployeeAction extends ActionSupport  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Employee employee;
	private int currentPage = 1;
//	private int pageSize;

	@Autowired
	private Services employeeServicesImpl;

	public void setServices(Services employeeServicesImpl) {
		this.employeeServicesImpl = employeeServicesImpl;
	}
	@Autowired
	private Services departmentServicesImpl;

	public void setDepartmentServicesImpl(Services departmentServicesImpl) {
		this.departmentServicesImpl = departmentServicesImpl;
	}
	private String[] checkboxList;//
	private int eid;//单记录的主键号
	private Department department;
	private String jsonResult;
	

	

	/**
	 * 查询所有员工
	 * 
	 * @return
	 */
	@Action(value = "QueryAll", results = { @Result(name = "input", location = "/pages/showEmployeeList2.jsp"),
			@Result(name = "success", location = "/pages/showEmployeeList.jsp") })
	public String QueryAll() {
		List<Employee> EmployeeList = employeeServicesImpl.queryList();
//		for (Employee employee : EmployeeList) {
//			System.out.println(employee.getDepartment().getDname());
//		}
		if (!EmployeeList.isEmpty()) {
			ActionContext.getContext().getValueStack().set("EmployeeList", EmployeeList);
			return SUCCESS;
		} else {
			this.addActionMessage("数据库没有数据！");
			return INPUT;
		}
	}

	/**
	 * 根据id查找员工
	 */
	@Action(value = "findById", results = { @Result(name = "success", location = "/pages/updateEmployee.jsp",type="dispatcher")})
	public String findById() {
		System.out.println("eid: "+ eid);
		employee = employeeServicesImpl.findById(eid);
		List<Department> departmentList = departmentServicesImpl.queryList();//查询所有的部门
		ActionContext.getContext().getValueStack().set("departmentList", departmentList);//将查询到的部门集合放入到值栈中
		return SUCCESS;
	}
	
	
	/**
	 * 根据id查找员工，返回json
	 */
	@Action(value = "findByIdReturnJson", results = { @Result(name = "success",type="json",params={"root","jsonResult"}),
			@Result(name="input",type="json")})
	public String findByIdReturnJson() {
		System.out.println("eid: "+ eid + "进入了findByIdReturnJson！");
		employee = employeeServicesImpl.findById(eid);
		 jsonResult = new JSONObject(employee).toString();
		 System.out.println(jsonResult);
//		List<Department> departmentList = departmentServicesImpl.queryList();//查询所有的部门
//		ActionContext.getContext().getValueStack().set("departmentList", departmentList);//将查询到的部门集合放入到值栈中
		 if(!jsonResult.isEmpty()) {
				
			 return SUCCESS;
			}else {
				return INPUT;
			}
	}

	/**
	 * 跳转到添加员工的方法
	 */
	@Action(value = "saveUI", results = { @Result(name = "success", location = "/pages/insertEmployee.jsp")})
	public String saveUI() {
		List<Department> departmentList = departmentServicesImpl.queryList();//查询所有的部门
		ActionContext.getContext().getValueStack().set("departmentList", departmentList);//将查询到的部门集合放入到值栈中
		return SUCCESS;
	}
	/**
	 * 添加单个员工
	 */
	@Action(value = "insert", results = { @Result(name = "success", location = "/queryByPage", type = "redirectAction") })
	public String insert() {
		employeeServicesImpl.insert(employee);
		return SUCCESS;
	}
	
	/**
	 * 更新员工信息
	 */
	@Action(value = "update", results = { @Result(name = "success", location = "/queryByPage", type = "redirectAction") })
	public String update() {
		employeeServicesImpl.update(employee);
		return SUCCESS;
	}


	/**
	 * 删除员工
	 */
	@Action(value = "deleteList", results = {
			@Result(name = "success", location = "/queryByPage", type = "redirectAction") })
	public String deleteList() {
		int[] ids = new int[checkboxList.length];
		System.out.println("ids.length: " + ids.length);
		for (int i = 0; i < checkboxList.length; i++) {
			ids[i] = Integer.parseInt(checkboxList[i]);
		}
		employeeServicesImpl.deleleList(ids);
		return SUCCESS;
	}
/**
 * 分页查询
 */
	@Action(value = "queryByPage", results = { @Result(name = "input", location = "/pages/showEmployeeList2.jsp"),
			@Result(name = "success", location = "/pages/showEmployeeList.jsp") })
	public String queryByPage() {
		int pageSize = 1;
		PageBean<Employee> pageBean= employeeServicesImpl.queryByPage(pageSize, currentPage);
		if (!pageBean.getList().isEmpty()) {
			ActionContext.getContext().getValueStack().push(pageBean);
			return SUCCESS;
		} else {
			this.addActionMessage("数据库没有数据！");
			return INPUT;
		}
	}
	
	public String[] getCheckboxList() {
		return checkboxList;
	}

	public void setCheckboxList(String[] checkboxList) {
		this.checkboxList = checkboxList;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}

	
	
	
}
