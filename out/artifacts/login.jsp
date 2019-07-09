<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Login Form by Tooplate</title>

	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min1.css">
	<link rel="stylesheet" type="text/css" href="css/materialize.min.css">
	<link rel="stylesheet" type="text/css" href="css/tooplate.css">
</head>

<body id="login">
<div class="container">
	<div class="row tm-register-row tm-mb-35">
		<div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 tm-login-l">
			<%
				Object message = request.getSession().getAttribute("message");
				if(message!=null && !"".equals(message)){

			%>
			<script type="text/javascript">
				alert("<%=message%>");
			</script>
			  <%} %>
			<form action="loginServlet" method="post" class="tm-bg-black p-5 h-100">
				<div class="input-field">
					<input placeholder="Email" id="email" name="email" type="text" class="validate" >
				</div>
				<div class="input-field mb-5">
					<input placeholder="Password" id="password" name="password" type="password" class="validate" onclick="check()">
				</div>
				<div class="tm-flex-lr">
<%--					<a href="#" class="white-text small">Forgot Password?</a>--%>
					<button type="submit" class="waves-effect btn-large btn-large-white px-4 black-text rounded-0">登录</button>
					<a href="logon.jsp" class="waves-effect btn-large btn-large-white px-4 black-text rounded-0">注册</a>
				</div>
<%--				<div class="row">--%>
<%--					<div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 ml-auto mr-0 text-center">--%>
<%--						<a href="logon.jsp" class="waves-effect btn-large btn-large-white px-4 black-text rounded-0">注册</a>--%>
<%--					</div>--%>
<%--				</div>--%>
			</form>
		</div>
<%--		<div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 tm-login-r">--%>
<%--			<header class="font-weight-light tm-bg-black p-5 h-100">--%>
<%--&lt;%&ndash;				<h3 class="mt-0 text-white font-weight-light">Your Login</h3>&ndash;%&gt;--%>
<%--&lt;%&ndash;				<p>Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.</p>&ndash;%&gt;--%>
<%--&lt;%&ndash;				<p class="mb-0">Vestibulum neque neque, porttitor quis lacinia eu, iaculis id dui. Mauris quis velit lectus.</p>&ndash;%&gt;--%>
<%--			</header>--%>
<%--		</div>--%>
	</div>

	<footer class="row tm-mt-big mb-3">
		<div class="col-xl-12 text-center">
			<p class="d-inline-block tm-bg-black white-text py-2 tm-px-5">
				Copyright &copy; 2018 Company Name

				- Design:  Tooplate / More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
		</div>
	</footer>
</div>

<script src="js/jquery-3.2.1.slim.min.js"></script>
<script src="js/materialize.min.js"></script>
<script>
	$(document).ready(function () {
		$('select').formSelect();
	});
    function check()
    {

        var email=document.getElementById("email").value;

//
        if(email=="")
        {
            alert("电子邮件不能为空");
            return false;
        }
        else
        {
            reg=/^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/gi;
            if(!reg.test(email))
            {
                alert("非法的电子邮件");
                return false;
            }
        }
    }
</script>
</body>

</html>