package com.action;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.entity.ManagerAccount;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.services.Services;
/**
 * 登陆账号action
 * 凡帅  2018年4月16日下午6:56:28
 *
 *
 */
@Controller
@Scope("prototype")
@Namespace("/ManagerAccountAction")
@ParentPackage("struts-default")
public class ManagerAccountAction extends ActionSupport implements ModelDriven<ManagerAccount> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ManagerAccount managerAccount = new ManagerAccount();
	public ManagerAccount getModel() {
		// TODO Auto-generated method stub
		return managerAccount;
	}
	@Autowired
	private Services managerAccountServicesImpl; 
	public void setServices(Services managerAccountServicesImpl) {
		this.managerAccountServicesImpl = managerAccountServicesImpl;
	}

/**
 * 验证登陆
 * @return
 */
	@Action(value="login",
			results= {@Result(name="input",location="/index.jsp"),
			@Result(name="success",location="/pages/content.jsp")})
	public String login() {
		ManagerAccount existManagerAccount = managerAccountServicesImpl.query(managerAccount);
		if(existManagerAccount==null) {
			this.addActionError("用户名或密码错误！");
			return INPUT;
		}else {
			ActionContext.getContext().getSession().put("username", existManagerAccount.getMname());
			return SUCCESS;
		}
	}
}
