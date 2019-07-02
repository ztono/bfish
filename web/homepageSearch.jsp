<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="entity.*,dao.*,java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>book information</title>
<style type="text/css">
.content{
margin-top:40px;
}
.info{
margin-left:300px;
}
</style>
</head>
<body  style="background-image:url('/bfish/images/school.jpg');">

<div class="content">
<%
Book book = (Book)request.getAttribute("book");
List<SBook> sbooks = (List<SBook>)request.getAttribute("sbooks");
String reserve = (String)request.getAttribute("reserve");
%>
<div class="info">
<h2>book information</h2>
title:<%=book.getTitle() %><br/>
author:<%=book.getAuthor() %><br/>
category:<%=book.getCategory_name() %><br/>
press:<%=book.getPress() %><br/>
ISBN:<%=book.getISBN() %><br/>
price:<%=book.getPrice() %><br/>
introduction:<%=book.getIntroduce() %><br/>
</div>

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
			<%}else if(!"".equals(sbook.getReserve_time())){ %>
				<td>been reserved:<%=sbook.getReserve_time() %></td>
			<%}else{ %>
				<td> can be borrowed</td>
			<%} %>
		</tr>
	<%} %>
<%if("true".equals(reserve)){ %>
	<script type="text/javascript">
	alert("reserve success!");
	</script>
<%} %>
</table>

</div>
</body>
</html>