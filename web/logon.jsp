<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<meta name="format-detection" content="telephone=no">
	<title>Register - Input Form by Tooplate</title>

	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/materialize.min.css">
	<link rel="stylesheet" href="css/tooplate.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrapValidator.min.css">

	<script src="js/jquery-3.2.1.slim.min.js"></script>
	<script src="js/materialize.min.js"></script>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/bootstrapValidator.min.js"></script>
</head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<style type="text/css">
	input{
		width: 30px;
		margin: 5px 0 0 5px;
		padding: 5px 0 0 5px;
	}

</style>
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
			<div style="width:100%;text-align:center">
			<form id="form1" class="form-horizontal" action="addClientServlet" method="post" style="width:600px;height:800px"
			>
				<div class="form-group ">
					<label for="username1" class="col-xs-3 control-label">客户名：</label>
					<div class="col-xs-8 ">
						<input type="" name="name" class="form-control input-sm duiqi" id="username1" placeholder="">
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-xs-3 control-label">密码：</label>
					<div class="col-xs-8 ">
						<input type="" name="password" class="form-control input-sm duiqi" id="password" placeholder="">
					</div>
				</div>
				<div class="form-group">
					<label for="idcard" class="col-xs-3 control-label">身份证号：</label>
					<div class="col-xs-8">
						<input type="" name="idcard" class="form-control input-sm duiqi" id="idcard" placeholder="">
					</div>
				</div>
				<div class="form-group">
					<label for="email" class="col-xs-3 control-label">邮箱号：</label>
					<div class="col-xs-8">
						<input type="" name="email" class="form-control input-sm duiqi" id="email" placeholder="">
					</div>
				</div>
				<div class="form-group">
					<label for="telephone" class="col-xs-3 control-label">电话号码：</label>
					<div class="col-xs-8">
						<input type="" name="telephone" class="form-control input-sm duiqi" id="telephone" placeholder="">
					</div>
				</div>
				<div class="form-group text-right">
					<div class="col-xs-offset-4 col-xs-5" style="margin-left: 169px;">
						<button type="submit" class="btn btn-sm btn-green">提 交</button>
					</div>
				</div>
			</form>
		</div>
		</div>

		<script type="text/javascript">
			window.onload = function () {
				$('#form1').bootstrapValidator({
					message: 'This value is not valid',
					feedbackIcons: {
						valid: 'glyphicon glyphicon-ok',
						invalid: 'glyphicon glyphicon-remove',
						validating: 'glyphicon glyphicon-refresh'
					},
					fields: {
						name: {
							message: '用户名验证失败',
							validators: {
								notEmpty: {
									message: '用户名不能为空！'
								},
								stringLength: {
									min: 6,
									max: 20,
									message: '用户名长度必须在6到20位之间'
								},
								regexp: {
									regexp: /^[a-zA-Z0-9_]+$/,
									message: '用户名只能包含大写、小写、数字和下划线'
								}
							}
						},
						password: {
							message: '密码验证失败',
							validators: {
								notEmpty: {
									message: '密码不能为空！'
								},
								stringLength: {
									min: 8,
									max: 16,
									message: '密码长度必须在8到16位之间'
								},
								regexp: {
									regexp: /^[a-zA-Z0-9_]+$/,
									message: '密码只能包含大写、小写、数字和下划线'
								}
							}
						},
						idcard: {
							validators: {
								notEmpty: {
									message: '身份证号不能为空！'
								},
								creditCard:{
									message:'身份证号格式有误'
								}
							}
						},
						email:{
							validators:{
								notEmpty:{
									message:'邮箱不能为空！'
								},
								emailAddress: {
									message:'邮箱格式有误'
								}
							}
						},
						telephone:{
							validators:{
								notEmpty:{
									message:'电话号码不能为空！'
								},
								phone:{
									message:'电话号码格式有误'
								}
							}
						}
					}
				});
			}
		</script>


<%--		<div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 tm-register-col-r">--%>
<%--			<header class="mb-5">--%>
<%--				<h3 class="mt-0 text-white">REGISTER Yourself</h3>--%>
<%--				<p class="grey-text">Aenean tincidunt, enim nec blandit lobortis, ante enim ultrices eros, et laoreet augue libero id nunc.--%>
<%--					Proin semper feugiat ultrices.</p>--%>
<%--				<p class="grey-text">Aenean a efficitur magna, sed dignissim odio. Praesent pretium lectus ac nunc ultrices, ac volutpat orci--%>
<%--					viverra.--%>
<%--				</p>--%>
<%--			</header>--%>

<%--		</div>--%>
<%--	</div>--%>
<%--	<footer class="row tm-mt-big mb-3">--%>
<%--		<div class="col-xl-12">--%>
<%--			<p class="text-center grey-text text-lighten-2 tm-footer-text-small">--%>
<%--				Copyright &copy; 2018 Company Name--%>

<%--				- Design:  Tooplate / More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>--%>
<%--		</div>--%>
<%--	</footer>--%>
<%--</div>--%>

<script>
	$(document).ready(function () {
		$('select').formSelect();
	});
</script>
</body>

</html>