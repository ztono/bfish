<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Email</title>
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
    height: 300px;
    padding: 30px;
    background:rgba(255,255,255,0.1);
    position: absolute;
    top: 130px;
    left: 500px;
    z-index: 999;
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

.login-submit-box span {
    float: left;
    width: 100%;
    height: 40px;
    line-height: 15px;
    color: #ff0000;
    font-size: 14px;
    padding-top: 11px;
}
</style>
<% String user_id = (String)session.getAttribute("user_id");
//String password = UserDao.getPassword(user_id); %>
<script type="text/javascript">
var step = 1;
function check()
{
	if(step == 2){
		var code = document.getElementById("code");
		if (code.value == "" || code.value == null)	{	
			document.getElementById("error").innerHTML="please input the security code";
			return false;
		}else{
			document.getElementById("action").value="2";
			document.getElementById("error").innerHTML="the security code is wrong";
			return true;
		}
	}
	if(step == 1){
		var email = document.getElementById("email");
		if (email.value == "" || email.value == null)	{	
			document.getElementById("error").innerHTML="please input your email";
			return false;
		}else{
			step = 2;
			document.getElementById("submit").value="SUBMIT";
			document.getElementById("code").disabled="";
			document.getElementById("email").readOnly="readOnly";
			document.getElementById("error").innerHTML="please input the security code";
			return true;
		}
	}
}
</script>
</head>
<body style="background-image:url('/bfish/images/school.jpg');">

<div class="login-bag">
        		  
<p class="login-bag-title">Change Email</p>
<form id="fm1" class="fm-v clearfix" action="/bfish/Rchange.do" method="post" onsubmit="return check()">
	<input name="action" type="hidden" value="0" id="action">
	<input name="email" id="email" placeholder="input new email" class="login-username" type="text"> 
	<input name="code" id="code" placeholder="input security code" class="login-password" type="text" disabled="disabled">
	
	<div class="login-submit-box">
		<input type="submit" class="submit_button" value="GET SECURITY" id="submit">
		<div class="errorInfo" id="errorInfo"><span id="error"></span></div>
	</div>
 
</form>
</div>

</body>
</html>