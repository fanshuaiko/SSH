<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理系统</title>
<script type="text/javascript">
</script>
<link
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
	
</head>
<body style="background-color: #eee;">

		<div class="container" style="width: 330px; padding-top: 150px">
			<h3>
				<s:actionerror />
				<s:actionmessage />
			</h3>
			<s:form method="post" theme="simple"
				action="/ManagerAccountAction/login" class="form-signin">
				<h2 class="form-signin-heading">Please sign in</h2>
				<label for="inputName" class="sr-only">用户名</label>
				<input type="text" name="mname" id="inputName" class="form-control"
					placeholder="用户名" required autofocus>
				<label for="inputPassword" class="sr-only">密码</label>
				<input type="password" name="mpassword" id="inputPassword"
					class="form-control" placeholder="密码" required />
				<div class="checkbox">
					<label> <input type="checkbox" value="remember-me">
						记住密码oookk
					</label>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">
					登陆</button>
			</s:form>
		</div>

</body>
</html>