<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="entity.SBook,java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>DeleteRecord</title>
</head>
<body  style="background-image:url('/bfish/images/school.jpg');">

<%@ include file="/title.jsp" %>
<div class="content">
<input type="button"   value="back" onclick="history.go(-1)"/>		
			
<table style="width: 800px; margin: 44px auto"
	class="table table-striped table-bordered table-hover  table-condensed"
	align='center' border='1' cellspacing='0'>
		
					

	<tr>
			
	        <td>LibrarianID</td>
			<td>SbookID</td>
			<td>DeleteTime</td>
		</tr>
<c:forEach items="${deletes}" var="delete" varStatus="st">
		<tr>
	
		<td align="center" >${delete["user_id"]}</td>
		<td align="center" >${delete["sbook_id"]}</td>	
		<td align="center" >${delete["delete_time"]}</td>	
		</tr>
	</c:forEach>

</table>

</div>
<%@ include file="/foot.jsp" %>
</body>