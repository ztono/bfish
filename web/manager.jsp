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
<div align="right">
            <form name="form1" action="sign1.do" >
               <input type="hidden" name="staff_no" id="staff_no" value="<%=(String) request.getSession().getAttribute("staff")%>">

                <INPUT Type="submit" class="btn btn-sm btn-primary" value="上班">

            </form>
            <form name="form2" action="sign2.do" >
                <input type="hidden" name="staff_no2" id="staff_no2" value="<%=(String) request.getSession().getAttribute("staff")%>">
                <INPUT TYPE="submit" class="btn btn-sm btn-warning" value="下班">
            </form>
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





        <div class="meun-item" href="#displayemployee" aria-controls="displayemployee" role="tab" data-toggle="tab"><img src="images/icon_char_grey.png">查看雇员</div>
        <div class="meun-item" href=""  aria-controls="displayemployee" role="tab" data-toggle="tab" id="taggle1"><img src="images/icon_char_grey.png">每日绩效</div>
        <div class="meun-item" href="#modroom" aria-controls="modroom" role="tab" data-toggle="tab" ><img src="images/icon_char_grey.png">查看绩效</div>
        <div class="meun-item" href="#lookincome" aria-controls="lookincome" role="tab" data-toggle="tab"><img src="images/icon_char_grey.png">查看月收入</div>

    </div>
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

            <div role="tabpanel" class="tab-pane" id="lookincome">
                <div class="container">
                    <div class="page-header">
                        <h4 align="center">查看收入</h4>
                    </div>
                    <div class="form-group">
                        <form name="form1" action="lookincomeServlet" >
                            <select id="y2" name="y2" onchange="funy1(this)"></select>
                            <select id="m2" name="m2" ></select>


                            <INPUT Type="submit"  Value="查找" >
                        </form>
                    </div>
                    <table style="width: 800px; margin: 44px auto"
                           class="table table-striped table-bordered table-hover  table-condensed"
                           align='center' border='0' cellspacing='0'>
                        <tr>
                            <td align="center">房间类型</td>
                            <td align="center">收入</td>

                        </tr>
                        <tr>

                            <td align="center" width="10%">singleroom</td>
                            <td align="center" width="10%">${single}</td>
                        </tr>
                        <tr>

                            <td align="center" width="10%">doubleroom</td>
                            <td align="center" width="10%">${dou}</td>
                        </tr>
                        <tr>

                            <td align="center" width="10%">bigbedroom</td>
                            <td align="center" width="10%">${bigbed}</td>
                        </tr>
                        <tr>

                            <td align="center" width="10%">总收入</td>
                            <td align="center" width="10%">${total}</td>
                        </tr>

                    </table>


                    <Script>
                        /*
                        在你的页面需要这三条html代码
                        <select id="y" onchange="funy(this)"></select>
                        <select id="m" onchange="funm(this)"></select>
                        <select id="d"></select>
                        */

                        var y2=document.getElementById('y2');
                        var m2=document.getElementById("m2")

                        var D = new Date();
                        var yy = D.getFullYear();               //年
                        var mm = parseInt(D.getMonth()) + 1;    //现在是8月，月份获取是7月。一脸懵逼！
                        var dd = D.getDate();                   //日
                        var oyy = 10 * (yy - 100).toString().substr(0,3);   //计算最小年 o = old
                        var marr = [1,3,5,7,8,10,12];           //列出31天的月份
                        var add;                                //初始化每月天数 a = all


                        starty2();
                        startm2();//开始生成日下拉列表

                        // 生成年下拉列表

                        function starty2(){

                            var pyy = document.createElement('option');
                            pyy.innerText = '选择 年';
                            pyy.value = 0;
                            y2.appendChild(pyy);

// 循环出所有年
                            for(i=yy;i>=oyy;i--){
                                pyy = document.createElement('option');
                                pyy.innerText = i + ' 年';
                                pyy.value = i;
                                y2.appendChild(pyy);

                            }
                        }

                        // 生成月下拉列表


                        function startm2(){
// 初始化
                            var pmm = document.createElement('option');
                            pmm.innerText = '选择 月';
                            pmm.value = 0;

                            m2.appendChild(pmm);

// 判断是否选择了年
                            if(y2.selectedOptions[0].value == 0) return;

// 循环出所有月
                            for(i=1;i<=12;i++){
                                pmm = document.createElement('option');
                                pmm.innerText = i + ' 月';
                                pmm.value = i;

                                m2.appendChild(pmm);
                            }
                        }





                        // 年份改变时调用

                        function funy1(obj){
                            m2.innerHTML=null;
                            var yy2=obj.selectedOptions[0].value;
                            startm2();
                        }

                    </Script>




                </div>
            </div>
    <script src="js/jquery.nouislider.js"></script>

        </div>
    </div>
    </div>
</div>
</body>
</html>