<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forget password</title>

<style type="text/css">
<%@ include file="forget.css" %>
</style>
</head>
<body style="background:url('/bfish/images/school.jpg');">

<form id="msform" action="/bfish/Rforget.do?action=3" onsubmit="return check()">
	
	<ul id="progressbar">
		<li class="active"><span>1</span>input account<i class="first-i"></i></li>
		<li class="active"><span>2</span>input security code<i></i></li>
		<li class="active"><span>3</span>reset password<i></i></li>
		<li><span>4</span>reset success<i></i></li>
	</ul>
	
	<fieldset style="display:block">
		<h2 class="fs-title">reset password</h2>
		<div class="fs-bag">
			<input name="action" type="hidden" value="3">
			<input id="accountpwd" name="accountpwd" class="fs-input3" placeholder="input new password" type="password">
		</div>
		<div class="fs-bag">
			<input id="checkpwd" name="checkpwd" class="fs-input3" placeholder="input new password" type="password">
		</div>
        <div class="fs-bag">
          <span id="errormessage"></span>
        </div>
		<input class="next action-button" value="next" type="submit">
	</fieldset>

</form>

</body>
<script type="text/javascript">
function check()
{
	var pwd = document.getElementById("accountpwd");
	if (pwd.value == "" || pwd.value == null)	{	
		document.getElementById("errormessage").innerHTML="please input password";
		return false;
	}
	var checkpwd = document.getElementById("checkpwd");
	if (checkpwd.value == "" || checkpwd.value == null)	{	
		document.getElementById("errormessage").innerHTML="please input password again";
		return false;
	}
	if (pwd.value != checkpwd.value)	{	
		document.getElementById("errormessage").innerHTML="two password are not same";
		return false;
	}
	return true;
}
</script>
</html>