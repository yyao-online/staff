<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<div id="login_msg">
	<s:if test="admin.perm==2">
		管理员&nbsp;&nbsp;|&nbsp;<a href="../login/logout">退出</a>
	</s:if>
	<s:else>
		您好！&nbsp;
		<s:action name="findName" executeResult="true" namespace="/employ">
			<s:param name="empid">
				<s:property value="admin.empid"/>
			</s:param>
		</s:action>
		&nbsp;|&nbsp;<a href="../login/logout">退出</a>
	</s:else>
</div>