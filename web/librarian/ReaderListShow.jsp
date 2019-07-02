<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="entity.Reader,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show Readers</title>
</head>
<body  style="background-image:url('/bfish/images/school.jpg');">
<%
String correct = (String)request.getAttribute("correct");
%>
<%@ include file="/title.jsp" %>

<div class="content">
<Script Language="JavaScript"> 
    function a() 
    { 
    document.form1.action="/bfish/Lreaderget.do"; 
    document.form1.submit(); 
    } 
     
    function b() 
    { 
    document.form1.action="/bfish/LReaderShow.do"; 
    document.form1.submit(); 
    } 
    
    function c() 
    { 
    document.form1.action="/bfish/Lreadergetbyname.do"; 
    document.form1.submit(); 
    } 
    </Script> 

<form name="form1" action=""> 
Reader_id:<input type="text" name="reader_id" id="reader_id">
	<INPUT Type="Button"  Value="SEARCH BY ID" onClick="a()"> 
or
name:<input type="text" name="name" id="name">
    <INPUT Type="Button"  Value="SEARCH BY NAME" onClick="c()">
    <INPUT Type="Button"  Value="RESET " onClick="b()"> 
    </form> 
    
<% if(correct == "0"){ %>This account has not returned all the books<%}
else if (correct=="1"){ %>Delete Successfully!<%}
%>
<table 
style="width: 500px; margin: 44px auto"
	class="table table-striped table-bordered table-hover  table-condensed"
	align='center' border='1' cellspacing='0'
	>
	
	<tr>
		<td>Reader_id</td>
		<td>Name</td>
		<!--td>Password</td-->
		<td>Email</td>


	</tr>
	<c:forEach items="${readers}" var="reader" varStatus="st">
		<tr>
			<td>${reader.reader_id}</td>
			<td>${reader.name}</td>	
			<!--td>${reader.password}</td-->	
			<td>${reader.email}</td>
			
			<td><a href="Lreaderdelete.do?reader_id=${reader.reader_id}">Delete</a></td>
			<td><a href="Lreaderupdateone.do?reader_id=${reader.reader_id}">Update</a></td>
			<td><a href="/bfish/librarian/ReaderBorrowRecord.jsp?reader_id=${reader.reader_id}">borrow record</a></td>
			<td><a href="LFpay.do?reader_id=${reader.reader_id}">Fine record</a></td>
		</tr>
	</c:forEach>
</table>


<form action="/bfish/Lreaderadd.do" >
		Reader_id:<input type="text" name="reader_id" id="reader_id">
		Name：<input type="text" name="name" id="name">
		Default Password:[12345678] <!--input type="text" name="password" id="password"-->
		Email:<input type="text" name="email" id="email">
		<input type="submit" value="ADD">
	</form>


</div>
<%@ include file="/foot.jsp" %>

</body>
</html>