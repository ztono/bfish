<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Password</title>
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
    height: 370px;
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
String password = UserDao.getPasswrod(user_id); %>
<script type="text/javascript">
function check()
{
	var oldpwd = document.getElementById("oldpwd");
	if (oldpwd.value == "" || oldpwd.value == null)	{	
		document.getElementById("error").innerHTML="please input the old password";
		return false;
	}
	var newpwd = document.getElementById("newpwd");
	if (newpwd.value == "" || newpwd.value == null)	{	
		document.getElementById("error").innerHTML="please input the new password";
		return false;
	}
	var repwd = document.getElementById("repwd");
	if (repwd.value == "" || repwd.value == null)	{	
		document.getElementById("error").innerHTML="please input the new password again";
		return false;
	}
	if (newpwd.value != repwd.value) {	
		document.getElementById("error").innerHTML="two new password are not same";
		return false;
	}
	if (oldpwd.value != "<%=password %>") {	
		document.getElementById("error").innerHTML="the password is wrong";
		return false;
	}
	return true;
}
</script>
</head>
<body style="background-image:url('/bfish/images/school.jpg');">

<div class="login-bag">
        		  
<p class="login-bag-title">Change Password</p>
<form id="fm1" class="fm-v clearfix" action="/bfish/Rchange.do" method="post" onsubmit="return check()">
	<input name="action" type="hidden" value="1">
	<input name="oldpwd" id="oldpwd" placeholder="input old password" class="login-username" type="password"> 
	
	<input name="newpwd" id="newpwd" placeholder="input new password" class="login-password" type="password">
	
	<input name="repwd" id="repwd" placeholder="repead new password" class="login-password" type="password">
	
	<div class="login-submit-box">
		<input type="submit" class="submit_button" value="submit">
		<div class="errorInfo" id="errorInfo"><span id="error"></span></div>
	</div>
 
</form>
</div>

</body>
</html>