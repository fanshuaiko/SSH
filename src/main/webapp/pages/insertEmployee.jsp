<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理系统</title>
</head>
<body>
<s:form action="/EmployeeAction/insert" method="post" class="form-signin">
	<s:textfield label="编号" name="employee.enumber" ></s:textfield>
	<s:textfield label="姓名" name="employee.name"  ></s:textfield>
	<s:radio  label="性别" list="{'男','女'}" name="employee.sex" value="男"></s:radio>
	<s:select label="部门" list="departmentList" name="employee.department.did" headerKey="" headerValue="请选择" listKey="did" listValue="dname"></s:select>
	<s:textfield label="地址" name="employee.address"></s:textfield>
	<s:textfield label="入职时间" name="employee.joinTime"></s:textfield>
	<s:submit value="提交" theme="simple"></s:submit>
	<s:reset value="重置" theme="simple"></s:reset>
</s:form>
</body>
</html>
