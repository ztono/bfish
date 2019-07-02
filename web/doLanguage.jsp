<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%
String language = request.getParameter("language");
session.setAttribute("language", language); %>
<fmt:setLocale value="<%=language %>" scope="session"/>

<%
out.println("<script language=javascript>self.location=document.referrer;</script>");
%>