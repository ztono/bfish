<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <link rel="stylesheet" href="css/buttons.css">
<head>

<script>
function myFunction1(){
	var fun=prompt("Please input Fine","");
	if (fun!=null && fun!=""){
		window.location.href="/bfish/Fchange.do?fine="+fun;
	
	
	}
}
function myFunction2(){
	var fun=prompt("Please input Period","");
	if (fun!=null && fun!=""){
		window.location.href="/bfish/Pchange.do?period="+fun;
	
	
	}
}
function myFunction3(){
	var fun=prompt("Please input Deposit","");
	if (fun!=null && fun!=""){
		window.location.href="/bfish/Dchange.do?deposit="+fun;
	
	
	}
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body  style="background-image:url('/bfish/images/school.jpg');">

<%@ include file="/title.jsp" %>
<div class="content">


<table 
style="width: 1000px; margin: 44px auto"
	class="altrowstable" id="alternatecolor"
	align='center' border='1' cellspacing='0'
style="font-size:44px;"
	>
	

<tr><td><font size="6">Fine</font></td> <td><font size="6"> ${ data["fine"]}  $</font></td> <td> <button  onclick="myFunction1()" >change </button></td></tr>
<tr><td><font size="6">Period</font></td> <td><font size="6">${ data["period"]} Day</font></td> <td><button  onclick="myFunction2()">change</button></td></tr>
<tr><td><font size="6">Deposit</font></td> <td><font size="6">${ data["deposit"]}  $</font></td><td><button  onclick="myFunction3()" >change</button></td></tr>

</table>


</div>
<%@ include file="/foot.jsp" %>	

</body>
</html>