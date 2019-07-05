<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Register - Input Form by Tooplate</title>

	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/materialize.min.css">
	<link rel="stylesheet" href="css/tooplate.css">
</head>

<body id="register">
<div class="container">
	<div class="row tm-register-row">
		<div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 tm-register-col-l">
			<%
				Object message2 = request.getSession().getAttribute("message2");
				if(message2!=null && !"".equals(message2)){

			%>
			<script type="text/javascript">
				alert("<%=message2%>");
			</script>
			  <%} %>
			<form action="logonServlet" method="post">
				<div class="input-field">
					<input placeholder="Name" id="name" name="name" type="text" class="validate">
				</div>
				<div class="input-field">
					<input placeholder="Email" id="email" name="email" type="text" class="validate">
				</div>
				<div class="input-field">
					<input placeholder="Password" id="password" name="password" type="text" class="validate">
				</div>
				<div class="input-field">
					<input placeholder="Telephone" id="telephone" name="telephone" type="text" class="validate">
				</div>
				<div class="input-field">
					<input placeholder="Idcard" id="idcard" name="idcard" type="text" class="validate">
				</div>
				<div class="text-right mt-4">
					<button type="submit" class="waves-effect btn-large btn-large-white px-4 black-text">SUBMIT</button>
				</div>
			</form>
		</div>
		<div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 tm-register-col-r">
			<header class="mb-5">
				<h3 class="mt-0 text-white">REGISTER Yourself</h3>
				<p class="grey-text">Aenean tincidunt, enim nec blandit lobortis, ante enim ultrices eros, et laoreet augue libero id nunc.
					Proin semper feugiat ultrices.</p>
				<p class="grey-text">Aenean a efficitur magna, sed dignissim odio. Praesent pretium lectus ac nunc ultrices, ac volutpat orci
					viverra.
				</p>
			</header>

		</div>
	</div>
	<footer class="row tm-mt-big mb-3">
		<div class="col-xl-12">
			<p class="text-center grey-text text-lighten-2 tm-footer-text-small">
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
</script>
</body>

</html>