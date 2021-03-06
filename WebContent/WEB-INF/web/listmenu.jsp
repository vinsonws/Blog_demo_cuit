<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${sessionScope.className }</title>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">  
<link rel="stylesheet"  href="css/bootstrapMagic.css" />
<link rel="stylesheet"  href="css/listmenu.css" />
<link rel="stylesheet"  href="css/footer.css" />
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="top_nav.jsp" />

<jsp:include page="nav.jsp" />


  <!-- Main jumbotron for a primary marketing message or call to action -->
  <div class="jumbotron  imgback">
    
    <div class="container">
    <div class="containers">
      <h1 class="display-3">${sessionScope.className }</h1>
      <!--  <p>This is a template for a simple marketing or informational website. It includes a large callout called a jumbotron
        and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
      <p>
       -->
      </p>
    </div>
    </div>
  </div>
    <hr>
    
<div class="container">
	<div class="mt-3 mb-5 ">
	      <ul class="nav nav-pills flex-column" >
			<c:forEach var="essay" items="${sessionScope.essayList }">
		        <li class="nav-item">
		          <a class="nav-link" href="essay?className=${essay.className }&essay_id=${essay.id }">${essay.essayName }
		          <p class="listtime">${essay.time }</p></a>
		        </li>
			</c:forEach>
	        <li class="nav-item">
	      </ul>
	</div>
</div>
    
    
    
    
    
  <div class="container">
    <!-- Example row of columns -->
   <div class="mt-3 mb-5">
      <nav>
        <ul class="pagination  midline pagination-lg">
         <li class="page-item">
         <c:if test="${sessionScope.pagePre != 0 }">
            <a href="essayList?className=${sessionScope.nowCol }&page=${sessionScope.pagePre }" class="page-link" aria-label="Previous">
              <span aria-hidden="true">«</span>
            </a>
           </c:if>
          </li>
          <c:forEach var="number" items="${sessionScope.listAllNum }">
	          <li class="page-item ">
	            <a href="essayList?className=${sessionScope.nowCol }&page=${number }" class="page-link">${number }</a>
	          </li>
	      </c:forEach>
	      <c:if test="${sessionScope.pageNext !=0 }">
          <li class="page-item">
            <a href="essayList?className=${sessionScope.nowCol }&page=${sessionScope.pageNext }" class="page-link" aria-label="Next">
              <span aria-hidden="true">»</span>
            </a>
          </li>
          </c:if>
        </ul>
      </nav>
    </div>


  </div>
  <!-- /container -->

<jsp:include page="footer.jsp" />

</body>
</html>