<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="entity.*,java.util.*,dao.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ChangeBook</title>
</head>
<body  style="background-image:url('/bfish/images/school.jpg');">

<%@ include file="/title.jsp" %>
<style>
.text1{
    width: 200px;
    height: 30px;
 
    font-size: 15px;
}
</style>

<style>
.text2{
    width: 100px;
    height: 30px;
 
    font-size: 20px;
}
</style>
<style>
.submit_button {
    width: 70px;
    height: 40px;
   
    font-size: 20px;
}
</style>
<div class="content">
<%
List<Category> categorys = CategoryDao.getCategorys();
%>
<%
List<Location> locations = LocationDao.getLocations();
%>	
 <h2>Edit book</h2>
  <div style="margin-left:35%;" >
<form action="/bfish/update2.do"  >

<table>
			
				
			<tr>
				<td width="100" height="50" font size="20px">ISBN</td>
				<td>${book.ISBN}
				<input type="hidden" name="ISBN" id="ISBN" value='${book.ISBN}'>
				</td>
			</tr>

	<tr>
				<td>category</td>
				<td>
					<select name="category_id" class="text2">
					<% for(Category category : categorys){ %>
						<option value="<%=category.getCategory_id()%>" > <%=category.getCategory_name()%></option>
					<% } %>
					</select>
				</td>
			</tr>
			<tr>
				<td>price:</td>
				<td><input type="text" name="price" id="price" value='${ book.price}' class="text1">
				</td>
			</tr>
		<tr>
				<td>Title：</td>
				<td><input type="text" name="title" id="title" value='${ book.title}' class="text1">
				</td>
			</tr>
		<tr>
				<td>Author:</td>
				<td><input type="text" name="author" id="author"value="${ book.author}" class="text1">
				</td>
			</tr>
		<tr>
				<td>Press:</td>
				<td><input type="text" name="press" id="press"value="${ book.press}" class="text1">
				</td>
			</tr>
			<tr>
				<td>Introduce:</td>
				<td>
					<textarea rows="10" cols="50"
					name="introduce" id="introduce" >"${book.introduce}"</textarea>
					
				</td>
			</tr>
	<tr>
				<td>Location:</td>
				<td><select name="location_id"class="text2">
					<% for(Location location : locations){ %>
						<option value="<%=location.getLocation_id()%>"> <%=location.getLocation_name()%></option>
					<% } %>
					</select>
			</tr>
	<tr>
				<td>CallNumber:</td>
				<td><input type="text" name="callnumber" id="callnumber"value="${ book.callnumber}" class="text1">
				</td>
			</tr>
	
		<tr>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="Sure" class="submit_button"></td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="reset" value="reset" class="submit_button">Reset</button>			
		</td>
		</tr>
		
		</table>
	</form>	




</div>
</div>
<%@ include file="/foot.jsp" %>

</body>
</html>