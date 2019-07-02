<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="entity.*,dao.*,java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>book information</title>
</head>
<body  style="background-image:url('/bfish/images/school.jpg');">

<%@ include file="/title.jsp" %>
<div class="content">
<%
String ISBN=request.getParameter("ISBN");
Book book = BookDao.getBook(ISBN);
List<SBook> sbooks = BookDao.getSbooks(ISBN);

%>

<h2>book information</h2>
title:<%=book.getTitle() %><br/>
author:<%=book.getAuthor() %><br/>
press:<%=book.getPress() %><br/>
ISBN:<%=book.getISBN() %><br/>
price:<%=book.getPrice() %><br/>
introduction:<%=book.getIntroduce() %><br/>



<table style="width: 800px; margin: 44px auto"
	class="table table-striped table-bordered table-hover  table-condensed"
	align='center' border='1' cellspacing='0'>
	<tr>
		<td>bar code</td>
		<td>call number</td>
		<td>location</td>
		<td>status</td>
	</tr>
	<%for(SBook sbook : sbooks){ %>
		<tr>
			<td><%=sbook.getSbook_id() %></td>
			<td><%=book.getCallnumber() %></td>
			<td><%=book.getLocation_name() %></td>
			<%if(!"".equals(sbook.getShouldback_time())){ %>
				<td>due date:<%=sbook.getShouldback_time() %></td>
				<td></td>
			<%}else if(!"".equals(sbook.getReserve_time())){ %>
				<td>been reserved:<%=sbook.getReserve_time() %></td>
				<td></td>
			<%}else{ %>
				<td> not be borrowed now</td>
				
			<%} %>
		</tr>
	<%} %>

</table>

</div>
<%@ include file="/foot.jsp" %>
</body>
</html>