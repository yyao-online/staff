<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>主页</title>
<style type="text/css">

.body{
	width: 1100px;
	height: 630px;
	margin: 0 auto;
	background: #ccf;
}
.top_div {
	height: 150px;
	background: #88f;
	text-align: center;
	color: #fff;
	line-height: 150px;
	font-style: inherit;
	font-size: 4em;
}
table {
	width: 240px;
	margin: 100px auto;
}
</style>
</head>
<body>
	<div class="body">
	<div class="top_div">企业员工信息管理系统</div>
	<h1 align="center">登&nbsp;&nbsp;录</h1>
	<form action="login/login" method="post">
		<table>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="loginName" /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td></td><td><input type="submit" value="登录" /></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>