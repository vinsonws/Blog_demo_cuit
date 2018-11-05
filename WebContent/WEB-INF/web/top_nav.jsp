<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="navbar navbar-expand-md navbar-dark fixed-top bg-info topsize">
  <a class="navbar-brand topsize1" href="#">vinsonws</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse"
    aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarCollapse">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="home.html">主页
        </a>
      </li>
      <c:if test="${sessionScope.logUser == null }">
      <li class="nav-item">
        <a class="nav-link" href="login">登录</a>
      </li>
      <li class="nav-item">
        <a class="nav-link " href="register">注册</a>
      </li>
      </c:if>
      <c:if test="${sessionScope.logUser != null }">
      <li class="nav-item">
        <a class="nav-link" href="exitUserServer">退出</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="userPage">${sessionScope.logUser.userName }</a>
      </li>
      <c:if test="${sessionScope.permission == 'admin' }">
      <li class="nav-item  active">
        <a class="nav-link " href="test">审核</a>
      </li>
      </c:if>
      <li class="nav-item  active">
        <a class="nav-link " href="editor">+</a>
      </li>
      </c:if>
    </ul>
    <form class="form-inline mt-2 mt-md-0" action="searchDataServer" method="get">
      <input class="form-control mr-sm-2" type="text" placeholder="输入文章或者作者名字" aria-label="Search" name="searchdata">
      <button class="btn btn-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</div>