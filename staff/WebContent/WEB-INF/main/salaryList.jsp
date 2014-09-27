<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>主页</title>
<link type="text/css" rel="stylesheet" media="all"
	href="../style/common.css" />
</head>
<body>
	<div class="body">
		<%@include file="/WEB-INF/main/login_msg.jsp"%>
		<div class="top_div">企业员工信息管理系统</div>
		<div class="left_div">
			<a href="../employ/findEmploy"><div class="zhu">基本信息</div></a>
			<a href="../employ/toAddEmploy"><div class="fu">添加</div></a>
			<a href="../salary/findSalary"><div class="zhu" id="select">工资管理</div></a>
			<a href="../attendance/toAttendance"><div class="zhu">考勤管理</div></a>
			<a href="../holiday/toHolidayManage"><div class="zhu">请假</div></a>
		</div>
		<div class="right_div">
			<table class="right_table" border="0" cellspacing="0" cellpadding="0">
				<thead>
					<tr>
						<td>员工编号</td>
						<td>姓名</td>
						<td>工资</td>
						<td>操作</td>
					</tr>
				</thead>
				<tbody class="tbody">
					<s:iterator value="list" var="e">
						<tr>
							<td><s:property value="id" /></td>
							<td><s:property value="name" /></td>
							<td><s:property value="salary" /></td>
							<td><a href="../salary/toEidtSalary?id=<s:property value="id" />">修改</a></td>
						</tr>
					</s:iterator>
					
				</tbody>
			</table>
			<div class="pages">
				<s:if test="page > 1">
							<a href="findSalary?page=<s:property value="1"/>">首页</a>
							<a href="findSalary?page=<s:property value="page-1"/>">上一页</a>
						</s:if> <s:if test="page>=5">
			...
		</s:if> <s:iterator begin="1" end="totalPage" var="p">
							<s:if test="(page>=#p-3)&&(page<=#p+3)">
								<s:if test="page==#p">
									<s:property value="#p" />
								</s:if>
								<s:else>
									<a href="findSalary?page=<s:property value="#p"/>"><s:property
											value="#p" /></a>
								</s:else>
							</s:if>
						</s:iterator> <s:if test="page<=totalPage-4">
			...
		</s:if> <s:if test="page < totalPage">
							<a href="findSalary?page=<s:property value="page+1"/>">下一页</a>
							<a href="findSalary?page=<s:property value="totalPage"/>">末页</a>
						</s:if>
			
</div>
		</div>
	</div>
</body>
</html>