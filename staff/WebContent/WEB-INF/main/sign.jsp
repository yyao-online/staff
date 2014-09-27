<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<s:if test="signed==true">
	</a><div class="zhu">已签</div></a>
</s:if>
<s:else>
	<a href="../personal/sign?empid=<s:property value="admin.empid"/>"><div class="zhu">签到</div></a>
</s:else>