<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="entity.SBook,java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>BookDetails</title>
</head>
<body  style="background-image:url('/bfish/images/school.jpg');">

<%@ include file="/title.jsp" %>
<div class="content">
<%String flag=(String)request.getAttribute("flag");  
if(flag=="0")
    { %>add successsfully<%}
    %>
    <br>
    <br>

<input type="button"   value="back" onclick="window.location.href = '/bfish/showallbook.do'"/>
			
<table style="width: 800px; margin: 44px auto"
	class="table table-striped table-bordered table-hover  table-condensed"
	align='center' border='1' cellspacing='0'>
		
					

	<tr>
			<td>ISBN</td>
	        <td>BookId</td>


		</tr>
<c:forEach items="${sbooks}" var="sbook" varStatus="st">
		<tr>
			<td align="center">${sbook.ISBN}</td>
		<td align="center" >${sbook["sbook_id"]}</td>
			
			
		</tr>
	</c:forEach>

</table>

</div>
<%@ include file="/foot.jsp" %>
</body>

</html>