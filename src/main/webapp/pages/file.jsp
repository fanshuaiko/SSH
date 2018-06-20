<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">


</head>
<body>
	<form method="post"
		action="<%=request.getContextPath()%>/FileAction/fileUpload"
		enctype="multipart/form-data">
		<input type="file" name="file" />
		 <input type="file" name="file" /> 
		 <input type="submit" value="上传">
	</form>


	<s:form method="post" name="f2">
	<table class="table table-striped table-hover">
		<tr>
			<th><input type="checkbox" id="checkall" onclick="selectAll()"/>全选</th>
			<th>文件名称</th>
			<th>操作</th>
		</tr>
		<s:iterator value="downloadFileNameList" var="dfname">
		<tr>
		<td><input type="checkbox" name="checkboxList" value="${did}"></td>
		<td><s:property value="#dfname"/></td>
		<td><a href="">删除</a>
		||<a href="<%=request.getContextPath()%>/FileAction/fileDownload?filename=${dfname}">下载</a>
		</td>
		
		</tr>
		</s:iterator>
	</table>
</s:form>
</body>
</html>