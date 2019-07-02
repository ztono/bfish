<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="entity.*,dao.*,java.util.*,java.text.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>		<!-- onomei -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reader Fine Record</title>
<script src="//libs.baidu.com/jquery/1.10.2/jquery.min.js" ></script>
<script>
$(document).ready(function(){
	$(".back").hide();
	
  $("#back").click(function(){
	$(".back").show();
    $(".not").hide();
    $("#borrowing").text("Fine have been payed");
  });
  $("#not").click(function(){
	$(".back").hide();
	$(".not").show();
	$("#borrowing").text("Fine to be payed");
  });
});
</script>
</head>

<body  style="background-image:url('/bfish/images/school.jpg');">

<%@include file="/title.jsp" %>

<div class="content">

<button id="back">payed</button>
<button id="not">to be payed</button>

<div style="text-align:center" id="borrowing">
Fine have been payed
</div>

<table style="width: 800px; margin: 44px auto"
	class="table table-striped table-bordered table-hover  table-condensed"
	align='center' border='1' cellspacing='0'>
	
	<tr class="back">
		<td>FID</td>   
		<td>reader_id</td>
		<td>fine</td>
	
	</tr>
	<c:forEach items="${fines2}" var="fine2" varStatus="st">
			<tr class='back'>
				<td>${fine2.FID}</td>
		<td>${fine2.reader_id}</td>
		<td>${fine2.fine}</td>
		
			
			</c:forEach>
<tr class="not">
		<td>FID</td>   
		<td>reader_id</td>
		<td>fine</td>
		<td>operation</td>
	</tr>
	<c:forEach items="${fines}" var="fine" varStatus="st">
			<tr class='not'>
				<td>${fine.FID}</td>
		<td>${fine.reader_id}</td>
		<td>${fine.fine}</td>
		<td><a href="Lpay.do?FID=${fine.FID}" >Pay</a></td>
			
			</c:forEach>
				
	
</table>
</div>

<%@ include file="/foot.jsp" %>
</body>
</html>