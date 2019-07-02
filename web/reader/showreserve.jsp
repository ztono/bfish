<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*,entity.*,dao.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>reserved book</title>
</head>
<body style="background-image:url('/bfish/images/school.jpg');">
<%@ include file="/title.jsp" %>
<div class="content">
<%
String reader_id = (String)session.getAttribute("user_id");
List<Reserve> reserves = ReserveDao.getReserves(reader_id);
%>

<table style="width: 800px; margin: 44px auto"
	class="table table-striped table-bordered table-hover  table-condensed"
	align='center' border='1' cellspacing='0'>
	<tr>
		<td>bar code</td>   
		<td>title</td>
		<td>author</td>
		<td>reserve time</td>
	</tr>
	<%for(Reserve reserve:reserves){ %>
		<tr>
			<td><%=reserve.getSbook_id() %></td>
			<td><a href="/bfish/reader/lookbook.jsp?ISBN=<%=reserve.getISBN() %>"><%=reserve.getTitle() %></a></td>
			<td><%=reserve.getAuthor() %></td>
			<td><%=reserve.getReserve_time() %></td>
		</tr>
	<%} %>

</table>

</div>
<%@ include file="/foot.jsp" %>

</body>
</html>