
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
			document.f2.action="<%=request.getContextPath()%>/EmployeeAction/deleteList";
		}
	}
	function selectAll() {
		var checkall = document.getElementById("checkall");
		var checkboxList = document.getElementsByName("checkboxList");
		//checkall判断是否选中
		if (checkall.checked == true) {
			for (var x = 0; x < checkboxList.length; x++) {
				checkboxList[x].checked = true;
			}
		} else {
			for (var x = 0; x < checkboxList.length; x++) {
				checkboxList[x].checked = false;
			}
		}
	}
</script>
</head>
<body>
	<s:actionmessage />

	<ul class="nav nav-tabs">
		<li role="presentation" class="active"><a href="#">Home</a></li>
		
	</ul>
	<s:form method="post" name="f2">
		<input type="submit" value="删除" onclick="deleteChoose()">
		<table class="table table-striped table-hover">
			<tr>
				<th><input type="checkbox" id="checkall" onclick="selectAll()" />全选</th>
				<th>文件编号</th>
				<th>文件名</th>
				<th>文件大小</th>
				<th>员工部门</th>
				<th>文件上传时间</th>
				<th>操作</th>
			</tr>
			<s:iterator value="list" var="employee">
				<tr>
					<td><input type="checkbox" name="checkboxList" value="${id}"></td>
					<td><s:property value="#employee.enumber" /></td>
					<td><s:property value="#employee.name" /></td>
					<td><s:property value="#employee.sex" /></td>
					<td><s:property value="#employee.department.dname" /></td>
					<td><s:property value="#employee.address" /></td>
					<td><s:date name="#employee.joinTime" format="yyyy-MM-dd" /></td>
					<td><a
						href="<%=request.getContextPath()%>/EmployeeAction/findById?eid=${id}">编辑</a></td>

				</tr>
			</s:iterator>
		</table>
	</s:form>

<div>
   <input type="file" formenctype="application/x-www-form-urlencoded">
</div>

	<div>
		<nav aria-label="...">
			<ul class="pager">
				<s:if test="currentPage!=1">
					<li><a
						href="<%=request.getContextPath()%>/EmployeeAction/queryByPage?currentPage=1">首页</a></li>
					<li><a
						href="<%=request.getContextPath()%>/EmployeeAction/queryByPage?currentPage=${currentPage-1}">上一页</a></li>
				</s:if>
				<s:if test="currentPage!=totalPage">
					<li><a
						href="<%=request.getContextPath()%>/EmployeeAction/queryByPage?currentPage=${currentPage+1}">下一页</a></li>
					<li><a
						href="<%=request.getContextPath()%>/EmployeeAction/queryByPage?currentPage=${totalPage}">尾页</a></li>
						<li style="color: #9D9D9D">
						第<s:property value="currentPage"/> / <s:property value="totalPage"/>页
						</li>
				</s:if>
			</ul>
		</nav>
	</div>
</body>
</html>