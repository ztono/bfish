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

<form id="msform" action="/bfish/Rforget.do?act=nihaoaaaa" onsubmit="return check()">
	
	<ul id="progressbar">
		<li class="active"><span>1</span>input account<i class="first-i"></i></li>
		<li><span>2</span>input security code<i></i></li>
		<li><span>3</span>reset password<i></i></li>
		<li><span>4</span>reset success<i></i></li>
	</ul>
	
	<fieldset style="display:block;padding: 20px 20px;">
		<h2 class="fs-title">input account</h2>
		<div class="fs-bag">
			<input name="action" type="hidden" value="1">
			<input style="padding-left:15px;padding-right:0;width:708px;" id="accountkey" name="accountkey" class="fs-input1" placeholder="account conot be empty" type="text">
			<p id="accounttip" class="magcws"></p>
		</div>
		<input class="next action-button" value="next" style="margin-top:50px;" type="submit">
	</fieldset>

</form>

<% String exist = (String)request.getAttribute("exist"); 
 if("false".equals(exist)){ %>
<script>document.getElementById("accounttip").innerHTML="the account does not exist";</script>
<%} %>

</body>
<script type="text/javascript">
function check()
{
	var user_id = document.getElementById("accountkey");
	if (user_id.value == "" || user_id.value == null)	{	
		document.getElementById("accounttip").innerHTML="the account cannot be empty";
		return false;
	}
	return true;
}
</script>
</html>