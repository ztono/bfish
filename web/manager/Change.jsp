<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="entity.User,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ChangeLM</title>
</head>
<body  style="background-image:url('/bfish/images/school.jpg');">

<%@ include file="/title.jsp" %>
<div class="content">
<form action="/bfish/UserShow.do"  >
<input type="submit" value="Return">


</form>	
<form action="/bfish/updatetwo.do"  >
		
		LM_ID：<input type="text" name="user_id1" id="user_id1" value='${ user["user_id"]}'>
		
		LM_Name：<input type="text" name="name" id="name" value='${ user["name"]}'>
		<input type='hidden'   name="user_id" id="user_id" value='${ user["user_id"]}'>
		<input type='hidden'   name="password" id="password" value='${ user["password"]}'>
		<input type="submit" value="Sure">
</form>	



</div>
<%@ include file="/foot.jsp" %>	


</body>
</html>