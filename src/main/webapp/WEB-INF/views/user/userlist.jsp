<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html;charset=UTF-8" %>

<html>
<title>用户信息</title>
<head>
	<script src="${base}/static/js/jquery-1.8.3.js"></script>
	<script>
		$(function(){

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
<body>
<h2>Hello World!</h2>
<div>
	<input type="button" id="adduser" value="新增" onclick="addUser()"/>
	<table>
		<th>
			<td>ID</td>
			<td>姓名</td>
			<td>密码</td>
			<td>年龄</td>
			<td>性别</td>
			<td>操作</td>
		</th>
		<c:forEach items="${list}" var ="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.password}</td>
				<td>${user.age}</td>
				<td>${user.sex}</td>
				<td>
					<input type="button" value="查看" onclick="showDetail(${user.id})">
					<input type="button" value="修改" onclick="updateUser(${user.id})">
					<input type="button" value="删除" onclick="deleteUser(${user.id})">
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>
