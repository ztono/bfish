<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="entity.Notice,java.util.*"%>			<!-- onomei -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	#content{
		width:200px;
		height:100px;
	}
</style>
<title>Insert title here</title>
</head>
<body  style="background-image:url('/bfish/images/school.jpg');">

<%@ include file="/title.jsp" %>


<div class="content">

<table 
style="width: 500px; margin: 44px auto"
	class="table table-striped table-bordered table-hover  table-condensed"
	align='center' border='1' cellspacing='0'>
	
	<tr>
		<td>Name</td>
		<td>Content</td>
		<td>Notice_time</td>


	</tr>
	<c:forEach items="${notices}" var="notice" varStatus="st">
		<tr>
			<td>${notice.name}</td>	
			<td>${notice.content}</td>	
			<td>${notice.notice_time}</td>
			
			<td><a href="NoticeDelete.do?notice_id=${notice.notice_id}">Delete</a></td>
			<td><a href="Lnoticeupdateone.do?notice_id=${notice.notice_id}">Update</a></td>
			
		</tr>
	</c:forEach>
</table>

<form action="/bfish/NoticeAdd.do" >
		Content:
		<br />
		<textarea type="text" name="content" id="content" ></textarea>
		<input type="submit" value="ADD">
	</form>
	
	
</div>
<%@include file="/foot.jsp" %>
</body>
</html>