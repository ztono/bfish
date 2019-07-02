<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,dao.*,entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BiblioSoft</title>

<style type="text/css">
*{
padding:0px;
margin:0px;
}
body {
  background: #616161 url(images/home.jpg) center/cover no-repeat;
  height: 100vh;
  color: #FFF;
  overflow:hidden;
  text-align:center;
}
.logo{
margin:60px auto;
}
form{
margin:80px auto;
}
form .input{
width:500px;
height:50px;
border:2px green;
border-radius:5px;
background-color:rgba(255,255,255,0.8);
padding:2px 80px;
color:rgb(100,100,100);
font-size:25px;
}
form .submit{
height:50px;
border:0;
background-color:rgba(150,150,150,0.7);
position:relative;
right:86px;
width:80px;
font-size:25px;
}
form .search{
position:relative;
left:60px;
top:10px;
}
.login{
position:absolute;
right:20px;
top:20px;
color:blue;
font:30px;
}
.notice{
margin:0 auto;
margin-top:-50px;
width:500px;
color:black;
font-size:30px;
}
</style>
<script type="text/javascript">
function check()
{
	var search = document.getElementById("search");
	if (search.value == "" || search.value == null)	{	
		alert("please input title or author!")
		return false;
	}
	return true;
}
</script>
</head>
<body>
<a class="login" href="login.jsp">LOGIN</a>
<img class="logo" src="images/logo.png" >

<div class="notice">
<MARQUEE direction="left" onmouseout="this.start()" onmouseover="this.stop()" scrollAmount="3" scrollDelay="1"   vspace="50" hspace="50">	  
<%
List<Notice> notices = NoticeDao.getNotices();
for(int i=0;i<notices.size();i++){
  Notice notice=(Notice)notices.get(i);
  %>
<%=notice.getContent()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<%}%>
</marquee>
</div>

<form action="homepagesearch.do" method="post" onsubmit="return check()">
<div class="search">
	<img class="search" src="images/search.png" width="40px">
	<input class="input" type="text" placeholder="Input Title or Author" id="search" name="search">
	<input class="submit" type="submit" value="search" >
</div>
</form>


</body>
</html>