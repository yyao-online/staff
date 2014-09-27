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

#salary {
	background: #ccc;
}
#submit{
	width: 100%;
	height: 30px;
	font-size: 1.2em;
	background: #99f;
	border: 0;
	color: white;
}
table {
	width: 220px;
	margin: 0 auto;
}
#name_err {
	color: #f00;
	display: none;
}
</style>
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
					<div id="head">添加员工信息</div>
			<form action="../employ/addEmploy" method="post">
				<table border="0" cellspacing="0" cellpadding="0">
					<tr><td class="tdf">姓名:</td><td><input type="text" name="employ.name" id="name" onblur="checkname()" /></td></tr>
					<tr><td class="tdf">手机:</td><td><input type="text" name="employ.phone" id="phone" onblur="checkphone()" /></td></tr>
					<tr><td class="tdf">性别:</td><td><input type="radio" value="男" name="employ.sex" checked="checked"/>男&nbsp;&nbsp;<input type="radio" value="女" name="employ.sex" />女</td></tr>
					<tr><td class="tdf">年龄:</td><td><input type="text" name="employ.age" /></td></tr>
					<tr><td class="tdf">工资:</td><td><input type="text" name="employ.salary" /></td></tr>
					<tr><td colspan="2"><input id="submit" type="submit" value="提交" /></td></tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>