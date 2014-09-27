<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>主页</title>
<link type="text/css" rel="stylesheet" media="all" href="../style/common.css" />
<style type="text/css">

#head{
	line-height:50px;
	font-size:1.5em;
	background: #22f;
	color: #fff;
	text-align: center;
}

.tdf{
	text-align: center;
}
#submit{
	width: 100%;
	height: 30px;
	font-size: 1.2em;
	background: #99f;
	border: 0;
	color: white;
}
#salary {
	background: #ccc;
}
table {
	width: 220px;
	margin: 0 auto;
}
</style>
<script type="text/javascript">
	function ok() {
		location.href = '../employ/findEmploy';
	}
</script>
</head>
<body>
	<div class="body">
		<%@include file="/WEB-INF/main/login_msg.jsp"%>
		<div class="top_div">企业员工信息管理系统</div>
		<div class="left_div">
			<a href="../employ/findEmploy"><div class="zhu">基本信息</div></a>
			<a href="../employ/toAddEmploy"><div class="fu" id="select">添加</div></a>
			<a href="../salary/findSalary"><div class="zhu">工资管理</div></a>
			<a href="../attendance/toAttendance"><div class="zhu">考勤管理</div></a>
			<a href="../holiday/toHolidayManage"><div class="zhu">请假</div></a>
		</div>
		<div class="right_div">
					<div id="head">添加成功!</div>
			<form action="../employ/addEmploy" method="post">
				<table border="0" cellspacing="0" cellpadding="0">
					<tr><td class="tdf">登录名:</td><td><s:property value="loginName"/></td></tr>
					<tr><td class="tdf">密码:</td><td>welcome123</td></tr>
					<tr><td colspan="2"><input id="submit" type="button" value="记住了" onclick="ok()" /></td></tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>