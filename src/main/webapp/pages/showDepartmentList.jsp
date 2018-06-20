 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理系统</title>
<link
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
	<script type="text/javascript">
	function deleteChoose() {
		if(confirm("要删除所选吗？")){
			document.f2.action="<%=request.getContextPath()%>/DepartmentAction/deleteList";
		}
	}
	function selectAll() {
		 var checkall=document.getElementById("checkall");
		 var checkboxList=document.getElementsByName("checkboxList");
         //checkall判断是否选中
         if(checkall.checked==true)
         {
             for(var x=0;x<checkboxList.length;x++)
             {
                 checkboxList[x].checked=true;
             }
         }
         else
         {
        	 for(var x=0;x<checkboxList.length;x++)
             {
                 checkboxList[x].checked=false;
             }
         }
		}
      
		
	
	</script>
</head>
<body>
<s:actionerror/>
<ul class="nav nav-tabs">
  <li role="presentation" class="active"><a href="#">Home</a></li>
  <li role="presentation"><a href="<%=request.getContextPath()%>/pages/insertDepartment.jsp">添加</a></li>
</ul>
 <s:form method="post" name="f2">
 <input type="submit" value="删除" onclick="deleteChoose()">
	<table class="table table-striped table-hover">
		<tr>
			<th><input type="checkbox" id="checkall" onclick="selectAll()"/></th>
			<th>部门名称</th>
			<th>部门描述</th>
			<th>操作</th>
		</tr>
		<s:iterator value="departmentList" var="department">
		<tr>
		<td><input type="checkbox" name="checkboxList" value="${did}"></td>
		<td><s:property value="#department.dname"/></td>
		<td><s:property value="#department.ddescription"/></td>
		<td><a href="<%=request.getContextPath()%>/DepartmentAction/findById?id=${did}">编辑</a></td>
		
		</tr>
		</s:iterator>
	</table>
</s:form>

</body>
</html>