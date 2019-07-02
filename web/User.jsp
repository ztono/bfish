<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="体育器材管理系统">
    <meta name="keywords" content="体育器材管理系统 ">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <title>用户</title>
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
            <p id="logoP"><img id="logo" alt="体育器材管理" src="images/dong.jpg"><span>体育器材管理</span></p>
        </div>
        <div id="personInfor">
            <p id="userName">亲爱的用户<%= (String) request.getSession().getAttribute("id") %>，欢迎您！</p>
            <p>
                <a href="login.jsp">退出登录</a>
            </p>
        </div>
        <div class="meun-title">信息管理</div>
        <div class="meun-item" href="#addUser" aria-controls="addUser" role="tab" data-toggle="tab"><img src="images/icon_source.png">修改信息</div>
        <div class="meun-title">器材查询</div>
        <div class="meun-item" href="#allEquipments" aria-controls="addUser" role="tab" data-toggle="tab"><img src="images/icon_source.png">器材查询</div>
        <div class="meun-title">记录查询</div>
        <div class="meun-item" href="#borrowHistory" aria-controls="borrowHistory" role="tab" data-toggle="tab"><img src="images/icon_char_grey.png">借用记录</div>
        <div class="meun-item" href="#returnHistory" aria-controls="returnHistory" role="tab" data-toggle="tab"><img src="images/icon_char_grey.png">归还记录</div>
    </div>
    <!-- 右侧具体内容栏目 -->
    <div id="rightContent">
    
    	<img id="back" src="images/background.jpg">
        <a class="toggle-btn" id="nimei">
            <i class="glyphicon glyphicon-align-justify"></i>
        </a>
        <!-- Tab panes -->
        <div class="tab-content">
           <!-- 信息管理模块 -->
            <div role="tabpanel" class="tab-pane" id="addUser">
                <div class="container">
                    <div class="page-header">
                        <h1 align="center">修改信息</h1>
                    </div>
                    <div style="padding: 50px 0;margin-top: 50px;background-color: #fff; text-align: right;width: 420px;margin: 50px auto;">
                        <form class="form-horizontal" action="ModifyUserServlet" method="post">
                            <div class="form-group text-left">
                                <div class="col-xs-offset-4 col-xs-5" style="margin-left: 135px;">
                                    	您的密码为<%= (String) request.getSession().getAttribute("password") %>
                                </div>
                            </div>
                            <div class="form-group ">
                                <label for="sPwd" class="col-xs-3 control-label">密码：</label>
                                <div class="col-xs-8 ">
                                    <input type="" name="password" class="form-control input-sm duiqi" id="sPwd" placeholder="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="sReal" class="col-xs-3 control-label">姓名：</label>
                                <div class="col-xs-8 ">
                                    <input type="" name="realname" class="form-control input-sm duiqi" id="sReal" placeholder="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="sEmail" class="col-xs-3 control-label">邮箱：</label>
                                <div class="col-xs-8">
                                    <input type="" name="email" class="form-control input-sm duiqi" id="sEmail" placeholder="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="sPnum" class="col-xs-3 control-label">电话：</label>
                                <div class="col-xs-8">
                                    <input type="" name="Phone_Number" class="form-control input-sm duiqi" id="sPnum" placeholder="">
                                </div>
                            </div>
                            <div class="form-group" hidden>
                                <label for="sFine" class="col-xs-3 control-label">欠款：</label>
                                <div class="col-xs-8">
                                    <input type="" name="fine" class="form-control input-sm duiqi" id="sFine" placeholder="">
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
            
            <!--所有器材模块-->
            <div role="tabpanel" class="tab-pane" id="allEquipments">
            <div class="container">
                <div class="page-header">
                    <h1 align="center">所有器材</h1>
                </div>
                <sql:setDataSource var="snapshot" driver="com.mysql.cj.jdbc.Driver"
                                   url="jdbc:mysql://localhost:3306/library?serverTimezone=UTC"
                                   user="root"  password="123456"/>
                <sql:query dataSource="${snapshot}" var="result">
                    SELECT * from equipment;
                </sql:query>
                <form class="form-horizontal" action="UserSearchEquipmentServlet" method="post">
                    <div class="form-inline">
                        <div class="col-xs-4"></div>
                        <div class="col-xs-6">
                            <select name="search">
                                <option value="equipment_id">编号</option>
                                <option value="isbn">EAN</option>
                            </select>
                            <input type="text" name="str" class=" form-control input-sm " placeholder="输入文字搜索">
                            <button class="btn btn-white btn-xs ">查 询 </button>
                        </div>
                        <div class="col-xs-2"></div>
                    </div>
                </form>
                <table id="blocks" style="width: 800px; margin: 44px auto"
                       class="table table-striped table-bordered table-hover  table-condensed"
                       align='center' border='1' cellspacing='0'>
                    <tr>
                       <td align="center">编号</td>
                       <td align="center">EAN</td>
                       <td align="center">器材名称</td>
                       <td align="center">器材类型</td>
                       <td align="center">价格</td>
                       <td align="center">借用人</td>
                       <td align="center">是否可借</td>
                    </tr>
                    <c:forEach items="${result.rows }" var="equipment">
                        <tr>
                            <td>${equipment.equipment_id }</td>
                            <td>${equipment.ISBN }</td>
                            <td>${equipment.equipment_name }</td>
                            <td>${equipment.equipment_Type }</td>
                            <td>${equipment.money }</td>
                            <td>${equipment.belongsto }</td>
                            <td>${equipment.available }</td>
                        </tr>
                    </c:forEach>
                </table>
                <!--页码块-->
                <footer class="footer">
                    <ul class="pagination">
                        <li>
                            <i id="spanFirst" class="glyphicon glyphicon-backward"></i>
                        </li>
                        <li>
                            <i id="spanPre" class="glyphicon glyphicon-chevron-left"></i>
                        </li>
                        <li>
                            <i id="spanNext" class="glyphicon glyphicon-chevron-right">
                            </i>
                        </li>
                        <li>
                            <i id="spanLast" class="glyphicon glyphicon-forward"></i>
                        </li>
                        <li><span id="spanPageNum"></span>/<li><span  id="spanTotalPage"></span></li>
                    </ul>
                </footer>
            </div>
        </div>
        <script type="text/javascript">
            var numCount;       //数据总数量
            var columnsCounts;  //数据列数量
            var pageCount;      //每页显示的数量
            var pageNum;        //总页数
            var currPageNum ;   //当前页数

            //页面标签变量
            var blockTable;
            var preSpan;
            var firstSpan;
            var nextSpan;
            var lastSpan;
            var pageNumSpan;
            var currPageSpan;

            window.onload=function(){
                //页面标签变量
                blockTable = document.getElementById("blocks");
                preSpan = document.getElementById("spanPre");
                firstSpan = document.getElementById("spanFirst");
                nextSpan = document.getElementById("spanNext");
                lastSpan = document.getElementById("spanLast");
                currPageSpan = document.getElementById("spanPageNum");
                pageNumSpan = document.getElementById("spanTotalPage");
                //取table的行数作为数据总数量（减去标题行1）
                numCount = document.getElementById("blocks").rows.length - 1;
                columnsCounts = blockTable.rows[0].cells.length;
                pageCount = 10;
                pageNum = parseInt(numCount/pageCount);
                if(0 != numCount%pageCount){
                    pageNum += 1;
                }
                firstPage();
            };
        </script>

            <!--借用记录模块-->
            <div role="tabpanel" class="tab-pane" id="borrowHistory">
                <sql:setDataSource var="snapshot" driver="com.mysql.cj.jdbc.Driver"
                                   url="jdbc:mysql://localhost:3306/library?serverTimezone=UTC"
                                   user="root"  password="123456"/>
                <sql:query dataSource="${snapshot}" var="result">
                    SELECT * from borrowhistory where id='<%= (String) request.getSession().getAttribute("id") %>';
                </sql:query>
                <table id="blocks" style="width: 800px; margin: 44px auto"
                       class="table table-striped table-bordered table-hover  table-condensed"
                       align='center' border='1' cellspacing='0'>
                    <tr>
                        <td>用户名</td>
                        <td>器材编号</td>
                        <td>器材名称</td>
                        <td>借用时间</td>
                        <td>应还时间</td>
                        <td>是否归还</td>
                        <td>欠款</td>
                    </tr>
                    <c:forEach items="${result.rows }" var="record">
                        <tr>
                            <td>${record.id }</td>
                            <td>${record.equipment_id }</td>
                            <td>${record.equipment_name }</td>
                            <td>${record.borrowed_date }</td>
                            <td>${record.should_return_date }</td>
                            <td>${record.return1 }</td>
                            <td>${record.equipment_fine  }</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

            <!--归还记录模块-->
            <div role="tabpanel" class="tab-pane" id="returnHistory">
                <sql:setDataSource var="snapshot" driver="com.mysql.cj.jdbc.Driver"
                                   url="jdbc:mysql://localhost:3306/library?serverTimezone=UTC"
                                   user="root"  password="123456"/>
                <sql:query dataSource="${snapshot}" var="result">
                    SELECT * from returnhistory where id='<%= (String) request.getSession().getAttribute("id") %>';
                </sql:query>
                <table id="blocks" style="width: 800px; margin: 44px auto"
                       class="table table-striped table-bordered table-hover  table-condensed"
                       align='center' border='1' cellspacing='0'
                >
                    <tr>
                        <td>用户名</td>
                        <td>器材编号</td>
                        <td>器材名称</td>
                        <td>借用时间</td>
                        <td>归还时间</td>
                        <td>应还时间</td>
                        <td>欠款</td>
                    </tr>
                    <c:forEach items="${result.rows }" var="record">
                        <tr>
                            <td>${record.id }</td>
                            <td>${record.equipment_id }</td>
                            <td>${record.equipment_name }</td>
                            <td>${record.borrowed_date }</td>
                            <td>${record.return_date }</td>
                            <td>${record.should_return_date }</td>
                            <td>${record.equipment_fine  }</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
    </div>

<script src="js/jquery.nouislider.js"></script>


</body>
</html>