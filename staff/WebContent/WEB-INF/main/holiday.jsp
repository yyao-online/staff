<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>主页</title>
<script language="javascript" type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<link type="text/css" rel="stylesheet" media="all" href="../style/common.css" />
<style type="text/css">

#head{
	line-height:50px;
	font-size:1.5em;
	background: #22f;
	color: #fff;
	text-align: center;
}

table tr td{
	text-align: center;
}

#salary {
	background: #ccc;
}
/* #date input{
	width: 100px;
} */
textarea{
	width: 350px;
	height: 150px;
	resize: none;
}
#submit{
	width: 150px;
	height: 30px;
	font-size: 1.2em;
	background: #99f;
	border: 0;
	color: white;
}
table {
	width: 100%;
	margin: 0 auto;
}
#a{
	color: #fff;
	font-size: 1em;
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
			<a href="../personal/toPersonal"><div class="zhu">信息查询</div></a>
			<a href="../personal/toHoliday"><div class="zhu" id="select">请假</div></a>
			<a href="../personal/toEditPassword"><div class="zhu">修改密码</div></a>
			<s:action name="checkSign" executeResult="true" namespace="/personal">
				<s:param name="empid">
					<s:property value="admin.empid"/>
				</s:param>
			</s:action>
		</div>
		
		<div class="right_div">
					<div id="head">请假</div>
					<form action="applyHoliday" method="post">
				<table border="0" cellspacing="0" cellpadding="0">
					<tr><td>请假时间</td></tr>
					<tr><td id="date"><input class="Wdate" name="holiday.dateFrom" type="text" onClick="WdatePicker()">&nbsp;&nbsp;至&nbsp;&nbsp;<input class="Wdate" name="holiday.dateTo" type="text" onClick="WdatePicker()"></td></tr>
					<tr><td>请假事由</td></tr>
					<tr><td><textarea name="holiday.reason"></textarea></td></tr>
					<tr><td><br /><input id="submit" type="submit" /></td></tr>
				</table>
				</form>
		</div>
	</div>
</body>
</html>