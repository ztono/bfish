<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="entity.Reader,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Reader</title>
</head>
<body  style="background-image:url('/bfish/images/school.jpg');">

<%@ include file="/title.jsp" %>
<div class="content">




	
<form action="/bfish/Lreaderupdatetwo.do"  >
		Reader_id[Cannot be changed]：${reader.reader_id}
		<input type="hidden" name="reader_id" id="reader_id" value='${reader.reader_id}'>
		Name：<input type="text" name="name" id="name" value='${reader.name}'>
		Email：<input type="text" name="email" id="email" value='${reader.email}'>
		
		<input type="submit" value="SUBMIT">
</form>	

</div>
<%@ include file="/foot.jsp" %>



</body>
</html>