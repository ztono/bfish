<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="entity.*,dao.*,java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<fmt:setBundle basename="resource.reader.search" var="key" scope="page"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>search</title>
<script src="//libs.baidu.com/jquery/1.10.2/jquery.min.js" ></script>

</head>
<body style="background-image:url('/bfish/images/school.jpg');">
<%@ include file="/title.jsp" %>
<div class="content">
<script type="text/javascript">
function searchcheck()
{
	var title = document.getElementById("title");
	var author = document.getElementById("author");
	var press = document.getElementById("press");
	var category = document.getElementById("category");
	if ((title.value == "" || title.value == null)
			&& (author.value == "" || author.value == null)
			&& (press.value == "" || press.value == null)
			&& (category.value == "" || category.value == null))	{
		return false;
	}
	return true;
}
</script>

<%
List<Category> categorys = CategoryDao.getCategorys();
%>

<form action="/bfish/Rsearch.do" onsubmit="return searchcheck()">
<table style="width: 800px; margin: 44px auto"
	class="table table-striped table-bordered table-hover  table-condensed"
	align='center' border='1' cellspacing='0'>
	<tr>
		<td><input type="text" name="title" id="title"/></td>
		<td><input type="text" name="author" id="author"/></td>
		<td><input type="text" name="press" id="press"/></td>
		<td>
			<select name="category" id="category">
				<option></option>
				<%for(Category category : categorys){ %>
					<option value=<%=category.getCategory_id()%>><%=category.getCategory_name()%></option>
				<% }%>
			</select>
		</td>
		<td colspan="2"><input type="submit" value="search"></td>
	</tr>
	<tr>
		<td><fmt:message  bundle="${key}" key="title"/></td>
		<td><fmt:message  bundle="${key}" key="author"/></td>
		<td><fmt:message  bundle="${key}" key="press"/></td>
		<td><fmt:message  bundle="${key}" key="category"/></td>
		<td><fmt:message  bundle="${key}" key="total"/></td>   
		<td><fmt:message  bundle="${key}" key="remaining"/></td>
	</tr>
	<c:forEach items="${books}" var="book" varStatus="st">
		<tr>
			<td><a href="/bfish/reader/lookbook.jsp?ISBN=${book.ISBN}">${book.title}</a></td>
			<td>${book.author}</td>
			<td>${book.press}</td>
			<td>${book.category_name}</td>
			<td>${book.total}</td>
			<td>${book.canborrow}</td>
		</tr>
	</c:forEach>
</table>
</form>
<script>
</script>
</div>
<%@ include file="/foot.jsp" %>
</body>
</html>