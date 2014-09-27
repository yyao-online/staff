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
			<a href="../personal/toPersonal"><div class="zhu" id="select">信息查询</div></a>
			<a href="../personal/toHoliday"><div class="zhu">请假</div></a>
			<a href="../personal/toEditPassword"><div class="zhu">修改密码</div></a>
			<s:action name="checkSign" executeResult="true" namespace="/personal">
				<s:param name="empid">
					<s:property value="admin.empid"/>
				</s:param>
			</s:action>
		</div>
		<div class="right_div">
				<div id="head">修改个人信息</div>
				<form action="../personal/editPersonal" method="post">
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