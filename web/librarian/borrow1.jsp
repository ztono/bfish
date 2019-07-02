<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<style>
.text1{
    width: 300px;
    height: 40px;
    line-height: 40px;
    border-radius: 5px;
    padding: 0 10px;
    border: 1px solid #ccc;
    outline: none;
    margin-top: 10px;
    font-size: 25px;
}
.submit_button {
    width: 200px;
    height: 40px;
    line-height: 40px;
    border-radius: 5px;
    border: none;
    outline: none;
    background: white;
    color: black;
    font-size: 25px;
}
</style>
<body  style="background-image:url('/bfish/images/school.jpg');">
<% String correct = (String)request.getAttribute("correct");
%>
<%@ include file="/title.jsp" %>
<div class="content">
<center>
<p style="font-size: 40px">
<% if(correct == "-1"){ %>Please input the borrower<%}
else if (correct=="-2"){ %>This account can not be found<%}
else if (correct=="-3"){ %>This account has borrowed 3 books<%}
%>
</p>
<form action="/bfish/Borrow1.do" method="post"
		onsubmit="return check()">
		<table>
		<tr ><td style="font-size: 50px">ReaderID:</td><td><input type="text" name="user_id" id="user_id" class="text1"></td></tr>
		</table><br/><br/>
		<input type="submit" value="submit" class="submit_button"/>
		</form>
</center>
</div>
<%@ include file="/foot.jsp" %>	
</body>
</html>