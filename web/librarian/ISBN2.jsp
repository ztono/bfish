<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="entity.SBook,entity.*,dao.*,java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function check(){
var number= document.getElementById("number");
if(number.value==""||number.value==null){
	document.getElementById("error").innerHTML=" number can not be empty";
return false;}
return true;
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>BookDetails</title>

</head>
<body  style="background-image:url('/bfish/images/school.jpg');">

<%@ include file="/title.jsp" %>
<div class="content">
<%
List<Category> categorys = CategoryDao.getCategorys();
%>
<% String n1 = (String)request.getAttribute("n1");
    if(n1=="2")
    { %>This ISBN has existed in the database<%}
    %>	
    <br>
    <br>
    <br>
    
<form action="/bfish/getbook2.do"  >
<table>
<tr>
<td align="left" width="10%">ISBN ${book.ISBN}</td></tr>
		<tr><td align="left" width="10%">category_name ${book.category_name}</td></tr>
		<tr><td align="left" width="10%">price ${book.price}</td></tr>
			<tr><td align="left" width="10%">title ${book.title}</td></tr>
			<tr><td align="left" width="10%">author ${book.author}</td></tr>
			<tr><td align="left" width="10%">press ${book.press}</td></tr>
			<tr><td align="left" width="10%">location ${book.location_id}</td></tr>
			<tr><td align="left" width="10%">callnumber ${book.callnumber}</td></tr>
			
</table>
	</form>	

<form action="/bfish/addsbook.do" name=form1 onsubmit="return check()">
<input  type="hidden" name="ISBN"  id="ISBN" value="${ISBN}"/>
<br>
input the number please<input  type="text" name="number"  id="number" onblur="my()"/>
<input  type="hidden" name="bookstatus"  id="bookstatus" value="normal"/>
<button type="submit"  value="确定">Sure</button>

</form>
<div id="error"></div>		
</div>
 <script>
 function my()
 {
 	if(form1.number.value=="")
 		{
 		alert("number can not be empty")
 	
 		}	
 	
 }
 
 </script>
 <script type="text/javascript">
var text = document.getElementById("number");
text.onkeyup = function(){
this.value=this.value.replace(/\D/g,'');
 if(text.value>20){
	 text.value = 20;
  alert("you can add 20 books ");
}

}
</script>
<%@ include file="/foot.jsp" %>
</body>
</html>