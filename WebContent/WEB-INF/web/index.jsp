	<%@page import="entity.Essay"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>VINSONWS</title>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">  
<link rel="stylesheet"  href="css/bootstrapMagic.css" />
<link rel="stylesheet"  href="css/footer.css" />
<link rel="stylesheet"  href="css/index.css" />
<link rel="stylesheet"  href="css/listmenu.css" />
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="top_nav.jsp" />
<div style="height:100px;"></div>
 <div class="marketing  container" style="width:900px"	>
	<div class="" style="padding-bottom:2.25rem;">
		<div class="panel panel-default" >
			<div class="panel-heading">
			</div>
			<div class="panel-body">
				<ul class="essaylist" style="display: flex;flex-wrap: wrap;padding-left: 0;margin-bottom: 0;list-style: none; ">
			      		<%for(Essay essay:(List<Essay>)session.getAttribute("essayList")){ %>
		      			<li class="nav-item" style="width:900px">
				         	 <a class="nav-link" href="essay?className=<%=essay.getClassName() %>&essay_id=<%=essay.getId() %>"><%=essay.getEssayName() %>
				         <!--  <p class="listtime">${essay.time }</p>-->
				         <p class="listtime" style="float:right"><%=essay.getTime() %></p></a>
				        </li>
			      		<%} %>
				</ul>
			</div>
		</div>
	 </div>
</div>

  
 
<jsp:include page="footer.jsp" />
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/webfont/1.6.28/webfontloader.js"></script>
 
</body>
</html>