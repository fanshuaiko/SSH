<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理系统</title>
</head>
<body>
<s:form action="/DepartmentAction/insert" method="post" class="form-signin">
	<s:textfield label="姓名" name="department.dname" ></s:textfield>
	<s:textarea label="描述" name="department.ddescription" ></s:textarea>
	<s:submit value="提交" theme="simple"></s:submit>
	<s:reset value="重置" theme="simple"></s:reset>
</s:form>
</body>
</html>
