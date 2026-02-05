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
</head>
<body>

<c:if test="${count==0 }">
   <h6 class="alert alert-info">입고된 상품이 없습니다</h6>
</c:if>
<c:if test="${count>0 }">
   <h6 class="alert alert-info">총 ${count }개의 상품이 입고중입니다</h6>
</c:if>

<br>
<button type="button" class="btn btn-secondary"
onclick="location.href='addform'">입력폼</button>
<hr>
<table class="table table-bordered" style="width: 800px;">
   <tr class="table-secondary">
      <th width="80">번호</th>
      <th width="150">상품명</th>
      <th width="180">가격</th>
      <th width="200">입고일자</th>
   </tr>
   <c:forEach items="${list }"  var="dto" varStatus="i">
     <tr align="center">
        <td>${i.count}</td>
        <td><a href="detail?num=${dto.num }">${dto.sangpum }</a></td>
        <td><fmt:formatNumber value="${dto.price }" type="currency"/></td>
        <td>${dto.ipgoday }</td>
     </tr>
   </c:forEach>
</table>
</body>
</html>