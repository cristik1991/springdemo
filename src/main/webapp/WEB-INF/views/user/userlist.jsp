<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<title>用户信息</title>
<head>
	<jsp:include page="../main/resource.jsp"/>
	<script>
		$(function(){
			$("#example1").DataTable();
			$('#example2').DataTable({
				"paging": true,
				"lengthChange": false,
				"searching": false,
				"ordering": true,
				"info": true,
				"autoWidth": false
			});
		})
		function deleteUser(id){
			var url="${base}/user/deleteuser?id="+id;
			$.ajax({
						type:"post",
						url:url,
						dataType:"json",
						success:function(data) {
							var obj = eval(data);
							if(obj.success){
								window.location.href="${base}/user/list";
							}else{
								alert(obj.msg);
							}
						},
						error:function(e){
							alert(e);
						}
					}
			)
		}
		function showDetail(id){
			window.location.href="${base}/user/detail?id="+id;
		}
		function addUser(){
			window.location.href="${base}/user/toadduser";
		}
		function updateUser(id){
			window.location.href="${base}/user/toupdateuser?id="+id;
		}
	</script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
	<%--头部--%>
	<jsp:include page="../main/header.jsp"/>
	<%--导航栏--%>
	<jsp:include page="../main/navigation.jsp"/>
	<%--主体部分--%>
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>
				用户列表
			</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i>主菜单</a></li>
				<li class="active">用户列表</li>
			</ol>
		</section>

		<section class="content">
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
						<div class="box-header">
							<h3 class="box-title">用户列表</h3>
						</div><!-- /.box-header -->
						<div class="box-body">
							<table id="example1" class="table table-bordered table-hover">
								<thead>
								<tr>
									<th>用户名</th>
									<th>邮箱</th>
									<th>性别</th>
									<th>年龄</th>
									<th>状态</th>
									<th>创建时间</th>
									<th>更新时间</th>
									<th>操作</th>
								</tr>
								</thead>
								<tbody>
									<c:forEach items="${list}" var ="user">
										<tr>
											<td>${user.userName}</td>
											<td>${user.email}</td>
											<td>${user.sex}</td>
											<td>${user.age}</td>
											<td>${user.status}</td>
											<td><fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd"/> </td>
											<td><fmt:formatDate value="${user.updateTime}" pattern="yyyy-MM-dd"/></td>
											<td>
												<input type="button" value="查看" onclick="showDetail(${user.id})">
												<input type="button" value="修改" onclick="updateUser(${user.id})">
												<input type="button" value="删除" onclick="deleteUser(${user.id})">
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div><!-- /.box-body -->
					</div><!-- /.box -->

					<div class="box">
						<div class="box-header">
							<h3 class="box-title">Data Table With Full Features</h3>
						</div><!-- /.box-header -->
						<div class="box-body">
							<table id="example2" class="table table-bordered table-striped">
								<thead>
								<tr>
									<th>用户名</th>
									<th>邮箱</th>
									<th>性别</th>
									<th>年龄</th>
									<th>状态</th>
									<th>创建时间</th>
									<th>更新时间</th>
									<th>操作</th>
								</tr>
								</thead>
								<tbody>
									<c:forEach items="${list}" var ="user">
										<tr>
											<td>${user.userName}</td>
											<td>${user.email}</td>
											<td>${user.sex}</td>
											<td>${user.age}</td>
											<td>${user.status}</td>
											<td><fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd"/> </td>
											<td><fmt:formatDate value="${user.updateTime}" pattern="yyyy-MM-dd"/></td>
											<td>
												<input type="button" value="查看" onclick="showDetail(${user.id})">
												<input type="button" value="修改" onclick="updateUser(${user.id})">
												<input type="button" value="删除" onclick="deleteUser(${user.id})">
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div><!-- /.box-body -->
					</div><!-- /.box -->
				</div><!-- /.col -->
			</div><!-- /.row -->
		</section>
	</div>
	<%--页尾部分--%>
	<jsp:include page="../main/footer.jsp"/>
	<%--样式风格控制--%>
	<jsp:include page="../main/control-sidebar.jsp"/>
</div>
<script src="${base}/static/adminlte-2.3.0/dist/js/demo.js"></script>
</body>
</html>








<%--<body>
<div>
	<input type="button" id="adduser" value="新增" onclick="addUser()"/>
	<table>
		<th>
			<td>姓名</td>
			<td>性别</td>
			<td>年龄</td>
			<td>状态</td>
			<td>创建时间</td>
			<td>更新时间</td>
			<td>操作</td>
		</th>
		<c:forEach items="${list}" var ="user">
			<tr>
				<td>${user.userName}</td>
				<td>${user.sex}</td>
				<td>${user.age}</td>
				<td>${user.status}</td>
				<td><fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd"/> </td>
				<td><fmt:formatDate value="${user.updateTime}" pattern="yyyy-MM-dd"/></td>
				<td>
					<input type="button" value="查看" onclick="showDetail('${user.id}')">
					<input type="button" value="修改" onclick="updateUser('${user.id}')">
					<input type="button" value="删除" onclick="deleteUser('${user.id}')">
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>--%>
