<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/10
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body onload="shownum()">
<script type="text/javascript"> var i = 6; function shownum(){ i=i-1; document.getElementById("time").innerHTML=i+"秒后自动跳转登陆 界面"; setTimeout('shownum()',1000); } </script>
<a href="login.jsp">跳转中......</a>

<script language="javascript" type="text/javascript">

    window.onload = function setValue() {
        <%
            session.invalidate();
        %>

    }
</script>
<meta http-equiv="refresh" content='3; url=http://localhost:8080/login.jsp'>
</body>
</html>
