
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理系统</title>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.0.0.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
	
	
		$(function(){
			$("#findById").click(function(){
				$("#tb tr:not(:first)").empty("");  //删除之前的数据 
				var serchText = $("#serchText").val();
				$.ajax({
					type:"get",
					url:"<%=request.getContextPath()%>/EmployeeAction/findByIdReturnJson?eid=" + serchText,
					async:true,
					dataType:"json",
					success:function(data){
						var json = JSON.parse(data);
						console.log(json);
						/* $("#tb tr:not(:first)").html(""); //删除之前的数据  */
							var s = "";
								s+= "<tr><td>"+"</td><td>"+json.enumber+"</td><td>"+json.name+"</td><td>"+json.sex
								+"</td><td>"+json.department.dname+"</td><td>"+ json.address+"</td><td>"+json.joinTime
								+"</td><td>"+"</td></tr>";
							$("#tb").append(s);
					},
					 error: function () {
			                alert(" 发生错误");
			            }
				});
				alert("this is why!" + serchText);
			})
		})
		
		
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
		<li role="presentation"><a
			href="<%=request.getContextPath()%>/EmployeeAction/saveUI">添加</a></li>
	</ul>

	<!-- 搜索框 -->
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
						<li><a href="#" id="findById">员工号查询</a></li>
						<li><a href="#" id="findByName">员工姓名查询</a></li>
						<li><a href="#" id="findByDepartment">按部门查询</a></li>
					</ul>
				</div>
			</td>
		</tr>
	</table>

	<s:form method="post" name="f2" id="f2">
		<input type="submit" value="删除" onclick="deleteChoose()">
		<table class="table table-striped table-hover" id="tb">
			<tr>
				<th><input type="checkbox" id="checkall" onclick="selectAll()" /></th>
				<th>员工编号</th>
				<th>员工姓名</th>
				<th>员工性别</th>
				<th>员工部门</th>
				<th>员工住址</th>
				<th>员工入职时间</th>
				<th>操作</th>
			</tr>
			
			<%-- <s:iterator value="list" var="employee">
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
			</s:iterator> --%>
		</table>
	</s:form>
	
	<%-- <div>
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
					<li style="color: #9D9D9D">第<s:property value="currentPage" />
						/ <s:property value="totalPage" />页
					</li>
				</s:if>
			</ul>
		</nav>
	</div> --%>
</body>
</html>