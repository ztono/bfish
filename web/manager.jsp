<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="BEAN.Employee,java.util.*,DAO.*" %>
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
    <title>manager</title>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/pagination.js"></script>
    <script>
        function a()
        {
            document.form1.action="/sign1.do";
            document.form1.submit();
        }
        function b()
        {
            document.form1.action="/sign2.do";
            document.form1.submit();
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
<div id="wrap">
    <!-- 左侧菜单栏目块 -->
    <div class="leftMeun" id="leftMeun">
        <div id="logoDiv">
            <p id="logoP"><img id="logo" alt="旅馆管理系统" src="images/dong.jpg"><span>旅馆管理系统</span></p>
        </div>
        <div id="personInfor">
            <p id="admin">亲爱的经理<%= (String) request.getSession().getAttribute("id") %>，欢迎您！</p>
            <p>
                <a href="login.jsp">退出登录</a>
            </p>
            <form name="form1" action="" >
                staff_no:<input type="text" name="staff_no" id="staff_no">
                <INPUT Type="Button"  Value="上班" onClick="a()">
                <INPUT Type="Button"  Value="下班" onClick="b()">
            </form>
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



        </div>

        <div class="meun-item" href="#displayemployee" aria-controls="displayemployee" role="tab" data-toggle="tab"><img src="images/icon_char_grey.png">查看雇员</div>
        <div class="meun-item" href="#modroom" aria-controls="modroom" role="tab" data-toggle="tab" ><img src="images/icon_char_grey.png">查看绩效</div>
        <div class="meun-item" href="#checkout" aria-controls="checkout" role="tab" data-toggle="tab"><img src="images/icon_char_grey.png">查看月收入</div>


    <!-- 右侧具体内容栏目 -->
    <div id="rightContent">

        <img id="back" src="image/background.jpg">
        <a class="toggle-btn" id="nimei">
            <i class="glyphicon glyphicon-align-justify"></i>
        </a>
        <!-- Tab panes -->
        <div class="tab-content">
            <!-- 查看雇员信息 -->
<div role="tabpanel" class="tab-pane" id="displayemployee">
    <div class="container">

            <h1 align="center">查看雇员</h1>


        <table  style="width: 800px; margin: 44px auto"
               class="table table-striped table-bordered table-hover  table-condensed"
               align='center' border='0' cellspacing='0'>
            <tr>
                <td align="center">用户名</td>
                <td align="center">电子邮件</td>

                <td align="center">电话号码</td>
                <td align="center">职位</td>
                <td align="center">编号</td>

            </tr>
            <%
                List<Employee> employees =EmployeeDao.DisplayEmployee();


                for(Employee employee:employees)
                {

            %>
            <tr>
                <td align="center" width="10%"><%= employee.getUsername() %></td>

                <td align="center" width="10%"><%= employee.getEmail() %></td>
                <td align="center" width="10%"><%= employee.getTelephone() %></td>
                <td align="center" width="10%"><%= employee.getPosition() %></td>
                <td align="center" width="10%"><%= employee.getEmployee_no() %></td>


                    <%

}%>
        </table>




    </div>
</div>
    <script src="js/jquery.nouislider.js"></script>

        </div>
    </div>
    </div>
</div>
</body>
</html>