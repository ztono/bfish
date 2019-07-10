<%--
  Created by IntelliJ IDEA.
  User: 94714
  Date: 2019/7/2
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="旅馆管理系统">
    <meta name="keywords" content="旅馆管理系统 ">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <title>用户</title>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/pagination.js"></script>
    <script>
        $(function () {
            $(".meun-item").click(function () {
                $("#back").hide();
                $(".meun-item").removeClass("meun-item-active");
                $(this).addClass("meun-item-active");
                var itmeObj = $(".meun-item").find("img");
                itmeObj.each(function () {
                    var items = $(this).attr("src");
                    items = items.replace("_grey.png", ".png");
                    items = items.replace(".png", "_grey.png")
                    $(this).attr("src", items);
                });
                var attrObj = $(this).find("img").attr("src");
                ;
                attrObj = attrObj.replace("_grey.png", ".png");
                $(this).find("img").attr("src", attrObj);
            });
            $("#topAD").click(function () {
                $("#topA").toggleClass(" glyphicon-triangle-right");
                $("#topA").toggleClass(" glyphicon-triangle-bottom");
            });
            $("#topBD").click(function () {
                $("#topB").toggleClass(" glyphicon-triangle-right");
                $("#topB").toggleClass(" glyphicon-triangle-bottom");
            });
            $("#topCD").click(function () {
                $("#topC").toggleClass(" glyphicon-triangle-right");
                $("#topC").toggleClass(" glyphicon-triangle-bottom");
            });
            $(".toggle-btn").click(function () {
                $("#leftMeun").toggleClass("show");
                $("#rightContent").toggleClass("pd0px");
            })
        })
    </script>
    <!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/slide.css"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/flat-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/jquery.nouislider.css">
    <link rel="stylesheet" type="text/css" href="css/smart_qa.css">
    <style>
        #rightContent #back {
            width: 100%;
            height: 100%;
            display: block;
        }
    </style>
</head>

