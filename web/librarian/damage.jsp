<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body  style="background-image:url('/bfish/images/school.jpg');">

<%@ include file="/title.jsp" %>
<div class="content">
	<form action="/bfish/Ldamage.do" method="post"
		onsubmit="return check()">
		username:<input type="text" name="user_id" id="user_id"><br />
		book:<input type="text" name="sbook_id" id="sbook_id"><br />
		description：<input type="text" name="description" id="description"><br />
		fine：<input type="text" name="damage_fine" id="damage_fine"><br />
		<input type="submit" value="submit" />
	</form>
</div>
<%@ include file="/foot.jsp" %>
</body>
</html>