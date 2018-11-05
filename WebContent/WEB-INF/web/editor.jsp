<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Editor</title>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">  
<link rel="stylesheet"  href="/home/css/bootstrapMagic.css" />
<link rel="stylesheet"  href="/home/css/footer.css" />
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script charset="utf-8" src="/home/kindeditor/kindeditor-all.js"></script>
<script charset="utf-8" src="/home/kindeditor/lang/zh-CN.js"></script>
<script>
        KindEditor.ready(function(K) {
                window.editor = K.create('#editor_id',  {
                    uploadJson : 'kindeditor/jsp/upload_json.jsp',
                    fileManagerJson : 'kindeditor/jsp/file_manager_json.jsp',
                    allowFileManager : true
            });
        });
</script>
</head>
<body style="font-size: 16px;">

<jsp:include page="top_nav.jsp" />
<div class="nav2"></div>
<div class="container">
<form name="example" method="post" action="editor" enctype="multipart/form-data">
	<input type="text" id="inputEmail" class="form-control" placeholder="标题" required name="title">
	<%for(String Ename:(List<String>)session.getAttribute("navsKeys")){ %>
		<label class="form-check-label">
		         <input class="form-check-input" type="radio" name="colOptions" id="inlineRadio1" value="<%=Ename %>"> <%=session.getAttribute(Ename) %>
		   </label>
    <%} %>
	<input type="submit" name="button" value="提交" class="btn btn-secondary" style="float:right;"/>
	<textarea id="editor_id" name="content" style="width:700px;height:900px;margin:auto;">
	
	</textarea>
		<br />
	
	</form>

	
</div>
<!-- /container -->
<jsp:include page="footer.jsp" />

</body>
</html>