<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="BEAN.Employee,java.util.*,DAO.*,BEAN.*" %>
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
        function J_values(id) {
            $("#employee_no").val(id);


        }
        function a()
        {
            document.form1.action="/judge1.do";
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
<%
    String incomeflag=(String)request.getSession().getAttribute("incomeflag");
    if(incomeflag!=null)
        if(incomeflag.equals("1"))
        {


%>
<script type="text/javascript">
    $(document).ready(function(){
        $("#taggle6").click();
        incomeflag="0";
    });

</script>
<%}%>

<%
    String commentflag=(String)request.getSession().getAttribute("commentflag");
    if(commentflag!=null)
        if(commentflag.equals("1"))
        {


%>
<script type="text/javascript">
    $(document).ready(function(){
        $("#taggle4").click();
        commentflag="0";
    });

</script>
<%}%>

<%
    String judge1flag=(String)request.getAttribute("judge1flag");
    if(judge1flag!=null)
        if(judge1flag.equals("1"))
        {


%>
<script type="text/javascript">
    $(document).ready(function(){
        $("#taggle2").click();
        judge1flag="0";
    });

</script>
<%}%>
<%
    String judge2flag=(String)request.getAttribute("judge2flag");
    if(judge2flag!=null)
        if(judge2flag.equals("1"))
        {


%>
<script type="text/javascript">
    $(document).ready(function(){
        $("#taggle3").click();
        judge2flag="0";
    });

</script>
<%}%>

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

            <% if (flag!=null){if (flag.equals("1")){ %>alert('上班打卡成功'); flag="0";<% }
else if (flag=="-1"){ %>alert('您已打卡');  flag="0";<%}
else if (flag=="2"){ %>alert('下班打卡成功');  flag="0";<%}
else if (flag=="-2"){ %>alert('您已打卡'); flag="0";<%}
else if (flag=="3"){ %>alert('上错误') ;flag="0";<%}
else if (flag=="-3"){ %>alert('下错误'); flag="0";<%}
}%>
        </Script>





        <div class="meun-item" href="#displayemployee" aria-controls="displayemployee" role="tab" data-toggle="tab"><img src="images/icon_char_grey.png">查看雇员</div>
        <div class="meun-item" href="#showcom" aria-controls="showcom" role="tab" data-toggle="tab" id="taggle4"><img src="images/icon_char_grey.png">查看客户评价</div>
        <div class="meun-item" href="#judge" aria-controls="judge" role="tab" data-toggle="tab" id="taggle2" ><img src="images/icon_char_grey.png">绩效打分</div>
        <div class="meun-item" href="#checkjudge" aria-controls="checkjudge" role="tab" data-toggle="tab"  id="taggle3" ><img src="images/icon_char_grey.png">查看绩效</div>
        <div class="meun-item" href="#lookincome" aria-controls="lookincome" role="tab" data-toggle="tab" id="taggle6"><img src="images/icon_char_grey.png">查看月收入</div>

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
            <div role="tabpanel" class="tab-pane" id="showcom"><!-- showcom -->
                <div class="container">
                    <div class="page-header">
                        <h1 align="center">查看客户评价</h1>
                    </div>
                    <form class="form-horizontal" action="commentServlet" method="post">
                        <div class="form-inline" align="center">
                            <div>
                                <input type="text" name="operator_name" class="form-control input-sm duiqi" id="op_name" placeholder="请输入姓名" style="height: 30px;">
                                <button type="submit" class="btn btn-white btn-xs " style="position: relative;left: 20px;height: 30px;top: 3px;">查 询 </button>
                            </div>
                        </div>
                    </form>
                    <div style="margin-left: 180px;margin-top: 10px;">
                        <h>平均值 </h>
                        <h><%= request.getSession().getAttribute("average")%></h>
                    </div>
                    <table id="blocks2" style="width: 800px; margin: 44px auto"
                           class="table table-striped table-bordered table-hover  table-condensed"
                           align='center' border='1' cellspacing='0'>
                        <tr>
                            <td>房间号</td>
                            <td>离开日期</td>
                            <td>评价</td>

                        </tr>
                        <c:forEach items="${sessionScope.commentList}" var="comment">
                            <tr>
                                <td>${comment.room_no }</td>
                                <td>${comment.leavedate }</td>
                                <td>${comment.ser_score }</td>

                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>


            <div role="tabpanel" class="tab-pane" id="lookincome">
                <div class="container">
                    <div class="page-header">
                        <h4 align="center">查看收入</h4>
                    </div>
                    <div class="form-group">
                        <form name="form1" action="lookincomeServlet2" >
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

            <div role="tabpanel" class="tab-pane" id="judge">
                <div class="container">
                    <div class="page-header">
                        <h4 align="center">绩效打分</h4>
                    </div>
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>员工号</th>
                            <th>员工姓名</th>
                            <th>评分</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<JudgeDay> es =JudgeDao.getemployees();


                            for(JudgeDay jd: es)
                            {

                        %>
                        <tr>
                            <td ><%= jd.getEmployee_no() %></td>
                            <td ><%= jd.getEmployee_name()%></td>
                            <td ><%= jd.getPerformance()%></td>
                            <td> <button class="btn btn-sm btn-primary" data-toggle="modal" data-target="#myJudge" onclick="J_values(<%=jd.getEmployee_no()%>)" > change</button></td>
                        </tr>
                        <%
                            }
                        %>



                        </tbody>
                    </table>
                    <%--                    <%--%>
                    <%--                        String flag = (String)request.getAttribute("flag");--%>
                    <%--                    %>--%>
                    <%--                    <Script language="javascript">--%>
                    <%--                        <% if (flag=="1"){ %>alert('错误')<%}--%>
                    <%--                        else if (flag=="-1"){ %>alert('修改成功')<%}--%>
                    <%--                        %>--%>
                    <%--                    </Script>--%>
                    <div class="modal fade" id="myJudge" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <div class="form-group ">
                                        <form action="judge1.do">
                                            <table>

                                                <tr>
                                                    <td width="100" height="50" font size="20px">评分</td>

                                                    <td><input type="text" name="performance" id="performance" ></td></tr>

                                                <input type="hidden" name="employee_no" id="employee_no">
                                                <tr> <td><input type="submit" value="SUBMIT"></td></tr>

                                            </table>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- 查看绩效 -->
            <div role="tabpanel" class="tab-pane" id="checkjudge">
                <div class="container">
                    <div class="page-header">
                        <h4 align="center">查看绩效</h4>
                    </div>
                    <form name="form1" action="judge1.do">
                        <%--                        年：<input type = text name="y" id="y">--%>
                        <%--                        月：<input type = text name="m" id="m">--%>
                        <%--                        日：<input type = text name="d" id="d">--%>
                        <%--                        <select id="y" name="y" onchange="funy(this)"></select>--%>
                        <%--                        <select id="m" name="m" onchange="funm(this)"></select>--%>
                        <%--                        <select id="d" name="d"></select>--%>
                        <select name="y" class="text2">
                            <option value="0" selected>请选择年份</option>
                            <option value="2019">2019年</option>
                            <option value="2018">2018年</option>
                            <option value="2017">2017年</option>
                            <option value="2016">2016年</option>
                        </select>
                        <select  name="m" class="text2">
                            <option value="0" selected>请选择月份</option>
                            <option value="1">1月</option>
                            <option value="2">2月</option>
                            <option value="3">3月</option>
                            <option value="4">4月</option>
                            <option value="5">5月</option>
                            <option value="6">6月</option>
                            <option value="7">7月</option>
                            <option value="8">8月</option>
                            <option value="9">9月</option>
                            <option value="10">10月</option>
                            <option value="11">11月</option>
                            <option value="12">12月</option>

                        </select>
                        <INPUT Type="submit"  Value="查找" >
                    </form>


                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>员工号</th>
                            <th>员工姓名</th>
                            <th>员工绩效</th>
                            <th>评分时间</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<JudgeDay> jds =(List<JudgeDay>)request.getAttribute("jds");
                            if(jds!=null){
                                for(JudgeDay jd: jds)
                                {
                        %>
                        <tr>
                            <td ><%= jd.getEmployee_no() %></td>
                            <td ><%= jd.getEmployee_name()%></td>
                            <td ><%= jd.getPerformance()%></td>
                            <td ><%= jd.getTime().substring(0,10)%></td>
                        </tr>
                        <%
                                }
                            }
                        %>

                        </tbody>
                    </table>

                </div>
            </div>
        </div>
    </div>
    <script src="js/jquery.nouislider.js"></script>

        </div>
    </div>
    </div>
</div>
</body>
</html>