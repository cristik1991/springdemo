<%@page contentType="text/html;charset=UTF-8" %>
<html>
<title>用户信息</title>
<head>
	<script src="${base}/static/js/jquery-1.8.3.js"></script>
	<script>
		$(function(){
			$("#submit").click(function(){
				$("#form1").submit();
			})
		})
	</script>
</head>
<body>
<h2>Hello World!</h2>
<div>
	<form id="form1" method="post" action="${base}/user/adduser">
		<label>用户名</label><input type="text" name="name"/>
		<label>密码</label><input type="password" name="password"/>
		<label>年龄</label><input type="text" name="age"/>
		<label>性别</label><input type="text" name="sex"/>
	</form>
	<input type="button" id="submit" value="注册"/>
</div>
</body>
</html>
