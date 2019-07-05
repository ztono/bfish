<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"  import="java.util.*,BEAN.*,DAO.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="旅馆管理系统">
    <meta name="keywords" content="旅馆管理系统 ">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <title>admin</title>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/pagination.js"></script>
    <script>
        $("#myModal").modal("hide");
        function Rvalues(id) {
            $("#room_id").val(id);


        }
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
<% String Rd = (String)request.getAttribute("room_delete");
    if("true".equals(Rd)){%>
<script type="text/javascript">alert("delete success");</script>
<% }else if("false".equals(Rd)){%>
<script type="text/javascript">alert("error");</script>
<%} %>

<% String Rflag = (String)request.getAttribute("add");
    if(Rflag=="3")
    {%>
<script type="text/javascript">alert("add successfully");</script>
<% }
else if(Rflag=="2")

{%>
<script type="text/javascript">alert("this room id has already existed,please change");</script>
<%}
%>

    <div id="wrap">
    <!-- 左侧菜单栏目块 -->
    <div class="leftMeun" id="leftMeun">
        <div id="logoDiv">
            <p id="logoP"><img id="logo" alt="旅馆管理系统" src="images/dong.jpg"><span>旅馆管理系统</span></p>
        </div>
        <div id="personInfor">
            <p id="userName">亲爱的管理员<%= (String) request.getSession().getAttribute("id") %>，欢迎您！</p>
            <p>
                <a href="login.jsp">退出登录</a>
            </p>
        </div>
        <div class="meun-title">房间管理</div>
        <div class="meun-item" href="#addroom" aria-controls="addroom" role="tab" data-toggle="tab"><img src="images/icon_char_grey.png">添加房间</div>
        <div class="meun-item" href="#modroom" aria-controls="modroom" role="tab" data-toggle="tab" ><img src="images/icon_char_grey.png">修改房间</div>
        <div class="meun-title">人事管理</div>
        <div class="meun-item" href="#checkout" aria-controls="checkout" role="tab" data-toggle="tab"><img src="images/icon_char_grey.png">添加雇员</div>
        <div class="meun-item" href="#checkout" aria-controls="checkout" role="tab" data-toggle="tab"><img src="images/icon_char_grey.png">查看雇员</div>
        <div class="meun-item" href="#checkout" aria-controls="checkout" role="tab" data-toggle="tab"><img src="images/icon_char_grey.png">查看上班记录</div>
        <div class="meun-title">收入管理</div>
        <div class="meun-item" href="#checkout" aria-controls="checkout" role="tab" data-toggle="tab"><img src="images/icon_char_grey.png">查看月收入</div>

    </div>
    <!-- 右侧具体内容栏目 -->
    <div id="rightContent">

        <img id="back" src="image/background.jpg">
        <a class="toggle-btn" id="nimei">
            <i class="glyphicon glyphicon-align-justify"></i>
        </a>
        <!-- Tab panes -->
        <div class="tab-content">

            <!--添加房间模块-->
            <div role="tabpanel" class="tab-pane" id="addroom">
                <div class="container">
                    <div class="page-header">
                        <h1 align="center">添加房间</h1>
                    </div>
                    <div style="padding: 50px 0;margin-top: 50px;background-color: #fff; text-align: right;width: 420px;margin: 50px auto;">
                        <form class="form-horizontal" action="addroomServlet" method="post">
                            <div class="form-group ">
                                <label for="rid" class="col-xs-3 control-label">房间ID：</label>
                                <div class="col-xs-8 ">
                                    <input type="" name="room_id" class="form-control input-sm duiqi" id="rid" placeholder="">
                                </div>
                            </div>
                            <label for="rty" class="col-xs-3 control-label">房间型号:</label>
                            <div  class="form-group">
                                 <select class="form-control"style="width: 200px;height: 30px" name="room_type"  id="rty" >
                                        <option>singleroom</option>
                                        <option>doubleroom</option>
                                        <option>bigbedroom</option>

                                    </select>


                            </div>

                            <div class="form-group">
                                <label for="pri" class="col-xs-3 control-label">客房价格：</label>
                                <div class="col-xs-8">
                                    <input type="" name="room_price" class="form-control input-sm duiqi" id="pri" placeholder="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="loc" class="col-xs-3 control-label">客房位置：</label>
                                <div class="col-xs-8">
                                    <input type="" name="room_location" class="form-control input-sm duiqi" id="loc" placeholder="">
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
            <!-- 修改房间模块 -->
            <div role="tabpanel" class="tab-pane" id="modroom">
                <div class="container">
                    <div class="page-header">
                        <h4 align="center">修改房间</h4>
                    </div>
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>房间号</th>
                            <th>房间类型</th>
                            <th>房间价格</th>
                            <th>房间位置</th>
                            <th>操作</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                    <%
                        List<Room> rooms =RoomDao.getrooms();


                        for(Room room:rooms)
                        {

                    %>

                    <tr>
                        <td ><%= room.getRoom_id() %></td>
                        <td ><%= room.getRoom_type() %></td>
                        <td ><%= room.getRoom_price() %></td>
                        <td ><%= room.getRoom_location() %></td>
                        <td> <button class="btn btn-sm btn-primary" data-toggle="modal" data-target="#myModal" onclick="values(<%=room.getRoom_id()%>)" > change</button></td>
                        <td> <button class="btn btn-sm btn-warning" data-toggle="modal" data-target="#myModal" onclick="values(<%=room.getRoom_id()%>)"> delete</button></td>
                        </tr>
                        <%
                        }
                        %>



                            </tbody>
                        </table>

                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <div class="form-group ">
                                        <form action="">
                                            <table>

                                                <tr>
                                                    <td width="100" height="50" font size="20px">房间号</td>

                                                    <td><input type="text" name="room_id" id="room_id" ></td></tr>
                                                <tr>	<td width="100" height="50" font size="20px">房间价格</td>

                                                    <td>
                                                        <input type="text" name="room_price" id="room_price"></td></tr>
                                                <tr>
                                                    <td width="100" height="50" font size="20px">房间位置</td>
                                                    <td>
                                                        <input type="text" name="room_location" id="room_location"></td></tr>
                                                <tr>
                                                    <td width="100" height="50" font size="20px">房间型号</td>
                                                    <td>
                                                        <select name="room_type" class="text2">

                                                            <option value="singleroom">singleroom</option>
                                                            <option value="doubleroom">doubleroom</option>
                                                            <option value="bigbedroom">bigbedroom</option>
                                                        </select></td></tr>
                                                                  <input type="hidden" name="room_no" id="room_no">
                                                <tr> <td><input type="submit" value="SUBMIT"></td></tr>

                                            </table>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
