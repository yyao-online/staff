<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>主页</title>
<link type="text/css" rel="stylesheet" media="all"
	href="../style/common.css" />
<style type="text/css">
#head {
	line-height: 50px;
	font-size: 1.5em;
	background: #22f;
	color: #fff;
	text-align: center;
}

.tdf {
	text-align: center;
}

#salary {
	background: #ccc;
}

#submit {
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

#a {
	color: #fff;
	font-size: 1em;
}

.holiday_msg {
	width: 400px;
	margin: 50px auto;
	background: #ccf;
}

#name_err {
	color: #f00;
	display: none;
}
</style>
<script language="javascript" type="text/javascript"
	src="../js/check.js"></script>
</head>
<body>
	<div class="body">
		<%@include file="/WEB-INF/main/login_msg.jsp"%>
		<div class="top_div">企业员工信息管理系统</div>
		<div class="left_div">
			<a href="../personal/toPersonal"><div class="zhu" id="select">信息查询</div></a>
			<a href="../personal/toHoliday"><div class="zhu">请假</div></a> <a
				href="../personal/toEditPassword"><div class="zhu">修改密码</div></a>
			<s:action name="checkSign" executeResult="true" namespace="/personal">
				<s:param name="empid">
					<s:property value="admin.empid" />
				</s:param>
			</s:action>
		</div>

		<div class="right_div">
			<div id="head">
				个人信息&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id="a"
					href="../personal/toEditPersonal?id=<s:property value="employ.id"/>">修改</a>
			</div>
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td class="tdf">姓名:</td>
					<td><s:property value="employ.name" /></td>
				</tr>
				<tr>
					<td class="tdf">手机:</td>
					<td><s:property value="employ.phone" /></td>
				</tr>
				<tr>
					<td class="tdf">性别:</td>
					<td><s:property value="employ.sex" /></td>
				</tr>
				<tr>
					<td class="tdf">年龄:</td>
					<td><s:property value="employ.age" /></td>
				</tr>
				<tr>
					<td class="tdf">工资:</td>
					<td><s:property value="employ.salary" /></td>
				</tr>
			</table>
			<div class="holiday_msg">
				你申请的
				<s:date name="holiday.dateFrom" />
				至
				<s:date name="dateTo" />
				的假期
				<s:if test="holiday.state==0">还未审核</s:if>
				<s:elseif test="holiday.state==1">获得批准</s:elseif>
				<s:else>被退回</s:else>
			</div>
		</div>
	</div>
</body>
</html>