<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理系统</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/content.css?t=0544"
	type="text/css"></link>
<link
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>


	<div id="content">

		<div id="header">
			<nav class="navbar navbar-inverse navbar-fixed-top">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">员工管理系统</a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="#">待完善</a></li>
							<li><a href="#">待完善</a></li>
							<li style="color: red">欢迎您：${sessionScope.username}</li>
							<li><a href="<%=request.getContextPath()%>/index.jsp">退出</a></li>
						</ul>
						<form class="navbar-form navbar-right">
							<input type="text" class="form-control" placeholder="Search...">
						</form>
					</div>
				</div>
			</nav>
		</div>
		<div id="sidebar">
			<ul class="nav nav-pills nav-stacked">
				<li role="presentation" class="active"><a href="<%=request.getContextPath()%>/EmployeeAction/queryByPage" target="iframe_main" >员工管理</a></li>
				<li role="presentation"><a href="#">待完善</a></li>
				<li role="presentation"><a href="#">待完善</a></li>
			</ul>
			<ul class="nav nav-pills nav-stacked">
				<li role="presentation" class="active"><a href="<%=request.getContextPath()%>/DepartmentAction/QueryAll" target="iframe_main">部门管理</a></li>
				<li role="presentation"><a href="#">待完善</a></li>
				<li role="presentation"><a href="#">待完善</a></li>
			</ul>
			<ul class="nav nav-pills nav-stacked">
				<li role="presentation" class="active"><a href="<%=request.getContextPath()%>/FileAction/queryAllFile" target="iframe_main">我的云盘</a></li>
				<li role="presentation"><a href="#">待完善</a></li>
				<li role="presentation"><a href="#">待完善</a></li>
			</ul>
		</div>
		<div id="main">
			<iframe id="iframe_main" name="iframe_main" width="100%"
				height="100%" style="border: 0px"></iframe>
		</div>
		<div id="footer" align="center">Coyright © 2018 凡帅 版权所有</div>
	</div>
</body>
</html>