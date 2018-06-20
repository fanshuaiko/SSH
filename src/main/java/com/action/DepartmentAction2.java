package com.action;

import java.util.List;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.entity.Department;
import com.opensymphony.xwork2.ActionSupport;
import com.services.Services;

/**
 * 
 * 凡帅 2018年4月16日下午6:51:56 部门管理的action，目前只实现了查询所有部门的功能
 *
 */
@Controller
@Scope("prototype")
@Namespace("/DepartmentAction2")
@ParentPackage("json-default")
public class DepartmentAction2 extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private Services departmentServicesImpl;

	public void setDepartmentServicesImpl(Services departmentServicesImpl) {
		this.departmentServicesImpl = departmentServicesImpl;
	}
    //返回Ajax请求的数据
	private String jsonResult;
	private String condition;

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}

	/**
	 * 查询所有的部门
	 * 
	 * @return
	 */
	@Action(value = "QueryAll", results = { @Result(name = "success", type = "json",params={"root","jsonResult"}),
			@Result(name = "input", type = "json") })
	public String QueryAll() {
		System.out.println("接受到Ajax传的参数：" + condition);
		
		List<Department> departmentList = departmentServicesImpl.queryList();
		if (!departmentList.isEmpty()) {
		  jsonResult = new JSONArray(departmentList).toString();
			return SUCCESS;
		} else {
			this.addActionError("数据库没有数据！");
			return INPUT;
		}
	}

	

}
