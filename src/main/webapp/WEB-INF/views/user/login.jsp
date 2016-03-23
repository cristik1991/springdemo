<%@page contentType="text/html;charset=UTF-8" %>

<html>
<title>用户登录</title>
<head>
	<script src="${base}/static/js/jquery-1.8.3.js"></script>
	<script src="${base}/static/js/main.js"></script>
	<script>
		$(function(){
			$("#submit").click(function(){
				var form = $("#form").serializeObject();
				$.ajax({
					type:"post",
					url:"${base}/api/user/login",
					data:JSON.stringify(form),
					dataType: "json",
					contentType:"application/json",
					success:function(data){
						alert(data.msg);
						window.location.href="${base}${url}";
					}
				})
			})
		})
	</script>
</head>
<body>

<div>
	<form id="form" method="post" action="${base}/api/user/login">
		<label>用户名</label><input type="text" name="userName"/>
		<label>密码</label><input type="password" name="password"/>
	</form>
	<input type="button" id="submit" value="登录"/>
	<input type="button" value="注册" onclick="window.location.href='${base}/user/toregister'">
</div>
</body>
</html>
