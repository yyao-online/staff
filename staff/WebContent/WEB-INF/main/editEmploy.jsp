<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>主页</title>
<link type="text/css" rel="stylesheet" media="all"
	href="../style/common.css" />
	<style type="text/css">
		#head{
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
table {
	width: 220px;
	margin: 0 auto;
}
	</style>
</head>
<body>
	<div class="body">
		<%@include file="/WEB-INF/main/login_msg.jsp"%>
		<div class="top_div">企业员工信息管理系统</div>
		<div class="left_div">
			<a href="../employ/findEmploy"><div class="zhu" id="select">基本信息</div></a>
			<a href="../employ/toAddEmploy"><div class="fu">添加</div></a>
			<a href="../salary/findSalary"><div class="zhu">工资管理</div></a>
			<a href="../attendance/toAttendance"><div class="zhu">考勤管理</div></a>
			<a href="../holiday/toHolidayManage"><div class="zhu">请假</div></a>
		</div>
		<div class="right_div">
			<div id="head">修改员工信息</div>
			<form action="../employ/editEmploy" method="post">
				<input type="hidden" name="employ.id" value="<s:property value="employ.id"/>" />
				<table border="0" cellspacing="0" cellpadding="0">
					<tr><td class="tdf">姓名:</td><td><input type="text" name="employ.name" value="<s:property value="employ.name"/>" /></td></tr>
					<tr><td class="tdf">电话:</td><td><input type="text" name="employ.phone" value="<s:property value="employ.phone"/>" /></td></tr>
					<s:if test='employ.sex=="男"'>
					<tr><td class="tdf">性别:</td><td><input type="radio" value="男" name="employ.sex" checked="checked"/>男&nbsp;&nbsp;<input type="radio" value="女" name="employ.sex" />女</td></tr>
					</s:if>
					<s:else>
					<tr><td class="tdf">性别:</td><td><input type="radio" value="男" name="employ.sex"/>男&nbsp;&nbsp;<input type="radio" value="女" name="employ.sex" checked="checked"/>女</td></tr>
					</s:else>
					<tr><td class="tdf">年龄:</td><td><input type="text" name="employ.age" value="<s:property value="employ.age"/>" /></td></tr>
					<tr><td colspan="2"><input id="submit" type="submit" value="修改" /></td></tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>