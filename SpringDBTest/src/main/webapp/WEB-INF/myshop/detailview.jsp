<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
<style>
  .detail-img {
    width: 350px;
    height: auto;
    border: 1px solid #ddd;
    padding: 5px;
  }
</style>
</head>
<body>
<div class="container mt-5">

  <!-- 상단 : 이미지 + 상품정보 -->
  <div class="row">
    <!-- 이미지 -->
    <div class="col-md-5 text-center">
      <c:if test="${dto.photo!='no' }">
         <c:forTokens var="selphoto" items="${dto.photo }" delims=",">
           <img alt="" src="../photo/${selphoto }" style="max-width: 200px;">
         </c:forTokens>
      </c:if>
    </div>

    <!-- 상품 정보 -->
    <div class="col-md-7">
      <h3 class="mb-3">${dto.sangpum}</h3>

      <p class="fs-5">
        💰 가격 :
        <b class="text-danger">
          <fmt:formatNumber value="${dto.price}" type="number"/>
        </b> 원
      </p>

      <p class="fs-6 text-muted">
        📦 입고일 : ${dto.ipgoday}
      </p>
    </div>
  </div>

  <hr class="my-4">

  <!-- 버튼 영역 -->
  <div class="text-center">
    <button type="button" class="btn btn-outline-primary"
      onclick="location.href=''">수정</button>

    <button type="button" class="btn btn-outline-danger"
      onclick="location.href='delete?num=${dto.num}'">삭제</button>

    <button type="button" class="btn btn-outline-success"
      onclick="location.href='addform'">글쓰기</button>

    <button type="button" class="btn btn-outline-secondary"
      onclick="location.href='list'">목록</button>
  </div>

</div>
</body>
</html>