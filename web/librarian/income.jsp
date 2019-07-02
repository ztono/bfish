<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Income</title>
</head>
<body  style="background-image:url('/bfish/images/school.jpg');">

<%@ include file="/title.jsp" %>
<div class="content">
<%
String today = (String)request.getAttribute("today");
%>
<%
String week = (String)request.getAttribute("week");
%>
<%
String month = (String)request.getAttribute("month");
%>
<%
String today1 = (String)request.getAttribute("today1");
%>
<%
String week1 = (String)request.getAttribute("week1");
%>
<%
String month1 = (String)request.getAttribute("month1");
%>
<%
String total = (String)request.getAttribute("total");
%>
<%
String total1 = (String)request.getAttribute("total1");
%>
<%
String total2 = (String)request.getAttribute("total2");
%>
<center>
<br/><br/>
<table border="1" style="font-size:33px;float:left;margin-left:10%">
<tr><th colspan="2">Income</th></tr>
<tr><td>TotalFine:</td><td><%=total %></td></tr>
<tr><td>TotalDeposit:</td><td><%=total2 %></td></tr>
<tr><td>TotalIncome:</td><td><%=total %></td></tr>
</table>

<table border="1" style="font-size:33px;float:left">
<tr><th colspan="2">Fine</th></tr>
<tr><td>Today:</td><td><%=today %></td></tr>
<tr><td>This week:</td><td><%= week %></td></tr>
<tr><td>This month:</td><td><%=month %></td></tr>
</table>

<table border="1" style="font-size:33px;float:left">
<tr><th colspan="2">Deposit</th></tr>
<tr><td>Today:</td><td><%=today1 %></td></tr>
<tr><td>This week:</td><td><%= week1 %></td></tr>
<tr><td>This month:</td><td><%=month1 %></td></tr>
</table>

</center>
</div>
<%@ include file="/foot.jsp" %>
</body>
</html>