<%@ page import="java.util.List" %>
<%@ page import="BEAN.Room" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
    <title>前台工作人员</title>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/pagination.js"></script>
    <script src="js/bootstrapValidator.min.js"></script>
    <script src="js/jquery.nouislider.js"></script>
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
    <link rel="stylesheet" type="text/css" href="css/bootstrapValidator.min.css">
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
            <div role="group" aria-label="...">
                <a href="loading.jsp"><button type="button" class="btn btn-link btn-xs" style="margin-left: 10px;width: 100px;" >点击退出登录</button></a>
                <div>
                    <form class="form-inline" action="sign3.do" method="post" style="float: left">
                        <input type="hidden" name="staff_no" id="staff_no" value="<%=(String) request.getSession().getAttribute("staff")%>">
                        <button type="submit" class="btn btn-primary btn-xs">上班</button>
                    </form>
                    <form class="form-inline" action="sign4.do" method="post">
                        <input type="hidden" name="staff_no2" id="staff_no2" value="<%=(String) request.getSession().getAttribute("staff")%>">
                        <button type="submit" class="btn btn-primary btn-xs" style="float: right;margin-right: 30px;">下班</button>
                    </form>
                </div>
            </div>
        </div>

        <%
            String flag = (String)request.getAttribute("flag");
        %>
        <Script language="javascript">
            <% if (flag=="1"){ %>alert('上班打卡成功')<%}
        else if (flag=="-1"){ %>alert('您已打卡')<%}
        else if (flag=="2"){ %>alert('下班打卡成功')<%}
        else if (flag=="-2"){ %>alert('您已打卡')<%}
        else if (flag=="3"){ %>alert('上错误')<%}
        else if (flag=="-3"){ %>alert('下错误')<%}
