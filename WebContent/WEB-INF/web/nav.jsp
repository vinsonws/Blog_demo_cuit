<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="nav3">
<div class="container nav2">


    <nav class="navbar navbar-expand-md navbar-light bg-light rounded mb-3">
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse"
        aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav text-md-center nav-justified w-100">
        	<%for(String Ename:(List<String>)session.getAttribute("navsKeys")){
        		%>
	         <li class="nav-item">
	            <a class="nav-link" href="essayList?className=<%=Ename %>"><%=session.getAttribute(Ename) %></a>
	          </li>
          <%} %>
          
        </ul>
      </div>
    </nav>
</div>
</div>
<!-- /container -->
 
