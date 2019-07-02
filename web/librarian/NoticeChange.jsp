<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="entity.Notice,java.util.*"%>			<!-- onomei -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Notice</title>
</head>
<body  style="background-image:url('/bfish/images/school.jpg');">

<%@ include file="/title.jsp" %>
<div class="content">




	
<form action="/bfish/Lnoticeupdatetwo.do"  >
<table>
	<tr>
		<td>Notice_id：${param.notice_id}</td>
		<td><input type="hidden" name="notice_id" id="notice_id" value='${param.notice_id}'></td>
	</tr>
	<tr>
		<td>Content：</td>
		<td><input type="text" name="content" id="content" value='${notice.content}'></td>
	</tr>
		
	<tr>
		<td><input type="submit" value="SUBMIT"></td>
	</tr>
</table>
</form>	

</div>
<%@ include file="/foot.jsp" %>

</body>
</html>