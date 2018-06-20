<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理系统</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/content.css?t=22"
	type="text/css"></link>
</head>
<body>
	<s:form action="/EmployeeAction/update" method="post">
	<s:hidden name="employee.id"></s:hidden>
		<s:textfield label="员工编号" name="employee.enumber" ></s:textfield>
		<s:textfield label="姓名" name="employee.name"></s:textfield>
		<s:radio list="#{'男':'男','女':'女'}" name="employee.sex" ></s:radio>
		<s:select label="部门" list="departmentList" name="employee.department.did" listKey="did" listValue="dname"></s:select>
		<s:textfield label="地址" name="employee.address"></s:textfield>
		<s:textfield label="入职时间" name="employee.joinTime"></s:textfield>
		<s:submit value="提交" theme="simple"></s:submit>
		<s:reset value="重置" theme="simple"></s:reset>
	</s:form>
</body>
</html>