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
	<s:form action="/DepartmentAction/update" method="post">
		<s:hidden name="department.did"></s:hidden>
		<s:textfield label="姓名" name="department.dname"></s:textfield>
		<s:textarea label="描述" name="department.ddescription"></s:textarea>
		<s:submit value="提交" theme="simple"></s:submit>
		<s:reset value="重置" theme="simple"></s:reset>
	</s:form>
</body>
</html>