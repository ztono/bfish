<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="entity.SBook,java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>BarCode</title>

</head>
<body  style="background-image:url('/bfish/images/school.jpg');">

<%@ include file="/title.jsp" %>
<div class="content">

<c:forEach items="${sbooks}" var="sbook" varStatus="st">
	<img style="vertical-align:middle;" src="/bfish/ShowBarCode.do?msg=${sbook}&barH=30&barXD=0.6&codeType=code128"/>
</c:forEach>


</div>
<%@ include file="/foot.jsp" %>
</body>
</html>
