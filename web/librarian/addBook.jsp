<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="entity.*,java.util.*,dao.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.text1{
    width: 200px;
    height: 30px;
 
    font-size: 15px;
}
</style>

<style>
.text2{
    width: 100px;
    height: 30px;
 
    font-size: 20px;
}
</style>
<style>
.submit_button {
    width: 70px;
    height: 40px;
   
    font-size: 20px;
}
</style>
<script type="text/javascript">
function check(){
var price= document.getElementById("price");
if(price.value==""||price.value==null){
	document.getElementById("error").innerHTML=" price can not be empty";
return false;}

var title= document.getElementById("title");
if(title.value==""||title.value==null){
	document.getElementById("error").innerHTML=" title can not be empty";
return false;}

var author= document.getElementById("author");
if(author.value==""||author.value==null){
	document.getElementById("error").innerHTML="author can not be empty";
return false;}

var press= document.getElementById("press");
if(press.value==""||press.value==null){
	document.getElementById("error").innerHTML=" press can not be empty";
return false;}

var introduce= document.getElementById("introduce");
if(introduce.value==""||introduce.value==null){
	document.getElementById("error").innerHTML="introduce can not be empty";
return false;}


var callnumber= document.getElementById("callnumber");
if(callnumber.value==""||callnumber.value==null){
	document.getElementById("error").innerHTML=" callnumber can not be empty";
return false;}

var number= document.getElementById("number");
if(number.value==""||number.value==null){
	document.getElementById("error").innerHTML=" number can not be empty";
return false;}
var location= document.getElementById("location");
if(location.value==""||location.value==null){
	document.getElementById("error").innerHTML="location can not be empty";
return false;}

return true;
}
</script>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.5.2.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
 
    var url="https://api.douban.com/v2/book/isbn/"+$("#ISBN").val()
    var img_url=""
    $.ajax({
        url: url,
        type: 'GET',
        dataType: 'JSONP',//here
        success: function (data) {
          console.log(data);
          $("#title").val(data.title);
          $("#author").val(data.author[0]);
          $("#press").val(data.publisher);
          $("#price").val(data.price);
          $("#introduce").val(data.summary);
      }
    });

  
});
</script>
  <link rel="stylesheet" href="css/buttons.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>AddBook</title>
</head>
<body  style="background-image:url('/bfish/images/school.jpg');">

<%@ include file="/title.jsp" %>

<div class="content">
<%
List<Category> categorys = CategoryDao.getCategorys();
%>
<%
List<Location> locations = LocationDao.getLocations();
%>
   <h2>Add book</h2>
    <div style="margin-left:35%;" >
<form action="/bfish/addbook.do" name=form1 onsubmit="return check()">
<table>
			
			<tr>
				 <td width="100" height="50" font size="20px">ISBN</td>
			
				<td><input type="text"
					name="ISBN"  id="ISBN"   value="${ISBN}" class="text1" readonly="true"/>
				</td>
			</tr>
			<tr>
				<td>category</td>
				<td>
					<select name="category_id" class="text2">
					<% for(Category category : categorys){ %>
						<option value="<%=category.getCategory_id()%>"> <%=category.getCategory_name()%></option>
					<% } %>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<span width="100" height="40" font size="20px">Price</span></td>
				<td><input type="text"
					name="price"  id="price" class="text1"/>
						
				</td>
			</tr>
			<tr>
				<td width="100" height="40" font size="20px">Title</td>
				<td ><input type="text"
					name="title" id="title" class="text1"/>
				</td>
			</tr>
			<tr>
				<td width="100" height="40" font size="20px">Author</td>
				<td ><input type="text"
					name="author" id="author" class="text1"/>
				</td>
			</tr>
			<tr>
				<td width="100" height="40" font size="20px">Press</td>
				<td ><input type="text"
					name="press" id="press" class="text1"/>
				</td>
			</tr>
			<tr>
				<td width="100" height="40" font size="20px">Introduce</td>
				<td ><textarea rows="10" cols="50"
					name="introduce" id="introduce" >
					</textarea>
				</td>
			</tr>
			<tr>
				<td width="100" height="40" font size="20px">Location</td>
				<td ><select name="location_id" class="text2">
					<% for(Location location : locations){ %>
						<option value="<%=location.getLocation_id()%>"> <%=location.getLocation_name()%></option>
					<% } %>
					</select>
				</td>
			</tr>
				<tr>
				<td width="100" height="40" font size="20px">CallNumber</td>
				<td ><input type="text"
					name="callnumber" id="callnumber" class="text1"/>
				</td>
			</tr>
				<tr>
				
				<td ><input type="hidden"
					name="bookstatus" id="bookstatus" value="normal" class="text1"/>
				</td>
			</tr>
				<tr>
				<td width="100" height="40" font size="20px">number </td>
				<td ><input type="text"
					name="number" id="number" class="text1" onblur="my()"/> 
				</td>
			</tr>
			
			<tr>
				<td>&nbsp;&nbsp;&nbsp;
					<button type="submit"  value="确定" id="button01" class="submit_button" >Sure</button>
						
				</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	<button type="reset" value="重置"  class="submit_button">Reset</button></td>
				
<div id="error"></div>							
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

			</tr>
</table>
</form>


</div>
<%@ include file="/foot.jsp" %>	
</body>
</html>


