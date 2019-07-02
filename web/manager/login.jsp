<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,dao.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<fmt:setBundle basename="resource.login" var="myKey" scope="page"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message  bundle="${myKey}" key="login"/></title>
<style type="text/css">
* {
    margin: 0;
    padding: 0;
    list-style-type: none;
    font-family: "微软雅黑";
    box-sizing: border-box;
}
.login-bag {
    width: 370px;
    height: 330px;
    padding: 30px;
    background: url('/bfish/images/login-bg.png');
    position: absolute;
    top: 180px;
    right: 100px;
    z-index: 999;
}
.change-language-btn {
    position: absolute;
    width: 70px;
    padding-right: 6px;
    height: 70px;
    line-height: 50px;
    display: block;
    top: -6px;
    right: -6px;
    background: url(/bfish/images/change-language-btn-bg.png) no-repeat;
    font-size: 16px;
    color: #fff;
    text-decoration: none;
    text-align: right;
}
.login-bag-title {
    width: 310px;
    height: 30px;
    line-height: 30px;
    color: #333;
    font-size: 26px;
    text-align: left;
}
.login-bag-title span {
    font-size: 20px;
    margin-left: 10px;
}
.login-username {
    width: 100%;
    height: 40px;
    line-height: 40px;
    border-radius: 5px;
    padding: 0 10px;
    border: 1px solid #ccc;
    outline: none;
    margin-top: 30px;
}
.login-password {
    width: 100%;
    height: 40px;
    line-height: 40px;
    border-radius: 5px;
    padding: 0 10px;
    border: 1px solid #ccc;
    outline: none;
    margin-top: 15px;
}
.login-submit-box {
    width: 310px;
    height: 40px;
    margin-top: 30px;
}
.submit_button {
    width: 100%;
    height: 40px;
    line-height: 40px;
    border-radius: 5px;
    border: none;
    outline: none;
    background: #0188CC;
    color: #FFF;
}
.login-submit-box-forget {
    width: 55%;
    float: right;
    height: 40px;
    line-height: 40px;
    text-align: right;
    padding-top: 11px;
}
.login-submit-box-forget a {
    font-size: 14px;
    color: #666;
    text-decoration: underline;
    margin-left: 15px;
}
.image{
width:100%;
height:654px;
}
.login-submit-box span {
    float: left;
    width: 45%;
    height: 40px;
    line-height: 15px;
    color: #ff0000;
    font-size: 14px;
    padding-top: 11px;
}
</style>
<script type="text/javascript">
function check()
{
	var user_id = document.getElementById("username");
	if (user_id.value == "" || user_id.value == null)	{	
		document.getElementById("error").innerHTML="<fmt:message  bundle="${myKey}" key="accountempty"/>";
		return false;
	}
	var password = document.getElementById("password");
	if (password.value == "" || password.value == null)	{	
		document.getElementById("error").innerHTML="<fmt:message  bundle="${myKey}" key="passwordempty"/>";
		return false;
	}
	return true;
}
</script>
</head>
<body>
<% String user_id = (String)session.getAttribute("user_id");
if(user_id != null){
	String able = UserDao.getAble(user_id);
	if("0".equals(able)){ %>
		<c:redirect url="/reader/search.jsp"/>
	<% }else if("1".equals(able)){ %>
		<c:redirect url="/librarian/borrow1.jsp"/>
	<% }else{ %>
		<c:redirect url="/bfish/UserShow.do"/>
	<% }%>
<%} %>


<% String language = (String)session.getAttribute("language");
if("en_US".equals(language))language="zh_CN";
else language="en_US";%>

<div class="image"><img src="/bfish/images/readbook.jpg" width="100%" height="100%"></div>
<img alt="" src="/bfish/images/logo.png" height="80px" style="position:absolute;top:20px;left:100px">
<div class="login-box">
<div class="login-bag">
        		  
<a class="change-language-btn" href="/bfish/doLanguage.jsp?language=<%=language%>"><fmt:message  bundle="${myKey}" key="language"/></a>  
<p class="login-bag-title"><fmt:message  bundle="${myKey}" key="userlogin"/></p>
<form id="fm1" class="fm-v clearfix" action="/bfish/login.do" method="post" onsubmit="return check()">
	<input name="username" id="username" placeholder="<fmt:message  bundle="${myKey}" key="inputaccount"/>" class="login-username" value="" type="text"> 
	
	<input name="password" id="password" placeholder="<fmt:message  bundle="${myKey}" key="inputpassword"/>" class="login-password" type="password">
	
	
	<div class="login-submit-box">
		<button type="submit" class="submit_button" onclick="javascript:return checkInput();"><fmt:message  bundle="${myKey}" key="login"/></button>
		<div class="errorInfo" id="errorInfo"><span id="error"></div>
		<p class="login-submit-box-forget">
				
		</p>
	</div>
 
</form>

<%
String login = (String)request.getAttribute("login");
if(login == "false"){ %>
<script>document.getElementById("error").innerHTML="<fmt:message  bundle="${myKey}" key="passwordwrong"/>";</script>
<%}%>
</div>
</div>
</body>
</html>