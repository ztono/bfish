<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page import="java.io.*,java.util.*" %>
<%--<%--%>
<%--    // 获取session创建时间--%>
<%--    Date createTime = new Date(session.getCreationTime());--%>
<%--    // 获取最后访问页面的时间--%>
<%--    Date lastAccessTime = new Date(session.getLastAccessedTime());--%>

<%--    String title = "访问网页";--%>
<%--    Integer visitCount = new Integer(0);--%>
<%--    String visitCountKey = new String("visitCount");--%>
<%--    String userIDKey = new String("userID");--%>
<%--    String userID = new String("ABCD");--%>

<%--    // 检测网页是否有新的访问用户--%>
<%--    if (session.isNew()){--%>
<%--        title = "访问网页";--%>
<%--        session.setAttribute(userIDKey, userID);--%>
<%--        session.setAttribute(visitCountKey,  visitCount);--%>
<%--    } else {--%>
<%--        visitCount = (Integer)session.getAttribute(visitCountKey);--%>
<%--        visitCount += 1;--%>
<%--        userID = (String)session.getAttribute(userIDKey);--%>
<%--        session.setAttribute(visitCountKey,  visitCount);--%>
<%--    }--%>
<%--%>--%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="旅馆管理系统">
    <meta name="keywords" content="旅馆管理系统 ">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <title>前台工作人员</title>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/pagination.js"></script>
    <script>
        $(function() {
            $(".meun-item").click(function() {
            	$("#back").hide();
                $(".meun-item").removeClass("meun-item-active");
                $(this).addClass("meun-item-active");
                var itmeObj = $(".meun-item").find("img");
                itmeObj.each(function() {
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
            $("#topAD").click(function() {
                $("#topA").toggleClass(" glyphicon-triangle-right");
                $("#topA").toggleClass(" glyphicon-triangle-bottom");
            });
            $("#topBD").click(function() {
                $("#topB").toggleClass(" glyphicon-triangle-right");
                $("#topB").toggleClass(" glyphicon-triangle-bottom");
            });
            $("#topCD").click(function() {
                $("#topC").toggleClass(" glyphicon-triangle-right");
                $("#topC").toggleClass(" glyphicon-triangle-bottom");
            });
            $(".toggle-btn").click(function() {
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
        <div class="meun-title">登记管理</div>
        <div class="meun-item" ><a href="#checkout" aria-controls="checkout" role="tab" data-toggle="tab" id="t1"><img src="images/icon_char_grey.png">退房登记</a></div>
        <div class="meun-item" ><a href="#reserve" aria-controls="reserve" role="tab" data-toggle="tab"><img src="images/icon_char_grey.png">预定</a></div>
    </div>
    <!-- 右侧具体内容栏目 -->
    <div id="rightContent">
    
    	<img id="back" src="image/background.jpg">
        <a class="toggle-btn" id="nimei">
            <i class="glyphicon glyphicon-align-justify"></i>
        </a>
        <!-- Tab panes -->
        <div class="tab-content">
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
<%--                <h1>Session 跟踪</h1>--%>

<%--                <table border="1" align="center">--%>
<%--                    <tr bgcolor="#949494">--%>
<%--                        <th>Session 信息</th>--%>
<%--                        <th>值</th>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                        <td>id</td>--%>
<%--                        <td><% out.print( session.getId()); %></td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                        <td>创建时间</td>--%>
<%--                        <td><% out.print(createTime); %></td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                        <td>最后访问时间</td>--%>
<%--                        <td><% out.print(lastAccessTime); %></td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                        <td>用户 ID</td>--%>
<%--                        <td><% out.print(userID); %></td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                        <td>访问次数</td>--%>
<%--                        <td><% out.print(visitCount); %></td>--%>
<%--                    </tr>--%>
<%--                </table>--%>
            </div>
            <div role="tabpanel" class="tab-pane" id="reserve">
                <div class="container">
                    <div class="page-header">
                        <h1 align="center">reserve</h1>
                    </div>
                    <div style="padding: 50px 0;margin-top: 50px;background-color: #fff; text-align: right;width: 420px;margin: 50px auto;">
                        <form class="form-horizontal" action="checkOutServlet" method="post">
                            <div class="form-group ">
                                <label for="cNo2" class="col-xs-3 control-label">客户ID：</label>
                                <div class="col-xs-8 ">
                                    <input type="" name="client_no" class="form-control input-sm duiqi" id="cNo2" placeholder="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="rNo2" class="col-xs-3 control-label">房间号：</label>
                                <div class="col-xs-8 ">
                                    <input type="" name="room_no" class="form-control input-sm duiqi" id="rNo2" placeholder="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="isD2" class="col-xs-3 control-label">是否损坏：</label>
                                <div class="col-xs-8">
                                    <input type="" name="isdamaged" class="form-control input-sm duiqi" id="isD2" placeholder="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="expS2" class="col-xs-3 control-label">体验评分：</label>
                                <div class="col-xs-8">
                                    <input type="" name="exp_score" class="form-control input-sm duiqi" id="expS2" placeholder="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="serS2" class="col-xs-3 control-label">服务评分：</label>
                                <div class="col-xs-8">
                                    <input type="" name="ser_score" class="form-control input-sm duiqi" id="serS2" placeholder="">
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

    </div>
</div>
<script src="js/jquery.nouislider.js"></script>

<% if (request.getParameter("ds")!= null) {%>
<script type="text/javascript">
    $(document).ready(function(){

            // $('#t1').tab('show');
            $("#t1").click();
        });
</script>
<%} %>
/* 看板娘 */
<script src="https://cdn.jsdelivr.net/npm/live2d-widget@3.0.4/lib/L2Dwidget.min.js"></script>
<script type="text/javascript">
    L2Dwidget.init();
</script>

</body>
</html>