<body>
<div id="wrap">
    <!-- 左侧菜单栏目块 -->
    <div class="leftMeun" id="leftMeun">
        <div id="logoDiv">
            <p id="logoP"><img id="logo" alt="旅馆管理系统" src="images/dong.jpg"><span>旅馆管理系统</span></p>
        </div>
        <div id="personInfor">
            <p id="userName">亲爱的用户<%= (String) request.getSession().getAttribute("id") %>，欢迎您！</p>
            <p>
                <a href="login.jsp">退出登录</a>
            </p>
        </div>
        <div class="meun-title">用户选项</div>
        <div class="meun-item" href="#" aria-controls="rooms_query" role="tab" data-toggle="tab"><img
                src="images/icon_char_grey.png">剩余客房查询
        </div>
        <div class="meun-item" href="#smart_qa" aria-controls="smart_qa" role="tab" data-toggle="tab"><img
                src="images/icon_char_grey.png">智能小助手
        </div>
        <div class="meun-item" href="#" aria-controls="ask_clean" role="tab" data-toggle="tab"><img
                src="images/icon_char_grey.png">申请打扫
        </div>
        <div class="meun-item" href="#" aria-controls="reserve" role="tab" data-toggle="tab"><img
                src="images/icon_char_grey.png">预定房间
        </div>
        <div class="meun-item" href="#ChangePassword" aria-controls="ChangePassword" role="tab" data-toggle="tab"><img
                src="images/icon_char_grey.png">修改密码
        </div>
        <div class="meun-item" href="#checkout" aria-controls="checkout" role="tab" data-toggle="tab"><img
                src="images/icon_char_grey.png">修改密码
        </div>
    </div>
    <!-- 右侧具体内容栏目 -->
    <div id="rightContent">

        <img id="back" src="image/background.jpg">
        <a class="toggle-btn" id="nimei">
            <i class="glyphicon glyphicon-align-justify"></i>
        </a>
        <!-- Tab panes -->
        <div class="tab-content">

            <!--智能助手模块-->
            <div role="tabpanel" class="tab-pane" id="smart_qa" >
                <div class="container">
                    <div class="page-header">
                        <h1 align="center">智能小助手</h1>
                    </div>
                    <div class="qa_guide_text">
                        <p>欢迎问智能小助手问题哦！</p>
                    </div>
                    <div id="ask_block" class="qa_ask_div">
                        <textarea id="ask_qa_textarea">

                        </textarea>
                    </div>
                    <div id="ask_button_div" class="qa_ask_button_div">
                        <button id="qa_ask_button" >
                            询问小助手
                        </button>
                    </div>
                    <div id="qa_answer_div" class="qa_ask_div">
                        <textarea id="qa_answer_textarea">

                        </textarea>
                    </div>
                </div>
            </div>
            <script type="text/javascript">
                var qa_xml_http_request = new XMLHttpRequest();

                var ask_button = document.getElementById("qa_ask_button");
                ask_button.addEventListener('click',function (ev) {
                    var user_qa_input_textarea = document.getElementById("ask_qa_textarea");
                    var user_qa_input = user_qa_input_textarea.value;
                    var qa_url = "smartQaServlet?question="+user_qa_input;
                    qa_xml_http_request.open("GET",qa_url,true);
                    qa_xml_http_request.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
                    qa_xml_http_request.send(null);
                    qa_xml_http_request.onreadystatechange = show_answer;
                    function show_answer(){
                        if(qa_xml_http_request.readyState===4)
                        {
                            if(qa_xml_http_request.status===200)
                            {
                                var qa_answer_textarea = document.getElementById("qa_answer_textarea");
                                qa_answer_textarea.value = qa_xml_http_request.responseText;
                            }
                        }
                    }
                });

            </script>
        <%-- 智能问答助手--%>

            <!--客户删除-->
            <div role="tabpanel" class="tab-pane" id="ChangePassword">
                <div class="container">
                    <div class="page-header">
                        <h1 align="center">客户删除</h1>
                    </div>
                    <div style="padding: 50px 0;margin-top: 50px;background-color: #fff; text-align: right;width: 420px;margin: 50px auto;">
                        <form class="form-horizontal" action="deleteClientServlet" method="post">
                            <div class="form-group">
                                <label for="email1" class="col-xs-3 control-label">邮箱号：</label>
                                <div class="col-xs-8">
                                    <input type="" name="email1" class="form-control input-sm duiqi" id="email1" placeholder="">
                                </div>
                            </div>
                            <div class="form-group text-right">
                                <div class="col-xs-offset-4 col-xs-5" style="margin-left: 169px;">
                                    <button type="submit" class="btn btn-sm btn-green">提交</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <!--退房登记模块-->
            <div role="tabpanel" class="tab-pane" id="checkout">
                <div class="container">
                    <div class="page-header">
                        <h1 align="center">退房登记</h1>
                    </div>
                    <div style="padding: 50px 0;margin-top: 50px;background-color: #fff; text-align: right;width: 420px;margin: 50px auto;">
                        <form class="form-horizontal" action="checkOutServlet" method="post">
                            <div class="form-group ">
                                <label for="cNo" class="col-xs-3 control-label">客户ID：</label>
                                <div class="col-xs-8 ">
                                    <input type="" name="client_no" class="form-control input-sm duiqi" id="cNo" placeholder="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="rNo" class="col-xs-3 control-label">房间号：</label>
                                <div class="col-xs-8 ">
                                    <input type="" name="room_no" class="form-control input-sm duiqi" id="rNo" placeholder="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="isD" class="col-xs-3 control-label">是否损坏：</label>
                                <div class="col-xs-8">
                                    <input type="" name="isdamaged" class="form-control input-sm duiqi" id="isD" placeholder="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="expS" class="col-xs-3 control-label">体验评分：</label>
                                <div class="col-xs-8">
                                    <input type="" name="exp_score" class="form-control input-sm duiqi" id="expS" placeholder="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="serS" class="col-xs-3 control-label">服务评分：</label>
                                <div class="col-xs-8">
                                    <input type="" name="ser_score" class="form-control input-sm duiqi" id="serS" placeholder="">
                                </div>
                            </div>
                            <div class="form-group text-right">
                                <div class="col-xs-offset-4 col-xs-5" style="margin-left: 169px;">
                                    <button class="btn btn-sm btn-primary" type="reset">重置</button>
                                    <button type="button" class="btn btn-sm btn-warning" data-dismiss="modal">取 消</button>
                                    <button type="submit" class="btn btn-sm btn-green">保 存</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>

        <% if (request.getParameter("num").equals("1")) {%>
        <script type="text/javascript">
            alert("修改成功");
            $(document).ready(function(){
                $("#ChangePassword").click();
            });
        </script>
        <%} %>

    <script src="js/jquery.nouislider.js"></script>
    </div>
</div>
</body>
</html>