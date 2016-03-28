<%@page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>用户注册</title>
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<jsp:include page="../main/resource.jsp"/>
</head>
<body class="hold-transition register-page">
<div class="register-box">
	<%--<div class="register-logo">
		<a href="${base}/static/adminlte-2.3.0/index2.html"><b>Admin</b>LTE</a>
	</div>--%>

	<div class="register-box-body">
		<p class="login-box-msg">账户注册</p>
		<form id="form" action="${base}/user/register" method="post">
			<div class="form-group has-feedback">
				<input type="text" class="form-control" id="username" name="userName" placeholder="用户名">
				<span class="glyphicon glyphicon-user form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input type="email" class="form-control" id="email" name="email" placeholder="邮箱">
				<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input type="password" class="form-control" id="pwd" name="password" placeholder="密码">
				<span class="glyphicon glyphicon-lock form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input type="password" class="form-control" id="repeat-pwd" placeholder="重复密码">
				<span class="glyphicon glyphicon-log-in form-control-feedback"></span>
			</div>
			<div class="row">
				<div class="col-xs-8">
					<div class="checkbox icheck">
						<label>
							<input type="checkbox"> 我同意以下 <a href="#">条款</a>
						</label>
					</div>
				</div><!-- /.col -->
				<div class="col-xs-4">
					<button type="button" id="register" class="btn btn-primary btn-block btn-flat">注册</button>
				</div><!-- /.col -->
			</div>
		</form>

		<div class="social-auth-links text-center">
			<a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> facebook账号登陆</a>
			<a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Google+账号登陆</a>
		</div>

		<a href="login.html" class="text-center">已有账户</a>
	</div>
</div>


<script src="${base}/static/adminlte-2.3.0/plugins/jQuery/jQuery-2.1.4.min.js"></script>

<script src="${base}/static/adminlte-2.3.0/bootstrap/js/bootstrap.min.js"></script>

<script src="${base}/static/adminlte-2.3.0/plugins/iCheck/icheck.min.js"></script>
<script>
	$(function () {

		$("#register").click(function () {

			if(!$("#username").val()){
				alert("用户名不能为空");
				return;
			}
			if(!$("#email").val()){
				alert("联系邮箱不能为空");
				return;
			}
			if(!$("#pwd").val()){
				alert("密码不能为空");
				return;
			}
			if(!$("#repeat-pwd").val()){
				alert("重复密码不能为空");
				return;
			}
			if($("#pwd").val()!=$("#repeat-pwd").val()){
				alert("两次密码必须一直");
				return;
			}
			//$("#form").submit();
			test();
		});

		function test(){
			$("#register").click(function(){
				$.ajax({
					type:"post",
					url:"${base}/user/login",
					data:JSON.stringify($("#form").serializeObject()),
					dataType: "json",
					contentType:"application/json",
					success:function(data){
						alert(data.msg);
						window.location.href="${base}/user/list";
					}
				})


			})
		}

	});
</script>
</body>
</html>

