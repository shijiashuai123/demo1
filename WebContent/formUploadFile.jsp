<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜鸟教程</title>
</head>
<body>
	<h2>上传文件</h2>
	<form method="post" action="/demo1/UploadFile">
		选择一个文件:
	    <input type="file" name="uploadFile" />
	    <br/><br/>
	    <input type="submit" value="确认" />
	</form>
</body>
</html>