<%--        <div role="tabpanel" class="tab-pane" id="checkout">--%>
<%--            <div class="container">--%>
<%--                <div class="page-header">--%>
<%--                    <h1 align="center">退房登记</h1>--%>
<%--                </div>--%>
<%--                <div style="padding: 50px 0;margin-top: 50px;background-color: #fff; text-align: right;width: 420px;margin: 50px auto;">--%>
<%--                    <form class="form-horizontal" action="checkOutServlet" method="post">--%>
<%--                        <div class="form-group ">--%>
<%--                            <label for="cNo" class="col-xs-3 control-label">客户ID：</label>--%>
<%--                            <div class="col-xs-8 ">--%>
<%--                                <input type="" name="client_no" class="form-control input-sm duiqi" id="cNo" placeholder="">--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="form-group">--%>
<%--                            <label for="rNo" class="col-xs-3 control-label">房间号：</label>--%>
<%--                            <div class="col-xs-8 ">--%>
<%--                                <input type="" name="room_no" class="form-control input-sm duiqi" id="rNo" placeholder="">--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="form-group">--%>
<%--                            <label for="isD" class="col-xs-3 control-label">是否损坏：</label>--%>
<%--                            <div class="col-xs-8">--%>
<%--                                <input type="" name="isdamaged" class="form-control input-sm duiqi" id="isD" placeholder="">--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="form-group">--%>
<%--                            <label for="expS" class="col-xs-3 control-label">体验评分：</label>--%>
<%--                            <div class="col-xs-8">--%>
<%--                                <input type="" name="exp_score" class="form-control input-sm duiqi" id="expS" placeholder="">--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="form-group">--%>
<%--                            <label for="serS" class="col-xs-3 control-label">服务评分：</label>--%>
<%--                            <div class="col-xs-8">--%>
<%--                                <input type="" name="ser_score" class="form-control input-sm duiqi" id="serS" placeholder="">--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="form-group text-right">--%>
<%--                            <div class="col-xs-offset-4 col-xs-5" style="margin-left: 169px;">--%>
<%--                                <button class="btn btn-sm btn-primary" type="reset">重置</button>--%>
<%--                                <button type="button" class="btn btn-sm btn-warning" data-dismiss="modal">取 消</button>--%>
<%--                                <button type="submit" class="btn btn-sm btn-green">保 存</button>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </form>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
    </div>
    </div>
</div>
    <script src="js/jquery.nouislider.js"></script>


</body>
</html>