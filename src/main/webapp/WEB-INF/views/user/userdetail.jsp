<%@page contentType="text/html;charset=UTF-8" %>
<html>
<title>用户详情</title>
<head>
	<script src="${base}/static/js/jquery-1.8.3.js"></script>
</head>
<body>
<h2>Hello World!</h2>
<div>
	<label>ID</label><div>${user.id}</div>
	<label>用户名</label><div>${user.userName}</div>
	<label>密码</label><div>${user.password}</div>
	<label>年龄</label><div>${user.age}</div>
	<label>性别</label><div>${user.sex}</div>
</div>
</body>
</html>
