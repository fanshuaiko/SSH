
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title></title>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
		<%-- function serchByAjax(obj){
			//发送Ajax请求并处理
			var xhr = new XMLHttpRequest();
			xhr.open("GET","<%=request.getContextPath()%>/DepartmentAction2/QueryAll?condition=" +obj.id);
		xhr.send();
		xhr.onreadystatechange = function() {
			if (xhr.readyState === 4) {
				if (xhr.status === 200) {
					var result = xhr.responseText;
					var json = JSON.parse(result);
					console.log(json);
				} else {
					alert("发生错误：" + xhr.statusText);
				}

			}
		}
	} --%>
		
		$(function(){
			$("#findByName").click(function(){
				console.log("进入了此方法");
				$.ajax({
					type:"get",
					dataType:"json",
					url:"<%=request.getContextPath()%>/DepartmentAction2/QueryAll",
					success:function(data){
						console.log(data);
					}
				});
			});
		})
		
</script>
</head>
<body>

	<!-- Split button -->

	<table style="border: 0px">
		<tr>
			<td><input type="email" class="form-control" id="serchText"
				placeholder="jane.doe@example.com" style="width: 200px;"></td>
			<td>
				<!-- Single button -->
				<div class="btn-group">
					<button type="button" class="btn btn-success dropdown-toggle"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						按条件查询 <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a href="#" id="findById" onclick="serchByAjax(this)">员工号查询</a>
						</li>
						<li><a href="#" id="findByName" >员工姓名查询</a>
						</li>
						<li><a href="#" id="findByDepartment"
							onclick="serchByAjax(this)">按部门查询</a></li>
					</ul>
				</div>
			</td>
		</tr>
	</table>

	<s:form method="post" name="f2">
		<input type="submit" value="删除" onclick="deleteChoose()">
		<table class="table table-striped table-hover" id="table">
			<tr>
				<th><input type="checkbox" id="checkall" onclick="selectAll()" /></th>
				<th>部门名称</th>
				<th>部门描述</th>
				<th>操作</th>
			</tr>
			<%-- <s:iterator value="departmentList" var="department">
				<tr>
					<td><input type="checkbox" name="checkboxList" value="${did}"></td>
					<td><s:property value="#department.dname" /></td>
					<td><s:property value="#department.ddescription" /></td>
					<td><a
						href="<%=request.getContextPath()%>/DepartmentAction/findById?id=${did}">编辑</a></td>

				</tr>
			</s:iterator> --%>
		</table>
	</s:form>


</body>



</html>