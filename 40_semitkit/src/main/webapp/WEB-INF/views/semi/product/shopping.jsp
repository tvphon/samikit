<%@include file="/WEB-INF/views/common/link_files.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<link href="${pageContext.request.contextPath }/resources/css/shopping.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/resources/css/product.css" rel="stylesheet">
<%@include file="/WEB-INF/views/common/common_function.jsp" %>
<title>Insert title here</title>
</head>
<body>
   	<div>
        <%@include file="/WEB-INF/views/semi/mainloginoutheader.jsp" %>
    </div>
    <div class="black"></div>
    <div>
        <select id="sortSelect" name="sort">
            <option value="new">신상품</option>
            <option value="name">상품명</option>
            <option value="low">낮은 가격</option>
            <option value="high">높은 가격</option>
        </select>
    </div>

	<div class="productlist">
		<%@include file="/WEB-INF/views/semi/product/productlist.jsp" %>
    </div>
    
    
</body>
</html>