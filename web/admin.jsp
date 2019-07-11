d<%@ page language="java" contentType="text/html; charset=UTF-8"
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
        function R_values(id) {
            $("#room_no").val(id);


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
<% String Rd = (String)request.getAttribute("room_delete");
if (Rd!=null){
    if(Rd.equals("0")){%>
<script type="text/javascript">alert("delete success");
$(document).ready(function(){
    $("#taggle2").click();
});</script>
<% }else if("false".equals(Rd)){%>
<script type="text/javascript">alert("error");
$(document).ready(function(){
    $("#taggle2").click();
});

</script>
<%} }%>

<% String add = (String)request.getAttribute("add");
if(add!=null){
    if(add.equals("0"))
    {%>
<script type="text/javascript">alert("add successfully");
$(document).ready(function(){
    $("#taggle1").click();
});
</script>
<% }
else if(add.equals("1"))

{%>
<script type="text/javascript">alert("this room id has already existed,please change");
$(document).ready(function(){
    $("#taggle1").click();
});</script>
<%}}
%>
<% String editroom = (String)request.getAttribute("edit");
if(editroom!=null){
    if(editroom.equals("0"))
    {%>
<script type="text/javascript">alert("edit successfully");
$(document).ready(function(){
    $("#taggle2").click();
});
</script>
<% }
else if(editroom.equals("1"))

{%>
<script type="text/javascript">alert("error");
$(document).ready(function(){
    $("#taggle2").click();
});</script>
<%}}
%>

    <div id="wrap">
    <!-- 左侧菜单栏目块 -->
    <div class="leftMeun" id="leftMeun">
        <div id="logoDiv">
            <p id="logoP"><img id="logo" alt="旅馆管理系统" src="images/dong.jpg"><span>旅馆管理系统</span></p>
        </div>
        <div id="personInfor">
            <p id="adminid">亲爱的管理员<%= (String) request.getSession().getAttribute("adminid") %>，欢迎您！</p>
            <p>
                <a href="adminlogin.jsp">退出登录</a>
            </p>
        </div>
        <div class="meun-title">房间管理</div>
        <div class="meun-item" href="#addroom" aria-controls="addroom" role="tab" data-toggle="tab" id="taggle1"><img src="images/icon_char_grey.png">添加房间</div>
        <div class="meun-item" href="#modroom" aria-controls="modroom" role="tab" data-toggle="tab" id="taggle2"><img src="images/icon_char_grey.png">修改房间</div>
        <div class="meun-title">人事管理</div>
        <div class="meun-item" href="#addemployee" aria-controls="addemployee" role="tab" data-toggle="tab"><img src="images/icon_char_grey.png" id="taggle4">添加雇员</div>
        <div class="meun-item" href="#showemployee" aria-controls="showemployee" role="tab" data-toggle="tab"><img src="images/icon_char_grey.png" id="taggle3">查看雇员</div>
        <div class="meun-item" href="#showrecord" aria-controls="showrecord" role="tab" data-toggle="tab" id="taggle5"><img src="images/icon_char_grey.png">查看上班记录</div>
        <div class="meun-title">收入管理</div>
        <div class="meun-item" href="#lookincome" aria-controls="lookincome" role="tab" data-toggle="tab" ><img src="images/icon_char_grey.png" id="taggle6">查看月收入</div>

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
                                        <option value="singleroom">singleroom</option>
                                        <option  value="doubleroom">doubleroom</option>
                                        <option  value="bigbedroom">bigbedroom</option>

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
                        <td> <button class="btn btn-sm btn-primary" data-toggle="modal" data-target="#myModal" onclick="R_values(<%=room.getRoom_no()%>)" > change</button></td>
                        <td>  <form method="post" action="deleteroomServlet" >
                            <input type="hidden" name="room_no" value="<%=room.getRoom_no()%>"/>
                            <input type="submit" class="btn btn-sm btn-warning" value="delete" />
                        </form>
                        </td>
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
                                    <form action="editroomServlet" method="post">
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
            </div>

        </div>
            <!--添加雇员模块-->
            <div role="tabpanel" class="tab-pane" id="addemployee">
                <div class="container">
                    <div class="page-header">
                        <h1 align="center">添加雇员</h1>
                    </div>
                    <div style="padding: 50px 0;margin-top: 50px;background-color: #fff; text-align: right;width: 420px;margin: 50px auto;">
                        <form class="form-horizontal" form action="/addemployee.do" name=form1 onsubmit="return check()" >
                            <div class="form-group ">
                                <label for="uname" class="col-xs-3 control-label">username：</label>
                                <div class="col-xs-8 ">
                                    <input type="" name="username" class="form-control input-sm duiqi" id="uname" placeholder="">
                                </div>
                            </div>

                            <label for="rty" class="col-xs-3 control-label">position:</label>
                            <div  class="form-group">

                                <select class="form-control"style="width: 200px;height: 23px" name="position" class="text2">
                                    <option value="repersonnel">repersonnel</option>
                                    <option value="manager">manager</option>
                                    <option value="cleaner">cleaner</option>

                                </select>



                            </div>

                            <div class="form-group">
                                <label for="upassword" class="col-xs-3 control-label">password：</label>
                                <div class="col-xs-8">
                                    <input type="" name="password" class="form-control input-sm duiqi" id="upassword" placeholder="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="uemail" class="col-xs-3 control-label">email：</label>
                                <div class="col-xs-8">
                                    <input type="" name="email" class="form-control input-sm duiqi" id="uemail" placeholder="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="utelephone" class="col-xs-3 control-label">telephone：</label>
                                <div class="col-xs-8">
                                    <input type="" name="telephone" class="form-control input-sm duiqi" id="utelephone" placeholder="">
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
            <div role="tabpanel" class="tab-pane" id="showemployee">
                <div class="container">
                    <div class="page-header">
                        <h1 align="center">查看雇员</h1>
                    </div>
                    <% String c = (String)request.getAttribute("reset");
                        if("true".equals(c)){%>
                    <script type="text/javascript">alert("reset success"); $(document).ready(function(){
                        $("#taggle3").click();
                    });</script>
                    <% }else if("false".equals(c)){%>
                    <script type="text/javascript">alert("error");
                    $(document).ready(function(){
                        $("#taggle3").click(); })
                    </script>
                    <%} %>
                    <% String p = (String)request.getAttribute("update");
                        if("true".equals(p)){%>
                    <script type="text/javascript">alert("update success"); $(document).ready(function(){
                        $("#taggle3").click();
                    });</script>
                    <% }else if("false".equals(p)){%>
                    <script type="text/javascript">alert("error");
                    $(document).ready(function(){
                        $("#taggle3").click(); })
                    </script>
                    <%} %>
                    <% String d = (String)request.getAttribute("delete");
                        if("true".equals(d)){%>
                    <script type="text/javascript">alert("delete success"); $(document).ready(function(){
                        $("#taggle3").click();
                    });</script>
                    <% }else if("false".equals(d)){%>
                    <script type="text/javascript">alert("error");
                    $(document).ready(function(){
                        $("#taggle3").click(); })
                    </script>
                    <%} %>

                    <% String flag = (String)request.getAttribute("add");
                        if(flag=="3")
                        {%>
                    <script type="text/javascript">alert("add successfully");
                    $(document).ready(function(){
                        $("#taggle3").click();
                    });</script>
                    <% }
                    else if(flag=="2")

                    {%>
                    <script type="text/javascript">alert("error");$(document).ready(function(){
                        $("#taggle3").click();
                    });</script>
                    <%}
                    %>
                    <Script Language="JavaScript">



                        $("#myModal").modal("hide");
                        function values(employee_no) {

                            $("#employee_no").val(employee_no);
                        }



                    </Script>





                    <table style="width: 800px; margin: 44px auto"
                           class="table table-striped table-bordered table-hover  table-condensed"
                           align='left' border='0' cellspacing='0'>
                        <tr>
                            <td align="center">用户名</td>
                            <td align="center">密码</td>
                            <td align="center">电子邮件</td>
                            <td align="center">电话号码</td>
                            <td align="center">职位</td>
                            <td align="center">编号</td>
                            <td>操作</td>
                            <td>操作</td>
                            <td>操作</td>

                        </tr>
                        <%
                            List<Employee> employees =EmployeeDao.ShowEmployee();


                            for(Employee employee:employees)
                            {

                        %>
                        <tr>
                            <td align="center" width="10%"><%= employee.getUsername() %></td>
                            <td align="center" width="10%"><%= employee.getPassword() %></td>
                            <td align="center" width="10%"><%= employee.getEmail() %></td>
                            <td align="center" width="10%"><%= employee.getTelephone() %></td>
                            <td align="center" width="10%"><%= employee.getPosition() %></td>
                            <td align="center" width="10%"><%= employee.getEmployee_no() %></td>


                            <td>  <form  action="deleteemployee.do" >
                                <input type="hidden" name="employee_no" value="<%=employee.getEmployee_no() %>"/>
                                <input type="submit" class="btn btn-sm btn-warning" value="delete" />
                            </form>
                            </td>

                            <td><button class="btn btn-sm btn-primary" data-toggle="modal" data-target="#myModal1" onclick="values(<%=employee.getEmployee_no()%>)">
                                change
                            </button>

                            <td>
                                <form  action="resetpassword.do" >
                                    <input type="hidden" name="employee_no" value="<%=employee.getEmployee_no() %>"/>
                                    <input type="submit" class="btn btn-sm btn-info" value="reset" />
                                </form>
                            </td>

                        </tr>
                        <%

                            }%>
                    </table>

                    <div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <div class="form-group ">
                                        <form action="/updateemployee.do">
                                            <table>

                                                <tr>
                                                    <td width="100" height="50" font size="20px">username</td>

                                                    <td><input type="text" name="username" id="username" ></td></tr>
                                                <tr>	<td width="100" height="50" font size="20px">password</td>

                                                    <td>
                                                        <input type="text" name="password" id="password"></td></tr>
                                                <tr>
                                                    <td width="100" height="50" font size="20px">position</td>


                                                    <td>
                                                        <select name="position" class="text2">

                                                            <option value="repersonnel">repersonnel</option>
                                                            <option value="manager">manager</option>
                                                            <option value="cleaner">cleaner</option>
                                                        </select></td></tr>
                                                <tr>
                                                    <td width="100" height="50" font size="20px">email</td>

                                                    <td>
                                                        <input type="text" name="email" id="email" ></td></tr>
                                                <tr>
                                                    <td width="100" height="50" font size="20px">telephone</td>
                                                    <td><input type="text" name="telephone" id="telephone"></td></tr>
                                                <tr>

                                                    <td>
                                                        <input type="hidden" name="employee_no" id="employee_no"></td></tr>

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

            <div role="tabpanel" class="tab-pane" id="showrecord">
                <div class="container">
                    <div class="page-header">
                        <h4 align="center">查看人员上班记录</h4>
                    </div>
                    <form name="form1" action="workrecord.do" >
                        <select id="y" name="y" onchange="funy(this)"></select>
                        <select id="m" name="m" onchange="funm(this)"></select>
                        <select id="d" name="d"></select>

                        <INPUT Type="submit"  Value="查找" >
                    </form>
                </div>
                <table style="width: 800px; margin: 44px auto"
                       class="table table-striped table-bordered table-hover  table-condensed"
                       align='center' border='1' cellspacing='0'>
                    <tr>
                        <td align="center">记录号</td>
                        <td align="center">员工号</td>
                        <td align="center">员工姓名</td>
                        <td align="center">上班时间</td>
                        <td align="center">下班时间</td>
                    </tr>
                    <c:forEach items="${wrs}" var="workrecord" varStatus="st">
                        <tr>

                            <td align="center" width="10%">${workrecord.record_no}</td>
                            <td align="center" width="10%">${workrecord.staff_no}</td>
                            <td align="center" width="10%">${workrecord.username}</td>
                            <td align="center" width="10%">${workrecord.start_time}</td>
                            <td align="center" width="10%">${workrecord.end_time}</td>


                        </tr>
                    </c:forEach>
                </table>
                <% String recordshow = (String)request.getAttribute("recordshow");

                  if(recordshow!=null)
                  if (recordshow.equals("1"))
                        {%>
                <script type="text/javascript">
                $(document).ready(function(){
                    $("#taggle5").click();
                    recordshow="0";
                });

                </script>
                <%}%>



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
                        var y = document.getElementById('y');
                        var m = document.getElementById('m');
                        var d = document.getElementById('d');
                        var y2=document.getElementById('y2');
                        var m2=document.getElementById("m2")

                        var D = new Date();
                        var yy = D.getFullYear();               //年
                        var mm = parseInt(D.getMonth()) + 1;    //现在是8月，月份获取是7月。一脸懵逼！
                        var dd = D.getDate();                   //日
                        var oyy = 10 * (yy - 100).toString().substr(0,3);   //计算最小年 o = old
                        var marr = [1,3,5,7,8,10,12];           //列出31天的月份
                        var add;                                //初始化每月天数 a = all

                        starty();           //开始生成年下拉列表
                        startm();
                    //开始生成月下拉列表
                        startd(dd,mm,yy);
                        starty2();
                        startm2();//开始生成日下拉列表

                        // 生成年下拉列表
                        function starty(){
// 初始化
                            var pyy = document.createElement('option');
                            pyy.innerText = '选择 年';
                            pyy.value = 0;
                            y.appendChild(pyy);

// 循环出所有年
                            for(i=yy;i>=oyy;i--){
                                pyy = document.createElement('option');
                                pyy.innerText = i + ' 年';
                                pyy.value = i;
                                y.appendChild(pyy);

                            }
                        }
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
                        function startm(){
// 初始化
                            var pmm = document.createElement('option');
                            pmm.innerText = '选择 月';
                            pmm.value = 0;

                            m.appendChild(pmm);

// 判断是否选择了年
                            if(y.selectedOptions[0].value == 0) return;

// 循环出所有月
                            for(i=1;i<=12;i++){
                                pmm = document.createElement('option');
                                pmm.innerText = i + ' 月';
                                pmm.value = i;

                                m.appendChild(pmm);
                            }
                        }
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


                        function startd(mm,yy){
// 初始化
                            var pdd = document.createElement('option');
                            pdd.innerText = '选择 日';
                            pdd.value = 0;
                            d.appendChild(pdd);

// 判断是否选择了月
                            if(m.selectedOptions[0].value == 0) return;
                            var day = isadd(mm,yy);

// 循环出所有日
                            for(i=1;i<=day;i++){
                                pdd = document.createElement('option');
                                pdd.innerText = i + ' 日';
                                pdd.value = i;
                                d.appendChild(pdd);
                            }
                        }

                        // 判断并产生该月的天数
                        function isadd(mm,yy){
                            if(marr.indexOf(parseInt(mm)) != -1){
                                add = 31;
                            }
                            else{
                                add = 30;
                                if(mm == 2 && yy % 4 == 0){
                                    add = 29;
                                }
                                else if(mm == 2 && yy % 4 != 0){
                                    add = 28;
                                }
                            }
                            return add;
                        }

                        // 年份改变时调用

                        function funy1(obj){
                            m2.innerHTML=null;
                            var yy2=obj.selectedOptions[0].value;
                            startm2();
                        }
                        function funy(obj){
                            m.innerHTML = null;
                            d.innerHTML = null;
                            var yy = obj.selectedOptions[0].value;
                            startm();
                            startd(dd,mm,yy);
                        }

                        // 月份改变时调用
                        function funm(obj){
                            d.innerHTML = null;
                            var yy = y.selectedOptions[0].value;
                            var mm = obj.selectedOptions[0].value;
                            startd(mm,yy);
                        }
                    </Script>




                </div>
            </div>
    </div>
    </div>
    <script src="js/jquery.nouislider.js"></script>
    </div>
    </div>

</body>
</html>