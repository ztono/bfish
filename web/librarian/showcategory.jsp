<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="entity.SBook,java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>CategoryInformation</title>
</head>


<body  style="background-image:url('/bfish/images/school.jpg');">

<%@ include file="/title.jsp" %>
<% String flag = (String)request.getAttribute("add");
if(flag=="3")
{%>
<script type="text/javascript">alert("add successfully");</script>
<% }
else if(flag=="2")
	
{%>
<script type="text/javascript">alert("this ISBN has already existed,please change");</script>
<%} 
%>
<br>	
<div class="content">

<h2>CategoryInformation</h2>


<table style="width: 800px; margin: 44px auto"
	class="table table-striped table-bordered table-hover  table-condensed"
	align='center' border='1' cellspacing='0'>
<div style="margin-left:25%;" >	
<form action="/bfish/addcategory.do" name=form1>
     
		category_name：<input type="text" name="category_name" id="category_name"  value=""  onkeyup="yz()">
		
		<input type="submit" value="Add"  id="button01" disabled >
		
		</form>
</div>		
<script language="javascript" type="text/javascript"> 
var button01=document.getElementById("button01");
function yz() { 
if(document.form1.category_name.value!="") {
    button01.disabled=false; 
} else{ button01.disabled=true; 
    }
}
</script>
<tr>
			
			
			<td align="center">category_name</td>	
			<td align="center"></td>
			<td align="center"></td>
	
</tr>


<c:forEach items="${categorys}" var="category" varStatus="st">
		<tr>
		
		<td align="center" width="50%">${category.category_name}</td>
		<td><a href="/bfish/deletecategory.do?category_id=${category.category_id}">Delete</a></td>
		<td><a href = "javascript:void(0)"  onclick = "change(${category['category_id']})">
change
</a>
<!--  div id="light" class="white_content">	
<form action="/librarian/updatecategory.do"  >
		<input type="text" name="category_id" id="category_id" value=''>
		category_name：<input type="text" name="category_name" id="category_name" value='${category.category_name}'>
		<input type="submit" value="Sure">
	</form>	
<a href = "javascript:void(0)" onclick = "document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'">
close
</a>

</div> 

</td-->

	</tr>
	</c:forEach>
	</table>
	
<script type="text/javascript">
function change(id){
	//document.getElementById('light').style.display='block';
	//document.getElementById('fade').style.display='block';
	//document.getElementById('p').innerHTML=x;
	var newname=prompt("input","");
	window.location.href="updatecategory.do?id=" + id +"&name=" + newname;
}
</script>

<% String d = (String)request.getAttribute("delete");
if("true".equals(d)){%>
<script type="text/javascript">alert("delete success");</script>
<% }else if("false".equals(d)){%>
<script type="text/javascript">alert("you must delect all the book in this category firstly");</script>
<%} %>
</div>
<%@ include file="/foot.jsp" %>
</body>
</html>