<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="entity.*,dao.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>borrowed book</title>
<script src="//libs.baidu.com/jquery/1.10.2/jquery.min.js" ></script>
<script>
$(document).ready(function(){
	$(".back").hide();
	
  $("#back").click(function(){
	$(".back").show();
    $(".not").hide();
  });
  $("#not").click(function(){
	$(".back").hide();
	$(".not").show();
  });
});
</script>
</head>
<body  style="background-image:url('/bfish/images/school.jpg');">
<%@ include file="/title.jsp" %>
<div class="content">
<%
String reader_id = (String)session.getAttribute("user_id");
List<Borrow> borrows = BorrowDao.getBorrows(reader_id);
%>
<button id="back">show returned</button>
<button id="not">show borrowing</button>

<table style="width: 800px; margin: 44px auto"
	class="table table-striped table-bordered table-hover  table-condensed"
	align='center' border='1' cellspacing='0'>
	<tr class="back">
		<td>bar code</td>   
		<td>title</td>
		<td>author</td>
		<td>borrow time</td>
		<td>due date</td>
		<td>return time</td>
		<td>book status</td>
		<td>fine</td>
	</tr>
	<tr class="not">
		<td>bar code</td>   
		<td>title</td>
		<td>author</td>
		<td>borrow time</td>
		<td>due date</td>
	</tr>
	<%for(Borrow borrow:borrows){ 
		if(!"".equals(borrow.getRealback_time())){
			String status = borrow.getBookstatus();%>
			<tr class='back'>
				<td><%=borrow.getSbook_id() %></td>
				<%if(borrow.getISBN() != null){ %>
					<td><a href="/bfish/reader/lookbook.jsp?ISBN=<%=borrow.getISBN() %>"><%=borrow.getTitle() %></a></td>
					<td><%=borrow.getAuthor() %></td>
				<%}else{ %>
					<td colspan="2">The book has been taken off shelves</td>
				<%} %>
				<td><%=borrow.getBorrow_time() %></td>
				<td><%=borrow.getShouldback_time() %></td>
				<td><%=borrow.getRealback_time() %></td>
				<%if("0".equals(status)){ %>
					<td>normal</td>
				<%}else if("1".equals(status)){ %>
					<td>timeout</td>
				<%}else if("2".equals(status)){ %>
					<td>broken</td>
				<%}else if("3".equals(status)){ %>
					<td>lost</td>
				<%} %>
				<td><%=borrow.getFine() %></td>
			</tr>
		<%}else{ %>
			<tr class='not'>
				<td><%=borrow.getSbook_id() %></td>
				<td><a href="/bfish//reader/lookbook.jsp?ISBN=<%=borrow.getISBN() %>"><%=borrow.getTitle() %></a></td>
				<td><%=borrow.getAuthor() %></td>
				<td><%=borrow.getBorrow_time() %></td>
				<td><%=borrow.getShouldback_time() %></td>	
			</tr>
		<%}} %>
	
</table>
</div>
<%@ include file="/foot.jsp" %>
</body>
</html>