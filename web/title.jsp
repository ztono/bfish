<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<fmt:setBundle basename="resource.title" var="myKey" scope="page"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<style>
body{
	/*background: #f5f6f7;*/
	margin: 0;
    padding: 0;
}
 
.nav a {
    text-decoration: none;
    color: rgb(0, 0, 0);
}
.foot a{
	text-decoration: none;
    color: rgb(0, 0, 0);
}
.nav li {
    list-style: none;
}
 
/*nav*/
.nav {
    background-color: rgba(255,255,255,0.1);;
    height: 50px;
    margin-bottom: 20px;
    margin: 0;
    padding: 0;
}

.nav *{
	margin: 0;
    padding: 0;
}
 
.nav > .nav_1 {
    position: absolute;
    width: 100%;
    height: 50px;
    z-index: 1000;
}
 
.nav_1 > li {
    float: left;
}
 
.nav_1 > li {
    font: 20px/50px '微软雅黑';
    width: auto;
    text-align: center;
    margin:0 10px;
}
 
.nav_2 > li {
	width: 200px;
    line-height: 35px;
    display: none;
}
 
.nav_1 > li a:hover {
    color: #fd572e;
    width: 70px;
}
 
.nav_1 > li:hover .nav_2 > li {
    display: block;
    background-color: rgba(255,255,255,0.1);
    padding:3px 3px;
    box-shadow: 0 1px 0 0 rgba(0,0,0,.05);
}
.content{
	margin:20px 50px;
	background:rgba(255,255,255,0.1);
	min-height:480px;
	padding:20px;
}

</style>
</head>
<body>
<% 
String name = (String)session.getAttribute("name");
String able = (String)session.getAttribute("able");
String language = (String)session.getAttribute("language");
if("en_US".equals(language))language="zh_CN";
else language="en_US";%>

	<div class="nav">
		<ul class="nav_1">
		<%if("0".equals(able)){ %>
			<li style="margin-right: 250px;"><img src="/bfish/images/logo.png" height='50px'></li>
			<li><a href="/bfish/Rsearch.do"><fmt:message  bundle="${myKey}" key="searchbook"/></a></li>
			<li><a href="/bfish/reader/showborrow.jsp"><fmt:message  bundle="${myKey}" key="borrowedbook"/></a></li>
			<li><a href="/bfish/reader/showreserve.jsp"><fmt:message  bundle="${myKey}" key="reservedbook"/></a></li>
		<%}else if("1".equals(able)){ %>
			<li style="margin-right: 30px;"><img src="/bfish/images/logo.png" height='50px'></li>
			<li><a href="/bfish/librarian/borrow1.jsp"><fmt:message  bundle="${myKey}" key="borrowbook"/></a></li>
			<li><a href="/bfish/librarian/return.jsp"><fmt:message  bundle="${myKey}" key="returnbook"/></a></li>
			<li><a href="/bfish/LReaderShow.do"><fmt:message  bundle="${myKey}" key="managereader"/></a></li>
			<li><a href="/bfish/showcategory.do"><fmt:message  bundle="${myKey}" key="category"/></a></li>
			<li><a href="/bfish/showlocation.do"><fmt:message  bundle="${myKey}" key="location"/></a></li>
			<li><a href="/bfish/showallbook.do"><fmt:message  bundle="${myKey}" key="book"/></a></li>
			<li><a href="/bfish/Lincome.do"><fmt:message  bundle="${myKey}" key="income"/></a></li>
			<li><a href="/bfish/NoticeShow.do"><fmt:message  bundle="${myKey}" key="notice"/></a></li>
			<li><a href="/bfish/showdelete.do"><fmt:message  bundle="${myKey}" key="DeleteRecord"/></a></li>
		<%}else{ %>
			<li style="margin-right: 300px;"><img src="/bfish/images/logo.png" height='50px'></li>
			<li><a href=/bfish/UserShow.do><fmt:message  bundle="${myKey}" key="librarianmanage"/></a></li>
			<li><a href="/bfish/DataShow.do"><fmt:message  bundle="${myKey}" key="datamanage"/></a></li>
		<%} %>
			<li style="color: rgb(0, 0, 0);float:right;width:180px;"><%=name %>
				<ul class="nav_2">
					<li><a href="/bfish/doLanguage.jsp?language=<%=language%>"><fmt:message  bundle="${myKey}" key="switchlanguage"/></a></li>
					<li><a href="/bfish/reader/change/password.jsp" target="_blank"><fmt:message  bundle="${myKey}" key="changepassword"/></a></li>
					<%if("0".equals(able)){ %>
					<li><a href="/bfish/reader/change/email.jsp" target="_blank"><fmt:message  bundle="${myKey}" key="changeemail"/></a></li>
					<li><a href="/bfish/reader/change/information.jsp" target="_blank"><fmt:message  bundle="${myKey}" key="changeinformation"/></a></li>
					<%} %>
					<li><a href="/bfish/logout.do"><fmt:message  bundle="${myKey}" key="logout"/></a></li>
				</ul>
			</li>
		</ul>
	</div>
</body>
</html>