%>
        </Script>





        <div class="meun-title">登记管理</div>
        <div class="meun-item" href="#checkin" aria-controls="checkin" role="tab" data-toggle="tab" id="checkInButton"><img src="images/icon_char_grey.png">入住登记</div>
        <div class="meun-item" href="#checkout" aria-controls="checkout" role="tab" data-toggle="tab" id="checkOutButton"><img src="images/icon_char_grey.png">退房登记</div>
        <div class="meun-item" href="#change" aria-controls="change" role="tab" data-toggle="tab" id="changeRoomButton"><img src="images/icon_char_grey.png">换房登记</div>
        <div class="meun-title">预定管理</div>
        <div class="meun-item" href="#reserve" aria-controls="reserve" role="tab" data-toggle="tab" id="employeeReserveButton"><img src="images/icon_char_grey.png">前台预定</div>
        <div class="meun-item" href="#searchReserve" aria-controls="searchReserve" role="tab" data-toggle="tab" id="employeeSearchReserveButton"><img src="images/icon_char_grey.png">预定查询</div>
        <div class="meun-title">客户管理</div>
        <div class="meun-item" href="#addClient" aria-controls="addClient" role="tab" data-toggle="tab" id="clientAddButton"><img src="images/icon_char_grey.png">客户添加</div>
        <div class="meun-item" href="#deleteClient" aria-controls="deleteClient" role="tab" data-toggle="tab" id="clientDelButton"><img src="images/icon_char_grey.png">客户删除</div>
        <div class="meun-title">房间管理</div>
        <div class="meun-item" href="#allRooms" aria-controls="allRooms" role="tab" data-toggle="tab" id="allRoomsButton"><img src="images/icon_char_grey.png">所有房间</div>
        <div class="meun-item" href="#showEmptyRooms" aria-controls="showEmptyRooms" role="tab" data-toggle="tab" id="showRoomsButton"><img src="images/icon_char_grey.png">显示空房间</div>

    </div>

    <!-- 右侧具体内容栏目 -->
    <div id="rightContent">
    
    	<img id="back" src="image/background.jpg">
        <a class="toggle-btn" id="nimei">
            <i class="glyphicon glyphicon-align-justify"></i>
        </a>

        <!-- Tab panes -->
        <div class="tab-content">

            <!--入住登记模块-->
            <div role="tabpanel" class="tab-pane" id="checkin">
                <div class="container">
                    <div class="page-header">
                        <h1 align="center">入住登记</h1>
                    </div>
                    <div style="padding: 50px 0;margin-top: 50px;background-color: #fff; text-align: right;width: 420px;margin: 50px auto;">
                        <form id="form1" class="form-horizontal" action="checkInServlet" method="post">
                            <div class="form-group ">
                                <label for="clientName" class="col-xs-3 control-label" >用户名：</label>
                                <div class="col-xs-6 ">
                                    <input type="" name="clientName" class="form-control input-sm duiqi" id="clientName" placeholder="请输入姓名！">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="clientNo" class="col-xs-3 control-label">身份证号：</label>
                                <div class="col-xs-6">
                                    <input type="" name="clientNo" class="form-control input-sm duiqi" id="clientNo" placeholder="请输入身份证号！">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="phone_no" class="col-xs-3 control-label">手机号：</label>
                                <div class="col-xs-6">
                                    <input type="" name="phone_no" class="form-control input-sm duiqi" id="phone_no" placeholder="请输入手机号！">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="roomNo" class="col-xs-3 control-label">房间号：</label>
                                <div class="col-xs-6 ">
                                    <input type="" name="roomNo" class="form-control input-sm duiqi" id="roomNo" placeholder="请输入房间号！">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="duration" class="col-xs-3 control-label">入住时长：</label>
                                <div class="col-xs-6">
                                    <input type="" name="duration" class="form-control input-sm duiqi" id="duration" placeholder="请输入入住时长！">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="duration" class="col-xs-3 control-label">是否预约：</label>
                                <div class="col-xs-6">
                                    <select  type="" name="isReserved" id="isReserved" class="form-control" style="width: 200px;height: 30px;margin-left: -28px;">
                                        <option value="1">是</option>
                                        <option value="0">否</option>
                                    </select>
                                    <%--                                    <input type="" name="isReserved" class="form-control input-sm duiqi" id="isReserved" >--%>
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

            <script type="text/javascript">
                document.getElementById('checkInButton').onclick = function () {
            $('#form1').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                clientName: {
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
                clientNo: {
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
                phone_no:{
                    validators:{
                        notEmpty:{
                            message:'电话号码不能为空！'
                        },
                        regexp:{
                            regexp: /^0|1[0123456789]\d{9}$/,
                            message:'电话号码格式有误'
                        }
                    }
                },
            roomNo: {
                validators: {
                notEmpty: {
                message: '房间号不能为空！'
            },

            regexp: {
            regexp: /^[0-9]\d{3}$/,
            message: '房间号只能是三位'
            }
            }
            },
            duration:{
            validators:{
            notEmpty:{
            message:'入住时长不能为空！'
            },
                stringLength: {
                    min: 1,
                    max: 2,
                    message: '入住时长请合理'
                },
            regexp:{
            regexp:/^[0-9]+$/,
            message:'入住时长只能为整数'
            }
            }
            }
            }
            });
            }
            </script>


            <!--退房登记模块-->
            <div role="tabpanel" class="tab-pane" id="checkout">
                <div class="container">
                    <div class="page-header">
                        <h1 align="center">退房登记</h1>
                    </div>
                    <div style="padding: 50px 0;margin-top: 50px;background-color: #fff; text-align: right;width: 420px;margin: 50px auto;">
                        <form id="form2" class="form-horizontal" action="checkOutServlet" method="post">
                            <div class="form-group ">
                                <label for="cNo" class="col-xs-3 control-label">客户ID：</label>
                                <div class="col-xs-6 ">
                                    <input type="" name="client_no" class="form-control input-sm duiqi" id="cNo" placeholder="请输入身份证！">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="rNo" class="col-xs-3 control-label">房间号：</label>
                                <div class="col-xs-6 ">
                                    <input type="" name="room_no" class="form-control input-sm duiqi" id="rNo" placeholder="请输入房间号！">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="isD" class="col-xs-3 control-label">是否损坏：</label>
                                <div class="col-xs-6">
                                    <select  type="" name="isdamaged" id="isD" class="form-control" style="width: 200px;height: 30px;margin-left: -28px;">
                                        <option value="1">是</option>
                                        <option value="0">否</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="expS" class="col-xs-3 control-label">体验评分：</label>
                                <div class="col-xs-6">
                                    <input type="" name="exp_score" class="form-control input-sm duiqi" id="expS" placeholder="请输入体验评分！">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="serS" class="col-xs-3 control-label">服务评分：</label>
                                <div class="col-xs-6">
                                    <input type="" name="ser_score" class="form-control input-sm duiqi" id="serS" placeholder="请输入服务评分！">
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

            <script type="text/javascript">
                document.getElementById('checkOutButton').onclick= function () {
                    $('#form2').bootstrapValidator({
                        message: 'This value is not valid',
                        feedbackIcons: {
                            valid: 'glyphicon glyphicon-ok',
                            invalid: 'glyphicon glyphicon-remove',
                            validating: 'glyphicon glyphicon-refresh'
                        },
                        fields: {
                            client_no: {
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
                            room_no: {
                                validators: {
                                    notEmpty: {
                                        message: '房间号不能为空！'
                                    },
                                    regexp: {
                                        regexp: /^[0-9]+$/,
                                        message: '房间号只能为整数'
                                    }
                                }
                            },
                            exp_score:{
                                validators:{
                                    notEmpty:{
                                        message:'体验评分不能为空！'
                                    },
                                    between:{
                                        min:0,
                                        max:100,
                                        message:'评分只能在0-100之间'
                                    },
                                    regexp:{
                                        regexp:/^[0-9]+$/,
                                        message:'评分只能为整数'
                                    }
                                }
                            },
                            ser_score:{
                                validators:{
                                    notEmpty:{
                                        message:'服务评分不能为空！'
                                    },
                                    between:{
                                        min:0,
                                        max:100,
                                        message:'评分只能在0-100之间'
                                    },
                                    regexp:{
                                        regexp:/^[0-9]+$/,
                                        message:'评分只能为整数'
                                    }
                                }
                            }
                        }
                    });
                }
            </script>


            <!--换房登记模块-->
            <div role="tabpanel" class="tab-pane" id="change">
                <div class="container">
                    <div class="page-header">
                        <h1 align="center">换房登记</h1>
                    </div>
                    <div style="padding: 50px 0;margin-top: 50px;background-color: #fff; text-align: right;width: 420px;margin: 50px auto;">
                        <form id="form3" class="form-horizontal" action="changeRoomServlet" method="post">
                            <div class="form-group ">
                                <label for="clientid" class="col-xs-3 control-label">客户ID：</label>
                                <div class="col-xs-6 ">
                                    <input type="" name="clientid" class="form-control input-sm duiqi" id="clientid" placeholder="请输入客户ID！">
                                </div>
                            </div>
                            <div class="form-group ">
                                <label for="oldRoomNo" class="col-xs-3 control-label">原房间号：</label>
                                <div class="col-xs-6 ">
                                    <input type="" name="oldRoomNo" class="form-control input-sm duiqi" id="oldRoomNo" placeholder="请输入原房间号！">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="newRoomNo" class="col-xs-3 control-label">新房间号：</label>
                                <div class="col-xs-6 ">
                                    <input type="" name="newRoomNo" class="form-control input-sm duiqi" id="newRoomNo" placeholder="请输入新房间号！">
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

            <script type="text/javascript">
                document.getElementById('changeRoomButton').onclick = function () {
                    $('#form3').bootstrapValidator({
                        message: 'This value is not valid',
                        feedbackIcons: {
                            valid: 'glyphicon glyphicon-ok',
                            invalid: 'glyphicon glyphicon-remove',
                            validating: 'glyphicon glyphicon-refresh'
                        },
                        fields: {
                            clientid: {
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
                            oldRoomNo: {
                                validators: {
                                    notEmpty: {
                                        message: '房间号不能为空！'
                                    },
                                    regexp: {
                                        regexp: /^[0-9]+$/,
                                        message: '房间号只能为整数'
                                    }
                                }
                            },
                            newRoomNo:{
                                validators:{
                                    notEmpty:{
                                        message:'房间号不能为空！'
                                    },
                                    regexp:{
                                        regexp: /^[0-9]+$/,
                                        message: '房间号只能为整数'
                                    }
                                }
                            }
                        }
                    });
                }
            </script>

            <!--前台预定模块-->
            <div role="tabpanel" class="tab-pane" id="reserve">
                <div class="container">
                    <div class="page-header">
                        <h1 align="center">前台预定</h1>
                    </div>
                    <div style="padding: 50px 0;margin-top: 50px;background-color: #fff; text-align: right;width: 420px;margin: 50px auto;">
                        <form id="form4" class="form-horizontal" action="employeeReserveServlet" method="post">
                            <div class="form-group ">
                                <label for="client_name" class="col-xs-3 control-label">姓名：</label>
                                <div class="col-xs-6 ">
                                    <input type="" name="client_name" class="form-control input-sm duiqi" id="client_name" placeholder="请输入姓名！">
                                </div>
                            </div>
                            <div class="form-group ">
                                <label for="userID" class="col-xs-3 control-label">身份证号：</label>
                                <div class="col-xs-6 ">
                                    <input type="" name="clientIDnum" class="form-control input-sm duiqi" id="userID" placeholder="请输入身份证号！">
                                </div>
                            </div>
                            <div class="form-group ">
                                <label for="phone" class="col-xs-3 control-label">联系方式：</label>
                                <div class="col-xs-6 ">
                                    <input type="" name="telephone" class="form-control input-sm duiqi" id="phone" placeholder="请输入联系方式！">
                                </div>
                            </div>
                            <div class="form-group ">
                                <label for="rmNo" class="col-xs-3 control-label">房间号：</label>
                                <div class="col-xs-6 ">
                                    <input type="" name="roomNumber" class="form-control input-sm duiqi" id="rmNo" placeholder="请输入房间号！">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="arrtime" class="col-xs-3 control-label">到达时间：</label>
                                <div class="col-xs-6 ">
                                    <input type="date" name="arrtime" class="form-control input-sm duiqi" id="arrtime" placeholder="请输入到达时间！">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="leatime" class="col-xs-3 control-label">离开时间：</label>
                                <div class="col-xs-6 ">
                                    <input type="date" name="leatime" class="form-control input-sm duiqi" id="leatime" placeholder="请输入离开时间！">
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

            <script type="text/javascript">
                document.getElementById('employeeReserveButton').onclick = function () {
                    $('#form4').bootstrapValidator({
                        message: 'This value is not valid',
                        feedbackIcons: {
                            valid: 'glyphicon glyphicon-ok',
                            invalid: 'glyphicon glyphicon-remove',
                            validating: 'glyphicon glyphicon-refresh'
                        },
                        fields: {
                            client_name:{
                                validators:{
                                    notEmpty:{
                                        message:'姓名不能为空!'
                                    },
                                    // regexp:{
                                    //     regexp:/^[a-zA-Z]+$/,
                                    //     message:'姓名只能输入英文'
                                    // }
                                }
                            },
                            clientIDnum: {
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
                            },
                            roomNumber: {
                                validators: {
                                    notEmpty: {
                                        message: '房间号不能为空！'
                                    },
                                    regexp: {
                                        regexp: /^[0-9]+$/,
                                        message: '房间号只能为整数'
                                    }
                                }
                            },
                            arrtime:{
                                validators:{
                                    notEmpty:{
                                        message:'到达时间不能为空！'
                                    },
                                    date:{
                                        message:'日期格式有误'
                                    }
                                }
                            },
                            leatime:{
                                validators:{
                                    notEmpty:{
                                        message:'离开时间不能为空！'
                                    },
                                    date:{
                                        message:'日期格式有误'
                                    }
                                }
                            }
                        }
                    });
                }
            </script>


            <!--预定查询模块-->
            <div role="tabpanel" class="tab-pane" id="searchReserve">
                <div class="container">
                    <div class="page-header">
                        <h1 align="center">预定查询</h1>
                    </div>
                    <form class="form-horizontal" action="reserveCheckInServlet" method="post">
                        <div class="form-inline" align="center">
                            <div>
                                <input type="" name="clientId_no" class="form-control input-sm duiqi" placeholder="请输入身份证号！" style="position: relative;left: 30px;height: 30px;top: -3px;">
                                <input type="date" name="arrivetime" class="form-control input-sm duiqi" placeholder="请选择到达时间！" style="position: relative;left: 30px;height: 30px;top: -3px;">
                                <button type="submit" class="btn btn-white btn-xs " style="position: relative;left: 60px;height: 30px;top: 0px;">查 询 </button>
                            </div>
                        </div>
                    </form>
                    <table id="blocks3" style="width: 800px; margin: 44px auto"
                           class="table table-striped table-bordered table-hover  table-condensed"
                           align='center' border='1' cellspacing='0'>
                        <tr>
                            <td>客户名称</td>
                            <td>身份证号</td>
                            <td>联系方式</td>
                            <td>房间号码</td>
                            <td>到达时间</td>
                            <td>离开时间</td>
                        </tr>
                        <c:forEach items="${sessionScope.searchList}" var="reserve">
                            <tr>
                                <td>${reserve.client_name }</td>
                                <td>${reserve.client_id }</td>
                                <td>${reserve.client_tele }</td>
                                <td>${reserve.room_id }</td>
                                <td>${reserve.arr_date }</td>
                                <td>${reserve.lea_date }</td>
                            </tr>
                        </c:forEach>
                    </table>

                </div>
            </div>


            <!--客户添加模块-->
            <div role="tabpanel" class="tab-pane" id="addClient">
                <div class="container">
                    <div class="page-header">
                        <h1 align="center">客户添加</h1>
                    </div>
                    <div style="padding: 50px 0;margin-top: 50px;background-color: #fff; text-align: right;width: 420px;margin: 50px auto;">
                        <form id="form6" class="form-horizontal" action="addClientServlet" method="post">
                            <div class="form-group ">
                                <label for="username1" class="col-xs-3 control-label">客户名：</label>
                                <div class="col-xs-6 ">
                                    <input type="" name="username1" class="form-control input-sm duiqi" id="username1" placeholder="请输入姓名">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password" class="col-xs-3 control-label">密码：</label>
                                <div class="col-xs-6 ">
                                    <input type="" name="password" class="form-control input-sm duiqi" id="password" placeholder="请输入密码！">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="idcard" class="col-xs-3 control-label">身份证号：</label>
                                <div class="col-xs-6">
                                    <input type="" name="idcard" class="form-control input-sm duiqi" id="idcard" placeholder="请输入身份证号！">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="email" class="col-xs-3 control-label">邮箱号：</label>
                                <div class="col-xs-6">
                                    <input type="" name="email" class="form-control input-sm duiqi" id="email" placeholder="请输入邮箱！">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="telephone" class="col-xs-3 control-label">电话号码：</label>
                                <div class="col-xs-6">
                                    <input type="" name="telephone" class="form-control input-sm duiqi" id="telephone" placeholder="请输入电话号码！">
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

            <script type="text/javascript">
                document.getElementById('clientAddButton').onclick = function () {
                    $('#form6').bootstrapValidator({
                        message: 'This value is not valid',
                        feedbackIcons: {
                            valid: 'glyphicon glyphicon-ok',
                            invalid: 'glyphicon glyphicon-remove',
                            validating: 'glyphicon glyphicon-refresh'
                        },
                        fields: {
                            username1: {
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

            <!--客户删除模块-->
            <div role="tabpanel" class="tab-pane" id="deleteClient">
                <div class="container">
                    <div class="page-header">
                        <h1 align="center">客户删除</h1>
                    </div>
                    <div style="padding: 50px 0;margin-top: 50px;background-color: #fff; text-align: right;width: 420px;margin: 50px auto;">
                        <form id="form7" class="form-horizontal" action="deleteClientServlet" method="post">
                            <div class="form-group">
                                <label for="email1" class="col-xs-3 control-label">邮箱号：</label>
                                <div class="col-xs-6">
                                    <input type="" name="email1" class="form-control input-sm duiqi" id="email1" placeholder="请输入邮箱！">
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

            <script type="text/javascript">
                document.getElementById('clientDelButton').onclick = function () {
                    $('#form7').bootstrapValidator({
                        message: 'This value is not valid',
                        feedbackIcons: {
                            valid: 'glyphicon glyphicon-ok',
                            invalid: 'glyphicon glyphicon-remove',
                            validating: 'glyphicon glyphicon-refresh'
                        },
                        fields: {
                            email1:{
                                validators:{
                                    notEmpty:{
                                        message:'邮箱不能为空！'
                                    },
                                    emailAddress: {
                                        message:'邮箱格式有误'
                                    }
                                }
                            }
                        }
                    });
                }
            </script>

            <!--所有房间模块-->
            <div role="tabpanel" class="tab-pane" id="allRooms">
                <div class="container">
                    <div class="page-header">
                        <h1 align="center">所有房间</h1>
                    </div>
                    <sql:setDataSource var="snapshot" driver="com.mysql.cj.jdbc.Driver"
                                       url="jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC"
                                       user="root"  password="123456"/>
                    <sql:query dataSource="${snapshot}" var="result">
                        SELECT * from room;
                    </sql:query>
                        <table id="block" style="width: 800px; margin: 44px auto"
                               class="table table-striped table-bordered table-hover  table-condensed"
                               align='center' border='1' cellspacing='0'>
                            <tr>
                                <td align="center">序号</td>
                                <td align="center">房间号</td>
                                <td align="center">房间类型</td>
                                <td align="center">房间状态</td>
                                <td align="center">房间价格</td>
                                <td align="center">房间位置</td>
                                <td align="center">操作</td>
                            </tr>
                            <c:forEach items="${result.rows }" var="room">
                            <form action="cleanSureServlet" method="post">
                                <input style="display: none"value="${room.room_id }" name="room_no">
                                <tr>
                                    <td>${room.room_no }</td>
                                    <td>${room.room_id }</td>
                                    <td>${room.room_type }</td>
                                    <td>${room.room_state }</td>
                                    <td>${room.room_price }</td>
                                    <td>${room.room_location }</td>
                                    <td align="center"><button type="submit" class="btn btn-success btn-xs" data-toggle="modal">打扫确认</button></td>
                                </tr>
                            </form>
                            </c:forEach>
                        </table>
                </div>
            </div>


            <!--显示空房间模块-->
            <div role="tabpanel" class="tab-pane" id="showEmptyRooms">
                <div class="container">
                    <div class="page-header">
                        <h1 align="center">查询空房间</h1>
                    </div>
                    <form class="form-horizontal" action="searchRoomServlet" method="post">
                        <div class="form-inline" align="center">
                            <div>

                                <select  type="" name="room_type" id="cNo2" class="form-control" style="width: 200px;height: 30px;">
                                    <option>Select a Room</option>
                                    <option value="bigbedroom">Deluxe Room</option>
                                    <option value="singleroom">Single Room</option>
                                    <option value="doubleroom">Double Room</option>
                                </select>
                                <input type="date" name="arrivetime" class="form-control input-sm duiqi" id="rNo2" placeholder="" style="position: relative;left: 30px;height: 30px;top: -3px;">
                                <input type="date" name="leavetime" class="form-control input-sm duiqi" id="isD2" placeholder="" style="position: relative;left: 60px;height: 30px;top: -3px;">
                                <button type="submit" class="btn btn-white btn-xs " style="position: relative;left: 60px;height: 30px;top: 0px;">查 询 </button>
                            </div>
                        </div>
                    </form>

                    <table id="blocks2" style="width: 800px; margin: 44px auto"
                           class="table table-striped table-bordered table-hover  table-condensed"
                           align='center' border='1' cellspacing='0'>
                        <tr>
                            <td>房间号</td>
                            <td>房间类型</td>
                            <td>房间价格</td>
                            <td>房间位置</td>
                            <td>房间状态</td>
                        </tr>
                        <c:forEach items="${sessionScope.roomList}" var="room">
                            <tr>
                                <td>${room.room_id }</td>
                                <td>${room.room_type }</td>
                                <td>${room.room_price }</td>
                                <td>${room.room_location }</td>
                                <td>${room.room_state }</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>

    </div>
</div>

    <%--入住--%>
<% if (request.getParameter("checkin")!= null) {%>
<script type="text/javascript">
    $(document).ready(function(){
        $("#checkInButton").click();
    });
</script>
<%} %>
<%--    空房间警告--%>
 <% if (request.getParameter("room_er1")!= null) {%>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#checkInButton").click();
            alert("the room id is wrong");
        });
    </script>
        <%} %>



    <%--退房--%>
<% if (request.getParameter("checkout")!= null) {%>
<script type="text/javascript">
    $(document).ready(function(){
        $("#checkOutButton").click();
    });
</script>
<%} %>
<%----%>
<% if (request.getParameter("room_er2")!= null) {%>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#checkOutButton").click();
            alert("the old room id is wrong");
        });
    </script>
        <%} %>
    <%--换房--%>
<% if (request.getParameter("changeRoom")!= null) {%>
<script type="text/javascript">
    $(document).ready(function(){
        $("#changeRoomButton").click();
    });
</script>
<%} %>
        <% if (request.getParameter("room_er3")!= null) {%>
    <script  type="text/javascript">
        $(document).ready(function(){
            $("#changeRoomButton").click();
            alert("the old room id is wrong");
        });
    </script>
        <%} %>
        <% if (request.getParameter("room_er4")!= null) {%>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#changeRoomButton").click();
            alert("the new room id is wrong");
        });
    </script>
        <%} %>
        <% if (request.getParameter("clientid_er1")!= null) {%>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#changeRoomButton").click();
            alert("the client  id is wrong");
        });
    </script>
        <%} %>

    <%--前台预定--%>
<% if (request.getParameter("employeeRes")!= null) {%>
<script type="text/javascript">
    $(document).ready(function(){
        $("#employeeReserveButton").click();
    });
</script>
<%} %>

    <%--前台查询预定--%>
<% if (request.getParameter("searchReserve")!= null) {%>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#employeeSearchReserveButton").click();
        });
    </script>
<%} %>

    <%--前台添加客户--%>
<% if (request.getParameter("addClient")!= null) {%>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#clientAddButton").click();
        });
    </script>
<%} %>

    <%--前台删除客户--%>
<% if (request.getParameter("delClient")!= null) {%>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#clientDelButton").click();
        });
    </script>
<%} %>

    <%--显示所有房间--%>
<% if (request.getParameter("cleanSure")!= null) {%>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#allRoomsButton").click();
        });
    </script>
<%} %>

    <%--前台查询空房间--%>
<% if (request.getParameter("showEmptyRoom")!=null) {%>
<script type="text/javascript">
    $(document).ready(function(){
        $("#showRoomsButton").click();
    });
</script>
<%} %>

<%--    错误处理--%>
        <% if (request.getParameter("room_er1")!= null) {%>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#checkInButton").click();
            alert("the room id is wrong");
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