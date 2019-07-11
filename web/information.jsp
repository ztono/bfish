<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"
		 import="BEAN.Client,java.util.*,DAO.*"
		 import="DAO.LoginDAO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/pagination.js"></script>
<script src="js/html5shiv.min.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/slide.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/flat-ui.min.css" />
<link rel="stylesheet" type="text/css" href="css/jquery.nouislider.css">
<style>
	#rightContent #back{
		width:100%;
		height:100%;
		display:block;
	}
</style>
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
<script>
	function jump(){

		window.location.href="http://localhost:8080/client.html";
	}
	function jump1(){

		window.location.href="http://localhost:8080/information.jsp";
	}
</script>
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
				<div role="tabpanel" class="tab-pane" id="displayemployee">
					<div class="container">
                <br/> <br/> <br/>
				<h1 align="center">个人信息</h1>


				<table  style="width: 800px; margin: 44px auto"
						class="table table-striped table-bordered table-hover  table-condensed"
						align='center' border='0' cellspacing='0'>
					<tr>
						<td align="center">用户名</td>
						<td align="center">身份证号</td>
						<td align="center">电子邮箱</td>
						<td align="center">电话号码</td>
					</tr>
					<%
						LoginDAO login = new LoginDAO();
						String email =(String)request.getSession().getAttribute("clientEmail");
						Client client =login.DisplayClient(email);




					%>
					<tr>
						<td align="center" width="10%"><%= client.getUsername() %></td>
						<td align="center" width="10%"><%= client.getIdcard() %></td>
						<td align="center" width="10%"><%= client.getEmail() %></td>
						<td align="center" width="10%"><%= client.getTelephone() %></td>

				</table>

						<div style="text-align:center">
						<button class="btn btn-sm btn-primary" type="button"onclick="jump()">返回主页</button>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button class="btn btn-sm btn-primary" data-toggle="modal" data-target="#myModal1" onclick="values(<%=client.getEmail()%>)">
								修改
							</button>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

						</div>

						<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<div class="form-group ">
											<form  id="form1" class="form-horizontal" action="informationServlet" method="post" style="width:700px;height:1000px"
											>
												<div class="form-group ">
													<label  style="font-size:20px ;color: #000000" for="username1" class="col-xs-3 control-label">客户名：</label>
													<div class="col-xs-8 ">
														<input  type="text" name="name" class="form-control input-sm duiqi" id="username1" value="<%= client.getUsername() %>">
													</div>
												</div>

												<div class="form-group">
													<label style="font-size:20px;color: #000000" for="idcard" class="col-xs-3 control-label">身份证号：</label>
													<div class="col-xs-8">
														<input   type="text" name="idcard" class="form-control input-sm duiqi" id="idcard" value="<%= client.getIdcard() %>">
													</div>
												</div>
												<div class="form-group">
													<label style="font-size:20px;color: #000000" for="email" class="col-xs-3 control-label">邮箱号：</label>
													<div class="col-xs-8">
														<input  type="text" name="email" class="form-control input-sm duiqi" id="email" value="<%= client.getEmail() %>">
													</div>
												</div>
												<div class="form-group">
													<label style="font-size:20px;color: #000000" for="telephone" class="col-xs-3 control-label">电话号码：</label>
													<div class="col-xs-8">
														<input   type="text" name="telephone" class="form-control input-sm duiqi" id="telephone" value="<%= client.getTelephone() %>">
													</div>
												</div>
												<div class="form-group text-right">
													<div class="col-xs-offset-4 col-xs-5" style="margin-left: 169px;">
														<button style="font-size:20px" type="button" class="btn btn-sm btn-green" onclick="jump1()">返回</button>
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

														<button style="font-size:20px" type="submit" class="btn btn-sm btn-green">提 交</button>
													</div>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>




					</div>
				</div>
		</div>
		</div>



	<script style="font-size:20px" type="text/javascript">
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

					idcard: {
						validators: {
							notEmpty: {
								message: '身份证号不能为空！'
							},
							regexp: {
								regexp: /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/,
								message: '身份证号码格式不正确，为15位和18位身份证号码！'
							},
							callback: {
								message: '身份证号码无效！',
								callback:function(value, validator,$field){
									//15位和18位身份证号码的正则表达式
									var regIdCard = /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/;
									//如果通过该验证，说明身份证格式正确，但准确性还需计算
									var idCard = value;
									if (regIdCard.test(idCard)) {
										if (idCard.length == 18) {
											var idCardWi = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2); //将前17位加权因子保存在数组里
											var idCardY = new Array(1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2); //这是除以11后，可能产生的11位余数、验证码，也保存成数组
											var idCardWiSum = 0; //用来保存前17位各自乖以加权因子后的总和
											for (var i = 0; i < 17; i++) {
												idCardWiSum += idCard.substring(i, i + 1) * idCardWi[i];
											}
											var idCardMod = idCardWiSum % 11;//计算出校验码所在数组的位置
											var idCardLast = idCard.substring(17);//得到最后一位身份证号码
											//如果等于2，则说明校验码是10，身份证号码最后一位应该是X
											if (idCardMod == 2) {
												if (idCardLast == "X" || idCardLast == "x") {
													return true;
													//alert("恭喜通过验证啦！");
												} else {
													return false;
													//alert("身份证号码错误！");
												}
											} else {
												//用计算出的验证码与最后一位身份证号码匹配，如果一致，说明通过，否则是无效的身份证号码
												if (idCardLast == idCardY[idCardMod]) {
													//alert("恭喜通过验证啦！");
													return true;
												} else {
													return false;
													//alert("身份证号码错误！");
												}
											}
										}
									} else {
										//alert("身份证格式不正确!");
										return false;
									}
								}
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
							regexp:{
								regexp: /^0|1[0123456789]\d{9}$/,
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