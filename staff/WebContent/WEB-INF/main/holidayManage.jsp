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

#name_err {
	color: #f00;
	display: none;
}
</style>
<script type="text/javascript">
	function al(obj){
		alert(obj);
	}
</script>
</head>
<body>
	<div class="body">
		<%@include file="/WEB-INF/main/login_msg.jsp"%>
		<div class="top_div">企业员工信息管理系统</div>
		<div class="left_div">
			<a href="../employ/findEmploy"><div class="zhu">基本信息</div></a>
			<a href="../employ/toAddEmploy"><div class="fu">添加</div></a>
			<a href="../salary/findSalary"><div class="zhu">工资管理</div></a>
			<a href="../attendance/toAttendance"><div class="zhu">考勤管理</div></a>
			<a href="../holiday/toHolidayManage"><div class="zhu" id="select">请假</div></a>
		</div>
		<div class="right_div">
			<table class="right_table" border="0" cellspacing="0" cellpadding="0">
				<thead>
					<tr>
						<td>员工编号</td>
						<td>姓名</td>
						<td>请假时间</td>
						<td>请假事由</td>
						<td>操作</td>
					</tr>
				</thead>
				<tbody class="tbody">
					<s:iterator value="holidays" var="holiday">
						<tr><td><s:property value="empId"/></td><td><s:action name="findName" executeResult="true" namespace="/employ">
									<s:param name="empid">
										<s:property value="empId"/>
									</s:param>
								</s:action></td><td><s:property value="dateFrom"/>至<s:property value="dateTo"/></td><td><a href='javascript:al("<s:property value="reason"/>");'>详细</a></td><td><a href="passHoliday?id=<s:property value="id"/>">通过</a>&nbsp;&nbsp;<a href="denyHoliday?id=<s:property value="id"/>">拒绝</a></td></tr>
					</s:iterator>
				</tbody>
			</table>
			<div class="pages">
					<a href="#">首页</a>
					<a href="#">上一页</a>
						1
					<a href="#">下一页</a>
					<a href="#">末页</a>

			</div>
		</div>
	</div>
</body>
</html>