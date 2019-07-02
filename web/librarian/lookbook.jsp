<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="entity.*,java.util.*,dao.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>BookInformation</title>
</head>
<body  style="background-image:url('/bfish/images/school.jpg');">

<%@ include file="/title.jsp" %>
<div class="content">


<h2>BookInformation</h2>

<Script Language="JavaScript"> 
    function a() 
    { 
    document.form1.action="/bfish/getbook.do"; 
    document.form1.submit(); 
    } 
    
    function b() {
    	
    	 document.form1.action="/bfish/getbooks2.do"; 
    	   document.form1.submit(); 	
    	
    	
    }
   
    </Script> 
    
   
    
 <%
List<Category> categorys = CategoryDao.getCategorys();
%>
   <% String flag = (String)request.getAttribute("add");
    if(flag=="3")
    { %>Add successfully<%}
    %>

   <% String t = (String)request.getAttribute("tt");
    if(t=="1")
    { %>change successfully<%}
    %>


    <% String d = (String)request.getAttribute("delete");
    if(d=="1")
    {%>
    delete successfully
    <% }
    else if(d=="0")
    	
    {%>
    please delete copies in this book firstly
    <%} 
    %>      
<div style="margin-left:30%;" >
<form name="form1" action=""> 
author:
 <input type="text" name="author" id="author">
<INPUT Type="Button"  Value="AuthorSearch" onClick="a()"> 
   Title:<input type="text" name="title" id="title">
     <INPUT Type="Button"  Value="TitleSearch" onClick="b()"> 
     </form>
    <input style="margin-left:14%;" type = "button" value = "Addbook" onclick = "window.location.href = '/bfish/librarian/ISBN.jsp'">
    
</div>
<table style="width: 800px; margin: 44px auto"
	class="table table-striped table-bordered table-hover  table-condensed"
	align='center' border='1' cellspacing='0'>
	<tr>
			<td align="center">ISBN</td>
			<td align="center">category</td>
			<td align="center">price</td>
	        <td align="center">Title</td>
			<td align="center">Author</td>
			<td align="center">Press</td>
			<td align="center">Location</td>
			<td align="center">CallNumber</td>
			<td></td>
			<td></td>
		</tr>
<c:forEach items="${books}" var="book" varStatus="st">
		<tr>
			<td align="center" width="10%"><a href="/bfish/looksbook.do?ISBN=${book.ISBN}">${book.ISBN}</a></td>
		<td align="center" width="10%">${book.category_name}</td>
		<td align="center" width="10%">${book.price}</td>
			<td align="center" width="10%">${book.title}</td>
			<td align="center" width="10%">${book.author}</td>
			<td align="center" width="10%">${book.press}</td>
			<td align="center" width="10%">${book.location_name}</td>
			<td align="center" width="10%">${book.callnumber}</td>
			<td><a href="deletebook.do?ISBN=${book.ISBN}">Delete</a></td>
			<td><a href="updatebook.do?ISBN=${book.ISBN}">Change</a></td>
		
		</tr>
	</c:forEach>
</table>

</div>
<%@ include file="/foot.jsp" %>
</body>

</html>